package com.example.akshat.home;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static EditText username ;
    private static EditText password;
    private static Button login_btn;
    AutoCompleteTextView auto1;
    String[] Name= {"xyz","xyz1","xyz2","xyz3","xyz4"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginBtn();
        auto1 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item,Name);
        auto1.setThreshold(1);
        auto1.setAdapter(adapter);
    }
public void LoginBtn(){

    password = (EditText)findViewById(R.id.editText);
    //password = (EditText)findViewById(R.id.editText2);
    login_btn = (Button)findViewById(R.id.button);

    login_btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(auto1.getText().toString().equals("Akshat")
                            && password.getText().toString().equals("Home@1234") ) {
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent("com.example.akshat.home.user");
                        startActivity(intent);
                    }
                    else if(auto1.getText().toString().equals("")
                            || password.getText().toString().equals("") ) {

                        Toast.makeText(MainActivity.this, "Enter Text", Toast.LENGTH_SHORT).show();
                    }
                else
                {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();

                }
                }
            }

    );
}
}
