package FrameWork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionLogin implements Action{

	@Override
	public String perform(HttpServletRequest request,HttpServletResponse response) 
	{
		String login=request.getParameter("Lelogin");
		if(login.equals("titi"))
			return "/Page1.jsp";
		else 
			return "/Erreur.jsp";		


	}

}
