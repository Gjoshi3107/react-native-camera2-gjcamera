import { NativeModules } from 'react-native';

const GJC = NativeModules.GJCamera;

class GJ {
  // OpenMyCamera = (options = {}) => {
  OpenMyCamera = async() => {
    const result = await GJC.openCamera();
    return result;
    // return await GJC.openCamera();
  }
}

export default new GJ()