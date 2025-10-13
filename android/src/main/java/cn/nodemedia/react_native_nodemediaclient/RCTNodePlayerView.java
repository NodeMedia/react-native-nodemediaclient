//
//  RCTNodePlayerView.java
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

package cn.nodemedia.react_native_nodemediaclient;

import android.widget.FrameLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import cn.nodemedia.NodePlayer;

public class RCTNodePlayerView extends FrameLayout implements LifecycleEventListener {
    private NodePlayer np;
    private String url = "";

    public RCTNodePlayerView(ThemedReactContext context) {
        super(context);
        context.addLifecycleEventListener(this);
        np = new NodePlayer(context, RCTNodeMediaClient.getLicense());
        np.attachView(this);
        np.setOnNodePlayerEventListener((player, code, msg) -> {
            WritableMap event = Arguments.createMap();
            event.putInt("code", code);
            event.putString("msg", msg);
            ReactContext reactContext = (ReactContext) getContext();
            reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                    getId(),
                    "topChange",
                    event);
        });
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBufferTime(int bufferTime) {
        np.setBufferTime(bufferTime);
    }

    public void setScaleMode(int mode) {
        np.setScaleMode(mode);
    }

    public void setCryptoKey(String key) {
        np.setCryptoKey(key);
    }

    public void setHWAccelEnable(boolean HWAccelEnable) {
        np.setHWAccelEnable(HWAccelEnable);
    }

    public void setHTTPReferer(String HTTPReferer) {
        np.setHTTPReferer(HTTPReferer);
    }

    public void setHTTPUserAgent(String HTTPUserAgent) {
        np.setHTTPUserAgent(HTTPUserAgent);
    }

    public int start() {
        return np.start(this.url);
    }

    public int stop() {
        return np.stop();
    }

    @Override
    public void onHostResume() {

    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {
        np.stop();
        np.detachView();
    }
}
