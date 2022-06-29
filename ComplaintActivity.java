package com.example.onlinegrievance;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComplaintActivity extends AppCompatActivity {
    EditText add_studentID,add_Complaint;
    Button send;
    FirebaseDatabase root;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        add_studentID=findViewById(R.id.studentID);
        add_Complaint=findViewById(R.id.complaint);
        send=findViewById(R.id.btnsignin);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase root= getInstance();
               reference= root.getReference("Complaints");
                String studentId = add_studentID.getText().toString().trim();
                String complaint = add_Complaint.getText().toString().trim();
                if(complaint.isEmpty())
                {
                    add_Complaint.setError("Field can not be empty");
                    add_Complaint.requestFocus();
                    return;
                }
                if(studentId.isEmpty())
                {
                    add_studentID.setError("Student id is empty");
                    add_studentID.requestFocus();
                    return;
                }
                if( studentId.length()!=10)
                {
                    add_studentID.setError("Student id must be 10 digit");
                    add_studentID.requestFocus();
                    return;
                }

                ComplaintHelperClass helper= new ComplaintHelperClass(studentId,complaint);
                reference.child(studentId).setValue(helper);
                Toast.makeText(ComplaintActivity.this, "Complaint sent successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),StartScreen.class);
                startActivity(intent);
                finish();


            }
        });
    }
}