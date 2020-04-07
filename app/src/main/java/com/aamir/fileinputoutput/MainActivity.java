package com.aamir.fileinputoutput;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText editText;
    static final int READ_BLOCK_SIZE=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btnsave);
        btn2 = findViewById(R.id.btnload);
        editText = findViewById(R.id.editText);

       /* InputStream inputStream=getResources().openRawResource(R.raw.myintro);  //data inputstream me aa gya
        try {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream)); // fast read krne ke liye
            String str= null;
            while ((str=bufferedReader.readLine())!=null) {
                Toast.makeText(this, ""+str, Toast.LENGTH_LONG).show(); //length long for show toast long time
        }
        inputStream.close();
        bufferedReader.close();
        }
         catch (Exception e){
            e.printStackTrace(); }*/
        }

    public void save(View view) {

        try {

            String data = editText.getText().toString();
            FileOutputStream fileOutputStream = openFileOutput("aamirmlaik.txt", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(data);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            Toast.makeText(this, "file save successfully", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void load(View view) {
        try{
        FileInputStream fileInputStream=openFileInput("aamirmlaik.txt");
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        char[] ichar=new char[READ_BLOCK_SIZE];
        String s="";
        int charRead;

        while((charRead=inputStreamReader.read(ichar))>0){
            String readString=String.copyValueOf(ichar,0,charRead);
            s+=readString;
            ichar=new char[READ_BLOCK_SIZE];
        }
        editText.setText(s);

            Toast.makeText(this, "file loaded successfully", Toast.LENGTH_SHORT).show();

        }
        catch (Exception e){

            e.printStackTrace();
        }

    }
}

