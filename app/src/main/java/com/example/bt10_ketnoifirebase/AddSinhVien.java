package com.example.bt10_ketnoifirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddSinhVien extends AppCompatActivity {

    EditText name,tacgia,hinh;
    Button btnAdd,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sinhvien);

        name = (EditText)findViewById(R.id.txtName);
        tacgia =(EditText) findViewById(R.id.txtTacgia);
        hinh = (EditText) findViewById(R.id.txtHinh);

        btnAdd = (Button) findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Books.class);
                startActivity(intent);
            }
        });
    }
    private void clearAll(){
        name.setText("");
        tacgia.setText("");
        hinh.setText("");
    }
    private void insertData(){
        Map<String,Object> map= new HashMap<>();
        map.put("name",name.getText().toString());
        map.put("tacgia",tacgia.getText().toString());
        map.put("hinh",hinh.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Books").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddSinhVien.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddSinhVien.this, "Error While Insertion", Toast.LENGTH_SHORT).show();
                    }
                });
    }

}