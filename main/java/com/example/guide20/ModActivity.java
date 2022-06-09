package com.example.guide20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ModActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_page);

        TextView txtmanu = (TextView)findViewById(R.id.sec_name); //текст в top bar
        String manuArr[] = getResources().getStringArray(R.array.wd_mod);//список моделей
        ImageView imgTeme = (ImageView)findViewById(R.id.img_theme); //поле изображения
        TextView text1 = (TextView)findViewById(R.id.textview); //поле основной информации
        String text = "";

        Bundle args = getIntent().getExtras();
        int mod_n = args.getInt("mod_v");
        switch(mod_n){
            case 0:
                txtmanu.setText(manuArr[0]); // присваивание строки
                imgTeme.setImageResource(R.drawable.img);//присваивание изображения
                //присваивание текста
                text = "wdBlueInf";
                text1.setText(ChangeText(text));
                //
                break;
            case 1:
                txtmanu.setText(manuArr[1]); // присваивание строки
                imgTeme.setImageResource(R.drawable.wd_img);//присваивание изображения
                //присваивание текста
                text = "wdGreenInf";
                text1.setText(ChangeText(text));
                //
                break;
            case 2:
                txtmanu.setText(manuArr[2]); // присваивание строки
                imgTeme.setImageResource(R.drawable.wd_img);//присваивание изображения
                //присваивание текста
                text = "wdRedInf";
                text1.setText(ChangeText(text));
                //
                break;
            case 3:
                txtmanu.setText(manuArr[3]); // присваивание строки
                imgTeme.setImageResource(R.drawable.wd_img);//присваивание изображения
                //присваивание текста
                text = "wdBlackInf";
                text1.setText(ChangeText(text));
                //
                break;
            case 4:
                txtmanu.setText(manuArr[4]); // присваивание строки
                imgTeme.setImageResource(R.drawable.wd_img);//присваивание изображения
                //присваивание текста
                text = "wdPurpleInf";
                text1.setText(ChangeText(text));
                //
                break;
            case 5:
                txtmanu.setText(manuArr[5]); // присваивание строки
                imgTeme.setImageResource(R.drawable.wd_img);//присваивание изображения
                //присваивание текста
                text = "wdGoldInf";
                text1.setText(ChangeText(text));
                //
                break;
        }
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
        Intent intent = new Intent(this,ModListActivity.class);
        startActivity(intent);
    }


}
