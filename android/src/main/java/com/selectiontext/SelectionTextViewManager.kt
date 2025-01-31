package com.selectiontext


import android.graphics.Color
import androidx.annotation.ColorInt
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.views.text.ReactTextViewManager



class SelectionTextViewManager : ReactTextViewManager() {
  override fun getName() = "SelectionTextView"

  override fun createViewInstance(reactContext: ThemedReactContext): SelectionText {
    return SelectionText(reactContext)
  }

  @ReactProp(name = "text")
  fun setText(view: SelectionText, text: String?) {
    view.text = text
  }

  @ReactProp(name = "color")
  fun setColor(view: SelectionText, @ColorInt color: Int) {
    view.setTextColor(color)
  }


  override fun getExportedCustomDirectEventTypeConstants(): Map<String, Any> {
    return mapOf(
      "textSelected" to mapOf(
        "registrationName" to "onTextSelected"
      )
    )
  }
}
