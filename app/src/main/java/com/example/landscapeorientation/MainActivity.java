package com.example.landscapeorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    private String getScreenOrientation(){
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            return "Портретная ориентация";
        else if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомная ориентация";
        else
            return"";
    }

    public void OnClick(View view) {
        TextView editText = findViewById(R.id.textView);
        editText.setText(getScreenOrientation());

    }
}
