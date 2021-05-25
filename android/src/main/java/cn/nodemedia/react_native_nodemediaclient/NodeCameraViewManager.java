//
//  NodeCameraViewManager.java
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017年 NodeMedia. All rights reserved.
//

package cn.nodemedia.react_native_nodemediaclient;

import android.util.Log;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nullable;

public class NodeCameraViewManager extends ViewGroupManager<RCTNodeCameraView> {

    private static final int COMMAND_STARTPREV_ID = 0;
    private static final String COMMAND_STARTPREV_NAME = "startprev";
    private static final int COMMAND_STOPPREV_ID = 1;
    private static final String COMMAND_STOPPREV_NAME = "stopprev";
    private static final int COMMAND_START_ID = 2;
    private static final String COMMAND_START_NAME = "start";
    private static final int COMMAND_STOP_ID = 3;
    private static final String COMMAND_STOP_NAME = "stop";
    private static final int COMMAND_SWITCH_CAM_ID = 4;
    private static final String COMMAND_SWITCH_CAM_NAME = "switchCamera";
    private static final int COMMAND_SWITCH_FLASH_ID = 5;
    private static final String COMMAND_SWITCH_FLASH_NAME = "flashEnable";
    private static final int COMMAND_SET_VIDEO_PARAM_PRESET_ID = 6;
    private static final String COMMAND_SET_VIDEO_PARAM_PRESET_NAME = "setVideoParamPreset";

    @Override
    public String getName() {
        return "RCTNodeCamera";
    }

    @Override
    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder()
                .put("topChange", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onStatus")))
                .build();
    }

    @Override
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override
    protected RCTNodeCameraView createViewInstance(ThemedReactContext reactContext) {
        RCTNodeCameraView view = new RCTNodeCameraView(reactContext);
        return view;
    }

    @ReactProp(name = "outputUrl")
    public void setOutputUrl(RCTNodeCameraView view, @Nullable String outputUrl) {
        view.setOutputUrl(outputUrl);
    }

    @ReactProp(name = "autopreview")
    public void setAutoPreview(RCTNodeCameraView view, @Nullable Boolean autoPreview) {
        if (autoPreview == true) {
            view.audioPreview();
        } else {
            view.stopPrev();
        }
    }

    @ReactProp(name = "camera")
    public void setCameraParam(RCTNodeCameraView view, ReadableMap cameraParam) {
        view.setCamera(cameraParam.getInt("cameraId"), cameraParam.getBoolean("cameraFrontMirror"));
    }

    @ReactProp(name = "audio")
    public void setAudioParam(RCTNodeCameraView view, ReadableMap audioParam) {
        view.setAudio(audioParam.getInt("bitrate"), audioParam.getInt("profile"), audioParam.getInt("samplerate"));
    }

    @ReactProp(name = "video")
    public void setVideoParam(RCTNodeCameraView view, ReadableMap videoParam) {
        view.setVideo(videoParam.getInt("preset"), videoParam.getInt("fps"), videoParam.getInt("bitrate"),
                videoParam.getInt("profile"), videoParam.getBoolean("videoFrontMirror"));
    }

    @ReactProp(name = "denoise")
    public void setDenoise(RCTNodeCameraView view, boolean denoise) {
        view.setDenoise(denoise);
    }

    @ReactProp(name = "dynamicRateEnable")
    public void setDynamicRateEnable(RCTNodeCameraView view, boolean dynamicRateEnable) {
        view.setDynamicRateEnable(dynamicRateEnable);
    }

    @ReactProp(name = "smoothSkinLevel")
    public void setSmoothSkinLevel(RCTNodeCameraView view, int level) {
        view.setSmoothSkinLevel(level);
    }

    @ReactProp(name = "cryptoKey")
    public void setCryptoKey(RCTNodeCameraView view, @Nullable String cryptoKey) {
        view.setCryptoKey(cryptoKey);
    }

    @Nullable
    @Override
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of(COMMAND_STARTPREV_NAME, COMMAND_STARTPREV_ID, COMMAND_STOPPREV_NAME, COMMAND_STOPPREV_ID,
                COMMAND_START_NAME, COMMAND_START_ID, COMMAND_STOP_NAME, COMMAND_STOP_ID, COMMAND_SWITCH_CAM_NAME,
                COMMAND_SWITCH_CAM_ID, COMMAND_SWITCH_FLASH_NAME, COMMAND_SWITCH_FLASH_ID, COMMAND_SET_VIDEO_PARAM_PRESET_NAME, COMMAND_SET_VIDEO_PARAM_PRESET_ID);
    }

    @Override
    public void receiveCommand(RCTNodeCameraView root, int commandId, @Nullable ReadableArray args) {
        switch (commandId) {
            case COMMAND_STARTPREV_ID:
                root.startPrev();
                break;
            case COMMAND_STOPPREV_ID:
                root.stopPrev();
                break;
            case COMMAND_START_ID:
                root.start();
                break;
            case COMMAND_STOP_ID:
                root.stop();
                break;
            case COMMAND_SWITCH_CAM_ID:
                root.switchCam();
                break;
            case COMMAND_SWITCH_FLASH_ID:
                root.setFlashEnable(args.getBoolean(0));
                break;
            case COMMAND_SET_VIDEO_PARAM_PRESET_ID:
                setVideoParam(root, args.getMap(0));
                break;
        }
    }
}
