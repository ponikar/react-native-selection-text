package com.selectiontext
import android.content.Context
import android.view.MotionEvent
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.facebook.react.views.text.ReactTextView


class SelectionText(context: Context) : ReactTextView(context) {
   private var lastTouchX: Float = 0f
   private var lastTouchY: Float = 0f
   private var lastSelectedText: String = ""


  init {
       setTextIsSelectable(true)
       customSelectionActionModeCallback = object : ActionMode.Callback {
           override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean = true
           override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
               menu?.clear()
               return false
           }
           override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean = false
           override fun onDestroyActionMode(mode: ActionMode?) {}
       }
   }

  override fun onTextContextMenuItem(id: Int): Boolean {
    val handled = super.onTextContextMenuItem(id)
    if (handled) {
      val selectedText = text?.substring(selectionStart, selectionEnd) ?: ""
      sendEvent("textSelected", selectedText, true)  // Dismissed after menu action
    }
    return handled
  }



  override fun onSelectionChanged(selStart: Int, selEnd: Int) {
    super.onSelectionChanged(selStart, selEnd)
    if (selStart != selEnd) {
      val start = minOf(selStart, selEnd)
      val end = maxOf(selStart, selEnd)
      val selectedText = text?.substring(start, end) ?: ""
      sendEvent("textSelected", selectedText, false)
    } else if (lastSelectedText.isNotEmpty()) {
      // User dismissed selection
      sendEvent("textSelected", "", true)
      lastSelectedText = ""
    }
  }


  private fun sendEvent(eventName: String, selectedText: String, dismissed: Boolean) {
    val event = Arguments.createMap().apply {
      putString("selectedText", selectedText)
      putBoolean("dismissed", dismissed)
      if (!dismissed && selectedText.isNotEmpty()) {
        putDouble("x", lastTouchX.toDouble())
        putDouble("y", lastTouchY.toDouble())
      }
    }

    if (!dismissed) {
      lastSelectedText = selectedText
    }

    val reactContext = context as ReactContext
    reactContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(id, eventName, event)
  }

   override fun onTouchEvent(event: MotionEvent?): Boolean {
       event?.let {
           when (it.action) {
               MotionEvent.ACTION_DOWN -> {
                   lastTouchX = it.x
                   lastTouchY = it.y
               }
           }
       }
       return super.onTouchEvent(event)
   }
}

