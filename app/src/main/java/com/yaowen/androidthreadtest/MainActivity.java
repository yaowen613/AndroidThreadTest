package com.yaowen.androidthreadtest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int UPDATE_TEXT = 1;
    private Button changeText;
    private TextView textView;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    // 在这⾥可以进⾏UI操作
                    textView.setText("Nice to meet you!");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeText = (Button) findViewById(R.id.change_text);
        textView = (TextView) findViewById(R.id.text);

        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        //textView.setText("Nice to meet you!");
                        Message message=new Message();
                        message.what=UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }
}
