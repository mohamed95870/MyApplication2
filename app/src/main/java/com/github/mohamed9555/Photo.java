package com.github.mohamed9555;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Photo extends AppCompatActivity {

    private static final int RETOUR_PRENDRE_PHOTO=1;
    private Button btnPrendrePhoto;
    private ImageView imgAffichePhoto;
    private String photoPath = null;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        initActivity();
    }

    private void initActivity(){

    btnPrendrePhoto = (Button)findViewById(R.id.btnPrendrePhoto);
    imgAffichePhoto = (ImageView)findViewById(R.id.imgAffichePhoto);
    createOnClickBtnPrendrePhoto();

    }

    private void createOnClickBtnPrendrePhoto(){
        btnPrendrePhoto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                prendreUnePhoto();

            }
        });
    }

    private void prendreUnePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File photoDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
            try {
                File photoFile = File.createTempFile("photo" + time, ".jpg", photoDir);
                photoPath = photoFile.getAbsolutePath();
                Uri photoUri = FileProvider.getUriForFile(Photo.this, Photo.this.getApplicationContext().getPackageName() + ".provider",
                        photoFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                startActivityForResult(intent, RETOUR_PRENDRE_PHOTO);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
        @Override
         protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode ==RETOUR_PRENDRE_PHOTO && resultCode==RESULT_OK){
                Bitmap image = BitmapFactory.decodeFile(photoPath);
                imgAffichePhoto.setImageBitmap(image);
            }



    }
}
