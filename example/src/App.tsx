import { View, StyleSheet } from 'react-native';
import { SelectionTextView } from 'react-native-selection-text';

export default function App() {
  return (
    <View style={styles.container}>
      <SelectionTextView
        text="orem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum"
        style={styles.box}
        onTextSelected={(e) => {
          console.log('e', e.nativeEvent);
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
    fontWeight: '900',
    fontFamily: 'serif',
  },
});
