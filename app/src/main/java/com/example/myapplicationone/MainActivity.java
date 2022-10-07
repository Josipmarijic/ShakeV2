package com.example.myapplicationone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager mySensorManager;
    Sensor accl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(mySensorManager != null){
            accl = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if(accl != null){
                mySensorManager.registerListener(this, accl, mySensorManager.SENSOR_DELAY_NORMAL);
            }

        }else{
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT);
        }

        //t1.setText("X: ");
        //t2.setText("Y: ");
        //t3.setText("Z: ");
    }

    @Override
    public void onSensorChanged(SensorEvent event){

        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            TextView t1 = (TextView) findViewById(R.id.textView7);
            TextView t2 = (TextView) findViewById(R.id.textView8);
            TextView t3 = (TextView) findViewById(R.id.textView9);

            t1.setText("X: " + event.values[0]);
            t2.setText("Y: " + event.values[1]);
            t3.setText("Z: " + event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }
}

