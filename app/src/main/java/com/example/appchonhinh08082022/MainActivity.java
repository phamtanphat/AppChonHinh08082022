package com.example.appchonhinh08082022;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] arrAnimals;
    ImageView imgRandom, imgPick;
    int REQUEST_CODE = 1;
    int resourceImageRandom = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgRandom = findViewById(R.id.imgRandom);
        imgPick = findViewById(R.id.imgPick);

        randomImage();
        event();
    }

    private void event() {
        imgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListImageActivity.class);
                intent.putExtra("array", arrAnimals);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            int resource = data.getIntExtra("resource", -1);
            if (resource != -1) {
                imgPick.setImageResource(resource);
                if (resource == resourceImageRandom) {
                    Toast.makeText(this, "Bạn đã chọn đúng", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Bạn đã chọn sai", Toast.LENGTH_SHORT).show();
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        randomImage();
                    }
                }, 1000);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_refresh:
                randomImage();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void randomImage() {
        Random random = new Random();
        arrAnimals = getResources().getStringArray(R.array.array_animals);
        int indexRandom = random.nextInt(arrAnimals.length);
        resourceImageRandom = getResources().getIdentifier(arrAnimals[indexRandom], "drawable", getPackageName());
        imgRandom.setImageResource(resourceImageRandom);
    }
}
