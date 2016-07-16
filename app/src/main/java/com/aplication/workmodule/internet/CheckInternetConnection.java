package com.aplication.workmodule.internet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aplication.workmodule.R;

public class CheckInternetConnection extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    private Button checkConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_internet_connection);

        // Manually checking internet connection
//        checkConnection();

        checkConnection = (Button)findViewById(R.id.btn_check);
        checkConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkConnection();
            }
        });

    }

    // Method to manually check connection status
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        
        if(isConnected){
            Toast.makeText(CheckInternetConnection.this, "Internet connection is available", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(CheckInternetConnection.this, "Not Available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MyApplication.getInstance().setConnectivityListener(this);
    }

    /**
     * Callback will be triggered when there is change in
     * network connection
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
//        checkConnection();
    }
}
