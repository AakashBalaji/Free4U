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


public class MainActivity extends AppCompatActivity {
    public Button button1;
    public Button button2;

    public EditText mUsername;
    public EditText mPassword;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        mAuth = FirebaseAuth.getInstance();

        button1 = (Button) findViewById(R.id.Sign);
        button2 = (Button) findViewById(R.id.bLogin);
        mUsername = (EditText) findViewById(R.id.etUsername);
        mPassword = (EditText) findViewById(R.id.etPassword);
       /* mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(MainActivity.this, AboutUs.class));


                }
            }
        };*/
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {

                    Intent registerBtn = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(registerBtn);
                }
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    startSignin();


            }
        });
    }



    /*protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }*/


    private void startSignin() {
        String username = mUsername.getText().toString();
        String password = mPassword.getText().toString();

        if(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password)){
            Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }else if(!(TextUtils.isEmpty(username)|| TextUtils.isEmpty(password))){
                Intent registerBtn = new Intent(MainActivity.this, AboutUs.class);
                startActivity(registerBtn);

            }

        else{

            mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Sign In Problem", Toast.LENGTH_LONG).show();
                    }


                }
            });


                }

            }





        }






















