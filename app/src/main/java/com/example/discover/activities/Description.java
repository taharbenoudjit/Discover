package com.example.discover.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.discover.R;
import com.squareup.picasso.Picasso;


public class Description extends AppCompatActivity {

    public TextView nameD;
    public ImageView imageD;
    public TextView historique;
    public TextView description;
    public TextView todo;
    public View layout;
    public Toolbar toolbar;
    public Button btn;

    private static final String TAG = "Description";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameDesc");
        String imUrl = intent.getStringExtra("imgDesc");

        Log.d(TAG, "onCreate: started.");
        nameD = (TextView) findViewById(R.id.textTest);
        nameD.setText(intent.getStringExtra("nameDesc"));

        imageD = (ImageView) findViewById(R.id.toolbarimg);
        Picasso.get().load(imUrl).resize(500,500).into(imageD);

        historique = (TextView) findViewById(R.id.historique);
        historique.setText(intent.getStringExtra("hisDesc"));

        description = (TextView) findViewById(R.id.description);
        description.setText(intent.getStringExtra("descDesc"));

        todo = (TextView) findViewById(R.id.todo);
        todo.setText(intent.getStringExtra("todoDesc"));
    }


    }







