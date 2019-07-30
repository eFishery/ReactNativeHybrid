import React from 'react';
import {AppRegistry, TextInput, StyleSheet, Text, View, NativeModules, TouchableOpacity} from 'react-native';
import NoteItem from './components/NoteItem';

class AddNoteComponent extends React.Component {
  state = {
    title:'',
    body:''
  }

  saveNote = async () => {
    if(this.state.title === '') alert('please insert title')
    else {
      if(this.state.body === '') alert('please insert body')
      else {
        await NativeModules.DataModule.saveNote(this.state.title,this.state.body);
        NativeModules.NavigatorModule.showListNotesActivity();
      }
    }
  }

  render() {
    return (
      <View style={styles.container}>
        <Text>
          Title
        </Text>
        <TextInput
          style={{height: 40, borderColor: 'gray', borderWidth: 1}}
          onChangeText={(title) => this.setState({title})}
          value={this.state.title}
        />
        <Text>
          Body
        </Text>
        <TextInput
          style={{height: 40, borderColor: 'gray', borderWidth: 1}}
          onChangeText={(body) => this.setState({body})}
          value={this.state.body}
        />
        <TouchableOpacity
          onPress={this.saveNote}
          style={styles.buttonSave}>
          <Text style={styles.buttonText}>Save</Text>
        </TouchableOpacity>
      </View>
    );
  }
}
var styles = StyleSheet.create({
  container: {
    margin:10,
  },
  buttonText : {
    textAlign:'center',
    lineHeight:40,
    color:'rgba(235, 237, 239, 1)',
  },
  buttonSave: {
    marginTop:10,
    width:'100%',
    height:40,
    backgroundColor : 'rgba(77, 171, 246, 1)'
  },
});

AppRegistry.registerComponent('AddNoteComponent', () => AddNoteComponent);
