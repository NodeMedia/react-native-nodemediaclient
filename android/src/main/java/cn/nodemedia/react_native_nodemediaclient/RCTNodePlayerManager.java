//
//  RCTNodePlayerManager.java
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

package cn.nodemedia.react_native_nodemediaclient;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nullable;

public class RCTNodePlayerManager extends SimpleViewManager<RCTNodePlayerView> {

    @Override
    public String getName() {
        return "RCTNodePlayer";
    }

    @Override
    protected RCTNodePlayerView createViewInstance(@NonNull ThemedReactContext reactContext) {
        return new RCTNodePlayerView(reactContext);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("topChange",
                        MapBuilder.of("phasedRegistrationNames",
                                MapBuilder.of("bubbled", "onChange")))
                .build();
    }

    @ReactProp(name = "url")
    public void setUrl(RCTNodePlayerView view, @Nullable String url) {
        view.setUrl(url);
    }

    @ReactProp(name = "bufferTime")
    public void setBufferTime(RCTNodePlayerView view, int bufferTime) {
        view.setBufferTime(bufferTime);
    }

    @ReactProp(name = "scaleMode")
    public void setScaleMode(RCTNodePlayerView view, int mode) {
        view.setScaleMode(mode);
    }

    @ReactProp(name = "cryptoKey")
    public void setCryptoKey(RCTNodePlayerView view, @Nullable String cryptoKey) {
        view.setCryptoKey(cryptoKey);
    }

    @ReactProp(name = "HWAccelEnable")
    public void setHWAccelEnable(RCTNodePlayerView view, @Nullable boolean HWAccelEnable) {
        view.setHWAccelEnable(HWAccelEnable);
    }

    @ReactProp(name = "HTTPReferer")
    public void setHTTPReferer(RCTNodePlayerView view, @Nullable String HTTPReferer) {
        view.setHTTPReferer(HTTPReferer);
    }

    @ReactProp(name = "HTTPUserAgent")
    public void setHTTPUserAgent(RCTNodePlayerView view, @Nullable String HTTPUserAgent) {
        view.setHTTPUserAgent(HTTPUserAgent);
    }

    @Override
    public void receiveCommand(@NonNull RCTNodePlayerView root, String commandId, @Nullable ReadableArray args) {
        switch (commandId) {
            case "start" -> root.start();
            case "stop" -> root.stop();
        }
    }

}
