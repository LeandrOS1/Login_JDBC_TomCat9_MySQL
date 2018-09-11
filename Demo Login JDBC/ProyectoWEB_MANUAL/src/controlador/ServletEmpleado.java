package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Empleado;
import modelo.ModelEmpleado;

@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	ModelEmpleado m=new ModelEmpleado();
	private static final long serialVersionUID = 1L;
       
    public ServletEmpleado() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login, clave;
		login=request.getParameter("txtLogin");
		clave=request.getParameter("txtPass");
		Empleado e=m.iniciarSesion(login, clave);
		
		if(e==null) {
			
			request.setAttribute("msj", "Incorrect username and / or password.");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		
		}
		else {
			
			response.sendRedirect("menu.jsp");
			
		}
		
		
	}

}
