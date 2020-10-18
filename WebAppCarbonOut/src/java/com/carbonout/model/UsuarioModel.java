/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.model;

import com.carbonout.dao.ScoreDao;
import com.carbonout.dao.UsuarioDao;
import com.carbonout.entity.Score;
import com.carbonout.entity.Usuario;
import com.carbonout.util.Json;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class UsuarioModel {
    UsuarioDao udao = new UsuarioDao();
    ScoreDao sdao = new ScoreDao();
    /*Metodo para insertar un area. Mayor detalle en el modelo DAO*/
    public int RegistrarUsuario(Usuario u) throws SQLException {        
        return udao.Insertar(u);
    }
    public int CambiarContrasenia(String correoUsuario, String contraseniaNueva) throws SQLException {        
        return udao.CambiarContrasenia(correoUsuario, contraseniaNueva);
    }
    public String LoginUsuario(String correoUsuario, String contrasenia) throws SQLException, IOException{
        Usuario user = udao.login(correoUsuario, contrasenia);
        String JsonUser = Json.convertJavaToJson(user);
        return JsonUser;
    }
    public String ObtenerScore(int idUsuario) throws SQLException, IOException{
        Score score = sdao.obteneScore(idUsuario);
        String JsonUser = Json.convertJavaToJson(score);
        return JsonUser;
    }
    public Usuario LoginUsuarioObject(String correoUsuario, String contrasenia) throws SQLException, IOException{
        Usuario user = udao.login(correoUsuario, contrasenia);
        return user;
    }
    public int CalcularScore(Score s) throws SQLException, IOException{
        return sdao.Insertar(s);
    }
    /*public int EditarUsuario(Usuario u) throws SQLException {        
        return udao.Editar(u);
    }*/
}
