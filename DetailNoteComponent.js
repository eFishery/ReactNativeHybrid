// val uuid: String,
// val title: String,
// val body: String,
// val createdAt: String Thu Jul 18 13:38:19 GMT+07:00 2019
import React from 'react';
import {AppRegistry, TouchableOpacity, StyleSheet, Text, View, NativeModules} from 'react-native';

class DetailNoteComponent extends React.Component {
  state = {
    note:{}
  }
  backToList = async () => {
    await NativeModules.NavigatorModule.showListNotesActivity();
  }
  getDetailNote = async (uuid) => {
    const note = await NativeModules.DataModule.getDetailNote(uuid);
    this.setState({note})
  }

  componentDidMount() {
    this.getDetailNote(this.props.uuid)
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.detailContainer}>
          <View style={styles.detailItem}>
            <Text style={styles.label}>UUID :</Text>
            <Text style={styles.value}>{this.state.note.uuid}</Text>
          </View>
          <View style={styles.detailItem}>
            <Text style={styles.label}>TITLE :</Text>
            <Text style={styles.value}>{this.state.note.title}</Text>
          </View>
          <View style={styles.detailItem}>
            <Text style={styles.label}>BODY :</Text>
            <Text style={styles.value}>{this.state.note.body}</Text>
          </View>
          <View style={styles.detailItem}>
            <Text style={styles.label}>CREATED AT :</Text>
            <Text style={styles.value}>{this.state.note.createdAt}</Text>
          </View>
        </View>
        <TouchableOpacity
          style={styles.buttonBack}
          onPress={this.backToList}>
          <Text style={styles.buttonText}>
            Back
          </Text>
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
  buttonBack : {
    width: 60,
    height: 60,
    borderRadius: 30,
    backgroundColor : 'rgba(77, 171, 246, 1)',
    position: 'absolute',
    bottom: 20,
    right: 10,
  },
  buttonText : {
    lineHeight:70,
    textAlign:'center',
    color:'rgba(235, 237, 239, 1)',
  },
  detailContainer : {
    backgroundColor : 'rgba(235, 237, 239, 0.6)',
  },
  detailItem : {
    padding:10,
    flexDirection:'row',
    flexWrap:'wrap'
  },
  label: {
    flex:1,
    fontSize: 18
  },
  value : {
    flex: 2,
    fontSize: 18
  }
});

AppRegistry.registerComponent('DetailNoteComponent', () => DetailNoteComponent);
