package com.example.noteit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditNoteActivity extends AppCompatActivity {

    EditText heading,content;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        heading=findViewById(R.id.heading);
        content = findViewById(R.id.content);
        save = findViewById(R.id.save);


        Intent intent = getIntent();
        String header = intent.getStringExtra(ShowNotesActivity.HEADER_MSG);

        //heading(Title)
        heading.setText(header);

        try {
            FileInputStream fin = openFileInput(header + ".txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String line;
            String whole = "";

            while((line = reader.readLine()) != null){

                if(whole.equals("")){

                    whole = whole + line;
                }else{

                    whole = whole + "\n" + line;
                }
            }

            reader.close();
            content.setText(whole);
        } catch (Exception e) {
            e.printStackTrace();
        }

        save.setOnClickListener(view -> {
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
    }
}