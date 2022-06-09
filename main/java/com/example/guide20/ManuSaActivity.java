package com.example.guide20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ManuSaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu_page);

        //замена текста topbar на название фирмы
        TextView txtmanu = (TextView)findViewById(R.id.sec_name);
        String manuArr[] = getResources().getStringArray(R.array.manu_hdd);
        txtmanu.setText(manuArr[4]);

        //замена логотипа фирмы
        ImageView imgTeme = (ImageView)findViewById(R.id.img_theme);
        imgTeme.setImageResource(R.drawable.sa_img);


        //заполнение основной информацией
        TextView text1 = (TextView)findViewById(R.id.textview); //поле основной информации
        String text = "saInf";
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
}