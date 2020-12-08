package com.moments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText getEditTextPasswordAgain;
    private Button register;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference firebaseRootRef;

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextEmail = findViewById(R.id.editTextRegisterEmail);
        editTextUsername = findViewById(R.id.editTextRegisterUsername);
        editTextPassword = findViewById(R.id.editTextRegisterPassword);
        getEditTextPasswordAgain = findViewById(R.id.editTextRegisterPasswordAgain);
        register = findViewById(R.id.registerSubmit);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseRootRef = FirebaseDatabase.getInstance().getReference();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String passwordAgain = getEditTextPasswordAgain.getText().toString();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(username)) {
                    Toast.makeText(getApplicationContext(), "Enter your details", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "Password is to short", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(passwordAgain)) {
                    Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(email, username, password);
                }
            }
        });
    }

    private void registerUser(String email, String username, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("email", email);
                    map.put("username", username);
                    map.put("id", firebaseAuth.getCurrentUser().getUid());

                    firebaseRootRef.child("Users").child(firebaseAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("RegisterStatus", "createUserWithEmail:success");
                                Toast.makeText(getApplicationContext(), "Successfully registered", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), WallActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });

                    // Sign in success, update UI with the signed-in user's information
//                    FirebaseUser user = mAuth.getCurrentUser();
//                    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("RegisterStatus", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(getApplicationContext(), "Unable to register", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
//                    updateUI(null);
                }
            }
        });
    }
}