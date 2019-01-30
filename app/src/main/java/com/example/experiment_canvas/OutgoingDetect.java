package com.example.experiment_canvas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * The {@code OutgoingDetect} class gets fired when an outgoing call is made,
 * It shows a toast to the user containing the dialed number.
 *
 * @author manishjoshi394
 */
public class OutgoingDetect extends BroadcastReceiver {

    /**
     * Displays a toast when action specified by {@code intent} matches the {@Intent} for
     * new outgoing call.
     *
     * @param context the Context in which the Receiver is running.
     * @param intent the Intent being received.
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        // check if the Intent's action denotes some outgoing call
        if (intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)) {

            // get callee's number from intent
            String callee = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);

            // show a Long toast
            Toast.makeText(context,
                    "Calling : " + callee,
                    Toast.LENGTH_LONG).show();
        }
    }
}
