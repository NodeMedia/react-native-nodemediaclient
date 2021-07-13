//
//  index.js
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017年 NodeMedia. All rights reserved.
//
import NodeCameraView from "./NodeCameraModule";
import NodePlayerView from "./NodePlayerModule";
import { NativeModules } from "react-native";
module.exports = {
  NodeCameraView,
  NodePlayerView,
  NodeMediaClient: NativeModules.NodeMediaClient,
  OutputStreamStatus: {
    Connecting: 2000,
    Start: 2001,
    Failed: 2002,
    Closed: 2004,
    None: 0,
  },
  InputStreamStatus: {
    Connecting: 1000,
    Connected: 1001,
    Reconnection: 1003,
    Buffering: 1101,
    BufferFull: 1102,
    Resolution: 1104,
    None: 0,
  },
};
