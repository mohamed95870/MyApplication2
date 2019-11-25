package com.github.mohamed9555;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity {
    private ImageView play;
    private ImageView radio;
    private ImageView sms;
    private ImageView camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       this.play = (ImageView) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
               Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
               startActivity(otherActivity);
               finish();
          }
        });


       this.sms = (ImageView)findViewById(R.id.sms);
        sms.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
               Intent otherActivity = new Intent(getApplicationContext(), Sms.class);
              startActivity(otherActivity);
              finish();
           }
        });


        this.camera = (ImageView)findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), Photo.class);
                startActivity(otherActivity);
                finish();
            }
        });

    }
}
