package com.example.zagamx.proyectofinalpma.Perfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zagamx.proyectofinalpma.DB.Datapma;
import com.example.zagamx.proyectofinalpma.MainActivity;
import com.example.zagamx.proyectofinalpma.Models.Usuario;
import com.example.zagamx.proyectofinalpma.R;
import com.example.zagamx.proyectofinalpma.Shared.SharedLogin;

public class Sesion extends AppCompatActivity {

    private Datapma databaseHelper;
    private Usuario user;

    private static final String TAG = "Funciona: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        setTitle("Inicio de Sesión");





        String correo = SharedLogin.getInstans(getApplicationContext()).getUserEmail();
        String pass = SharedLogin.getInstans(getApplicationContext()).getUserPass();
        /*if(databaseHelper.checkUser(correo,pass)){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }*/
    }
    public void Onclick(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
    public void OnclickCrear(View view){
        startActivity(new Intent(this,Crearperfil.class));
    }
}
