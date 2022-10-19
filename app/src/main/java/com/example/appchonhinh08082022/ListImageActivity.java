package com.example.appchonhinh08082022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

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

        Collections.shuffle(Arrays.asList(arrAnimals));
        int count = 0;
        int column = 3;
        int row = (int) Math.ceil(arrAnimals.length / 3);

        for (int i = 0; i < row; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 0; j < column; j++) {
                ImageView imageView = new ImageView(this);
                int resourceImage = getResources().getIdentifier(arrAnimals[count], "drawable", getPackageName());
                imageView.setImageResource(resourceImage);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent1 = new Intent();
                        intent1.putExtra("resource", resourceImage);
                        setResult(RESULT_OK, intent1);
                        finish();
                    }
                });
                tableRow.addView(imageView);
                count++;
            }
            tableLayout.addView(tableRow);
        }
    }
}
