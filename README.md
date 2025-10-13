# react-native-nodemediaclient
[![npm](https://img.shields.io/npm/v/react-native-nodemediaclient.svg)](https://www.npmjs.com/package/react-native-nodemediaclient)
[![npm](https://img.shields.io/npm/dm/react-native-nodemediaclient.svg)](https://www.npmjs.com/package/react-native-nodemediaclient)  
This project is the react-native packaging of NodeMediaClient-Android and NodeMediaClient-iOS SDK.

Complete live publish and play functions, providing the exact same API call. You can publish two platforms just by developing one set of programs.  

A commercial license is required.

## 1.Install
npm i react-native-nodemediaclient

## 2.Install dependencies
npx pod-install ios

## 3.Permission

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

https://reactnative.dev/docs/permissionsandroid

### iOS
Open AwesomeProject/ios/QLive/Info.plist , Add:
```
<key>NSCameraUsageDescription</key>
<string>AwesomeProject requires access to your phone’s camera.</string>
<key>NSMicrophoneUsageDescription</key>
<string>AwesomeProject requires access to your phone’s Microphone.</string>
```

## Demo
https://github.com/NodeMedia/iShow
