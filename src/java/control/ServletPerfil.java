/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;
import DAO.PerfilFacade;
import POJO.Perfil;


/**
 *
 * @author CASKLE
 */

   


public class ServletPerfil extends HttpServlet {
    
  @EJB
    private PerfilFacade perfilFacade;
  private Perfil perfil;
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
        //Perfil e =new Perfil("camila","Diez","25","Ingeniera Industrial");
         try{
        String accion = request.getParameter("action");
        String Nombre =  request.getParameter("nombre");
        String Apellido = request.getParameter("apellido");
        String Edad = request.getParameter("edad");
        String Pregrado = request.getParameter("pregrado");
        
        perfil =new Perfil(Nombre,Apellido,Edad,Pregrado);
        if("Agregar".equalsIgnoreCase(accion)){
           perfilFacade.create(perfil);
            request.setAttribute("perfil", perfil);
            
        }else if("Editar".equalsIgnoreCase(accion)){
            perfilFacade.edit(perfil);
            Perfil PerfilBuscado =  perfilFacade.fin(Nombre);
            request.setAttribute("perfils",PerfilBuscado);
            
        }else if("Borrar".equalsIgnoreCase(accion)){
            perfilFacade.remove(perfil);
            
        }else if("Buscar".equalsIgnoreCase(accion)){
            Perfil perfilBuscado = perfilFacade.fin(Nombre);
            request.setAttribute("perfil", perfilBuscado);
        }
        
        }catch(Exception e){
            System.out.println("Hay error");
        }
        
        
        
        request.setAttribute("perfiles", perfilFacade.findAll());
               System.out.println("cargo estudiante" + perfilFacade.count());        
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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