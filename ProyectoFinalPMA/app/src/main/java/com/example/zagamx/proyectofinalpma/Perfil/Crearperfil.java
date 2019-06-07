package com.example.zagamx.proyectofinalpma.Perfil;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.zagamx.proyectofinalpma.Adapter.spinneradapter;
import com.example.zagamx.proyectofinalpma.DB.Datapma;
import com.example.zagamx.proyectofinalpma.Models.Usuario;
import com.example.zagamx.proyectofinalpma.R;
import com.example.zagamx.proyectofinalpma.Shared.SharedLogin;

public class Crearperfil extends AppCompatActivity {

    String[] carrera = {"Ing. en Desarrollo de Software", "Ing. en Tecnologias de la Comunicacion", "Lic. en Administracion de la Tecnologia de la Informacion"};
    String[] semestre = {"2","4","6","8"};
    String[] turno = {"Matutino","Vespertino"};
    TextInputLayout nombre,correo,contra1,contra2;
    Spinner spinner,spinner1,spinner2;

    private Datapma databaseHelper;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearperfil);
        setTitle("Crear cuenta");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nombre = findViewById(R.id.nombreCrear);
        correo = findViewById(R.id.correoCrear);
        contra1 = findViewById(R.id.contraCrear);
        contra2 = findViewById(R.id.repCrear);

        databaseHelper = new Datapma(getApplicationContext());
        user = new Usuario();

        spinner = findViewById(R.id.carrera);
        spinner1 = findViewById(R.id.semestre);
        spinner2 = findViewById(R.id.turno);
        SpinnerAdapter adapter = new spinneradapter(getApplicationContext(),carrera);
        spinner.setAdapter(adapter);

        SpinnerAdapter adapter1 = new spinneradapter(getApplicationContext(),semestre);
        spinner1.setAdapter(adapter1);

        SpinnerAdapter adapter2 = new spinneradapter(getApplicationContext(),turno);
        spinner2.setAdapter(adapter2);




    }

    public void onClick(View view){

        if(nombre.getEditText().getText().toString().equals("")){
            nombre.setError("Campo vacio");
        }
        else{
            nombre.setErrorEnabled(false);
        }

        if(correo.getEditText().getText().toString().equals("")){
            correo.setError("Campo vacio");
        }
        else{
            correo.setErrorEnabled(false);
        }

        if(contra1.getEditText().getText().toString().compareTo(contra2.getEditText().getText().toString())==0){
            contra1.setError("Contraseñas desiguales");
            contra2.setError("Contraseñas desiguales");
            //Toast.makeText(getApplicationContext(),"Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
        }else{
            contra1.setErrorEnabled(false);
            contra2.setErrorEnabled(false);
        }

        if(contra1.getEditText().getText().toString().equals("")){
            contra1.setError("Campo vacio");
        }else{
            contra1.setErrorEnabled(false);
        }

        if(contra2.getEditText().getText().toString().equals("")){
            contra2.setError("Campo vacio");
        }else {
            contra2.setErrorEnabled(false);
        }
        int i = spinner.getSelectedItemPosition();

        //String s = carrera[i];

        crearUsuario();



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void crearUsuario(){
        String nam,emai,pass,carr,seme,tur;
        nam = nombre.getEditText().getText().toString();
        emai = correo.getEditText().getText().toString();
        pass = contra1.getEditText().getText().toString();

        int i = spinner.getSelectedItemPosition();
        int se = spinner1.getSelectedItemPosition();
        int tr = spinner2.getSelectedItemPosition();
        String c = carrera[i];
        String s = semestre[se];
        String t = turno[tr];

        user.setName(nam);
        user.setEmail(emai);
        user.setPassword(pass);
        user.setCarrera(c);
        user.setSemestre(s);
        user.setTurno(t);

        databaseHelper.addUser(user);

        SharedLogin.getInstans(getApplicationContext()).userLogin("1",nam,emai,pass,c,s,t);
        Toast.makeText(getApplicationContext(),"Usuario Agregado",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(getApplicationContext(),Sesion.class));
    }

}
