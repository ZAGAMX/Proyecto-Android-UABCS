package com.example.zagamx.proyectofinalpma.retrofitComponents;

import com.example.zagamx.proyectofinalpma.Models.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetHorarios {
    @GET("horarios")
    Call<List<Example>> listaHorarios();
}
