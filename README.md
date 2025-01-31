# react-native-selection-text

A custom Text component for React Native that provides text selection functionality without the default Android selection menu options.

## Features

- Clean text selection without default Android menu options
- Selection event callback
- Maintains native text selection behavior
- Support for Android

## Installation

```sh
npm install react-native-selection-text
```

## Android Setup

1. Add the following to your `android/settings.gradle`:

```gradle
include ':react-native-selection-text'
project(':react-native-selection-text').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-selection-text/android')
```

2. Add the dependency to your `android/app/build.gradle`:

```gradle
dependencies {
    // ...
    implementation project(':react-native-selection-text')
}
```

3. Add the package to your `MainApplication.java`:

```java
import com.selectiontext.SelectionTextPackage; // Add this import

public class MainApplication extends Application implements ReactApplication {
    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.asList(
            new MainReactPackage(),
            new SelectionTextPackage() // Add this line
        );
    }
}
```

## Usage

```javascript
import { SelectionTextView } from 'react-native-selection-text';

const YourComponent = () => {
  const handleTextSelection = (event) => {
    const { selectedText, selectionStart, selectionEnd } = event.nativeEvent;
    console.log('Selected text:', selectedText);
    console.log('Selection range:', selectionStart, selectionEnd);
  };

  return (
    <SelectionTextView
      text="Select this text"
      onTextSelected={handleTextSelection}
    />
  );
};
```

## Props

| Prop             | Type     | Description                          |
| ---------------- | -------- | ------------------------------------ |
| `text`           | string   | The text content to display          |
| `onTextSelected` | function | Callback fired when text is selected |

### Selection Event Object

The `onTextSelected` callback receives an event object with the following structure:

```javascript
{
  nativeEvent: {
    selectedText: string,    // The selected text content
    selectionStart: number,  // Starting index of selection
    selectionEnd: number     // Ending index of selection
  }
}
```

## Example

```javascript
import React from 'react';
import { View } from 'react-native';
import { SelectionTextView } from 'react-native-selection-text';

export default function App() {
  return (
    <View style={{ flex: 1, justifyContent: 'center', padding: 20 }}>
      <SelectionTextView
        text="This is a selectable text component. Try selecting this text!"
        onTextSelected={({ nativeEvent }) => {
          console.log('Selected:', nativeEvent.selectedText);
        }}
      />
    </View>
  );
}
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
