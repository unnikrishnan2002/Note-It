package com.example.noteit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ShowNotesActivity extends AppCompatActivity {

    public static final String HEADER_MSG = "com.example.noteit.MESSAGE";
    public static  String FILE_NAME;

    TextView heading,content;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notes);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        content = findViewById(R.id.Content);
        heading = findViewById(R.id.Heading);
        heading.setText(message);

        FILE_NAME = message + ".txt";

        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            String whole = "";

            while((line = reader.readLine()) != null){

                if(whole == ""){

                    whole = whole + line;
                }else{

                    whole = whole + "\n" + line;
                }
            }
            reader.close();

            content.setText(whole);
        }catch (Exception e){
            e.printStackTrace();
        }

        //edit Buttton
        edit = findViewById(R.id.edit);
        edit.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), EditNoteActivity.class);
            intent1.putExtra(HEADER_MSG, message);
            startActivity(intent1);
        });

    }

    // delete action
    public void deleteMethod() {
        File dir = getFilesDir();
        File file = new File(dir, FILE_NAME);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        file.delete();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.show_activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.delete)
            deleteMethod();
        return super.onOptionsItemSelected(item);
    }
}