package com.cykj.guitdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.zlw.main.recorderlib.RecordManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private AudioRecorder mAudioRecorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        Python py = Python.getInstance();

        button = findViewById(R.id.text_id);
        RecordManager.getInstance().init(MyApp.getInstance(), false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAudioRecorder.startRecord();
            }
        });
        mAudioRecorder = new AudioRecorder(this);
        mAudioRecorder.createDefaultAudio();
        mAudioRecorder.setRecordStreamListener(new AudioRecorder.RecordStreamListener() {

            @Override
            public void onRecording(short[] bytes, int offset, int length) {
            }

            @Override
            public void finishRecord() {
                Log.i("TAG===", "finishRecord");
            }
        });
    }

    // 初始化Python环境
    void initPython() {
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
    }
}
