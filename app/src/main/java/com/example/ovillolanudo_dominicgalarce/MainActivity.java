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

public class MainActivity extends AppCompatActivity {

    private EditText usuario, password;
    private TextView error;
    private ProgressBar barra;
    private Button inicio;

    Usuarios obj_usuario = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = (EditText)findViewById(R.id.edt_usuario);
        password = (EditText)findViewById(R.id.edt_pass_contraseña);
        error = (TextView)findViewById(R.id.txt_error);

        barra = (ProgressBar)findViewById(R.id.pgb_main);

        inicio = (Button)findViewById(R.id.btt_ingresar);

        usuario.setText("");
        password.setText("");

        barra.setVisibility(View.INVISIBLE);

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                error.setText("");
                new Task().execute();
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

            //validacion en on postexecute
            //captura de valores ingrewsados por pantalla
            String usser = usuario.getText().toString().trim();
            String contraseña = password.getText().toString().trim();

            for(int i = 0; i <= obj_usuario.getId().length; i++){
                try {
                    if(usser.equals(obj_usuario.getUsuario()[i]) && contraseña.equals(obj_usuario.getPassword()[i])){
                        Intent intent = new Intent(getBaseContext(), Home.class);
                        LimpiarCampos();
                        error.setText("");
                        barra.setVisibility(View.INVISIBLE);
                        startActivity(intent);
                        break;
                    }

                    else if(usser.equals("") && contraseña.isEmpty()){
                        barra.setVisibility(View.INVISIBLE);
                        error.setText("Campos vacios, ingrese usuario y contraseña.");
                        break;
                    }

                    else if(!usser.equals(obj_usuario.getUsuario()[i]) && !contraseña.equals(obj_usuario.getPassword()[i])){
                        barra.setVisibility(View.INVISIBLE);
                        LimpiarCampos();
                        error.setText("Usuario o contraseña invalida, intente nuevamente.");
                    }
                } catch (Exception e){
                    System.out.println(e);
                }

            }
        }
    }

    public void registro(View view){
        Intent i = new Intent(getBaseContext(), Registro.class);
        startActivity(i);
    }

    public void LimpiarCampos(){
        usuario.setText("");
        password.setText("");
    }
}