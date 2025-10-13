//
//  NodePlayer.js
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

import React from 'react';
import { PropTypes } from 'prop-types';
import { requireNativeComponent, UIManager, findNodeHandle } from 'react-native';

class NodePlayer extends React.Component {

    componentDidMount = () => {
        if (this.props.autoplay) {
            this.start();
        }
    }

    componentWillUnmount = () => {
        this.stop();
    }

    start = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this), "start", []);
    }


    stop = () => {
        UIManager.dispatchViewManagerCommand(findNodeHandle(this), "stop", []);
    }

    _onChange(event) {
        if (this.props.onEvent) {
            this.props.onEvent(event.nativeEvent.code, event.nativeEvent.msg);;
        }
    }

    render() {
        return <RCTNodePlayer
            {...this.props}
            onChange={this._onChange.bind(this)}
        />
    }
}

NodePlayer.propTypes = {
    url: PropTypes.string,
    volume: PropTypes.number,
    autoplay: PropTypes.bool,
    cryptoKey: PropTypes.string,
    bufferTime: PropTypes.number,
    scaleMode: PropTypes.number,
    HWAccelEnable: PropTypes.bool,
    HTTPReferer: PropTypes.string,
    HTTPUserAgent: PropTypes.string,
    onEvent: PropTypes.func,
};

const RCTNodePlayer = requireNativeComponent('RCTNodePlayer', NodePlayer, {
    nativeOnly: { onChange: true }
});

export default NodePlayer;