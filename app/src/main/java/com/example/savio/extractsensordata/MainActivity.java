package com.example.savio.extractsensordata;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




// Main Class that defines the Main Activity of the app:
public class MainActivity extends AppCompatActivity {

//    // Instantiate an object of the type :TextView
//    TextView accel_data_x;

    //Instantiate an object for the Button: 'Button' is a superclass of TextView and TextView is a superclass of View:
    // The function findViewById returns the View associated with the id given as its input argument.
    // Now what does casting do exactly??: Casting takes the returned 'View' object and upcasts it an android.widget.Button object:

    Button btn;


//    // Declare an object of the sensorManager class:
//    private SensorManager mySensorManager;
//
//    // Declare an object for the accelerometer sensor:
//    private Sensor myAccel;

    // Declare an object for a Sensor event:


    // This function gets called when the activity is created: How is it different from the constructor?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn  = (Button) findViewById(R.id.get_accel_button);

        // Going the conventional way: Setting up an OnClickListener for the Button object: NOTE: This needs to be inside the onCreate function otherwise the function
        // cannot be found under the Button Class:

        // The 'setOnClickListener' function registers an onClickListner to the object that invokes it.
        // The input argument is the onClickListner:

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                // Initialize mySensorManager: Use the Context function getSystemService to get an abstract object of type 'Object' and then
//                // upcast it to mySensorManager:
//                mySensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//
//
//                // Get an accelerometer object from the Sensor Manager:
//                myAccel= mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


                // Create and initialize the object of type SensorActivity:
                SensorActivity testSensorAct = new SensorActivity();



            }
        });


    };



    // Create a function that is called whenver the value of the sensor changed:





    // This is the callback function for the Pushbutton:
    public void onButtonClick(View v){

    SensorActivity accel_sensor_act = new SensorActivity();

        TextView accel_data = (TextView) findViewById(R.id.accel_data);

         double[] disp_values= accel_sensor_act.linear_acceleration;

        // Display these values in a text box:

        accel_data.setText("Savio");

    }
}
