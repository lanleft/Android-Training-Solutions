package com.example.form_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText fullName = (EditText) findViewById(R.id.edit_name);
        EditText studentID = (EditText) findViewById(R.id.edit_sid);
        EditText dateBirth = (EditText) findViewById(R.id.edit_date);
        EditText phoneNumber = (EditText) findViewById(R.id.text_phone);
        EditText email = (EditText) findViewById(R.id.edit_email);

        Button submitButton = (Button) findViewById(R.id.button_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = "TAG";
                String str_fullname = fullName.getText().toString();
                String str_studentID = studentID.getText().toString();
                String str_dateBirth = dateBirth.getText().toString();
                String str_phoneNumber = phoneNumber.getText().toString();
                String str_email = email.getText().toString();
                Log.d(tag, str_fullname);

                if (str_fullname.equals("") || str_studentID.equals("") || str_dateBirth.equals("") || str_phoneNumber.equals("") || str_email.equals("")){
                    Toast toast = Toast.makeText(MainActivity.this, R.string.submit_fail, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, R.string.submit_correct, Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }



}