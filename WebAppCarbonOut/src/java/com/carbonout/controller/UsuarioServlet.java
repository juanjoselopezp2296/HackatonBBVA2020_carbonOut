/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.controller;

import com.carbonout.entity.Score;
import com.carbonout.entity.Usuario;
import com.carbonout.model.UsuarioModel;
import com.carbonout.util.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author 51968
 */
public class UsuarioServlet extends HttpServlet {
    private UsuarioModel umodel =  new UsuarioModel();
    private Email email = new Email();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario u = new Usuario();
        if (id == 1) {
               String correo = request.getParameter("correoUsuario");
               String contrasenia = request.getParameter("contrasenia"); 
               u.set_CorreoUsuario(correo);
               u.set_Contrasenia(contrasenia); 
               
               String uSesion = umodel.LoginUsuario(u.get_CorreoUsuario(), u.get_Contrasenia());
               Usuario user = umodel.LoginUsuarioObject(u.get_CorreoUsuario(), u.get_Contrasenia());
               
               if(uSesion.length()>0){    
               HttpSession sesion = request.getSession();
               sesion.setAttribute("userIdSession", user.get_Id());
               
               response.setContentType("application/json");
               response.getWriter().write(uSesion);    
               
               }else{
                   uSesion = "";
                   response.setContentType("application/json");
                   response.getWriter().write(uSesion);
               }
        }else if (id == 2){
            HttpSession sesion = request.getSession();
            int idUsuarioSesion =  Integer.parseInt(sesion.getAttribute("userIdSession").toString());
            String score = umodel.ObtenerScore(idUsuarioSesion);
            response.setContentType("application/json");
            response.getWriter().write(score);
        }
         } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8"); 
        int rpta = 0;
        try {
            Usuario u = new Usuario();
            int id = Integer.parseInt(request.getParameter("id"));
            if(id == 1){
                String nombre = request.getParameter("nombreUsuario");
                String correo = request.getParameter("correoUsuario");
                String contrasenia = request.getParameter("contrasenia");
                String flag = request.getParameter("flgActivo");

                u.set_Nombre(nombre);
                u.set_CorreoUsuario(correo);
                u.set_Contrasenia(contrasenia);
                u.set_FlgActivo(flag);
                rpta = umodel.RegistrarUsuario(u);
                try{
                    if(rpta == 1){
                        email.enviar(correo, "Hola " + nombre, "¡Bienvenid@ a nuestra comunidad de CarbonOut!\nGracias por Registrarte!!\n");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            }else if (id == 2){
                SecureRandom random = new SecureRandom();
                StringBuffer password = new StringBuffer();
                char[] allowedCharacters = {'a','b','c','1','2','3','4'};
                
                for(int i = 0; i < 8; i++) {
                        password.append(allowedCharacters[ random.nextInt(allowedCharacters.length) ]);
                }
                
                String correoRecuperar = request.getParameter("correoRecuperar");
                String contraseniaRecuperar = password.toString();//request.getParameter("correoRecuperar");
                rpta = umodel.CambiarContrasenia(correoRecuperar, contraseniaRecuperar);
                try{
                    if(rpta == 1){
                        email.enviar(correoRecuperar, "Recuperar Contraseña", "Su nueva contraseña es " + contraseniaRecuperar + "\nRecuerde que tiene solo 15 minutos para realizar el cambio.");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                //int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
                //u.set_Id(idUsuario);
                //rpta = umodel.EditarUsuario(u);
            }else if (id == 3){
                HttpSession sesion = request.getSession();
                sesion.invalidate();
            }else if (id == 4){
                Score s = new Score();
                int p1 = Integer.parseInt(request.getParameter("p1"));
                int p2 = Integer.parseInt(request.getParameter("p2"));
                int p3 = Integer.parseInt(request.getParameter("p3"));
                int p4 = Integer.parseInt(request.getParameter("p4"));
                int p5 = Integer.parseInt(request.getParameter("p5"));
                int p6 = Integer.parseInt(request.getParameter("p6"));
                int p7 = Integer.parseInt(request.getParameter("p7"));
                int p8 = Integer.parseInt(request.getParameter("p8"));
                int p9 = Integer.parseInt(request.getParameter("p9"));
                int p10 = Integer.parseInt(request.getParameter("p10"));
                int p11 = Integer.parseInt(request.getParameter("p11"));
                
                
                
                int cat1 = p1 + p2;//Integer.parseInt(request.getParameter("valorCat1"));
                int cat2 = p3 + p4 + p5;//Integer.parseInt(request.getParameter("valorCat2"));
                int cat3 = p6 + p7 + p8 + p9;//Integer.parseInt(request.getParameter("valorCat3"));
                int cat4 = p10 + p11;//Integer.parseInt(request.getParameter("valorCat4"));
                
                 HttpSession sesion = request.getSession();
                 int idUsuarioSesion =  Integer.parseInt(sesion.getAttribute("userIdSession").toString());
                
                 if(cat2 == 3)
                     cat2 = 0;
                 
                s.setValorCat1(cat1);
                s.setValorCat2(cat2);
                s.setValorCat3(cat3);
                s.setValorCat4(cat4);
                s.setId(idUsuarioSesion);
                rpta = umodel.CalcularScore(s);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            response.setContentType("application/json");
            if(rpta == 1){
                response.getWriter().write("1");
            }else{
                response.getWriter().write("0");
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
