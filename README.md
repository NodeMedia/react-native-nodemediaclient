# react-native-nodemediaclient
[![npm](https://img.shields.io/npm/v/react-native-nodemediaclient.svg)](https://www.npmjs.com/package/react-native-nodemediaclient)
[![npm](https://img.shields.io/npm/dm/react-native-nodemediaclient.svg)](https://www.npmjs.com/package/react-native-nodemediaclient)  
This project is the react-native packaging of NodeMediaClient-Android and NodeMediaClient-iOS SDK.
Complete live publish and play functions, providing the exact same API call. You can publish two platforms just by developing one set of programs.  
[中文介绍](https://github.com/NodeMedia/react-native-nodemediaclient/blob/master/README_CN.md)

## 0.Enter the project directory
cd AwesomeProject

## 1.Install
npm i react-native-nodemediaclient

## 2.Link
~~react-native link react-native-nodemediaclient~~
>No longer needed after react native 0.60

## 3.Install dependencies
cd ios  
pod install

## 4.NodeCameraView Permission

### Android
Open AwesomeProject/android/app/src/main/AndroidManifest.xml, Add

```  
<uses-feature android:name="android.hardware.camera"/>
<uses-feature android:name="android.hardware.camera.autofocus"/>

<uses-permission android:name="android.permission.CAMERA"/>
<uses-permission android:name="android.permission.RECORD_AUDIO"/>
<uses-permission android:name="android.permission.FLASHLIGHT"/>
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
```

### iOS
Open AwesomeProject/ios/QLive/Info.plist , Add:
```
<key>NSCameraUsageDescription</key>
<string>AwesomeProject requires access to your phone’s camera.</string>
<key>NSMicrophoneUsageDescription</key>
<string>AwesomeProject requires access to your phone’s Microphone.</string>
````

## 5.Example

### NodePlayerView

```
import {  NodePlayerView } from 'react-native-nodemediaclient';

......

<NodePlayerView 
  style={{ height: 200 }}
  ref={(vp) => { this.vp = vp }}
  inputUrl={"rtmp://192.168.0.10/live/stream"}
  scaleMode={"ScaleAspectFit"}
  bufferTime={300}
  maxBufferTime={1000}
  autoplay={true}
/>
```


### NodeCameraView
```
import {  NodeCameraView } from 'react-native-nodemediaclient';


const requestCameraPermission = async () => {
  try {
    const granted = await PermissionsAndroid.requestMultiple([PermissionsAndroid.PERMISSIONS.CAMERA,PermissionsAndroid.PERMISSIONS.RECORD_AUDIO],
      {
        title: "Cool Photo App Camera And Microphone Permission",
        message:
          "Cool Photo App needs access to your camera " +
          "so you can take awesome pictures.",
        buttonNeutral: "Ask Me Later",
        buttonNegative: "Cancel",
        buttonPositive: "OK"
      }
    );
    if (granted === PermissionsAndroid.RESULTS.GRANTED) {
      console.log("You can use the camera");
    } else {
      console.log("Camera permission denied");
    }
  } catch (err) {
    console.warn(err);
  }
};

......

<NodeCameraView 
  style={{ height: 400 }}
  ref={(vb) => { this.vb = vb }}
  outputUrl = {"rtmp://192.168.0.10/live/stream"}
  camera={{ cameraId: 1, cameraFrontMirror: true }}
  audio={{ bitrate: 32000, profile: 1, samplerate: 44100 }}
  video={{ preset: 12, bitrate: 400000, profile: 1, fps: 15, videoFrontMirror: false }}
  autopreview={true}
/>

 <Button title="request permissions" onPress={requestCameraPermission} />
<Button
  onPress={() => {
    if (this.state.isPublish) {
      this.setState({ publishBtnTitle: 'Start Publish', isPublish: false });
      this.vb.stop();
    } else {
      this.setState({ publishBtnTitle: 'Stop Publish', isPublish: true });
      this.vb.start();
    }
  }}
  title={this.state.publishBtnTitle}
  color="#841584"
/>
```
>I don't know which version of react native updated compileSdkVersion to 28 instead of 23, Camera and microphone permissions need to be manually requested. Look at the document at https://reactnative.dev/docs/permissionsandroid , If don't have permission to apply first, you will only see a white screen.

>In this demo you might have to boot it twice.
In the official version, you can apply permission on the home page first, and then jump to the live page after you have permission.

## Note for android
If you have enabled proguard in release don't forget to add this to `proguard-rules.pro` file:
```
-keep class cn.nodemedia.** {*;} 
```

## Demo project
![img](https://raw.githubusercontent.com/NodeMedia/iShow-RN/master/1519740855033.gif)
https://github.com/NodeMedia/iShow-RN
