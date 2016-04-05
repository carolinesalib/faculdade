/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author caroline
 */
@WebServlet(name = "PedidoServlet", urlPatterns = {"/pedido"})
public class PedidoServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String descricao = request.getParameter("descricao");
            Double preco = Double.parseDouble(request.getParameter("preco"));
            Integer quantidade = Integer.parseInt(request.getParameter("quantidade"));
            
            Produto produto = new Produto();
            
            produto.setDescricao(descricao);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            
            
            HttpSession session = request.getSession();

            Pedido pedido = (Pedido)session.getAttribute("pedido");
            
            System.out.println(pedido);
            
            if (pedido == null) {
                pedido = new Pedido();
            }
            
            pedido.addProduto(produto);
            session.setAttribute("pedido", pedido);
            
            List<Produto> produtos = pedido.getProdutos();
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pedido</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Pedidos</h1>");
            
            for (Produto p : produtos) {
               out.println("<h2>" + p.getDescricao() + "</h2>");       
            }
            
            out.println("</body>");
            out.println("</html>");
             
        } finally {            
            out.close();
        }
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
