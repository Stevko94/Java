
package Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import moduls.Doctorlog;
import moduls.HibernateUtil;
import moduls.Userlog;
import org.hibernate.Query;
import org.hibernate.Session;
@WebServlet(name = "Log", urlPatterns = {"/Log"})
public class Log extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         Session session = HibernateUtil.getSF().openSession();
         HttpSession htps= request.getSession();
         String u = request.getParameter("user");
         String p = request.getParameter("pass");
         String dr = request.getParameter("doctor");
         if(dr==null){
             Query q =session.getNamedQuery("Auth");
             q.setParameter("username", u);
             q.setParameter("pass", p);
             Userlog ul= (Userlog) q.uniqueResult();
             if(ul!=null){
                 htps.setAttribute("userloged", u);
                 request.getRequestDispatcher("./kalendar.jsp").forward(request, response);
                 
             }else {
                 response.sendRedirect("./");
             }
         } else{
             Query q =session.getNamedQuery("Doctorlog.Auth");
             q.setParameter("username", u);
             q.setParameter("pass", p);
             Doctorlog drl =(Doctorlog) q.uniqueResult();
             if(drl!=null){
                 htps.setAttribute("doctorloged", drl.getId().toString());
                 request.getRequestDispatcher("./kalendar.jsp").forward(request, response);
                 
             }else {
                 response.sendRedirect("./");
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
