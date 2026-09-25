package com.example.zad7;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    }
    public void togglePass(View view) {
        Switch switch1 = findViewById(R.id.switch1);
        EditText passInput = findViewById(R.id.pass);
        TextView textView = findViewById(R.id.text1);
        ImageView image = findViewById(R.id.image);
        if(switch1.isChecked()) { //pokaz haslo
            String pass = passInput.getText().toString();
            textView.setText(pass);
            image.setImageResource(R.drawable.eye_open);
        } else { //ukryj haslo
            textView.setText(R.string.hidden);
            image.setImageResource(R.drawable.eye_closed);
        }

    }
}