//
//  NodePlayerModule.js
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017年 NodeMedia. All rights reserved.
//

import React, { Component } from 'react';
import { PropTypes } from 'prop-types';
import { requireNativeComponent, View, UIManager, findNodeHandle } from 'react-native';



var RCT_VIDEO_REF = 'NodePlayerView';

class NodePlayerView extends Component {
  constructor(props) {
    super(props);
  }
  _onChange(event) {
    if (!this.props.onStatus) {
      return;
    }
    this.props.onStatus(event.nativeEvent.code, event.nativeEvent.msg);
  }

  pause() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodePlayer').Commands.pause,
      null
    );
  }

  start() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodePlayer').Commands.start,
      null
    );
  }

  stop() {
    UIManager.dispatchViewManagerCommand(
      findNodeHandle(this.refs[RCT_VIDEO_REF]),
      UIManager.getViewManagerConfig('RCTNodePlayer').Commands.stop,
      null
    );
  }

  render() {
    return <RCTNodePlayer
      {...this.props}
      ref={RCT_VIDEO_REF}
      onChange={this._onChange.bind(this)}
    />;
  };
}
NodePlayerView.name = RCT_VIDEO_REF;
NodePlayerView.propTypes = {
  inputUrl: PropTypes.string,
  bufferTime: PropTypes.number,
  maxBufferTime: PropTypes.number,
  autoplay: PropTypes.bool,
  audioEnable: PropTypes.bool,
  scaleMode: PropTypes.oneOf(['ScaleToFill', 'ScaleAspectFit', 'ScaleAspectFill']),
  renderType: PropTypes.oneOf(['SURFACEVIEW', 'TEXTUREVIEW']),
  cryptoKey:PropTypes.string,
  onStatus: PropTypes.func,
  ...View.propTypes // 包含默认的View的属性
};

const RCTNodePlayer = requireNativeComponent('RCTNodePlayer', NodePlayerView, {
  nativeOnly: { onChange: true }
});

module.exports = NodePlayerView;