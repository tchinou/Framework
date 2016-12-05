package FrameWork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionDebut implements Action{

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) 
	{		
		return "/Login.jsp";
	}

}
