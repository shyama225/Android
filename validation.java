package com.example.validation;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etDOB, etPassword, etConfirmPassword;
    RadioGroup rgGender;
    Spinner spinnerState;
    Button btnSubmit;

    String[] states = {"Select State", "California", "kerala","bihar","goa","New York", "Texas", "Florida"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etDOB = findViewById(R.id.etDOB);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        rgGender = findViewById(R.id.rgGender);
        spinnerState = findViewById(R.id.spinnerState);
        btnSubmit = findViewById(R.id.btnSubmit);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerState.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();
        String dob = etDOB.getText().toString().trim();
        String password = etPassword.getText().toString();
        String confirmPassword = etConfirmPassword.getText().toString();

        int genderId = rgGender.getCheckedRadioButtonId();
        String state = spinnerState.getSelectedItem().toString();

        if (name.isEmpty()) {
            etName.setError("Name is required");
            return;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter valid email");
            return;
        }

        if (phone.isEmpty() || phone.length() != 10) {
            etPhone.setError("Enter valid 10-digit phone number");
            return;
        }

        if (dob.isEmpty()) {
            etDOB.setError("DOB is required");
            return;
        }

        if (password.isEmpty() || password.length() < 6) {
            etPassword.setError("Password must be at least 6 characters");
            return;
        }

        if (!confirmPassword.equals(password)) {
            etConfirmPassword.setError("Passwords do not match");
            return;
        }

        if (genderId == -1) {
            Toast.makeText(this, "Select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if (state.equals("Select State")) {
            Toast.makeText(this, "Select a valid state", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Form Submitted Successfully", Toast.LENGTH_LONG).show();
    }
}
