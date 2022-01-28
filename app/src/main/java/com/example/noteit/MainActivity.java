package com.example.noteit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.noteit.MESSAGE";
    RelativeLayout mainLayout;
    FloatingActionButton insertNote;
    static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization
        mainLayout=findViewById(R.id.mainLayout);

        File files = getFilesDir();
        String[] fileArray = files.list();

        ArrayList<String> arrayList = new ArrayList<>();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        for(String filename : fileArray){

            filename = filename.replace(".txt", "");
            System.out.println(filename);
            adapter.add(filename);
        }

        ListView listview =findViewById(R.id.listview);
        listview.setAdapter(adapter);

        insertNote = findViewById(R.id.addNote);

        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            String item = listview.getItemAtPosition(i).toString();
            Intent intent2 = new Intent(getApplicationContext(), ShowNotesActivity.class);
            intent2.putExtra(EXTRA_MESSAGE, item);
            startActivity(intent2);
        });
    }

    public void launchCreateActivity(View view) {

        Intent intent = new Intent(this, CreateNoteActivity.class);
        startActivity(intent);
    }

    // deleteALl Files
    public void deleteAllMethod() {
        File dir = getFilesDir();
        File file = new File(String.valueOf(dir));
        File[] files= file.listFiles();

            if(files.length == 0) {
                Snackbar.make(mainLayout,
                    "Nothing To Delete \uD83E\uDD70",
                    3000).show();
            }
            else{
                for (File value : files)
                    value.delete();

                Snackbar.make(mainLayout,
                        "All Notes Are Deleted ⚡",
                        3000).show();
                adapter.clear();
            }

    }
        //thunder
    //🌻
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_acitvity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.deleteAll)
            deleteAllMethod();
        return super.onOptionsItemSelected(item);
    }
}