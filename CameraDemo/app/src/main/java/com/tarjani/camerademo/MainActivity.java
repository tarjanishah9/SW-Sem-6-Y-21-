package com.tarjani.camerademo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.BitmapCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.tarjani.camerademo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String[] permission=new String[]{Manifest.permission.CAMERA};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        binding.btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
    }

    private void openCamera(){
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activityResultLauncher.launch(i);

    }
    private void checkPermission(){
         if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
            requestPermissions(permission,100);

    }
    ActivityResultLauncher<Intent> activityResultLauncher=registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        binding.imgCamera.setImageBitmap(bitmap);
                    }
                }
            });
   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if(resultCode==RESULT_OK){
                Bitmap bitmap=(Bitmap)data.getExtras().get("data");
                binding.imgCamera.setImageBitmap(bitmap);
            }
        }

    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100)
        {
            if(grantResults[0]== PackageManager.PERMISSION_GRANTED)
                openCamera();
            else if(grantResults[0]==PackageManager.PERMISSION_DENIED){
               // Toast.makeText(this, "Permission not granted..", Toast.LENGTH_SHORT).show();
                checkPermission();
            }
        }
    }
}