package es.ieslavereda.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnPlus;
    private Button btnMinus;
    private Button btnActivity;
    private Button btnAdd;
    private TextView tvDisplay;
    private RecyclerView recycler;
    private RadioButton rbVisible;
    private RadioButton rbInvisible;
    private RadioButton rbGone;

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnActivity = findViewById(R.id.btnActivity);
        btnAdd = findViewById(R.id.btnAdd);

        tvDisplay = findViewById(R.id.tvDisplay);

        rbVisible = findViewById(R.id.rbVisible);
        rbInvisible = findViewById(R.id.rbInvisible);
        rbGone = findViewById(R.id.rbGone);

        linearLayout = findViewById(R.id.ejer_uno);


        rbVisible.setOnClickListener( view ->
                linearLayout.setVisibility(View.VISIBLE)
        );
        rbInvisible.setOnClickListener( view ->
                linearLayout.setVisibility(View.INVISIBLE)
        );
        rbGone.setOnClickListener( view ->
                linearLayout.setVisibility(View.GONE)
        );


        recycler = findViewById(R.id.recycler);

        MyRecyclerViewAdapter recyclerViewAdapter = new MyRecyclerViewAdapter(this);
        recycler.setAdapter(recyclerViewAdapter);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearLayout);

        btnPlus.setOnClickListener(view -> {
            tvDisplay.setText(String.valueOf(Integer.parseInt(tvDisplay.getText().toString())+1));
        });
        btnMinus.setOnClickListener(view -> {
            tvDisplay.setText(String.valueOf(Integer.parseInt(tvDisplay.getText().toString())-1));
        });

        btnActivity.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),Activity2.class);
            intent.putExtra("value",tvDisplay.getText().toString());
            startActivity(intent);
        });

        btnAdd.setOnClickListener(view -> {
            recyclerViewAdapter.insertValue(tvDisplay.getText().toString());
        });
    }
}