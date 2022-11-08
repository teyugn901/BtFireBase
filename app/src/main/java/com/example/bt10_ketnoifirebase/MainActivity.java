package com.example.bt10_ketnoifirebase;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SinhVienAdapter sinhVienAdapter;

    FloatingActionButton floatingActionButton;

    BottomNavigationView bottomNavigationView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<SinhVienModel> options =
                new FirebaseRecyclerOptions.Builder<SinhVienModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Books"), SinhVienModel.class)
                        .build();
        sinhVienAdapter = new SinhVienAdapter(options);
        recyclerView.setAdapter(sinhVienAdapter);

        floatingActionButton =(FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddSinhVien.class));
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        sinhVienAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sinhVienAdapter.stopListening();
    }

}