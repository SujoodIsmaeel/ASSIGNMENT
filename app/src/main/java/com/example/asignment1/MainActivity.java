package com.example.asignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button add;
    private ListView list;
    private ArrayList<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add= findViewById(R.id.add);
        list= findViewById(R.id.list);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasks(view);
            }
        });
        tasks= new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
         list.setAdapter(tasksAdapter);

    }

    private void tasks(View view) {

        EditText input = findViewById(R.id.edit_text);
        String taskText = input.getText().toString();

        if (!taskText.equals("")) {

            tasksAdapter.add(taskText);
            input.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Enter Text", Toast.LENGTH_LONG).show();
        }
    }

    }
