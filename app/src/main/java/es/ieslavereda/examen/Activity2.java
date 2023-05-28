package es.ieslavereda.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity2 extends AppCompatActivity {

    private FloatingActionButton btnBack;
    private TextView tvValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        String value = getIntent().getExtras().getString("value");

        btnBack = findViewById(R.id.btnBack);
        tvValue = findViewById(R.id.tvActivity2);

        tvValue.setText(value);

        btnBack.setOnClickListener(view -> {
            finish();
        });

    }
}