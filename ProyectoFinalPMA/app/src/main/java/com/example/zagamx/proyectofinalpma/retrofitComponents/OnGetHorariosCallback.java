package com.example.zagamx.proyectofinalpma.retrofitComponents;

import com.example.zagamx.proyectofinalpma.Models.Example;

import java.util.List;

public interface OnGetHorariosCallback {
    void onSuccess(List<Example> movies);

    void onError();
}
