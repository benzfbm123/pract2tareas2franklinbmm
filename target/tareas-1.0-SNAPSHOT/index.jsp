<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.TareaClass"%>
<%
    if(session.getAttribute("almacenados")==null){
    ArrayList<TareaClass> listarea = new ArrayList<TareaClass>();
    session.setAttribute("almacenados",listarea);
    }
   ArrayList<TareaClass> almacenados =(ArrayList<TareaClass>)session.getAttribute("almacenados");
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
       <body>
        <h1>Carrito de compras</h1>
        <form action="TareaServlet" method="post" >
        <table border="0">
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="0" size="" /></td>
                </tr>
                <tr>
                    <td>Tarea</td>
                     <td><input type="text" name="tarea" value="" size="" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="procesar" /></td>
                </tr>
        </table>
        </form>
        
        <form>
            <a href="TareaServlet?op=vaciar">Vaciar Tareas</a>
            <h2>TAREAS PENDIENTES</h2>
            <table border="1">            
                    <tr>
                        <td>Id</td>
                        <td>Tarea</td>   
                        <td>Completado </td>
                        <td></td>
                    </tr>
                    <%
                        if (almacenados !=null){
                            for (TareaClass p : almacenados) {
                    %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getTarea() %></td>
                        <td><input type="checkbox" name="" value="ON" /></td>  
                        <td><a href="TareaServlet?op=eliminar&id=<%= p.getId() %>">eliminar</a></td>
                    </tr>
                    <%
                        }
                     }
                    %>                
            </table>       
        </form> 
    </body>
</html>
