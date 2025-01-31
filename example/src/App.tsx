import { View, StyleSheet } from 'react-native';
import { SelectionTextView } from 'react-native-selection-text';

export default function App() {
  return (
    <View style={styles.container}>
      <SelectionTextView
        text="LOL! YOU STILL THINK SOMETHING IS EVEN REAL THAN EVER YOU CAN THINK??? I DO NOT THINK SO BROTER"
        style={styles.box}
        onTextSelected={(e) => {
          console.log('PLEASE WORK I AM DONE WITH YOU', e.nativeEvent);
        }}
        selectable
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  box: {
    flex: 1,
    fontSize: 20,
    color: 'red',
  },
});
