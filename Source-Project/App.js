import React, { Component } from 'react';
import { Platform, StyleSheet, Text, View, TouchableOpacity, NativeModules } from 'react-native';

const GJC = NativeModules.GJCamera;

type Props = {};
export default class App extends Component<Props> {
  constructor() {
    super();
    this.state = {
      imagePathh: "empty",
    }
    this.OpenMyCamera = this.OpenMyCamera.bind();
  }
  OpenMyCamera = async () => {
    const result = await GJC.openCamera();
    this.setState({ imagePathh: result.imgPath });
  }
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>Welcome to React Native!</Text>
        <Text style={styles.instructions}>To enter camera, click on the "Camera" below</Text>
        <Text style={styles.instructions}>The path of image will be shown below...</Text>

        <TouchableOpacity style={{ backgroundColor: 'green' }} onPress={() => this.OpenMyCamera()}>
          <Text style={{ color: '#fff' }}>
            Camera
          </Text>
        </TouchableOpacity>
        <Text style={{ paddingTop: 300 }}>The Path of image is </Text>
        <Text style={{ color: "skyblue" }}>{this.state.imagePathh}</Text>

      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
