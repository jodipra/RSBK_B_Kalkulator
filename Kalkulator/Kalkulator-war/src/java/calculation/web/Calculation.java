/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation.web;

import calculation.ejb.CalculationLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HZ
 */
@WebServlet(name = "Calculation", urlPatterns = {"/Calculation"})
public class Calculation extends HttpServlet {

    CalculationLocal calculation = lookupCalculationLocal();

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calculator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h2>Kalkulator Statefull</h2></center>");
            out.println("<div id='calc-contain'>");
            out.println("<form name=\"calculation\">");
            out.println("<center><input type=\"text\" name=\"answer\" /></center>");
            out.println("<br>");
            out.println("<center>");
            out.println("<input type=\"button\" value=\" 1 \" onclick=\"calculation.answer.value += '1'\" />");
            out.println("<input type=\"button\" value=\" 2 \" onclick=\"calculation.answer.value += '2'\" />");
            out.println("<input type=\"button\" value=\" 3 \" onclick=\"calculation.answer.value += '3'\" />");
            out.println("<input type=\"button\" value=\" + \" onclick=\"calculation.answer.value += '+'\" />");
            out.println("<br/>");
            out.println("<input type=\"button\" value=\" 4 \" onclick=\"calculation.answer.value += '4'\" />");
            out.println("<input type=\"button\" value=\" 5 \" onclick=\"calculation.answer.value += '5'\" />");
            out.println("<input type=\"button\" value=\" 6 \" onclick=\"calculation.answer.value += '6'\" />");
            out.println("<input type=\"button\" value=\" - \" onclick=\"calculation.answer.value += '-'\" />");
            out.println("<br/>");
            out.println("<input type=\"button\" value=\" 7 \" onclick=\"calculation.answer.value += '7'\" />");
            out.println("<input type=\"button\" value=\" 8 \" onclick=\"calculation.answer.value += '8'\" />");
            out.println("<input type=\"button\" value=\" 9 \" onclick=\"calculation.answer.value += '9'\" />");
            out.println("<input type=\"button\" value=\" x \" onclick=\"calculation.answer.value += '*'\" />");
            out.println("<br/>");
            out.println("<input type=\"button\" value=\" c \" onclick=\"calculation.answer.value = ''\" />");
            out.println("<input type=\"button\" value=\" 0 \" onclick=\"calculation.answer.value += '0'\" />");
            out.println("<input type=\"button\" value=\" = \" onclick=\"calculation.answer.value = eval(calculation.answer.value)\" />");
            out.println("<input type=\"button\" value=\" / \" onclick=\"calculation.answer.value += '/'\" />");
            out.println("<br/>");
            out.println("</center>");
            out.println("</div>");
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

    private CalculationLocal lookupCalculationLocal() {
        try {
            Context c = new InitialContext();
            return (CalculationLocal) c.lookup("java:global/Kalkulator/Kalkulator-ejb/Calculation!calculation.ejb.CalculationLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
