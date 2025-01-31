import {
  requireNativeComponent,
  UIManager,
  Platform,
  type ViewStyle,
} from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-selection-text' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

type SelectionTextProps = {
  color: string;
  style: ViewStyle;
};

const ComponentName = 'SelectionTextView';

export const SelectionTextView =
  UIManager.getViewManagerConfig(ComponentName) != null
    ? requireNativeComponent<SelectionTextProps>(ComponentName)
    : () => {
        throw new Error(LINKING_ERROR);
      };
