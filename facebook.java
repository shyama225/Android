package com.example.facebook;  // Change this to your actual package name

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin, btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the XML layout file named activity_main.xml
        setContentView(R.layout.activity_main);

        // Link Java variables to XML views
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        // Handle Login button click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Please enter your email or phone");
                    etEmail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Please enter your password");
                    etPassword.requestFocus();
                    return;
                }

                // For demo, just show a Toast message
                Toast.makeText(MainActivity.this, "Logging in with:\n" + email, Toast.LENGTH_SHORT).show();

                // TODO: Add real authentication logic here
            }
        });

        // Handle Create Account button click
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Create Account clicked", Toast.LENGTH_SHORT).show();

                // TODO: Navigate to registration screen
            }
        });
    }
}
