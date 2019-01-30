package com.example.experiment_canvas;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.PROCESS_OUTGOING_CALLS)
                != PackageManager.PERMISSION_GRANTED) {


            ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.PROCESS_OUTGOING_CALLS },
                    0);
        } else {
            Toast.makeText(this.getApplicationContext(),
                    "Everything's fine! The app is active!",
                    Toast.LENGTH_LONG).show();
            this.finish();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean allGranted = true;
        if (requestCode == 0) {
            for (int i = 0; i < permissions.length; ++i) {
                allGranted &= (grantResults[i] == PackageManager.PERMISSION_GRANTED);
            }
        }
        if (allGranted) {
            Toast.makeText(this.getApplicationContext(),
                    "Thank you for granting permission, we can do our work now!",
                    Toast.LENGTH_LONG).show();
            this.finish();
        } else {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.PROCESS_OUTGOING_CALLS)) {

                Toast.makeText(this.getApplicationContext(),
                        "Please GRANT the Permissions so that we can detect the calls!",
                        Toast.LENGTH_LONG).show();

                this.finish();
            } else {
                Toast.makeText(this.getApplicationContext(),
                        "ERROR : Please grant the Permission from App Info to continue!",
                        Toast.LENGTH_LONG).show();
                this.finish();
            }
        }
    }
}
