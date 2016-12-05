package FrameWork;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    Factory factory=new Factory();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dans Action Servlet");
		
		
		// récupérer la provenance
		String provenance= request.getServletPath();
		//System.out.println(provenance);
		
		String jspDeSuite=null;
		
		if (provenance.equals("/Index.html")){
			jspDeSuite="/Debut.html";
		}
		
		else{
		
		Action act=factory.getAction(provenance);
		jspDeSuite = act.perform(request, response);
		

		}
		
		
		getServletContext().getRequestDispatcher(jspDeSuite).forward(request, response);
		
		
	}

}
