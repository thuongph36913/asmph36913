package com.thuonght.asignmentapiph36913;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Creat_account extends AppCompatActivity {
    TextView txtLogin;
    Button btnCreataccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_account);
        txtLogin = findViewById(R.id.txtLogin);
        btnCreataccount=findViewById(R.id.btnCreat);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Creat_account.this, Login.class);
                startActivity(intent);
            }
        });
        btnCreataccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Creat_account.this, Login.class);
                startActivity(intent);
            }
        });
    }
}