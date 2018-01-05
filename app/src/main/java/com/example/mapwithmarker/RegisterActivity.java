package com.example.mapwithmarker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    Button button1;

    public Button button4;
    public Button button5;
    private EditText mUsername;
    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Firebase.setAndroidContext(this);
        mAuth = FirebaseAuth.getInstance();
        mUsername = (EditText) findViewById(R.id.etUsername);
        mName = (EditText) findViewById(R.id.etName);
        mPassword = (EditText) findViewById(R.id.etPassword);
        mEmail = (EditText) findViewById(R.id.etEmail);
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                }
            }
        };




        final Button bRegister = (Button) findViewById(R.id.bRegister);
        button4 = (Button) findViewById(R.id.bRegister);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    startSignin();
                    //Firebase mRefChild = mRef.child("Name");
                    //mRefChild.setValue("Aakash");
                    //Firebase childRef = mRef.child(user);
                    //childRef.setValue(value);
                    //mRef.push().setValue(value);
                    //childRef.setValue(pass);

                }
            }
        });
        button5 = (Button) findViewById(R.id.button2);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent ABoutBtn = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(ABoutBtn);
                }
            }
        });

    }

    private void startSignin() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            Toast.makeText(RegisterActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }else {
            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Intent ABoutBtn = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(ABoutBtn);
                        Toast.makeText(RegisterActivity.this, "Congratulations! Registration Success", Toast.LENGTH_LONG).show();
                    }

                }

            });
        }
    }

}




