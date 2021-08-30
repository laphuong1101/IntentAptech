package com.example.intentaptech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_PASSWORD = "KEY_PASSWORD";
    private static final int REQUEST_CODE_PROFILE = 100;
    private EditText edtUserName, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        edtUserName = findViewById(R.id.edt_userName);
        edtPassword = findViewById(R.id.edt_password);

        findViewById(R.id.btn_login).setOnClickListener(this);
        findViewById(R.id.tv_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_login) {
            if (edtUserName.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
                Toast.makeText(this, "Input is empty ", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra(KEY_USERNAME, edtUserName.getText().toString());
            intent.putExtra(KEY_PASSWORD, edtPassword.getText().toString());
            startActivityForResult(intent, REQUEST_CODE_PROFILE);
        }
    }
}