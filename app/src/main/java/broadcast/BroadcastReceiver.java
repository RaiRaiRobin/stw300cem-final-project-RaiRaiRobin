package broadcast;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.example.finalandroidassignmentproject.NurseActivity;

public class BroadcastReceiver extends android.content.BroadcastReceiver {
    public BroadcastReceiver(NurseActivity nurseActivity) {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean noConnectivity;

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false);

            if (noConnectivity) {
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(context,"Connected",Toast.LENGTH_SHORT).show();
            }

        }
    }
}
