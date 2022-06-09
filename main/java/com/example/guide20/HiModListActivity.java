package com.example.guide20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HiModListActivity extends AppCompatActivity {
    Intent intent; //Переменная Intent для возможности нескольких использований
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_list);

        //заполнение списка моделей
        ListView list1 = (ListView)findViewById(R.id.mod_list);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.wd_mod,
                android.R.layout.simple_list_item_1);
        list1.setAdapter(adapter);

        //обработка нажатия на пункт списка
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent = new Intent(HiModListActivity.this, HiModActivity.class); //Заполняем Intent
                        intent.putExtra("mod_v",0);//синий
                        break;
                    case 1:
                        intent = new Intent(HiModListActivity.this, HiModActivity.class); //Заполняем Intent
                        intent.putExtra("mod_v",1);//зеленый
                        break;
                    case 2:
                        intent = new Intent(HiModListActivity.this, HiModActivity.class); //Заполняем Intent
                        intent.putExtra("mod_v",2);//черный
                        break;
                    case 3:
                        intent = new Intent(HiModListActivity.this, HiModActivity.class); //Заполняем Intent
                        intent.putExtra("mod_v",3);//красный
                        break;
                    case 4:
                        intent = new Intent(HiModListActivity.this, HiModActivity.class); //Заполняем Intent
                        intent.putExtra("mod_v",4);//фиолетовый
                        break;
                    case 5:
                        intent = new Intent(HiModListActivity.this, HiModActivity.class); //Заполняем Intent
                        intent.putExtra("mod_v",5);//золотой
                        break;
                }
                startActivity(intent); //Запускаем активность
            }
        });
    }

    //кнопка для возврата в main
    public void GoBack(View view){
        Intent intent = new Intent(this,ManuHiActivity.class);
        startActivity(intent);
    }
}