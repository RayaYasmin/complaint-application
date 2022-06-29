package com.example.onlinegrievance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.username1);
        password= (EditText) findViewById(R.id.password1);
        login = (Button) findViewById(R.id.btnsignin1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(user.isEmpty())
                {
                    username.setError("User name is empty");
                    username.requestFocus();
                    return;
                }
                if(pass.isEmpty())
                {
                    password.setError("Password is empty");
                    password.requestFocus();
                    return;
                }
                if(pass.length()<6)
                {
                    password.setError("Length of password is more than 6");
                    password.requestFocus();
                    return;
                }
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference("Registration");
                Query checkUser=ref.orderByChild("username").equalTo(user);
                Query check=ref.orderByChild("password").equalTo(pass);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            check.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if (snapshot.exists()) {
                                        Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                                        Intent intent=new Intent(getApplicationContext(),ComplaintActivity.class);
                                        startActivity(intent);
                                        finish();

                                    } else {
                                        password.setError("Wrong Password");
                                        password.requestFocus();

                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                        }else{
                            username.setError("No such user exists");
                            username.requestFocus();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }
}