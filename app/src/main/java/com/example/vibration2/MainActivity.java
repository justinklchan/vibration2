package com.example.vibration2;

import android.os.Bundle;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Vibrator vibrator;
    EditText et,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et=(EditText)findViewById(R.id.editTextNumber);
        et2=(EditText)findViewById(R.id.editTextNumber2);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    public void work(View v) {
        Log.e("asdf","work");
        long spacing=Long.parseLong(et.getText().toString());
        long gap=Long.parseLong(et2.getText().toString());
        Log.e("asdf",spacing+"");
        long[] timings=new long[]{spacing,gap,spacing,gap};
        int[] amplitudes=new int[]{255,0,255,0};
//        vibrator.vibrate(300);
//        vibrator.vibrate(VibrationEffect.createWaveform(timings,amplitudes,1));
        vibrator.vibrate(1000*5);
    }

    public void stopwork(View v) {
        vibrator.cancel();
    }
}