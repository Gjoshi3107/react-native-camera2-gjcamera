package com.gjcamera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

import static android.support.v4.content.ContextCompat.startActivity;

public class GJCameraModule extends ReactContextBaseJavaModule {

    private Promise promise;


    public GJCameraModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @ReactMethod
    public String show() {
        String imagePath = "";
        String imageName = "";
        imageName = "";//GJCamera.sendPath();
        imagePath = Environment.getExternalStorageDirectory() + "/DCIM/Camera/" + imageName + ".jpg";
        return imagePath.toString();
    }

    @ReactMethod
    public void openCamera(final Promise promise) {
        Toast.makeText(getReactApplicationContext(), "LOLZ", Toast.LENGTH_SHORT).show();
        try {
            GJCamera gjc = GJCamera.newInstance();
            gjc.setPromise(promise);
            Intent intent = new Intent(getCurrentActivity(), GJCamera.class);
            getCurrentActivity().startActivity(intent);
            Toast.makeText(getReactApplicationContext(), "LOLZ--Return", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            promise.reject(e.getMessage(), e.getMessage());
        }
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

//    @SuppressLint("StaticFieldLeak")
//    void processRedirect(@Nullable Uri redirectData) {
//        final Promise promise = mCreateSourcePromise;
//
//        // Nulls those properties to avoid processing them twice
//        mCreatedSource = null;
//        mCreateSourcePromise = null;
//
//        new AsyncTask<Void, Void, Void>() {
//            switch(source.getStatus())
//
//            {
//                case Source.CHARGEABLE:
//                case Source.CONSUMED:
//                    promise.resolve(convertSourceToWritableMap(source));
//                    break;
//                case Source.CANCELED:
//                    promise.reject(
//                            getErrorCode(mErrorCodes, "redirectCancelled"),
//                            getDescription(mErrorCodes, "redirectCancelled")
//                    );
//                    break;
//                case Source.PENDING:
//                case Source.FAILED:
//                case Source.UNKNOWN:
//                    promise.reject(
//                            getErrorCode(mErrorCodes, "redirectFailed"),
//                            getDescription(mErrorCodes, "redirectFailed")
//                    );
//            }
//                return null;
//
//        }.execute();
//    }
}

