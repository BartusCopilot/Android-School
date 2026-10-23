package com.example.zad10;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        ListView list = findViewById(R.id.list);
        list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        String[] options = {"Czerwony", "Zielony", "Niebieski", "Zolty"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
                    android.R.layout.simple_list_item_single_choice,
                    options
        );
        list.setAdapter(adapter);

        String txt = list.getItemAtPosition(0).toString();
        list.setItemChecked(0, true);
        TextView textView = findViewById(R.id.text);
        textView.setText("Wybrano: " + txt);
    }
    public void print(View view) {
        ListView list = findViewById(R.id.list);
        int pos = list.getCheckedItemPosition();
        String txt = list.getItemAtPosition(pos).toString();
        TextView textView = findViewById(R.id.text);
        textView.setText("Wybrano: " + txt);
    }
}