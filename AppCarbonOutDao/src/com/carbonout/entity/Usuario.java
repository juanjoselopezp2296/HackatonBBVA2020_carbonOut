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
public class Usuario {
   /*Definicion de Atributos*/
    @JsonProperty ("correoUsuario")
    private String correoUsuario;
    @JsonProperty ("nombreUsuario")
    private String nombre;
    @JsonProperty ("contrasenia")
    private String contrasenia;
    @JsonProperty ("idUsuario")
    private int    id;
    @JsonProperty ("flgActivo")
    private String flgActivo;
    
    /*Definicion de Constructor*/
    public Usuario(){}
    
    /*Definicion de Metodos Gets / Sets*/
    public String get_CorreoUsuario(){
        return correoUsuario;
    }
    public void set_CorreoUsuario(String correoUsuario){
        this.correoUsuario = correoUsuario;
    }
     public String get_Nombre(){
        return nombre;
    }
    public void set_Nombre(String nombre){
        this.nombre = nombre;
    }
    public String get_Contrasenia(){
        return contrasenia;
    }
    public void set_Contrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    public String get_FlgActivo(){
        return flgActivo;
    }
    public void set_FlgActivo(String flgActivo){
        this.flgActivo = flgActivo;
    }
    public int get_Id(){
        return id;
    }
    public void set_Id(int id){
        this.id = id;
    }
    
}
