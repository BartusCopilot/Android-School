package com.example.zad9_spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    public void checkAnswer(View view) {
        String text = "";
        int duration = Toast.LENGTH_LONG;
        Spinner spinner = findViewById(R.id.spinner);
        String choice = String.valueOf(spinner.getSelectedItem());
        if (choice.equals("zielony"))
            text = "brawo, swietna odpowiedz";
        else
            text = "niestety, zla odpowiedz";
        Toast toast = Toast.makeText(this, text, duration);
        toast.show();
        TextView textView = findViewById(R.id.text1);
        textView.setText("aktualny wybor: " + choice);
    }
}