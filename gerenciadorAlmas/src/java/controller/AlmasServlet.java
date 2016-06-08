package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alma;
import modelo.DepositoAlmas;

//@WebServlet(name = "AlmaServlet", urlPatterns = {"/AlmaServlet"})
public class AlmasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 
        DepositoAlmas deposito = (DepositoAlmas) request.getSession().getAttribute("deposito");
        if(deposito == null){
            deposito = new DepositoAlmas();
            request.getSession().setAttribute("deposito", deposito);
        }
        String jsp = null;
        if(request.getRequestURI().endsWith("/cadastroAlma")){
            jsp = processaNovo(request, response, deposito);
        }else if(request.getRequestURI().endsWith("/editaAlma")){
            jsp = processaEdita(request, response, deposito);
        }else if(request.getRequestURI().endsWith("/removeAlma")){
            jsp = processaRemove(request, response, deposito);
        }else if(request.getRequestURI().endsWith("/salvaAlma")){
            jsp = processaSalvar(request, response, deposito);
        }else{
            jsp = processaLista(request, response, deposito);
        }
        
        if(jsp == null){
            response.sendRedirect(request.getContextPath() + "/listaAlmas");
        }else{
            request.getRequestDispatcher(jsp).forward(request, response);
        }
    }
    
    private String processaNovo(HttpServletRequest request, HttpServletResponse response, DepositoAlmas deposito){
        return "/cadastroAlma.jsp";
    }
    
    private String processaEdita(HttpServletRequest request, HttpServletResponse response, DepositoAlmas deposito){
        Alma alma = new Alma();
        
        alma.setId(Integer.parseInt(request.getParameter("id")));
        alma.setNome(request.getParameter("nome").toString());
        alma.setPecado(request.getParameter("pecado").toString());
        alma.setStatus(Integer.parseInt(request.getParameter("status")));
        
//        deposito.editaAlma(alma);
        
        return "/listaAlmas";
    }

    private String processaRemove(HttpServletRequest request, HttpServletResponse response, DepositoAlmas deposito){
        String id = request.getParameter("id");
        deposito.removeAlma(Integer.parseInt(id));
        return null;
    }
    
    private String processaSalvar(HttpServletRequest request, HttpServletResponse response, DepositoAlmas deposito){
        
        Alma alma = new Alma();
        
        alma.setNome(request.getParameter("nome").toString());
        alma.setPecado(request.getParameter("pecado").toString());
        alma.setStatus(Integer.parseInt(request.getParameter("status")));
        
        deposito.insereAlma(alma);
        
        return "/listaAlmas";
    }
    
    private String processaLista(HttpServletRequest request, HttpServletResponse response, DepositoAlmas deposito){
        String nome = request.getParameter("nome");
        List resultado = null;
        if(nome == null || nome.trim().length() == 0){
//            resultado = deposito.listaContatos();
        }else{
//            resultado = deposito.listaContatos(nome);
        }
        request.setAttribute("resultadoBusca", resultado);
        return "/listaAlmas.jsp";
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
