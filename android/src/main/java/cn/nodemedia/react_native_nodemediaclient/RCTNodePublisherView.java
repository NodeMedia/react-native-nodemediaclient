//
//  RCTNodePublisherView.java
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

package cn.nodemedia.react_native_nodemediaclient;

import android.view.Choreographer;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import cn.nodemedia.NodePublisher;

public class RCTNodePublisherView extends FrameLayout implements LifecycleEventListener {
    private NodePublisher np;
    private String url = "";

    private boolean mFrontCamera = true;

    private int mCameraDevice = 0;

    private boolean mIsPreview = false;

    public RCTNodePublisherView(@NonNull ThemedReactContext context) {
        super(context);
        context.addLifecycleEventListener(this);
        np = new NodePublisher(context.getCurrentActivity(), RCTNodeMediaClient.getLicense());
        np.attachView(this);
        np.setOnNodePublisherEventListener((publisher, code, msg) -> {
            WritableMap event = Arguments.createMap();
            event.putInt("code", code);
            event.putString("msg", msg);
            ReactContext reactContext = (ReactContext) getContext();
            reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                    getId(),
                    "topChange",
                    event);
        });
        setupLayoutHack();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCryptoKey(String cryptoKey) {
        np.setCryptoKey(cryptoKey);
    }

    public void setAudioParam(int codec, int profile, int sampleRate, int channels, int bitrate) {
        np.setAudioCodecParam(codec, profile, sampleRate, channels, bitrate);
    }

    public void setVideoParam(int codec, int profile, int width, int height, int fps, int bitrate) {
        np.setVideoCodecParam(codec, profile, width, height, fps, bitrate);
    }

    public void setHWAccelEnable(boolean HWAccelEnable) {
        np.setHWAccelEnable(HWAccelEnable);
    }

    public void setDenoiseEnable(boolean denoiseEnable) {
        np.setDenoiseEnable(denoiseEnable);
    }

    public void setTorchEnable(boolean torchEnable) {
        np.enableTorch(torchEnable);
    }

    public void setEnhancedRtmp(boolean enhancedRtmp) {
        np.setEnhancedRtmp(enhancedRtmp);
    }

    public void setFrontCamera(boolean frontCamera) {
        if(mFrontCamera != frontCamera) {
            mFrontCamera = frontCamera;
            if(mIsPreview) {
                this.stopPreview();
                this.startPreview();
            }
        }
    }

    public void setCameraDevice(int cameraDevice) {
        mCameraDevice = cameraDevice;
    }

    public void setRoomRatio(float roomRatio) {
        np.setRoomRatio(roomRatio);
    }

    public void setVideoOrientation(int videoOrientation) {
        // 兼容iOS定义
        switch (videoOrientation) {
            case 1 -> np.setVideoOrientation(NodePublisher.VIDEO_ORIENTATION_PORTRAIT);
            case 3 -> np.setVideoOrientation(NodePublisher.VIDEO_ORIENTATION_LANDSCAPE_RIGHT);
            case 4 -> np.setVideoOrientation(NodePublisher.VIDEO_ORIENTATION_LANDSCAPE_LEFT);
        }
    }

    public void setKeyFrameInterval(int keyFrameInterval) {
        np.setKeyFrameInterval(keyFrameInterval);
    }

    public void setVolume(float volume) {
        np.setVolume(volume);
    }

    public void startPreview() {
        mIsPreview = true;
        np.openCamera(mFrontCamera);
    }

    public void stopPreview() {
        mIsPreview = false;
        np.closeCamera();
    }

    public void start() {
        np.start(this.url);
    }

    public void stop() {
        np.stop();
    }

    @Override
    public void onHostResume() {
    }

    @Override
    public void onHostPause() {

    }

    @Override
    public void onHostDestroy() {
        np.closeCamera();
        np.detachView();
        np.stop();
    }

    void setupLayoutHack() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                manuallyLayoutChildren();
                getViewTreeObserver().dispatchOnGlobalLayout();
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }

    void manuallyLayoutChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int ww = getMeasuredWidth();
            int wh = getMeasuredHeight();
            int cw = child.getMeasuredWidth();
            int ch = child.getMeasuredHeight();
            child.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MeasureSpec.EXACTLY),
                    MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MeasureSpec.EXACTLY));
            child.layout(0, 0, child.getMeasuredWidth(), child.getMeasuredHeight());
        }
    }
}
