/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sevlet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "SmartServlet", urlPatterns = {"/SmartServlet"})
public class SmartServlet extends HttpServlet {
    static ArrayList persons = new ArrayList<>();

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

//            randomQ(request, response, out);
            personsCreater(request,response,out);
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
        saveToPersons(request,response);
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

    private void randomQ(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
       Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date 
        int hour = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        String quote = "";

        switch (hour) {
            case 0:
                quote = "Qoute from hour " + hour;
                break;
            case 1:
                quote = "Qoute from hour " + hour;
                break;
            case 2:
                quote = "Qoute from hour " + hour;
                break;
            case 3:
                quote = "Qoute from hour " + hour;
                break;
            case 4:
                quote = "Qoute from hour " + hour;
                break;
            case 5:
                quote = "Qoute from hour " + hour;
                break;
            case 6:
                quote = "Qoute from hour " + hour;
                break;
            case 7:
                quote = "Qoute from hour " + hour;
                break;
            case 8:
                quote = "Qoute from hour " + hour;
                break;
            case 9:
                quote = "Qoute from hour " + hour;
                break;
            case 10:
                quote = "Qoute from hour " + hour;
                break;
            case 11:
                quote = "Qoute from hour " + hour;
                break;
            case 12:
                quote = "Qoute from hour " + hour;
                break;
            case 13:
                quote = "Qoute from hour " + hour;
                break;
            case 14:
                quote = "Qoute from hour " + hour;
                break;
            case 15:
                quote = "Qoute from hour " + hour;
                break;
            case 16:
                quote = "Qoute from hour " + hour;
                break;
            case 17:
                quote = "Qoute from hour " + hour;
                break;
            case 18:
                quote = "Qoute from hour " + hour;
                break;
            case 19:
                quote = "Qoute from hour " + hour;
                break;
            case 20:
                quote = "Qoute from hour " + hour;
                break;
            case 21:
                quote = "Qoute from hour " + hour;
                break;
            case 22:
                quote = "Qoute from hour " + hour;
                break;
            case 23:
                quote = "Qoute from hour " + hour;
                break;
                
                default:
                    quote="Sorry failed";

        }

        out.write(quote);
    }

    private void personsCreater(HttpServletRequest request, HttpServletResponse response, PrintWriter out) {
        if(persons.isEmpty()){
        Person p1 = new Person("Hans", 15);
        Person p2 = new Person("Grete", 12);
        Person p3 = new Person("Kurt", 75);
        
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
            
        }
        
        //TO JSON
        String jsonString = new Gson().toJson(persons);
        out.write(jsonString);
    }

    private void saveToPersons(HttpServletRequest request, HttpServletResponse response) {
        try {
            BufferedReader reader =request.getReader();
            String s = reader.readLine();
            Person pfromServer = new Gson().fromJson(s, Person.class);
            persons.add(pfromServer);
        } catch (IOException ex) {
            System.out.println("Coun't not read");
            System.out.println(ex);
        }
    }

}
