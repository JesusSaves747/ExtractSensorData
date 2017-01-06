package com.example.savio.extractsensordata;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by savio on 12/11/16.
 */

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    // Instantiate an object of the type :TextView
    TextView accel_data_x;

    // Declare an object of the sensorManager class:
    private SensorManager mySensorManager;

    // Declare an object for the accelerometer sensor:
    private Sensor myAccel;

    // Declare arrays to store the acceleration and gravity values:
    private static double gravity[];
    public static double linear_acceleration[];


    // This is the constructor for this class:
    public SensorActivity() {

        mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        myAccel = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    protected void onResume() {
        super.onResume();
        mySensorManager.registerListener(this, myAccel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mySensorManager.unregisterListener(this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {


    }

    public void onSensorChanged(SensorEvent event) {

        // What should I do inside this function ??

        // So over here I need to get the accel data values and store them in an array: ??

        final double alpha = 0.8;

        // Gravity is specified in m/s^2

        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

        // Subtract the gravity from Raw Accelerometer to get the Linear Acceleration: All accelerations are in m/s^2:
        linear_acceleration[0] = event.values[0] - gravity[0];
        linear_acceleration[1] = event.values[1] - gravity[1];
        linear_acceleration[2] = event.values[2] - gravity[2];

        // Display this data on a plot:



        // Display this data in a text box:
        accel_data_x = (TextView) findViewById(R.id.accel_data);

        accel_data_x.setText(getString((int) linear_acceleration[0]));

    }

    public void exportValues(){

    }
}
