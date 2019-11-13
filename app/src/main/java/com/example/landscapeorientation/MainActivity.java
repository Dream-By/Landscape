package com.example.landscapeorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    static final String ORIENTATION_PORTRAIT = "Портретный режим";
    static final String ORIENTATION_LANDSCAPE = "Альбомный режим";
    //определяем изменение ориентации экрана
    boolean mState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.button3);

        //текст по умолчанию
        mButton.setText(ORIENTATION_LANDSCAPE);
        }

        private String getScreenOrientation(){
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            return "Портретная ориентация";
        else if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомная ориентация";
        else
            return"";
    }

    private String getRotateOrientation(){
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate){
            case Surface.ROTATION_0:
                return "Не поворачивали";
                case Surface.ROTATION_90:
                    return "Повернули на 90 градусов по часовой стрелке";
                    case Surface.ROTATION_180:
                        return "Повернули на 180 градусов";
                        case Surface.ROTATION_270:
                            return "Повернули на 270 градусов";
                            default:
                                return "Непонятно...";
        }
    }

    public void OnClick(View view) {
        TextView editText = findViewById(R.id.textView);
        editText.setText(getScreenOrientation());
        }

    public void OnRotation(View view) {
        TextView editText = findViewById(R.id.textView);
        editText.setText(getRotateOrientation());
    }

    public void OnLand(View view) {
        // state FALSE: переключаемся на LANDSCAPE
        if (!mState){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            TextView editText = findViewById(R.id.textView);
            editText.setText(ORIENTATION_LANDSCAPE);
        }
        //state TRUE: переключаемся на PORTRAIT
        else
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            TextView editText = findViewById(R.id.textView);
            editText.setText(ORIENTATION_PORTRAIT);
        }
        //обновляем state на противоположное значение
        mState = !mState;

    }
}
