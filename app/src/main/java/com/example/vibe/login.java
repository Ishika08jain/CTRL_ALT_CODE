package com.example.vibe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;

public class login extends AppCompatActivity {
    EditText username, password;
    ImageView icon;
    Button b1;
    ImageView googlebtn;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        username = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPersonName2);
        b1 = findViewById(R.id.button);
        googlebtn=findViewById(R.id.imageView);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc= GoogleSignIn.getClient(this,gso);
        googlebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });



        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(login.this, MainActivity.class));

            }
        });
    }

    private void signIn() {
        Intent signInIntent=gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);

    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                task.getResult(ApiException.class);
                navigateToMainActivity();
            }catch (ApiException e){
                Toast.makeText(getApplicationContext(),"Something went wrong", Toast.LENGTH_SHORT).show();
            }


        }
    }
    void  navigateToMainActivity() {
        finish();
        Intent intent = new Intent(login.this,MainActivity.class);
        startActivity(intent);

    }




}