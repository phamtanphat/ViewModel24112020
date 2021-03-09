package com.example.viewmodel24112020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyLocationManager mMyLocationManager;
    int REQUEST_CODE_LOCATION = 123;
    TextView mTvLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lifecycle aware component

        mTvLocation = findViewById(R.id.textViewLocation);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    this ,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_LOCATION
                    );
        }else{
            mMyLocationManager = new MyLocationManager(this, new OnListenerLocation() {
                @Override
                public void callbackLocation(Location location) {
                    mTvLocation.setText(location.getLatitude() + " ," + location.getLongitude());
                }
            });
            getLifecycle().addObserver(mMyLocationManager);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_LOCATION){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                mMyLocationManager = new MyLocationManager(this, new OnListenerLocation() {
                    @Override
                    public void callbackLocation(Location location) {
                        mTvLocation.setText(location.getLatitude() + " ," + location.getLongitude());
                    }
                });
                getLifecycle().addObserver(mMyLocationManager);
            }else{
                Toast.makeText(this, "Bạn chưa có quyền truy cập vào GPS của thiết bị", Toast.LENGTH_LONG).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}