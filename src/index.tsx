import {
  requireNativeComponent,
  UIManager,
  Platform,
  type TextProps,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-selection-text' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

interface SelectionTextProps extends TextProps {
  onTextSelected: (p: {
    nativeEvent: {
      selectedText: 'SOMETHING';
      dismissed: false;
      x: 286.02734375;
      y: 12.111328125;
      target: 2;
    };
  }) => void;

  text: string;
}

const ComponentName = 'SelectionTextView';

export const SelectionTextView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<SelectionTextProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
