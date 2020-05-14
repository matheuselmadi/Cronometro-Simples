package com.example.cronometro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean execucao;
    private int segundos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }
    public void onClickStart(View view){
        execucao = true;
    }
    public void onClickStop(View view){
        execucao = false;
    }
    public void onClickReset(View view){
        execucao = false;
        segundos = 0;
    }
    private void runTimer(){
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = segundos/3600;
                int minutes = (segundos%3600)/60;
                int secs = segundos%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                timeView.setText(time);
                if(execucao){
                    segundos++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
