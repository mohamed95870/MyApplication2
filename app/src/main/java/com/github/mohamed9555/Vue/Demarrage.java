package com.github.mohamed9555.Vue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import com.github.mohamed9555.R;

public class Demarrage extends AppCompatActivity {

 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_demarrage);
     Runnable runnable = new Runnable() {
         @Override
         public void run() {
             Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
             startActivity(intent);
             finish();
         }
     };

     new Handler().postDelayed(runnable, 3000);

 }



}