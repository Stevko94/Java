
package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import moduls.Admins;
import moduls.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

@WebServlet(name = "AdminLog", urlPatterns = {"/AdminLog"})
public class AdminLog extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
         Session session = HibernateUtil.getSF().openSession();
         HttpSession htps= request.getSession();
         String u = request.getParameter("auser");
         String p = request.getParameter("apass");
         Query q = session.getNamedQuery("Admins.Auth");
         q.setParameter("username", u);
         q.setParameter("pass", p);
         Admins ad = (Admins)q.uniqueResult();
         if(ad!=null){
         htps.setAttribute("logedin", ad);
         request.getRequestDispatcher("./CreateDoc.jsp").forward(request, response);
         }else{ response.sendRedirect("./adminlog.html");}
         

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
