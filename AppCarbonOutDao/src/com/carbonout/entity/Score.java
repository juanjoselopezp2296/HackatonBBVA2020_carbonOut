/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.entity;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author 51968
 */
public class Score {
    @JsonProperty ("idUsuario")
    private int    id;
    @JsonProperty ("valorCat1")
    private int valorCat1;
    @JsonProperty ("nota1")
    private float nota1;
    @JsonProperty ("valorCat2")
    private int valorCat2;
    @JsonProperty ("nota2")
    private float nota2;
    @JsonProperty ("valorCat3")
    private int valorCat3;
    @JsonProperty ("nota3")
    private float nota3;
    @JsonProperty ("valorCat4")
    private int valorCat4;
    @JsonProperty ("nota4")
    private float nota4;    
    /*Definicion de Constructor*/
    public Score(){}

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the valorCat1
     */
    public int getValorCat1() {
        return valorCat1;
    }

    /**
     * @param valorCat1 the valorCat1 to set
     */
    public void setValorCat1(int valorCat1) {
        this.valorCat1 = valorCat1;
    }

    /**
     * @return the nota1
     */
    public float getNota1() {
        return nota1;
    }

    /**
     * @param nota1 the nota1 to set
     */
    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    /**
     * @return the valorCat2
     */
    public int getValorCat2() {
        return valorCat2;
    }

    /**
     * @param valorCat2 the valorCat2 to set
     */
    public void setValorCat2(int valorCat2) {
        this.valorCat2 = valorCat2;
    }

    /**
     * @return the nota2
     */
    public float getNota2() {
        return nota2;
    }

    /**
     * @param nota2 the nota2 to set
     */
    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    /**
     * @return the valorCat3
     */
    public int getValorCat3() {
        return valorCat3;
    }

    /**
     * @param valorCat3 the valorCat3 to set
     */
    public void setValorCat3(int valorCat3) {
        this.valorCat3 = valorCat3;
    }

    /**
     * @return the nota3
     */
    public float getNota3() {
        return nota3;
    }

    /**
     * @param nota3 the nota3 to set
     */
    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    /**
     * @return the valorCat4
     */
    public int getValorCat4() {
        return valorCat4;
    }

    /**
     * @param valorCat4 the valorCat4 to set
     */
    public void setValorCat4(int valorCat4) {
        this.valorCat4 = valorCat4;
    }

    /**
     * @return the nota4
     */
    public float getNota4() {
        return nota4;
    }

    /**
     * @param nota4 the nota4 to set
     */
    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }
    
    
}
