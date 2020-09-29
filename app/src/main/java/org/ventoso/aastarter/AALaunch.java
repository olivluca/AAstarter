package org.ventoso.aastarter;

import android.content.Context;
import android.content.Intent;

public class AALaunch {
    private static final String CLASS_NAME_ANDROID_AUTO_WIRELESS = "com.google.android.apps.auto.wireless.setup.service.impl.WirelessStartupActivity";
    private static final String PACKAGE_NAME_ANDROID_AUTO_WIRELESS = "com.google.android.projection.gearhead";
    private static final String PARAM_HOST_ADDRESS_EXTRA_NAME = "PARAM_HOST_ADDRESS";
    private static final String PARAM_SERVICE_PORT_EXTRA_NAME = "PARAM_SERVICE_PORT";

    public static void connect(Context context, String address) {
        Intent intent = new Intent();
        intent.setClassName(PACKAGE_NAME_ANDROID_AUTO_WIRELESS, CLASS_NAME_ANDROID_AUTO_WIRELESS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(PARAM_HOST_ADDRESS_EXTRA_NAME, address).putExtra(PARAM_SERVICE_PORT_EXTRA_NAME, 5288);
        context.startActivity(intent);
    }
}
