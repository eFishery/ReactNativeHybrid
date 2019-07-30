import React from 'react';
import { Text, View, StyleSheet, TouchableOpacity, NativeModules } from 'react-native';

class NoteItem extends  React.PureComponent {
  detailNote = async () => {
    await NativeModules.NavigatorModule.showDetailNoteActivity(this.props.note.uuid);
  }
  render() {
    return (
      <View style={styles.inline}>
        <Text style={styles.index}>No. {this.props.index}</Text>
        <Text style={styles.title}>Title : {this.props.note.title}</Text>
        <TouchableOpacity
          style={styles.buttonDetail}
          onPress={this.detailNote}>
          <Text style={styles.buttonText}>Detail</Text>
        </TouchableOpacity>
      </View>
    )
  }
}

var styles = StyleSheet.create({
  index : {
    flex:1,
    fontSize: 18,
    textAlign: 'center',
    backgroundColor : 'rgba(235, 237, 239, 1)',
    marginRight: 5
  },
  buttonText : {
    color:'rgba(235, 237, 239, 1)',
  },
  buttonDetail : {
    flex:1,
    justifyContent:'center',
    alignItems:'center',
    backgroundColor : 'rgba(77, 171, 246, 1)',
  },
  title: {
    flex:3,
    fontSize: 18,
    backgroundColor : 'rgba(235, 237, 239, 1)',
  },
  inline : {
    padding:10,
    backgroundColor : 'rgba(235, 237, 239, 0.6)',
    flexDirection:'row',
    flexWrap:'wrap'
  }
});

export default NoteItem;
