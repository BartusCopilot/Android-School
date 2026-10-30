package com.example.zad10_seekbar;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textView;
    TextView textTrack;
    public void updateText(int value) {
        textView.setText("Aktualna wartosc: " + value);
    }
    public void updateTrack(boolean tracking) {
        if (tracking)
            textTrack.setText(R.string.txt_yes);
        else
            textTrack.setText(R.string.txt_no);

    }
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
        seekBar = findViewById(R.id.seekbar);
        textView = findViewById(R.id.text);
        textTrack = findViewById(R.id.text2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                updateTrack(true);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateTrack(false);
            }
        });
    }
}