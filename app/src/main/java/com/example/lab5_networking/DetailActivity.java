package com.example.lab5_networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lab5_networking.model.Value;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView txtHeight, txtWithd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initUI();
        Value value = (Value) getIntent().getExtras().get("aa");
        if (value != null) {
            Glide.with(this).load(value.getUrl()).into(imageView);
            txtHeight.setText(String.valueOf(value.getHeight()));
            txtWithd.setText(String.valueOf(value.getWitdh()));
        }
    }

    public void initUI() {
        imageView = findViewById(R.id.imageViewDetail);
        txtHeight = findViewById(R.id.txtHeightDetail);
        txtWithd = findViewById(R.id.txtWidthDetail);
    }
}