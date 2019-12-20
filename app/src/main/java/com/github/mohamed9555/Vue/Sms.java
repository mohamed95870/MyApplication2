package com.github.mohamed9555.Vue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.github.mohamed9555.R;

public class Sms extends AppCompatActivity {

    private EditText phone;
    private EditText message;
    private Button envoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sms);
        initActivity();
    }

    private void initActivity(){
        phone =(EditText)findViewById(R.id.txtPhone);
        message=(EditText)findViewById(R.id.txtMessage);
        envoi = (Button)findViewById(R.id.btnEnvoi);
        createOnClickEnvoiButton();
    }

   private void createOnClickEnvoiButton(){
       envoi.setOnClickListener(new Button.OnClickListener() {
       public void onClick(View v){
            SmsManager.getDefault().sendTextMessage(phone.getText().toString(), null,
            message.getText().toString(),null,null);
      }
      });
}}