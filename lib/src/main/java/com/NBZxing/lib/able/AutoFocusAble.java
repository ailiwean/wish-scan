package com.NBZxing.lib.able;

import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;

import com.NBZxing.lib.config.AutoFocusConfig;
import com.NBZxing.lib.config.CameraConfig;
import com.NBZxing.lib.listener.AutoFocusCallback;
import com.NBZxing.lib.listener.SensorChangeCallback;
import com.NBZxing.lib.manager.CameraManager;
import com.NBZxing.lib.manager.PixsValuesCus;
import com.NBZxing.lib.manager.SensorManager;
import com.NBZxing.lib.util.AccountUtils;


/***
 *  Created by SWY
 *  DATE 2019/6/8
 *
 */
public class AutoFocusAble implements PixsValuesCus {

    private Handler timeHandler;

    private boolean isFrist = false;

    private volatile long lastFocusTime = 0;

    //上次广场强度根据不同的广场强度变换确定是否需要调焦
    private int lastAcDark = 0;
    private final HandlerThread handlerThread;

    private void startAutoFocus() {
        if (CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.TIME)
            setTimeAutoFocus();
        if (CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.SENSOR)
            setSensorAutoFocus();
        if (CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.Hybride)
            setSensorAutoFocus();
    }

    @Override
    public void cusAction(byte[] data, Camera camera, int x, int y) {


        if (CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.PIXVALUES) {

            setPixvaluesAutoFocus(data, camera);

        } else if (CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.SENSOR
                || CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.TIME) {

            if (!isFrist) {
                startAutoFocus();
                isFrist = true;
            }
        } else if (CameraConfig.getInstance().getAutoFocusModel() == AutoFocusConfig.Hybride) {

            //  setPixvaluesAutoFocus(data, camera);

            if (!isFrist) {
                startAutoFocus();
                isFrist = true;
            }
        }

    }

    @Override
    public void stop() {
        handlerThread.interrupt();
        timeHandler.removeCallbacksAndMessages(null);
        SensorManager.getInstance().stopListener();
    }

    private final long TIMEINTERVAL = 1500L;
    private int model = 0;

    private AutoFocusAble() {
        handlerThread = new HandlerThread("time");
        handlerThread.start();
        timeHandler = new Handler(handlerThread.getLooper());
    }

    private static class Holder {
        static AutoFocusAble INSTANCE = new AutoFocusAble();
    }

    public static AutoFocusAble getInstance() {
        return AutoFocusAble.Holder.INSTANCE;
    }

    private void setFocus() {

        if (System.currentTimeMillis() - lastFocusTime < CameraConfig.getInstance().getTimeThreshold())
            return;

        lastFocusTime = System.currentTimeMillis();

        if (CameraManager.get().getCamera() == null)
            return;

        Camera camera = CameraManager.get().getCamera();
        camera.autoFocus(AutoFocusCallback.getInstance());

    }

    private void setTimeAutoFocus() {
        timeHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setFocus();
                timeHandler.postDelayed(this, TIMEINTERVAL);
            }
        }, TIMEINTERVAL);
    }

    private void setSensorAutoFocus() {

        SensorManager.getInstance().registerListener(new SensorChangeCallback() {
            @Override
            public void change() {
                setFocus();
            }
        })
                .startListener();

    }

    private void setPixvaluesAutoFocus(byte[] data, Camera camera) {

        int avDark = AccountUtils.getAvDark(data);
        //变换值大于10开始调焦
        if (Math.abs(lastAcDark - avDark) > 10) {
            setFocus();
            lastAcDark = avDark;
        }

    }
}