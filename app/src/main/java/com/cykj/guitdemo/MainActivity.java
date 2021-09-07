package com.cykj.guitdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.zlw.main.recorderlib.RecordManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 *Android和Python交互
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        callPythonCodeFromLib();
    }

    void callPythonCodeFromLib(){
        Python py = Python.getInstance();
        py.getModule("callPyLib").callAttr("get_http");
        py.getModule("callPyLib").callAttr("print_numpy");
        py.getModule("callPyLib").callAttr("Love");
    }


    // 初始化Python环境
    void initPython() {
        if (!Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }
    }
}
