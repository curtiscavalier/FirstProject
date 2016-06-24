/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.firstproject.helloWorld;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sun.misc.IOUtils;
/**
 *
 * @author curtiscavalier
 */
@WebServlet(urlPatterns = {"/Login"})
public class login extends HttpServlet {

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
     
        // Check username
        if (request.getParameter("username") != null && request.getParameter("password") != null) {
               ServletContext context = getServletContext();
               
            File file = new File("users.txt");
            if(!file.exists()){
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write("curtis,123");
                bw.newLine();
                bw.write("me,123");
                bw.newLine();
                bw.close();
            }
           
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            
            String line;
            Multimap<String,String> multimap = ArrayListMultimap.create();
         
           
      
            while((line = br.readLine())!=null){
                System.out.println(line);
                String [] s = line.split(",");
                multimap.put(s[0], s[1]);
                
            }
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            boolean valid_login = false;
            if (multimap.containsKey(username)){
                if(multimap.get(username).contains(password)){
                    valid_login = true;
                }
            }
            if (valid_login) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("incorrect_error", null);
                response.sendRedirect("forum.jsp");
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("incorrect_error", null);
                response.sendRedirect("invalid.jsp");
            }
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