package com.example.shaufyq.schoollab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    TextView editTextViewName;
    TextView editTextViewBirth;
    Button  submit;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editTextViewName = findViewById(R.id.editTextName);
        editTextViewBirth = findViewById(R.id.editTextBrith);
        submit = findViewById(R.id.submit);
        textView = findViewById(R.id.textView);

    }

    public void fnGreet(View vw){
       String strName = editTextViewName.getText().toString();
       textView.setText("Hello and welcome "+strName);
    }

    public void fnThreadActivity(View vw){
        Intent intent = new Intent(this,ThreadedActivity.class);
        String strMsg = editTextViewName.getText().toString();
        intent.putExtra("name",strMsg);
        startActivity(intent);
    }
}
