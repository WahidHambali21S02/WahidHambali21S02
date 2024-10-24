package com.example.uts_wahidhambali;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TextView Hasil;
    private EditText Masukan;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Masukan = (EditText) findViewById(R.id.input);
        Hasil= (TextView) findViewById(R.id.output);
        Button eksekusi = (Button) findViewById(R.id.save);
        preferences = getSharedPreferences(); eksekusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                Toast.makeText(getApplicationContext(),"Data Tersimpan", Toast.LENGTH_SHORT).show();
            }

            private Context getApplicationContext() {
                return null;
            }
        });
    }

    private SharedPreferences getSharedPreferences() {
        return null;
    }

    @SuppressLint("SetTextI18n")
    private void getData(){
        String getKonten = Masukan.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data_saya", getKonten);
        editor.apply();
        Hasil.setText("Output Data: "+preferences.getString("data_saya", null));
    }
}
