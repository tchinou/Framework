package FrameWork;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action{

	@Override
	public String perform(HttpServletRequest request, HttpServletResponse response) 
	{
		
		return "/GoodBye.jsp";
	}

}
