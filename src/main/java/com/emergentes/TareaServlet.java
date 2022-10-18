
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "TareaServlet", urlPatterns = {"/TareaServlet"})
public class TareaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        
        if(op.equals("vaciar")){
            //vaciar carrito
            HttpSession ses = request.getSession();
            ses.invalidate();
            response.sendRedirect("index.jsp");  
      }
        if (op.equals("eliminar")) {
            int pos = -1;
            int buscado = -1;
            int  id = Integer.parseInt(request.getParameter("id"));
            //eliminar tarea
            HttpSession ses  = request.getSession();
            
      ArrayList<TareaClass> lista =(ArrayList<TareaClass>)ses.getAttribute("almacenados");
            for (TareaClass p : lista) {
                pos++;
                if (p.getId() == id) {
                    buscado = pos;
                }
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }  
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      int id = Integer.parseInt(request.getParameter("id"));
      String tarea = request.getParameter("tarea");
      
     TareaClass tareas = new TareaClass();
     
     tareas.setId(id);
     tareas.setTarea(tarea);

     HttpSession ses = request.getSession();
     
     ArrayList<TareaClass> lista = (ArrayList<TareaClass>)ses.getAttribute("almacenados");
     lista.add(tareas);   
     response.sendRedirect("index.jsp");
     
    } 

}
