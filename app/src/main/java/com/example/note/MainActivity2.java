package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    AdapterClass1 adapter;
    RecyclerView recyclerView;
    ImageView imageView_add;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        imageView_add = findViewById(R.id.ImageView_add);
        recyclerView = findViewById(R.id.RecyclerView1);

        recyclerView1();

        imageView_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, AddNote.class);
                startActivity(intent);
            }
        });
    }

    private void recyclerView1() {
        SharedPreferences sharedPreferences = getSharedPreferences("Note", MODE_PRIVATE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ArrayList<HelperClass1> helperClass1s = new ArrayList<>();
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();

        strings1 = HelperClass1.sort(sharedPreferences.getString("N_Name", ""));
        strings2 = HelperClass1.sort(sharedPreferences.getString("N_Disc", ""));

        int i = (strings1.size() - 1);
        while (i >= 0) {
            helperClass1s.add(new HelperClass1(strings1.get(i), strings2.get(i)));
            i--;
        }
        adapter = new AdapterClass1(helperClass1s, this);
        recyclerView.setAdapter(adapter);
    }
}