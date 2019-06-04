## react-native-camera2-gjcamera

This project is Created in order to understand the working of android.hardware.camera2 package.
It is in react-native language.
It has a default Image Preview and Image Quality of 1600X1200.
It is supposed to take a picture and show it's storage path to the user.

In order to take multiple pictures put the condition in the returnHome function as per your need.

## Installation

```sh
npm install --save react-native-camera2-gjcamera
```

1.<img width=250px height=400px src ="https://github.com/Gjoshi3107/react-native-camera2-gjcamera/blob/master/img/Before%20Click.png"/>   2.<img width=250px height=400px src ="https://github.com/Gjoshi3107/react-native-camera2-gjcamera/blob/master/img/IMG_20190604_152120.png"/>   3.<img width=250px height=400px src ="https://github.com/Gjoshi3107/react-native-camera2-gjcamera/blob/master/img/after%20click.png"/>
<pre>1.Before Click</pre><pre>2.Image Clicked </pre><pre>3.After Clicked</pre>

## Usage

in React:-
```sh
import GJ from 'react-native-camera2-gjcamera'

...

    this.state = {
        ...
        imgPATH: "LOL"
    };
    ...
    OpenMyCamer = async () => {
        const result = await GJ.OpenMyCamera();
        this.setState({ imgPATH: result.imgPath });
    }
    ...
    render(){
        return(
            ...
            <TouchableOpacity onPress={() => this.OpenMyCamer()}>
                <Text>Open Camera</Text>
            </TouchableOpacity>
            <Text style={styles.signInText}>{this.state.imgPATH}</Text>
            ...
        );
    }
```
in Native:-

1) AndroidMainfest.xml
```
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.hardware.camera2.full" />
...
<application
    ...
    <activity android:name="com.gjcamera.GJCamera"/>
/>
```
2) settings.gradle:-
```
include ':react-native-camera2-gjcamera'
project(':react-native-camera2-gjcamera').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-camera2-gjcamera/android')
```
3) build.gradle(Module: app):-
```
implementation project(':react-native-camera2-gjcamera')
```

4) MainApplication.java:-

```
import com.gjcamera.GJCameraPackage;
...
    return Arrays.asList(
        ...
        new GJCameraPackage()
    );
```

Hope you will like it.

## Licence
The MIT License (MIT)

Copyright (c) 2015 Howard Yang

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


