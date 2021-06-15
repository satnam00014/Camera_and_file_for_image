package com.example.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imv1 = findViewById(R.id.imv1);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    //Launch Camera Activity
    public void go(View v)
    {
        Intent in=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(in,100);
    }

    //Launch Gallery
    public void go2(View v)
    {
        Intent in=new Intent(Intent.ACTION_PICK);

        //Filter for image type
        in.setType("image/*");

        startActivityForResult(in,110);
    }

    //below is function which will display image after selecting from galary or files
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent backintent) {
        super.onActivityResult(requestCode, resultCode, backintent);
        if (requestCode == 100)  //back from camera
        {
            if (resultCode == RESULT_OK) {
                Bitmap bmp = (Bitmap) (backintent.getExtras().get("data"));
                imv1.setImageBitmap(bmp);
            }
        } else if (requestCode == 110)  //back from gallery
        {
            if (resultCode == RESULT_OK) {
                try {
                    Uri uri = backintent.getData();
                    //following to convert from uri to bitmap
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    //following is to get and show image through URI in image view
                    //imv1.setImageURI(uri);
                    imv1.setImageBitmap(bitmap);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

}