package com.example.appchonhinh08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
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
    }

    private void randomImage() {
        Random random = new Random();
        arrAnimals = getResources().getStringArray(R.array.array_animals);
        int indexRandom = random.nextInt(arrAnimals.length);
        int resourceImageRandom = getResources().getIdentifier(arrAnimals[indexRandom], "drawable", getPackageName());
        imgRandom.setImageResource(resourceImageRandom);
    }
}
