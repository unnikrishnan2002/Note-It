package com.example.noteit.Activities;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.noteit.MainActivity;
import com.example.noteit.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditNoteActivity extends AppCompatActivity {

    private static final String EXTRA_HEADER = "com.example.noteit.HEADER";
    private static final String EXTRA_DESCRIPTION = "com.example.noteit.DESCRIPTION";
    EditText heading,content;
    ImageView saveChanges,backFromEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);


        heading=findViewById(R.id.heading);
        content = findViewById(R.id.content);
        saveChanges = findViewById(R.id.saveChanges);
        backFromEdit=findViewById(R.id.backFromEdit);

        Intent intent = getIntent();
        String header = intent.getStringExtra(EXTRA_HEADER);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);

        heading.setText(header);
        content.setText(description);

        saveChanges.setOnClickListener(view -> {
            String filename = header + ".txt";
            if(!content.getText().toString().trim().isEmpty()){

                File dir = getFilesDir();
                File file = new File(dir, filename);
                file.delete();

                try {
                    FileOutputStream fout = openFileOutput(filename, MODE_PRIVATE);
                    fout.write(content.getText().toString().trim().getBytes());
                    fout.close();
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }else{
                Toast.makeText(getApplicationContext(), "Content Cannot Be Empty", Toast.LENGTH_SHORT).show();
            }

        });
        backFromEdit.setOnClickListener(v -> {
            //intent
            Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
            backIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(backIntent);
        });
    }
    // delete action
    public void deleteMethod() {
        File dir = getFilesDir();
        File file = new File(dir, EXTRA_HEADER);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        file.delete();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
