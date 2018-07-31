
package Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import moduls.Doctorlog;
import moduls.Doctors;
import moduls.HibernateUtil;
import org.hibernate.Session;

@WebServlet(name = "DocCr", urlPatterns = {"/DocCr"})
public class DocCr extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         Session session = HibernateUtil.getSF().openSession();
         HttpSession htps= request.getSession();
         String us = request.getParameter("user");
         String pa = request.getParameter("pass");
         String na = request.getParameter("name");
         String lo = request.getParameter("Location");
         String op = request.getParameter("opens");
         String cl = request.getParameter("closes");
         String cc = request.getParameter("contact");
         Doctorlog dl= new Doctorlog();
         Doctors dr = new Doctors();
         session.beginTransaction();
         dl.setUsername(us);
         dl.setPass(pa);
         dr.setName(na);
         dr.setLocation(lo);
         dr.setOpens(Integer.parseInt(op));
         dr.setCloses(Integer.parseInt(cl));
         dr.setContact(cc);
         session.save(dl);
         session.save(dr);         
         session.getTransaction().commit();
         response.getWriter().write("Doctor created!!!");
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
