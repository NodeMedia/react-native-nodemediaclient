//
//  NodePublisher.js
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

import React from 'react';
import { PropTypes } from 'prop-types';
import { requireNativeComponent, UIManager, findNodeHandle } from 'react-native';

class NodePublisher extends React.Component {

    componentDidMount = () => {
        if (this.props.videoParam) {
            this.startPreview();
        }
    }

    componentWillUnmount = () => {
        this.stopPreview();
        this.stop();
    }

    start = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this), "start", []);
    }

    stop = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this), "stop", []);
    }

    startPreview = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this), "startPreview", []);
    }

    stopPreview = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this), "stopPreview", []);
    }

    _onChange(event) {
        if (this.props.onEvent) {
            this.props.onEvent(event.nativeEvent.code, event.nativeEvent.msg);;
        }
    }

    render() {
        return <RCTNodePublisher
            {...this.props}
            onChange={this._onChange.bind(this)}
        />
    }
}

NodePublisher.propTypes = {
    url: PropTypes.string,
    audioParam: PropTypes.shape({
        codecid: PropTypes.number,
        profile: PropTypes.number,
        samplerate: PropTypes.oneOf([8000, 16000, 32000, 44100, 48000]),
        channels: PropTypes.oneOf([1, 2]),
        bitrate: PropTypes.number,
    }),
    videoParam: PropTypes.shape({
        codecid: PropTypes.number,
        profile: PropTypes.number,
        width: PropTypes.number,
        height: PropTypes.number,
        fps: PropTypes.number,
        bitrate: PropTypes.number,
    }),
    cryptoKey: PropTypes.string,
    HWAccelEnable: PropTypes.bool,
    denoiseEnable: PropTypes.bool,
    torchEnable: PropTypes.bool,
    enhancedRtmp: PropTypes.bool,
    frontCamera: PropTypes.bool,
    cameraDevice: PropTypes.number,
    roomRatio: PropTypes.number,
    videoOrientation: PropTypes.number,
    keyFrameInterval: PropTypes.number,
    volume: PropTypes.number,
    onEvent: PropTypes.func,
};
NodePublisher.NMC_CODEC_ID_H264 = 27;
NodePublisher.NMC_CODEC_ID_H265 = 173;
NodePublisher.NMC_CODEC_ID_AAC = 86018;
NodePublisher.NMC_PROFILE_AUTO = 0;
NodePublisher.NMC_PROFILE_H264_BASELINE = 66;
NodePublisher.NMC_PROFILE_H264_MAIN = 77;
NodePublisher.NMC_PROFILE_H264_HIGH = 100;
NodePublisher.NMC_PROFILE_H265_MAIN = 1;
NodePublisher.NMC_PROFILE_AAC_LC = 1;
NodePublisher.NMC_PROFILE_AAC_HE = 4;
NodePublisher.NMC_PROFILE_AAC_HE_V2 = 28;
NodePublisher.NMC_PROFILE_AAC_LD = 22;
NodePublisher.NMC_PROFILE_AAC_ELD = 38;
NodePublisher.VIDEO_ORIENTATION_PORTRAIT = 1;
NodePublisher.VIDEO_ORIENTATION_LANDSCAPE_RIGHT = 3;
NodePublisher.VIDEO_ORIENTATION_LANDSCAPE_LEFT = 4;
NodePublisher.FLAG_AF = 1;
NodePublisher.FLAG_AE = 2;
NodePublisher.FLAG_AWB = 4;
NodePublisher.NMC_DEVICE_TYPE_WideAngleCamera = 0 // 广角
NodePublisher.NMC_DEVICE_TYPE_TelephotoCamera = 1 // 长焦
NodePublisher.NMC_DEVICE_TYPE_UltraWideCamera = 2 // 超广角
NodePublisher.NMC_DEVICE_TYPE_DualCamera = 3 // 双摄
NodePublisher.NMC_DEVICE_TYPE_TripleCamera = 4 // 三摄

const RCTNodePublisher = requireNativeComponent('RCTNodePublisher', NodePublisher, {
    nativeOnly: { onChange: true }
});

export default NodePublisher;