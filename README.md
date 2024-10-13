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
## 4. Usage Example
### NodePlayer
```
import React from 'react';
import { View } from 'react-native';
import NodePlayer from 'react-native-nodemediaclient';

export default function App() {
  return (
    <View style={{ flex: 1 }}>
      <NodePlayer
        style={{ width: '100%', height: 200 }}
        url="rtmp://yourstreamurl/live/streamkey"
        autoplay={true}
        volume={1.0}
        bufferTime={300}
        scaleMode={1}
        HWAccelEnable={true}
        onEvent={(code, msg) => {
          console.log(`Event code: ${code}, message: ${msg}`);
        }}
      />
    </View>
  );
}
```

### Props

### `url` (string)
- **Description**: The URL of the media stream to play.
- **Example**: `url="rtmp://yourstreamurl/live/streamkey"`

### `volume` (number)
- **Description**: Controls the playback volume.
- **Default**: `1.0` (full volume)
- **Example**: `volume={0.5}`

### `autoplay` (bool)
- **Description**: If `true`, the player will automatically start playing when the component mounts.
- **Default**: `false`
- **Example**: `autoplay={true}`

### `cryptoKey` (string)
- **Description**: A key used for decrypting the media stream if it's encrypted.
- **Example**: `cryptoKey="your_crypto_key_here"`

### `bufferTime` (number)
- **Description**: The buffer time in milliseconds before playback starts. Adjusting this can help with stream stability.
- **Default**: `300` (milliseconds)
- **Example**: `bufferTime={500}`

### `scaleMode` (number)
- **Description**: Sets the scaling mode of the video.
  - `0`: Stretch to fill
  - `1`: Maintain aspect ratio (fit within the view)
  - `2`: Maintain aspect ratio (crop to fill the view)
- **Default**: `1`
- **Example**: `scaleMode={2}`

### `HWAccelEnable` (bool)
- **Description**: Enables hardware acceleration for video decoding if available on the device.
- **Default**: `true`
- **Example**: `HWAccelEnable={false}`

### `HTTPReferer` (string)
- **Description**: Sets the HTTP referer header for the stream request.
- **Example**: `HTTPReferer="https://yourdomain.com"`

### `HTTPUserAgent` (string)
- **Description**: Sets the HTTP user-agent header for the stream request.
- **Example**: `HTTPUserAgent="YourCustomUserAgent/1.0"`

### `onEvent` (function)
- **Description**: A callback function triggered on player events. It receives two parameters:
  - `code`: The event code
  - `msg`: The event message
- **Example**: 
  ```jsx
  onEvent={(code, msg) => {
    console.log(`Event code: ${code}, message: ${msg}`);
  }}
## Demo
https://github.com/NodeMedia/iShow
