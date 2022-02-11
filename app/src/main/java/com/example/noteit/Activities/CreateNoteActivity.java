package com.example.noteit.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.noteit.MainActivity;
import com.example.noteit.R;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateNoteActivity extends AppCompatActivity {

    EditText ETContent,ETHeading;
    ImageView save,backFromCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        ETHeading = findViewById(R.id.ETHeading);
        ETContent = findViewById(R.id.ETContent);
        save = findViewById(R.id.save);
        backFromCreate=findViewById(R.id.backFromCreate);

        save.setOnClickListener(view -> {

            String heading = ETHeading.getText().toString().trim();
            String content = ETContent.getText().toString().trim();

            if(!heading.isEmpty() && !content.isEmpty()){

                try {

                  FileOutputStream fileOutputStream = openFileOutput(heading + ".txt", Context.MODE_PRIVATE);
                  fileOutputStream.write(content.getBytes());
                  fileOutputStream.close();
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                    //clearing text fields
                    ETContent.setText("");
                    ETHeading.setText("");

                    //intent
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Note Saved!", Toast.LENGTH_SHORT).show();
            }else{
                    Toast.makeText(getApplicationContext(), "Content Cannot Be Empty!", Toast.LENGTH_SHORT).show();
            }
        });

        backFromCreate.setOnClickListener(v -> {
            //intent
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}