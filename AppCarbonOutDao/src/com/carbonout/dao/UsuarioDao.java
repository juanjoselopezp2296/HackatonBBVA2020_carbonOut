/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.dao;

import com.carbonout.db.Database;
import com.carbonout.entity.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 51968
 */
public class UsuarioDao {
    private Connection con;
    
    /*Registrar Usuario*/
    public int Insertar(Usuario u) throws SQLException {
        
        int rpta = 0;
        
        try{
        /*Creamos conexion y enviamos el nombre del procedimiento a ejecutar en Mysql*/
        con = Database.getConnection();
        CallableStatement cStmt = con.prepareCall("{CALL sp_RegistrarUsuario(?,?,?)}");
        
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.setString(1, u.get_CorreoUsuario());
        cStmt.setString(2, u.get_Nombre());
        cStmt.setString(3, u.get_Contrasenia());
        
        rpta = cStmt.executeUpdate();
        }finally{
            con.close();
            /*Enviamos la lista de usuarios*/
            return rpta;
        }
    }
    public int CambiarContrasenia(String correoUsuario, String contraseniaNueva) throws SQLException {
        
        int rpta = 0;
        
        try{
        /*Creamos conexion y enviamos el nombre del procedimiento a ejecutar en Mysql*/
        con = Database.getConnection();
        CallableStatement cStmt = con.prepareCall("{CALL sp_CambiarContrasenia(?,?)}");
        
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.setString(1, correoUsuario);
        cStmt.setString(2, contraseniaNueva);
        
        rpta = cStmt.executeUpdate();
        }finally{
            con.close();
            /*Enviamos la lista de usuarios*/
            return rpta;
        }
    }
    
    public Usuario login(String correoUsuario, String contrasenia) throws SQLException {
        
        Usuario user = new Usuario();
        user.set_Id(0);
        /*Creamos conexion y enviamos el nombre del procedimiento a ejecutar en Mysql*/
        con = Database.getConnection();
        CallableStatement cStmt = con.prepareCall("{CALL sp_LoginUsuario(?,?)}");
        
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.setString(1, correoUsuario);
        cStmt.setString(2, contrasenia);
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.execute();
  
        /*Ejecutamos el procedimiento*/
        final ResultSet rs = cStmt.getResultSet(); 
        
        /*
          Obtenemos los datos de todos los Usuarios (que cuenta con acceso el usuario en sesion)
          directamente de la base de datos
        */
        while(rs.next()){ 
                user.set_Id(rs.getInt("idUsuario"));
                user.set_Nombre(rs.getString("nombreUsuario"));
                user.set_CorreoUsuario(rs.getString("correoUsuario"));
        }
        /*Enviamos la lista de usuarios*/
        con.close();
        return user;
    }  
    
}
