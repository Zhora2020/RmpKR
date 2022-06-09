package com.example.guide20;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import androidx.appcompat.app.AppCompatActivity;

public class ManuWdActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu_page);

        //замена текста topbar на название фирмы
        TextView txtmanu = (TextView)findViewById(R.id.sec_name); //текст в top bar
        String manuArr[] = getResources().getStringArray(R.array.manu_hdd); //массив строк с названиями компаний
        txtmanu.setText(manuArr[0]); // присваивание строки

        //замена логотипа фирмы
        ImageView imgTeme = (ImageView)findViewById(R.id.img_theme);
        imgTeme.setImageResource(R.drawable.wd_img);


        //заполнение основной информацией
        TextView text1 = (TextView)findViewById(R.id.textview); //поле основной информации
        String text = "wdInf";
        text1.setText(ChangeText(text));


    }

    //открывает файл с нужной информацией и записывает его содержимое в строку
    public String ChangeText(String file_to_add){
        byte[] buffer = null;
        InputStream is;
        try {
            is = getAssets().open(file_to_add);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str_data = new String(buffer);
        return str_data;
    }

    //кнопка для возврата в main
    public void GoBack(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    //кнопка для перехода к списку моделей
    public void ToList(View view){
        Intent intent = new Intent(this,ModListActivity.class);
        startActivity(intent);
    }
}