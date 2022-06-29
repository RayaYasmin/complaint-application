package com.example.onlinegrievance;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText username1, email1, password1,dept,stID;
    Button register;
    FirebaseDatabase data;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username1 = (EditText) findViewById(R.id.username);
        email1 = (EditText) findViewById(R.id.email);
        password1=(EditText)  findViewById(R.id.password);
        stID=(EditText) findViewById(R.id.StID);
        dept=(EditText) findViewById(R.id.department);
        register = (Button) findViewById(R.id.btnregister);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase data=getInstance();
                ref= data.getReference("Registration");
                String username = username1.getText().toString().trim();
                String email = email1.getText().toString().trim();
                String password = password1.getText().toString().trim();
                String Department = dept.getText().toString().trim();
                String Student_ID=stID.getText().toString().trim();
                if(username.isEmpty())
                {
                    username1.setError("Username is empty");
                    username1.requestFocus();
                    return;
                }
                if(email.isEmpty())
                {
                    email1.setError("Email is empty");
                    email1.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    email1.setError("Enter the valid email address");
                    email1.requestFocus();
                    return;
                }
                if(password.isEmpty())
                {
                    password1.setError("Enter the password");
                    password1.requestFocus();
                    return;
                }
                if(password.length()<6)
                {
                    password1.setError("Length of the password should be more than 6");
                    password1.requestFocus();
                    return;
                }
                if(Department.isEmpty())
                {
                    dept.setError("Department field is empty");
                    dept.requestFocus();
                    return;
                }
                if(Student_ID.isEmpty())
                {
                    stID.setError("Student id is empty");
                    stID.requestFocus();
                    return;
                }

                if(Student_ID.length()!=10)
                {
                    stID.setError("Student id must be 10 digit");
                    stID.requestFocus();
                    return;
                }

                UserHelperClass helperclass= new UserHelperClass(username,email,password,Department,Student_ID);
                ref.child(username).setValue(helperclass);
                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
