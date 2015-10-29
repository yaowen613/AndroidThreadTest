package com.yaowen.androidthreadtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button changeText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeText= (Button) findViewById(R.id.change_text);
        textView= (TextView) findViewById(R.id.text);

        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        textView.setText("Nice to meet you!");
                    }
                }).start();
            }
        });
    }
}
