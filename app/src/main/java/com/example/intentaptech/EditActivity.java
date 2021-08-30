package com.example.intentaptech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_RESULT = "KEY_RESULT";

    private EditText edtNewUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_activity);

        initViews();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }

        String userName = intent.getStringExtra(ProfileActivity.KEY_USERNAME_EDIT);
        edtNewUsername.setText(userName);
    }

    private void initViews() {
        edtNewUsername = findViewById(R.id.edt_newUsername);
        findViewById(R.id.btn_save).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_save) {
            if (edtNewUsername.getText().toString().isEmpty()) {
                Toast.makeText(this, "Input is empty ", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent();
            intent.putExtra(KEY_RESULT, edtNewUsername.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
