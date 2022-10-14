package com.example.appchonhinh08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] arrAnimals;
    ImageView imgRandom, imgPick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgRandom = findViewById(R.id.imgRandom);
        imgPick = findViewById(R.id.imgPick);

        arrAnimals = getResources().getStringArray(R.array.array_animals);
        int resourceImageRandom = getResources().getIdentifier(arrAnimals[1], "drawable", getPackageName());
        imgRandom.setImageResource(resourceImageRandom);

    }
}
