/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.dao;

import com.carbonout.db.Database;
import com.carbonout.entity.Score;
import com.carbonout.entity.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 51968
 */
public class ScoreDao {
    private Connection con;
    
    /*Registrar Usuario*/
    public int Insertar(Score s) throws SQLException {
        
        int rpta = 0;
        
        try{
        /*Creamos conexion y enviamos el nombre del procedimiento a ejecutar en Mysql*/
        con = Database.getConnection();
        CallableStatement cStmt = con.prepareCall("{CALL sp_CalcularScore(?,?,?,?,?)}");
        
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.setInt(1, s.getId());
        cStmt.setInt(2, s.getValorCat1());
        cStmt.setInt(3, s.getValorCat2());
        cStmt.setInt(4, s.getValorCat3());
        cStmt.setInt(5, s.getValorCat4());
        
        rpta = cStmt.executeUpdate();
        }finally{
            con.close();
            /*Enviamos la lista de usuarios*/
            return rpta;
        }
    }
     public Score obteneScore(int idUsuario) throws SQLException {
        
        Score score = new Score();
        score.setId(0);
        score.setNota1(100);
        score.setNota2(100);
        score.setNota3(100);
        score.setNota4(100);
        /*Creamos conexion y enviamos el nombre del procedimiento a ejecutar en Mysql*/
        con = Database.getConnection();
        CallableStatement cStmt = con.prepareCall("{CALL sp_ObtenerScore(?)}");
        
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.setInt(1, idUsuario);
        /*Enviamos las variables a enviar en el procedimiento*/
        cStmt.execute();
  
        /*Ejecutamos el procedimiento*/
        final ResultSet rs = cStmt.getResultSet(); 
        
        /*
          Obtenemos los datos de todos los Usuarios (que cuenta con acceso el usuario en sesion)
          directamente de la base de datos
        */
        while(rs.next()){ 
                score.setId(rs.getInt("idUsuario"));
                score.setNota1(rs.getFloat("nota1"));
                score.setNota2(rs.getFloat("nota2"));
                score.setNota3(rs.getFloat("nota3"));
                score.setNota4(rs.getFloat("nota4"));
        }
        /*Enviamos la lista de usuarios*/
        con.close();
        return score;
    }  
}
