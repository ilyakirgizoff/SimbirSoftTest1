package com.focaink.simbirsofttest;
//Unworking project
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private List<Note> notes;
    private void initData() throws FileNotFoundException {
        Gson g = new Gson();
        Note n = g.fromJson(new FileReader("notes.json"),Note.class);


        notes = new ArrayList<>();


        notes.add(new Note("99","7878","8787","hello","per aspera ad astra"));
        //notes.add(new Note(note.id,note.dateStart,note.dateFinish,note.name,note.description));
        /*notes.add(new Note("5459","sadfef"));
        notes.add(new Note("59","sadfjlkjbef"));
*/
    }


    CalendarView calendar;
    RecyclerView rvNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int day) {
                //add setting notes to under view
                Toast.makeText(getApplicationContext(), day + "." + (month+1) + "."+year, Toast.LENGTH_SHORT).show();
            }
        });
        try {
            initData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        initRv();
    }

    private void initRv(){
        rvNotes = findViewById(R.id.rv_notes);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));

        RvAdapter adapter = new RvAdapter(notes);
        rvNotes.setAdapter(adapter);

    }

}