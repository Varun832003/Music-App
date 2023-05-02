package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        seekBar = findViewById(R.id.seekBar);
        //Media player using local source.
        mediaPlayer = MediaPlayer.create(this,R.raw.pathan);

//         Media Player using remote source
//        mediaPlayer = new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource("https://www.hungama.com/song/apna-bana-le/96250275/ ");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//                Toast.makeText(MainActivity.this, "Ready to play", Toast.LENGTH_SHORT).show();
//                mp.start();
//            }
//        });
//        mediaPlayer.prepareAsync();
        mediaPlayer.start();
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                mediaPlayer.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    button.setText("Play");
                }else{
                    mediaPlayer.start();
                    button.setText("Pause");
                }
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.start();
            }

        });
    }

}
