package com.example.remarksolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.remarksolutions.Login.LoginActivity;
import com.example.remarksolutions.MainArea.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
        else
        {
            startActivity(new Intent(this, LoginActivity.class));
            finish();

        }

    }
}
