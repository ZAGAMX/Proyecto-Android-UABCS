package com.example.zagamx.proyectofinalpma.retrofitComponents;

import com.example.zagamx.proyectofinalpma.Models.Instalaciones;
import com.example.zagamx.proyectofinalpma.Models.Maestro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataInstalacion {

    @GET("instalaciones")
    Call<List<Instalaciones>> listaInstalaciones();
}
