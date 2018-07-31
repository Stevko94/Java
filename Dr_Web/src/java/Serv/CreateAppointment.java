
package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import moduls.Appointments;
import moduls.Doctors;
import moduls.HibernateUtil;
import org.hibernate.Session;
@WebServlet(name = "CreateAppointment", urlPatterns = {"/CrApp"})
public class CreateAppointment extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       Session session = HibernateUtil.getSF().openSession();
         HttpSession htps= request.getSession();
         String dr =(String) htps.getAttribute("doctorloged");
         String t = request.getParameter("time");
         String d = request.getParameter("date");
         String n = request.getParameter("name");
         session.beginTransaction();
         Appointments ap = new Appointments();
         Doctors drm = (Doctors)session.get(Doctors.class, Integer.parseInt(dr));
         ap.setDoctorId(drm);
         ap.setAtime(t+" "+d);
         ap.setUsername(n);
         session.save(ap);
         session.getTransaction().commit();
         response.sendRedirect("./kalendar.jsp");
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
