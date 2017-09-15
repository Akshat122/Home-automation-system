package com.example.akshat.home;

import android.app.Activity;
import android.location.Address;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.ToggleButton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.lang.String;


public class user extends Activity{
    String output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        /********************************/
         /*    Define all the buttons    */
        /********************************/
        Switch led1 = (Switch)findViewById(R.id.Led1);
        Switch led2 = (Switch)findViewById(R.id.Led2);
        Switch led3 = (Switch) findViewById(R.id.Led3);
        Switch led4 = (Switch) findViewById(R.id.Led4);
        Switch led5 = (Switch) findViewById(R.id.Led5);
        Switch led6 = (Switch) findViewById(R.id.Led6);
        Switch led7 = (Switch) findViewById(R.id.Led7);
        Switch led8 = (Switch) findViewById(R.id.Led8);

        /*******************************************************/
         /*  Set an onclick/onchange listener for every button  */
        /*******************************************************/

        led1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    /* Switch is led 1 */
                    new Background_get().execute("led1=1");
                } else {
                    new Background_get().execute("led1=0");
                }
            }
        });

        led2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led2=1");
                } else {
                    new Background_get().execute("led2=0");
                }
            }
        });

        led3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led3=1");
                } else {
                    new Background_get().execute("led3=0");
                }
            }
        });

        led4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led4=1");
                } else {
                    new Background_get().execute("led4=0");
                }
            }
        });
        led5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led5=1");
                } else {
                    new Background_get().execute("led5=0");
                }
            }
        });
        led6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led6=1");
                } else {
                    new Background_get().execute("led6=0");
                }
            }
        });
        led7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led7=1");
                } else {
                    new Background_get().execute("led7=0");
                }
            }
        });
        led8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    /* Toggle button is led 2 */
                    new Background_get().execute("led8=1");
                } else {
                    new Background_get().execute("led8=0");
                }
            }
        });

       /* led10.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View v, MotionEvent event) {
               if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    new Background_get().execute("led3=1");
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    new Background_get().execute("led3=0");
                }
                return true;
            }
        });*/
    }




    private class Background_get extends AsyncTask<String, Void, String> {

        @Override

        protected String doInBackground(String... params) {
            try {
                /* Change the IP to the IP of your RaspberryPi */
                URL url = new URL("http://192.168.1.5/?" + params[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder result = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null)
                    result.append(inputLine).append("\n");

                in.close();
                connection.disconnect();
                return result.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
