package com.example.appchonhinh08082022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] arrAnimals;
    ImageView imgRandom, imgPick;
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
                Children children = new Children("Tèo", "5");
                Intent intent = new Intent(MainActivity.this, ListImageActivity.class);
//                intent.putExtra("array", arrAnimals);
                intent.putExtra("object", children);
                startActivity(intent);
            }
        });
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
        int resourceImageRandom = getResources().getIdentifier(arrAnimals[indexRandom], "drawable", getPackageName());
        imgRandom.setImageResource(resourceImageRandom);
    }
}
