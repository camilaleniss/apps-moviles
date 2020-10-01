package com.example.permisosdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ModalDialog.OnOkListener {

    public static final int PERMISSIONS_CALLBACK = 11;
    public static final int CAMERA_CALLBACK = 12;
    public static final int GALLERY_CALLBACK = 13;

    private Button btnOpenCamera;
    private Button btnOpenGallery;
    private Button btnDownloadImg;

    private EditText txtImgURL;

    private ImageView imgMain;

    private File file;

    private ModalDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenCamera = findViewById(R.id.btnOpenCamera);
        btnOpenGallery = findViewById(R.id.btnOpenGallery);
        btnDownloadImg = findViewById(R.id.btnDownloadImg);
        txtImgURL = findViewById(R.id.txtImageURL);
        imgMain = findViewById(R.id.imgMain);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        }, PERMISSIONS_CALLBACK);

        btnOpenCamera.setOnClickListener(this);
        btnOpenGallery.setOnClickListener(this);
        btnDownloadImg.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == PERMISSIONS_CALLBACK){
            boolean allGrant = true;
            for (int i =0; i<grantResults.length; i++){
                if (grantResults[i] == PackageManager.PERMISSION_DENIED){
                    allGrant = false;
                    break;
                }
            }

            if (allGrant){
                Toast.makeText(this, "All allowed", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Not allowed, PANIC", Toast.LENGTH_LONG).show();
            }

        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOpenCamera:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                file = new File(getExternalFilesDir(null)+"/photo.png");
                Log.e(">>>>>",""+file);

                Uri uri = FileProvider.getUriForFile(this, getPackageName(), file);

                startActivityForResult(intent, CAMERA_CALLBACK);

                break;
            case R.id.btnOpenGallery:
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_CALLBACK);

                break;
            case R.id.btnDownloadImg:
                //Abrir modal
                dialog = ModalDialog.newInstance();
                dialog.setListener(this);
                dialog.show(getSupportFragmentManager(), "urlDialog");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CAMERA_CALLBACK && resultCode== RESULT_OK){
            Bitmap image = BitmapFactory.decodeFile(file.getPath());
            Bitmap thumbnail = Bitmap.createScaledBitmap(
                    image, image.getWidth()/4, image.getHeight()/4, true
            );

            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            Bitmap rotatedBitMap = Bitmap.createBitmap(thumbnail, 0, 0,
                    thumbnail.getWidth(), thumbnail.getHeight(), matrix, true);

            imgMain.setImageBitmap(rotatedBitMap);
        }else if(requestCode==GALLERY_CALLBACK && resultCode==RESULT_OK){
            Uri uri = data.getData();
            String path = UtilDomi.getPath(this, uri);
            Log.e(">>>>", ""+path);
            Bitmap image = BitmapFactory.decodeFile(path);
            imgMain.setImageBitmap(image);


        }
    }

    @Override
    public void onOk(String url) {
        dialog.dismiss();
        Glide.with(this).load(url).fitCenter().into(imgMain);
    }
}