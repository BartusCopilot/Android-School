package com.example.zad8;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
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
    int price = 0;
    public void calculate(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        int id = view.getId();
        int additional = 0;
        if (id == R.id.option1)
            additional = 45;
        else if (id == R.id.option2)
            additional = 35;
        else if (id == R.id.option3)
            additional = 20;
        if (checked)
            price += additional;
        else
            price -= additional;
        TextView summary = findViewById(R.id.summary);
        summary.setText("suma: " + price + "zl");
    }
}