package com.example.zad11;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String[] months = {
            "Styczen",
            "Luty",
            "Marzec",
            "Kwiecien",
            "Maj",
            "Czerwiec",
            "Lipiec",
            "Sierpien",
            "Wrzesien",
            "Pazdziernik",
            "Listopad",
            "Grudzien"
    };
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                months
        );
        AutoCompleteTextView textView = findViewById(R.id.text2);
        textView.setAdapter(adapter);
        textView.setThreshold(1);
        MultiAutoCompleteTextView multiText = findViewById(R.id.text3);
        multiText.setAdapter(adapter);
        multiText.setThreshold(1);
        multiText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}