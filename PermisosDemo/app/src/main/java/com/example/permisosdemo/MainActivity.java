package com.example.permisosdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int PERMISSIONS_CALLBACK = 11;

    private Button btnOpenCamera;
    private Button btnOpenGallery;
    private Button btnDownloadImg;
    private EditText txtImgURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenCamera = findViewById(R.id.btnOpenCamera);
        btnOpenGallery = findViewById(R.id.btnOpenGallery);
        btnDownloadImg = findViewById(R.id.btnDownloadImg);
        txtImgURL = findViewById(R.id.txtImageURL);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
        }, PERMISSIONS_CALLBACK);
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
}