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
    private static final String EXTRA_COLOR = "com.example.noteit.COLOR";
    EditText heading,content;
    ImageView saveChanges,backFromEdit;
    ImageView blueCirlce,yellowCircle,redCircle,greenCircle,whiteCircle;
    public static int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        color=0;
        heading=findViewById(R.id.heading);
        content = findViewById(R.id.content);
        saveChanges = findViewById(R.id.saveChanges);
        backFromEdit=findViewById(R.id.backFromEdit);

        blueCirlce=findViewById(R.id.bluecircle1);
        yellowCircle=findViewById(R.id.yellowcircle2);
        redCircle=findViewById(R.id.redcircle3);
        greenCircle=findViewById(R.id.greencircle4);
        whiteCircle=findViewById(R.id.whitecircle5);

        Intent intent = getIntent();
        String header = intent.getStringExtra(EXTRA_HEADER);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);
        int prevColor=Integer.parseInt(intent.getStringExtra(EXTRA_COLOR));

        heading.setText(header);
        content.setText(description);

        saveChanges.setOnClickListener(view -> {
            String preColorParser=":"+prevColor;
            String filename = header+preColorParser+".txt";
            if(!content.getText().toString().trim().isEmpty()){
                String colorParser=":"+color;
                File dir = getFilesDir();
                File file = new File(dir, filename);
                file.delete();
                filename=heading.getText().toString()+colorParser+".txt";
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


        blueCirlce.setOnClickListener(v-> {
            Toast.makeText(this, "Blue Color Selected", Toast.LENGTH_SHORT).show();
            color=1;
        });
        yellowCircle.setOnClickListener(v-> {
            Toast.makeText(this, "Yellow Color Selected", Toast.LENGTH_SHORT).show();
            color=2;
        });
        redCircle.setOnClickListener(v-> {
            Toast.makeText(this, "Red Color Selected", Toast.LENGTH_SHORT).show();
            color=3;
        });
        greenCircle.setOnClickListener(v-> {
            Toast.makeText(this, "Green Color Selected", Toast.LENGTH_SHORT).show();
            color=4;
        });
        whiteCircle.setOnClickListener(v-> {
            Toast.makeText(this, "White Color Selected", Toast.LENGTH_SHORT).show();
            color=5;
        });

    }

}
