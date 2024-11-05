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

public class MainActivity2 extends AppCompatActivity implements RecyclerViewInterface {
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
                finish();
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
        adapter = new AdapterClass1(helperClass1s, this , this);
        recyclerView.setAdapter(adapter);
    }
// we must create Page 4
    @Override
    public void ItemClick(int position) {
        SharedPreferences sharedPreferences = getSharedPreferences("Note", MODE_PRIVATE);
        Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
        ArrayList<String> strings1 = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();
        strings2 = HelperClass1.sort(sharedPreferences.getString("N_Disc",""));
        strings1 = HelperClass1.sort(sharedPreferences.getString("N_Name",""));
        intent.putExtra("Disc", strings2.get(strings2.size()-position-1));
        intent.putExtra("Name", strings1.get(strings1.size()-position-1));
        String Position = HelperClass1.convertRegister(position);
        intent.putExtra("position",Position);
        startActivity(intent);

    }
}