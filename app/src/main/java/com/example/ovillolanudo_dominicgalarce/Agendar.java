package com.example.ovillolanudo_dominicgalarce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ovillolanudo_dominicgalarce.database.AdminSQLiteOpenHelper;

public class Agendar extends AppCompatActivity {

    private EditText code, clas, nivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        code= findViewById(R.id.code);
        clas= findViewById(R.id.clas);
        nivel= findViewById(R.id.nivel);
    }

    public void guardarClase(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"OvilloLanudo",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String level = nivel.getText().toString();

        if (!codigo.isEmpty() && !clase.isEmpty() && !level.isEmpty()){

            ContentValues cont = new ContentValues();
            cont.put("codigo",codigo);
            cont.put("clase",clase);
            cont.put("level", level);

            db.insert("clases",null,cont);
            Clean();
            db.close();
            Toast.makeText(getBaseContext(),"Se ha insertado la clase", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getBaseContext(),"debe rellenar los campos", Toast.LENGTH_LONG).show();
        }

    }
    public void mostrarClase(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"OvilloLanudo",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty()){

            Cursor file =
                db.rawQuery("SELECT clase, level FROM clases WHERE codigo="+codigo,null);

            if(file.moveToFirst()){
                clas.setText(file.getString(0));
                nivel.setText(file.getString(1));
            }
            else{
                Toast.makeText(getBaseContext(),"no hay clase asociada", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getBaseContext(),"el codigo no debe ir vacio", Toast.LENGTH_LONG).show();
        }
    }
    public void actualizarClase(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"OvilloLanudo",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        if(!codigo.isEmpty()){
            db.delete("clases", "codigo"+codigo,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Se ha eliminado la clase", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(),"El codigo no debe estar vacio", Toast.LENGTH_LONG).show();
        }
    }
    public void eliminarClase(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getBaseContext(),"OvilloLanudo",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();
        String clase = clas.getText().toString();
        String level = nivel.getText().toString();

        if (!codigo.isEmpty() && !clase.isEmpty() && !level.isEmpty()){

            ContentValues cont = new ContentValues();

            cont.put("clase",clase);
            cont.put("level", level);

            db.update("clases",cont,"codigo="+codigo,null);
            Clean();
            db.close();
            Toast.makeText(getBaseContext(),"Se ha actualizado la clase", Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(getBaseContext(),"debe rellenar los campos", Toast.LENGTH_LONG).show();
        }

    }


    public void Clean(){
        code.setText("");
        clas.setText("");
        nivel.setText("");

    }
}