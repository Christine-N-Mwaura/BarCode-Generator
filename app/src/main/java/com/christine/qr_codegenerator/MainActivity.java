package com.christine.qr_codegenerator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mTakePic;

    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTakePic = findViewById(R.id.takePicBtn);
        mImageView = findViewById(R.id.imageView);


        mTakePic.setOnClickListener(this);

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            mTakePic.setEnabled(false);
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }
    }
    @Override
    public void onClick(View v){
        Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
        //takePicture();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        mImageView.setImageBitmap(bitmap);


    }


//
//    public void takePicture(){
//
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        file = Uri.fromFile(getOutputMediaFile());
//        intent.putExtra(MediaStore.EXTRA_OUTPUT,file);
//
//        startActivityForResult(intent,100);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
//        if(requestCode == 0){
//            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
//            && grantResults[1] == PackageManager.PERMISSION_GRANTED){
//                mTakePic.setEnabled(true);
//            }
//        }
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//
//    }
//


}
