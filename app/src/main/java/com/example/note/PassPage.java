package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class PassPage extends AppCompatActivity {
        Button button_save;
        EditText editText1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        button_save = findViewById(R.id.Button_Save1);
        editText1 = findViewById(R.id.EditText);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("Note", MODE_PRIVATE);
                ArrayList<String> strings1 = new ArrayList<>();
                ArrayList<String> strings2 = new ArrayList<>();
                ArrayList<String> strings3 = new ArrayList<>();
                strings1 = HelperClass1.sort(sharedPreferences.getString("N_Name", ""));
                strings2 = HelperClass1.sort(sharedPreferences.getString("N_Disc", ""));
                strings3 = HelperClass1.sort(sharedPreferences.getString("PassWord",""));
                int position = Integer.parseInt(getIntent().getStringExtra("position"));
                if (editText1.getText().toString().equals(strings1.get(strings1.size() - position -1))) {
                    Intent intent = new Intent(PassPage.this, MainActivity3.class);
                    intent.putExtra("Disc", strings2.get(strings2.size() - position - 1));
                    intent.putExtra("Name", strings1.get(strings1.size() - position - 1));
                    String Position = HelperClass1.convertRegister(position);
                    intent.putExtra("position", Position);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(PassPage.this, "your Password not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(PassPage.this,MainActivity2.class);
        startActivity(intent);
        finish();
    }
}