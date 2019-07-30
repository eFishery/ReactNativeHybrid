import React from 'react';
import {AppRegistry, StyleSheet, Text, View, NativeModules, TouchableOpacity} from 'react-native';
import NoteItem from './components/NoteItem';

class ListNoteComponent extends React.Component {
  state = {
    listNote: []
  }
  getListNote = async () => {
    const listNote = await NativeModules.DataModule.getListNote();
    this.setState({listNote})
  }
  addNote = async () => {
    await NativeModules.NavigatorModule.showAddNoteActivity();
  }
  componentDidMount(){
    this.getListNote();
  }

  render() {
    const list = this.state.listNote.map((note,index) => {
      return <NoteItem note={note} key={note.uuid} index={index}/>
    })
    return (
      <View style={styles.container}>
        {list}
        <TouchableOpacity
          onPress={this.addNote}
          style={styles.buttonAdd}>
          <Text style={styles.buttonText}>Add</Text>
        </TouchableOpacity>
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    margin:10,
    height:'100%'
  },
  buttonText : {
    lineHeight:70,
    textAlign:'center',
    color:'rgba(235, 237, 239, 1)',
  },
  buttonAdd: {
    width: 60,
    height: 60,
    borderRadius: 30,
    backgroundColor : 'rgba(77, 171, 246, 1)',
    position: 'absolute',
    bottom: 20,
    right: 10,
  },
});

AppRegistry.registerComponent('ListNoteComponent', () => ListNoteComponent);
