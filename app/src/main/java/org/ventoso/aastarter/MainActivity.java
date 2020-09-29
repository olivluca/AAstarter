package org.ventoso.aastarter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "AAStarter";
    TextView infoIp, infoPort;
    TextView textViewState, textViewPrompt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.exit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        button = findViewById(R.id.stop_service);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ServerService.class);
                stopService(i);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String action = getIntent().getAction();
        if (action !=null ) {
            Intent i = new Intent(this, ServerService.class);
            if (action.equalsIgnoreCase("android.intent.action.MAIN")) {
                startService(i);
            } else
            if (action.equalsIgnoreCase("android.intent.action.LOCKED_BOOT_COMPLETE")) {
                startService(i);
                finish();
            } else
            if (action.equalsIgnoreCase("org.ventoso.aastarter.STOP")) {
                stopService(i);
                finish();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onResume() {
        super.onResume();
        if (Settings.canDrawOverlays(this))
            return;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Overlay permission");
        builder.setMessage("The application needs this permission in order to run in the background. Probably you should also disable battery optimization for this application.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            private static final int ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE = 12345;
            public final void onClick(DialogInterface dialogInterface, int i) {
                startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), ACTION_MANAGE_OVERLAY_PERMISSION_REQUEST_CODE);
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    
     private void updateState(final String state){
        Log.d(TAG, state);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViewState.setText(state);
            }
        });
    }


}