//
//  RCTNodePublisherManager.java
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

package cn.nodemedia.react_native_nodemediaclient;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nullable;

public class RCTNodePublisherManager extends ViewGroupManager<RCTNodePublisherView> {

    @Override
    public String getName() {
        return "RCTNodePublisher";
    }

    @Override
    protected RCTNodePublisherView createViewInstance(ThemedReactContext reactContext) {
        return new RCTNodePublisherView(reactContext);
    }

    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("topChange", MapBuilder.of("phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onStatus")))
                .build();
    }

    @Override
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @ReactProp(name = "url")
    public void setUrl(RCTNodePublisherView view, @Nullable String url) {
        view.setUrl(url);
    }

    @ReactProp(name = "audioParam")
    public void setAudioParam(RCTNodePublisherView view, ReadableMap audioParam) {
        view.setAudioParam(audioParam.getInt("codecid"), audioParam.getInt("profile"),
                audioParam.getInt("samplerate"), audioParam.getInt("channels"),
                audioParam.getInt("bitrate"));
    }

    @ReactProp(name = "videoParam")
    public void setVideoParam(RCTNodePublisherView view, ReadableMap videoParam) {
        view.setVideoParam(videoParam.getInt("codecid"), videoParam.getInt("profile"),
                videoParam.getInt("width"), videoParam.getInt("height"),
                videoParam.getInt("fps"), videoParam.getInt("bitrate"));
    }

    @ReactProp(name = "cryptoKey")
    public void setCryptoKey(RCTNodePublisherView view, @Nullable String cryptoKey) {
        view.setCryptoKey(cryptoKey);
    }

    @ReactProp(name = "HWAccelEnable")
    public void setHWAccelEnable(RCTNodePublisherView view, boolean HWAccelEnable) {
        view.setHWAccelEnable(HWAccelEnable);
    }

    @ReactProp(name = "denoiseEnable")
    public void setDenoiseEnable(RCTNodePublisherView view, boolean denoiseEnable) {
        view.setDenoiseEnable(denoiseEnable);
    }

    @ReactProp(name = "torchEnable")
    public void setTorchEnable(RCTNodePublisherView view, boolean torchEnable) {
        view.setTorchEnable(torchEnable);
    }

    @ReactProp(name = "enhancedRtmp")
    public void setEnhancedRtmp(RCTNodePublisherView view, boolean enhancedRtmp) {
        view.setEnhancedRtmp(enhancedRtmp);
    }

    @ReactProp(name = "frontCamera")
    public void setFrontCamera(RCTNodePublisherView view, boolean frontCamera) {
        view.setFrontCamera(frontCamera);
    }

    @ReactProp(name = "cameraDevice")
    public void setCameraDevice(RCTNodePublisherView view, int cameraDevice) {
        view.setCameraDevice(cameraDevice);
    }

    @ReactProp(name = "roomRatio")
    public void setRoomRatio(RCTNodePublisherView view, float roomRatio) {
        view.setRoomRatio(roomRatio);
    }

    @ReactProp(name = "videoOrientation")
    public void setVideoOrientation(RCTNodePublisherView view, int videoOrientation) {
        view.setVideoOrientation(videoOrientation);
    }

    @ReactProp(name = "keyFrameInterval")
    public void setKeyFrameInterval(RCTNodePublisherView view, int keyFrameInterval) {
        view.setKeyFrameInterval(keyFrameInterval);
    }

    @ReactProp(name = "volume")
    public void setVolume(RCTNodePublisherView view, float volume) {
        view.setVolume(volume);
    }


    @Override
    public void receiveCommand(@NonNull RCTNodePublisherView root, String commandId, @Nullable ReadableArray args) {
        switch (commandId) {
            case "startPreview" -> root.startPreview();
            case "stopPreview" -> root.stopPreview();
            case "start" -> root.start();
            case "stop" -> root.stop();
        }
    }
}
