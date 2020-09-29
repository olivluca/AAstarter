package org.ventoso.aastarter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.content.ContextCompat;

public class BootActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent bootintent = new Intent(context, ServerService.class);
        ContextCompat.startForegroundService(context, bootintent);
    }
}
