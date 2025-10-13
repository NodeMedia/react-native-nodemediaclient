//
//  RCTNodeMediaClient.java
//
//  Created by Mingliang Chen on 2017/11/29.
//  Copyright © 2017-2024年 NodeMedia. All rights reserved.
//

package cn.nodemedia.react_native_nodemediaclient;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RCTNodeMediaClient extends ReactContextBaseJavaModule {
    private static String mLicense = "";

    public RCTNodeMediaClient(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "NodeMediaClient";
    }

    @ReactMethod
    public void setLicense(String license) {
        mLicense = license;
    }

    public static String getLicense() {
        return mLicense;
    }
}
