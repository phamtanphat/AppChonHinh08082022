package com.example.appchonhinh08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class ListImageActivity extends AppCompatActivity {

    TableLayout tableLayout;
    String[] arrAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_image);

        tableLayout = findViewById(R.id.table_layout);

        Intent intent = getIntent();
        if (intent != null) {
            arrAnimals = intent.getStringArrayExtra("array");
        }

        if (arrAnimals == null || arrAnimals.length == 0) return;

        int column = 3;
        int row = (int) Math.ceil(arrAnimals.length / 3);

        for (int i = 0; i < row; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < column; j++) {
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.bo);
                tableRow.addView(imageView);
            }
            tableLayout.addView(tableRow);
        }
    }
}
