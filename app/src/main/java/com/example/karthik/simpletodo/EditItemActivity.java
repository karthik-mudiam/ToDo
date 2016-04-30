package com.example.karthik.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String editText = getIntent().getStringExtra("item");
        position = getIntent().getIntExtra("position", -1);
        EditText etItem = (EditText)findViewById(R.id.text);
        etItem.setText(editText);
    }

    public void onSaveItem(View v) {
        EditText etName = (EditText) findViewById(R.id.text);
        Intent data = new Intent();
        data.putExtra("item", etName.getText().toString());
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        finish();
    }
}
