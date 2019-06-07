package com.example.zagamx.proyectofinalpma.Models;

import com.example.zagamx.proyectofinalpma.Horario.Horarios;

import java.util.List;

public class ListaHorario {

    String hora;


    List<HorariosSemestre> horariosSemestres;

    public List<HorariosSemestre> getHorariosSemestres() {
        return horariosSemestres;
    }

    public void setHorariosSemestres(List<HorariosSemestre> horariosSemestres) {
        this.horariosSemestres = horariosSemestres;
    }
}
