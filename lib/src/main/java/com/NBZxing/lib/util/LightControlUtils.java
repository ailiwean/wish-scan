package com.NBZxing.lib.util;

import android.hardware.Camera;

import com.NBZxing.lib.manager.CameraManager;

/***
 *  Created by SWY
 *  DATE 2019/6/2
 *
 */
public class LightControlUtils {

    private static Camera.Parameters parameters;

    private LightControlUtils() {
    }

    public static void openLight() {

        Camera camera = CameraManager.get().getCamera();

        if (camera == null)
            return;

        parameters = camera.getParameters();
        parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        camera.setParameters(parameters);

    }

    public static void closeLight() {

        Camera camera = CameraManager.get().getCamera();

        if (camera == null)
            return;

        parameters = camera.getParameters();
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
        camera.setParameters(parameters);


    }

}