package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddNote extends AppCompatActivity {
    EditText editText1, editText2;
    ImageView imageView_save;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        editText1 = findViewById(R.id.EditText1);
        editText2 = findViewById(R.id.EditText2);
        imageView_save = findViewById(R.id.ImageView_Save);
        imageView_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(AddNote.this, "Please Write Title", Toast.LENGTH_LONG).show();
                } else {
                    SharedPreferences sharedPreferences = getSharedPreferences("Note", MODE_PRIVATE);
                    String Note_Name, Disc;
                    Note_Name = sharedPreferences.getString("N_Name", "");
                    Disc = sharedPreferences.getString("N_Disc", "");

                    Note_Name = Note_Name + editText1.getText().toString() + "+";
                    Disc = Disc + editText2.getText().toString() + "+";

                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("N_Name", Note_Name);
                    editor.putString("N_Disc", Disc);
                    editor.apply();
                    Intent intent = new Intent(AddNote.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddNote.this, MainActivity2.class);
        startActivity(intent);
        finish();
    }
}