package com.example.test_pc.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button play, pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.silence);

        play = (Button) findViewById(R.id.play_button);
        pause = (Button) findViewById(R.id.pause_button);

        play.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                    {
                        Toast.makeText(getApplicationContext(), "Playing Song", Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();
                    }
            }
        );

        pause.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                    {
                        Toast.makeText(getApplicationContext(), "Pausing Song", Toast.LENGTH_SHORT).show();
                        mediaPlayer.pause();
                    }
            }
        );

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer)
                    {
                        Toast.makeText(getApplicationContext(), "Song is Finished", Toast.LENGTH_SHORT);
                    }
            }
        );
    }
}
