//
//  NodeCameraModule.js
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017年 NodeMedia. All rights reserved.
//

import React, { Component } from 'react';
import { PropTypes } from 'prop-types';
import { requireNativeComponent, View, UIManager, findNodeHandle } from 'react-native';



var RCT_VIDEO_REF = 'NodeCameraView';

class NodeCameraView extends Component {
  constructor(props) {
    super(props);
  }
  _onChange(event) {
    if (!this.props.onStatus) {
      return;
    }
    this.props.onStatus(event.nativeEvent.code, event.nativeEvent.msg);
  }

  switchCamera() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.switchCamera,
      null
    );
  }

  flashEnable(enable) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.flashEnable,
      [enable]
    );
  }

  startPreview() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.startprev,
      null
    );
  }

  stopPreview() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.stopprev,
      null
    );
  }

  setVideoParamPreset(video) {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.setVideoParamPreset,
      [video]
    );
  }

  start() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.start,
      null
    );
  }

  stop() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodeCamera').Commands.stop,
      null
    );
  }

  render() {
    return <RCTNodeCamera
      {...this.props}
      ref={RCT_VIDEO_REF}
      onChange={this._onChange.bind(this)}
    />;
  };
}

NodeCameraView.name = RCT_VIDEO_REF;
NodeCameraView.propTypes = {
  outputUrl: PropTypes.string,
  camera: PropTypes.shape({
    cameraId: PropTypes.oneOf([0, 1]),
    cameraFrontMirror: PropTypes.bool
  }),
  audio: PropTypes.shape({
    bitrate: PropTypes.number,
    profile: PropTypes.oneOf([0, 1, 2]),
    samplerate: PropTypes.oneOf([8000, 16000, 32000, 44100, 48000]),
  }),
  video: PropTypes.shape({
    preset: PropTypes.number,
    bitrate: PropTypes.number,
    profile: PropTypes.oneOf([0, 1, 2]),
    fps: PropTypes.oneOf([15, 20, 24, 30]),
    videoFrontMirror: PropTypes.bool
  }),
  autopreview:PropTypes.bool,
  denoise: PropTypes.bool,
  dynamicRateEnable: PropTypes.bool,
  smoothSkinLevel: PropTypes.oneOf([0, 1, 2, 3, 4, 5]),
  cryptoKey:PropTypes.string,
  onStatus: PropTypes.func,
  ...View.propTypes // 包含默认的View的属性
};

const RCTNodeCamera = requireNativeComponent('RCTNodeCamera', NodeCameraView, {
  nativeOnly: { onChange: true }
});

module.exports = NodeCameraView;