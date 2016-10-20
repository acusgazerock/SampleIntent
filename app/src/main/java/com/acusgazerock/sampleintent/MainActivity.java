package com.acusgazerock.sampleintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btnSub1,btnSub2, btnDial, btnSoundSetting;
        private EditText textIntent;
        private String strTextIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSub1 = (Button) findViewById(R.id.btn_activity_sub_1);
        btnSub2 = (Button) findViewById(R.id.btn_activity_sub_2);
        btnDial = (Button) findViewById(R.id.btn_activity_dial);
        btnSoundSetting = (Button) findViewById(R.id.btn_activity_sound_setting);
        textIntent = (EditText) findViewById(R.id.text_Intent);
        btnSub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Sub1Activity.class);
                startActivity(intent);
            }
        });

        btnSub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strTextIntent = textIntent.getText().toString();
                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                intent.putExtra(Sub2Activity.KEY_DATA, strTextIntent );
                startActivity(intent);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0227790566"));
                startActivity(intent);
            }
        });

        btnSoundSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SOUND_SETTINGS), 0);
            }
        });

    }
}
