package com.example.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button1, button2;
    TextView textView;

    private String myDataBaseFile =  "myDate";

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText =  findViewById(R.id.editText);
         button1 = findViewById(R.id.button1);
         button2 =  findViewById(R.id.button2);
         textView=findViewById(R.id.textView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data =  editText.getText().toString();
                try {
                    Log.d("Button Click","Save");
                    FileOutputStream fOut =  openFileOutput(myDataBaseFile,MODE_PRIVATE);

                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"file saved", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fIn =  openFileInput(myDataBaseFile);
                    int c;
                    StringBuilder temp = new StringBuilder();
                    while ( (c = fIn.read()) !=-1){
                        temp.append((char)c);
                    }
                    textView.setText(temp.toString());
                    Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
