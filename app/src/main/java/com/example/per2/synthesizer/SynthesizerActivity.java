package com.example.per2.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonC;
    private Button buttonCs;
    private Button buttonD;
    private Button buttonDs;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFs;
    private Button buttonG;
    private Button buttonGs;
    private Button buttonHighA;
    private Button buttonHighBb;
    private Button buttonHighB;
    private Button buttonHighC;
    private Button buttonHighCs;
    private Button buttonHighD;
    private Button buttonHighDs;
    private Button buttonHighE;
    private Button buttonHighF;
    private Button buttonHighFs;
    private Button buttonHighG;
    private Button buttonHighGs;
    private Button buttonPlaySong;
    private Button buttonPlaySong2;
    private Button buttonPlayScale;



    private Button buttonScale;
    private SoundPool soundPool;
    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCs;
    private int noteD;
    private int noteDs;
    private int noteE;
    private int noteF;
    private int noteFs;
    private int noteG;
    private int noteGs;
    private int noteHighA;
    private int noteHighBb;
    private int noteHighB;
    private int noteHighC;
    private int noteHighCs;
    private int noteHighD;
    private int noteHighDs;
    private int noteHighE;
    private int noteHighF;
    private int noteHighFs;
    private int noteHighG;
    private int noteHighGs;



    private Map<Integer, Integer>noteMap;

    public static final float DEFAULT_VOLUME = 1.0f;
    public static final int DEFAULT_PRIORITY = 1;
    public static final float DEFAULT_RATE = 1.0f;
    public static final int WHOLE_NOTE = 1000; //in ms



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);
        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();

    }

    private void initializeNoteMap()
    {
        noteMap = new HashMap<>();
        //in a map, you store a key: value pair
        //the key is the button Id, the value is the noteId
        noteMap.put(R.id.button_synth_a, noteA);
        noteMap.put(R.id.button_synth_bflat, noteBb);
        noteMap.put(R.id.button_synth_b, noteB);
        noteMap.put(R.id.button_synth_c, noteC);
        noteMap.put(R.id.button_synth_cs, noteCs);
        noteMap.put(R.id.button_synth_d, noteD);
        noteMap.put(R.id.button_synth_ds, noteDs);
        noteMap.put(R.id.button_synth_e, noteE);
        noteMap.put(R.id.button_synth_f, noteF);
        noteMap.put(R.id.button_synth_fs, noteFs);
        noteMap.put(R.id.button_synth_g, noteG);
        noteMap.put(R.id.button_synth_gs, noteGs);
        noteMap.put(R.id.button_synth_highA, noteHighA);
        noteMap.put(R.id.button_synth_highBb, noteHighBb);
        noteMap.put(R.id.button_synth_highB, noteHighB);
        noteMap.put(R.id.button_synth_highC, noteHighC);
        noteMap.put(R.id.button_synth_highCs, noteHighCs);
        noteMap.put(R.id.button_synth_highD, noteHighD);
        noteMap.put(R.id.button_synth_highDs, noteHighDs);
        noteMap.put(R.id.button_synth_highE, noteHighE);
        noteMap.put(R.id.button_synth_highF, noteHighF);
        noteMap.put(R.id.button_synth_highFs, noteHighFs);
        noteMap.put(R.id.button_synth_highG, noteHighG);
        noteMap.put(R.id.button_synth_highGs, noteHighGs);






    }

    private void initializeSoundPool()
    {
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalea, 1);
        noteBb = soundPool.load(this, R.raw.scalebb, 1);
        noteB = soundPool.load(this, R.raw.scaleb, 1);
        noteC = soundPool.load(this, R.raw.scalec, 1);
        noteCs = soundPool.load(this, R.raw.scalecs, 1);
        noteD = soundPool.load(this, R.raw.scaled, 1);
        noteDs = soundPool.load(this, R.raw.scaleds, 1);
        noteE = soundPool.load(this, R.raw.scalee, 1);
        noteF = soundPool.load(this, R.raw.scalef, 1);
        noteFs = soundPool.load(this, R.raw.scalefs, 1);
        noteG = soundPool.load(this,R.raw.scaleg, 1);
        noteGs = soundPool.load(this, R.raw.scalegs, 1);
        noteHighA = soundPool.load(this, R.raw.scalehigha, 1);
        noteHighBb = soundPool.load(this, R.raw.scalehighbb, 1);
        noteHighB = soundPool.load(this, R.raw.scalehighb, 1);
        noteHighC = soundPool.load(this, R.raw.scalehighc, 1);
        noteHighCs = soundPool.load(this, R.raw.scalehighcs, 1);
        noteHighD = soundPool.load(this, R.raw.scalehighd, 1);
        noteHighDs = soundPool.load(this, R.raw.scalehighds, 1);
        noteHighE = soundPool.load(this, R.raw.scalehighe, 1);
        noteHighF = soundPool.load(this, R.raw.scalehighf, 1);
        noteHighFs = soundPool.load(this, R.raw.scalehighfs, 1);
        noteHighG = soundPool.load(this, R.raw.scalehighg, 1);
        noteHighGs = soundPool.load(this, R.raw.scalehighgs, 1);


    }

    private void setListeners()
    {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCs.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDs.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFs.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGs.setOnClickListener(noteListener);
        buttonHighA.setOnClickListener(noteListener);
        buttonHighBb.setOnClickListener(noteListener);
        buttonHighB.setOnClickListener(noteListener);
        buttonHighC.setOnClickListener(noteListener);
        buttonHighCs.setOnClickListener(noteListener);
        buttonHighD.setOnClickListener(noteListener);
        buttonHighDs.setOnClickListener(noteListener);
        buttonHighE.setOnClickListener(noteListener);
        buttonHighF.setOnClickListener(noteListener);
        buttonHighFs.setOnClickListener(noteListener);
        buttonHighG.setOnClickListener(noteListener);
        buttonHighGs.setOnClickListener(noteListener);
        //challenge buttons still use the Activity's implementatic
        buttonPlayScale.setOnClickListener(this);
        buttonPlaySong2.setOnClickListener(this);
        buttonPlaySong.setOnClickListener(this);




    }


    private void wireWidgets()
    {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById((R.id.button_synth_bflat));
        buttonB = findViewById((R.id.button_synth_b));
        buttonC = findViewById(R.id.button_synth_c);
        buttonCs = findViewById(R.id.button_synth_cs);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDs = findViewById(R.id.button_synth_ds);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFs = findViewById(R.id.button_synth_fs);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGs = findViewById(R.id.button_synth_gs);
        buttonHighA = findViewById(R.id.button_synth_highA);
        buttonHighBb = findViewById(R.id.button_synth_highBb);
        buttonHighB = findViewById(R.id.button_synth_highB);
        buttonHighC = findViewById(R.id.button_synth_highC);
        buttonHighCs = findViewById(R.id.button_synth_highCs);
        buttonHighD = findViewById(R.id.button_synth_highD);
        buttonHighDs = findViewById(R.id.button_synth_highDs);
        buttonHighE = findViewById(R.id.button_synth_highE);
        buttonHighF = findViewById(R.id.button_synth_highF);
        buttonHighFs = findViewById(R.id.button_synth_highFs);
        buttonHighG = findViewById(R.id.button_synth_highG);
        buttonHighGs = findViewById(R.id.button_synth_highGs);
        buttonPlayScale = findViewById(R.id.button_synth_playScale);
        buttonPlaySong = findViewById(R.id.button_synth_playSong);
        buttonPlaySong2 = findViewById(R.id.button_synth_playSong3);


    }

    @Override
    public void onClick(View view)
    {
      //one method to handle the clicks of all the button
      //but don't forget to tell the buttons who is doing the listening.
      switch(view.getId())
      {
//          case R.id.button_synth_a:
//              soundPool.play(noteA, 1.0f, 1.0f, 1, 0, 1.0f);
//              Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
//             break;
//         case R.id.button_synth_bflat:
//              soundPool.play(noteBb, 1.0f, 1.0f, 1, 0, 1.0f);
//              Toast.makeText(this, "B♭", Toast.LENGTH_SHORT).show();
//              break;
//          case R.id.button_synth_b:
//              soundPool.play(noteB, 1.0f, 1.0f, 1, 0, 1.0f);
//              Toast.makeText(this, "B", Toast.LENGTH_SHORT).show();
//              break;
//          case R.id.button_synth_c:
//              playNote(noteC, 0);
//              break;
//          case R.id.button_synth_cs:
//              playNote(noteCs, 0);
//              break;
//          case R.id.button_synth_d:
//              playNote(noteD, 0);
//              break;
//          case R.id.button_synth_ds:
//              playNote(noteDs, 0);
//              break;
//          case R.id.button_synth_e:
//              playNote(noteE, 0);
//              break;
//          case R.id.button_synth_f:
//              playNote(noteF, 0);
//              break;
//          case R.id.button_synth_fs:
//              playNote(noteFs, 0);
//              break;
//          case R.id.button_synth_g:
//              playNote(noteG, 0);
//              break;
//          case R.id.button_synth_gs:
//              playNote(noteGs, 0);
//              break;

          case R.id.button_synth_playScale:
              playScale();
              break;
          case R.id.button_synth_playSong:
              playTwinkleStars();
              break;
          case R.id.button_synth_playSong3:
              playMidsummerMadness();
              break;
    }
}
    private void playSong(Song scale)
    {
        for(Note note : scale.getNotes())
        {
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void playScales() {
        Song scale = new Song();
        List<Note> notes = new ArrayList<>();
        notes.add(new Note(noteA));
        notes.add(new Note(noteBb));
        notes.add(new Note(noteB));
        notes.add(new Note(noteC));
        notes.add(new Note(noteCs));
        notes.add(new Note(noteD));
        notes.add(new Note(noteDs));
        notes.add(new Note(noteE));
        notes.add(new Note(noteF));
        notes.add(new Note(noteFs));
        notes.add(new Note(noteG));
        notes.add(new Note(noteGs));
        playSong(scale);
    }
    private void playScale() {
        ArrayList<Integer> musicalNotes = new ArrayList<Integer>(Arrays.asList(noteA, noteBb, noteB,
                noteC, noteCs, noteD, noteDs, noteE, noteF, noteFs, noteG, noteGs, noteHighA, noteHighBb,
                noteHighB, noteHighC, noteHighCs, noteHighD, noteHighDs, noteHighE, noteHighF, noteHighFs, noteHighG, noteHighGs));
        Song song1 = new Song();
        for (int n : musicalNotes) {
            song1.add(new Note(n, WHOLE_NOTE));
        }
        playSong(song1);
    }

     //play all the notes one at a time with a delay in between
//     soundPool.play(noteA, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, 0, DEFAULT_RATE);
//     playNote(noteA, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteBb, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteB, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteC, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteCs, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteD, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteDs, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteE, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteF, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteFs, 0);
//     delay((WHOLE_NOTE));
//     playNote(noteG, 0);
//     delay(WHOLE_NOTE);
//     playNote(noteGs, 0);


    private void playTwinkleStars()
    {
        ArrayList<Integer> musicalNotes = new ArrayList<Integer>(Arrays.asList(noteA,  noteA, noteE,
        noteE, noteFs, noteFs, noteE, noteD, noteD, noteCs, noteCs, noteB, noteB, noteA, noteE, noteE, noteD, noteD, noteCs, noteCs,
                noteB, noteE, noteE, noteD, noteD, noteCs, noteCs, noteB, noteA, noteA, noteE, noteE, noteFs, noteFs, noteE, noteD, noteD,
        noteCs, noteCs, noteB, noteB, noteA));
        Song song2 = new Song();
        for(int i = 1; i <=musicalNotes.size(); i++)
        {
            if(i%7==0) {
                song2.add(new Note(musicalNotes.get(i - 1), WHOLE_NOTE));
            }
            else
            {
                song2.add(new Note(musicalNotes.get(i - 1), WHOLE_NOTE/2));
            }


        }
        playSong(song2);
    }

    private void playMidsummerMadness()
    {
        ArrayList<Integer>musicalNotes = new ArrayList<>(Arrays.asList(noteE, noteCs, noteE, noteCs, noteFs, noteE, noteB, noteA, noteE, noteCs,
                noteE, noteCs, noteFs, noteE, noteB, noteA, noteE, noteCs, noteCs, noteHighA, noteA, noteFs, noteE, noteB, noteA, noteCs, noteCs, noteB,
                noteA, noteE, noteE, noteD, noteFs, noteHighA, noteHighCs, noteHighB, noteD, noteFs, noteHighA, noteHighCs, noteHighB, noteCs,
                noteFs, noteHighA, noteHighCs, noteHighB, noteHighA, noteHighCs, noteHighB, noteHighA, noteE, noteE, noteD, noteFs, noteHighA, noteHighCs, noteHighB, noteD, noteFs, noteHighA, noteHighCs, noteHighB, noteCs,
                noteFs, noteHighA, noteHighCs, noteHighB, noteHighA, noteHighCs, noteHighB, noteHighA));
        Song song3 = new Song();
        for(int i = 1; i <= musicalNotes.size(); i++)
        {
            if(i == 5)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE* 2));
            }
            else if(i == 6)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else if(i == 13)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE * 2));
            }
            else if(i == 14)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else if(i == 18 )
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/4));
            }
            else if(i == 19)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE * 2));
            }
            else if(i == 22)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE *2));
            }
            else if(i == 23)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else if(i == 25)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE*2));
            }
            else if(i == 27)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE*2));
            }
            else if(i == 28 )
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else if(i == 29)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE*2));
            }
            else if(i == 33)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else if(i == 37)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else if(i == 41)
            {
                song3.add(new Note(musicalNotes.get(i-1), WHOLE_NOTE/2));
            }
            else
                {
                song3.add(new Note(musicalNotes.get(i - 1), WHOLE_NOTE));
            }
        }
        playSong(song3);

    }

    private void delay(int duration) {
        try{
            Thread.sleep(duration);
        } catch (InterruptedException e) {

        }
    }

    private void playNote(int note, int loop)
    {
        soundPool.play(note, DEFAULT_VOLUME, DEFAULT_VOLUME, DEFAULT_PRIORITY, 0, DEFAULT_RATE);
    }
    private void playNote(Note note)
    {
        playNote(note.getNoteId());
    }
    private void playNote(int note)
    {
        playNote(note, 0);
    }

    private class KeyboardNoteListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            //get the id of the button that was clicked
            int id = v.getId();
            //use the map to figure out what note to play
            int note = noteMap.get(id);
            //play the note
            playNote(note);
        }
    }
}

