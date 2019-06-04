package com.gjcamera;
import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class GJCameraModule extends ReactContextBaseJavaModule {


    public GJCameraModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public void openCamera(final Promise promise) {
        Activity currentActivity = getCurrentActivity();
        GJCamera gjc = GJCamera.newInstance();
        gjc.setPromise(promise);
        Intent intent = new Intent(getCurrentActivity(), GJCamera.class);
        currentActivity.startActivity(intent);
    }

    @Override
    public String getName() {
        return "GJCamera";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        String android_id = Settings.System.getString(getReactApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);
        constants.put("uniqueId", android_id);
        return constants;
    }
}

