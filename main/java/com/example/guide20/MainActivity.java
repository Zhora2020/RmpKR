package com.example.guide20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Intent intent; //Переменная Intent для возможности нескольких использований

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list1 = (ListView)findViewById(R.id.hdd_list);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.manu_hdd,
                android.R.layout.simple_list_item_1);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, ManuWdActivity.class); //Заполняем Intent
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, ManuSeActivity.class); //Заполняем Intent
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ManuToActivity.class); //Заполняем Intent
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ManuHiActivity.class); //Заполняем Intent
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, ManuSaActivity.class); //Заполняем Intent
                        break;
                }
                startActivity(intent); //Запускаем активность
            }
        });
    }
    }
