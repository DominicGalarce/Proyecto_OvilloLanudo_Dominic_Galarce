package com.example.ovillolanudo_dominicgalarce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Object_Class.Usuarios;

public class Registro extends AppCompatActivity {

    private EditText usuario, id, password;
    private TextView mensaje;
    private ProgressBar barra;
    private Button registro;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        id = (EditText)findViewById(R.id.edt_IID);
        usuario = (EditText)findViewById(R.id.edt_IUsuario);
        password = (EditText)findViewById(R.id.edt_IPassword);
        mensaje = (TextView)findViewById(R.id.txt_mensaje);
        barra = (ProgressBar)findViewById(R.id.pgb_barraR);
        registro = (Button)findViewById(R.id.btt_registrarse);

        id.setText("");
        usuario.setText("");
        password.setText("");

        barra.setVisibility(View.INVISIBLE);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                mensaje.setText("");
                new Registro.Task().execute();
            }
        });
    }

    //tarea asincrona
    class Task extends AsyncTask<String, Void, String> {
        //define la configuracion inicial de mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }
        //realiza el proceso en segundo plano o mi tarea pesada
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 3; i++){
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }
        //finaliza tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}