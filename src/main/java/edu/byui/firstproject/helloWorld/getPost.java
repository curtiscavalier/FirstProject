/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.firstproject.helloWorld;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author curtiscavalier
 */

@WebServlet(name = "getPost", urlPatterns = {"/getPost"})
public class getPost extends HttpServlet {

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
        try{
            File file = new File("entry.txt");
            if (!file.exists()){
                file.createNewFile();
            }
        FileInputStream inputStream = new FileInputStream("entry.txt");
        String everything = IOUtils.toString(inputStream);
        String[] ss = everything.split("\n");
        try(PrintWriter out = response.getWriter()){
        for ( int a = (ss.length-1); a >= 0; a--){
               
                          
String [] entry = ss[a].split("//");
            out.println("<table width=\"400\" border=\"1\" cellpadding=\"10\">");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>" + "Time : " + entry[0] + "</td>");
            out.println("<td>" + "User : " + entry[1] + "</td>");
             out.println("</tr>");
             out.println("<tr>");
            out.println("<td colspan = \"2\">" + "Entry : " + entry[2] + "</td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");

        }
        out.println("<a href=forum.>Click here to return</a>");
        }
        }catch (Exception e){
            e.printStackTrace();
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
