package com.example.intentaptech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_USERNAME_EDIT = "KEY_USERNAME_EDIT";
    private static final int REQUEST_EDIT = 101;

    private TextView tvProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        initViews();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String userName = intent.getStringExtra(LoginActivity.KEY_USERNAME);
        String password = intent.getStringExtra(LoginActivity.KEY_PASSWORD);

        tvProfile.setText(userName);
    }

    private void initViews() {
        tvProfile = findViewById(R.id.tv_profile);
        findViewById(R.id.btn_edit).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_edit) {
            if (tvProfile.getText().toString().isEmpty()) {
                Toast.makeText(this, "Input is empty ", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra(KEY_USERNAME_EDIT, tvProfile.getText().toString());
            startActivityForResult(intent, REQUEST_EDIT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_EDIT && resultCode == RESULT_OK && data != null) {
            String rs = data.getStringExtra(EditActivity.KEY_RESULT);
            tvProfile.setText(rs);
            Toast.makeText(this, "" + rs, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,  "failed", Toast.LENGTH_SHORT).show();
        }
    }
}
