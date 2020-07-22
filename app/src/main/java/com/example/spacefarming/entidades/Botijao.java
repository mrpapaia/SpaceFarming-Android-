package com.example.spacefarming.entidades;

//import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

public class Botijao implements Serializable{
    private String id;
    private Double capacidadeLitros;
    private Double nivelAtual;
    private Integer quantidadeCanecas;
    private Integer quantidadePalhetas;
    private Integer quantidadeRacks;

    public Botijao() {

    }

    public Botijao(String id, Double capacidadeLitros, Double nivelAtual, Integer quantidadeCanecas, Integer quantidadePalhetas, Integer quantidadeRacks) {
        this.id = id;
        this.capacidadeLitros = capacidadeLitros;
        this.nivelAtual = nivelAtual;
        this.quantidadeCanecas = quantidadeCanecas;
        this.quantidadePalhetas = quantidadePalhetas;
        this.quantidadeRacks = quantidadeRacks;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Double getCapacidadeLitros() {
        return capacidadeLitros;
    }
    public void setCapacidadeLitros(Double capacidadeLitros) {
        this.capacidadeLitros = capacidadeLitros;
    }
    public Double getNivelAtual() {
        return nivelAtual;
    }
    public void setNivelAtual(Double nivelAtual) {
        this.nivelAtual = nivelAtual;
    }
    public Integer getQuantidadeCanecas() {
        return quantidadeCanecas;
    }
    public void setQuantidadeCanecas(Integer quantidadeCanecas) {
        this.quantidadeCanecas = quantidadeCanecas;
    }

    public Integer getQuantidadePalhetas() {
        return quantidadePalhetas;
    }

    public void setQuantidadePalhetas(Integer quantidadePalhetas) {
        this.quantidadePalhetas = quantidadePalhetas;
    }

    public Integer getQuantidadeRacks() {
        return quantidadeRacks;
    }

    public void setQuantidadeRacks(Integer quantidadeRacks) {
        this.quantidadeRacks = quantidadeRacks;
    }

    @Override
    public String toString() {
        return "Botijao{" +
                "id='" + id + '\'' +
                ", capacidadeLitros=" + capacidadeLitros +
                ", nivelAtual=" + nivelAtual +
                ", quantidadeCanecas=" + quantidadeCanecas +
                ", quantidadePalhetas=" + quantidadePalhetas +
                ", quantidadeRacks=" + quantidadeRacks +
                '}';
    }
}
