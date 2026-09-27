package com.example.peydey;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.peydey.HomePageActivity;
import com.example.peydey.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText edituserName = findViewById(R.id.username);
        EditText editpassword = findViewById(R.id.password);
        Button buttonLogin = findViewById(R.id.btn_entrar);

        buttonLogin.setOnClickListener(v -> {
            String userName = edituserName.getText().toString().trim();
            String password = editpassword.getText().toString().trim();

            if (userName.equals("Numquiditu") && password.equals("Numquiditu123")) {
                Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish(); // fecha o login para o botão "voltar" não trazer o usuário de volta pra cá
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}