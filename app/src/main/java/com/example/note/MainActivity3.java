package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    public int key = 0;
    EditText editText;
    TextView textView;
    ImageView edit,delete;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String s=getIntent().getStringExtra("Disc");
        String ss=getIntent().getStringExtra("Name");
        editText=findViewById(R.id.TextBoxMain3);
        textView=findViewById(R.id.NoteNameMain3);
        textView.setText(ss);
        editText.setText(s);
        edit=findViewById(R.id.EditIcon);
        delete=findViewById(R.id.deleteIcon);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(key == 0) {
                    edit.setImageResource(R.drawable.ic_baseline_done_24);
                    delete.setImageResource(R.drawable.ic_baseline_close_24);
                    editText.setEnabled(true);
                    key = 1;
                }
                else if (key == 2){
                    key = 0;
                    edit.setImageResource(R.drawable.ic_baseline_edit_24);
                    delete.setImageResource(R.drawable.ic_baseline_delete_24);
                }
                else
                {
                    SharedPreferences sharedPreferences = getSharedPreferences("Note", MODE_PRIVATE);
                    edit.setImageResource(R.drawable.ic_baseline_edit_24);
                    delete.setImageResource(R.drawable.ic_baseline_delete_24);
                    editText.setEnabled(false);
                    ArrayList<String> strings2 = new ArrayList<>();
                    int position = Integer.parseInt(getIntent().getStringExtra("position"));
                    strings2 = HelperClass1.sort(sharedPreferences.getString("N_Disc",""));
                    strings2.set(strings2.size() - position - 1, editText.getText().toString());
                    String string = HelperClass1.unsort(strings2);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("N_Disc");
                    editor.putString("N_Disc",string);
                    editor.apply();
                    Intent intent = new Intent(MainActivity3.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                    key = 0;
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(key == 0) {
                    key = 2;
                    delete.setImageResource(R.drawable.ic_baseline_done_24);
                    edit.setImageResource(R.drawable.ic_baseline_close_24);

                }else if(key == 2) {
                    SharedPreferences sharedPreferences = getSharedPreferences("Note", MODE_PRIVATE);
                    ArrayList<String> strings1 = new ArrayList<>();
                    ArrayList<String> strings2 = new ArrayList<>();
                    int position = Integer.parseInt(getIntent().getStringExtra("position"));
                    strings1 = HelperClass1.sort(sharedPreferences.getString("N_Name", ""));
                    strings2 = HelperClass1.sort(sharedPreferences.getString("N_Disc", ""));
                    strings1.remove(strings1.size() - position - 1);
                    strings2.remove(strings2.size() - position - 1);
                    String string1 = HelperClass1.unsort(strings1);
                    String string2 = HelperClass1.unsort(strings2);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("N_Disc");
                    editor.remove("N_Name");
                    editor.putString("N_Name", string1);
                    editor.putString("N_Disc", string2);
                    editor.apply();
                    Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                    startActivity(intent);
                    finish();

                }
                else
                {
                    editText.setText(s);
                    edit.setImageResource(R.drawable.ic_baseline_edit_24);
                    delete.setImageResource(R.drawable.ic_baseline_delete_24);
                    editText.setEnabled(false);

                    key = 0;
                }
            }
        });

    }
}