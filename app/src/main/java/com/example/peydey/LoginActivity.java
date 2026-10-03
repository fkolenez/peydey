package com.example.peydey;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edit_username = findViewById(R.id.login_user);
        EditText edit_password = findViewById(R.id.login_password);
        Button buttonLogin = findViewById(R.id.btn_login);

        TextView redirect_create_user = findViewById(R.id.label_redirect_to_create_user);
        redirect_create_user.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateUserActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        });

        buttonLogin.setOnClickListener(v -> {
            String username = edit_username.getText().toString().trim();
            String password = edit_password.getText().toString().trim();

            if(username.equals("123") && password.equals("123")){
                Intent intent = new Intent(this, HomePageActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }else{
                Toast.makeText(this, "SE FODEU", Toast.LENGTH_SHORT).show();
            }
        });
    }
}