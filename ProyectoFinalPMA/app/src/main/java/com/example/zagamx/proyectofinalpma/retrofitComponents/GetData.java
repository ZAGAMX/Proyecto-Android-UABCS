package com.example.zagamx.proyectofinalpma.retrofitComponents;

import com.example.zagamx.proyectofinalpma.Models.Maestro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {

    @GET("maestros")
    Call<List<Maestro>> listaMaestros();

}
