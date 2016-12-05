package FrameWork;

import java.net.URL;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class Factory {

	HashMap <String, Action> table = new HashMap<String, Action>();

	public Factory(){	
		remplir();

		/*table.put("/ActionDebut.do", new ActionDebut());
		table.put("/ActionLogin.do", new ActionLogin());
		table.put("/ActionUn.do", new ActionUn());
		table.put("/LogoutAction.do", new LogoutAction());	*/		
	}
	
	void remplir() {
		try{
		
		// TODO Auto-generated method stub
	  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 
		DocumentBuilder builder=null;
		Document document =null;
		
			//ClassLoader cl = Thread.currentThread().getContextClassLoader();
            //URL resURL = cl.getResource("maFactory.xml");
            //Document d = db.parse(resURL.toString());
            
			builder = factory.newDocumentBuilder();
			ClassLoader loader= Thread.currentThread().getContextClassLoader();
			URL resURL = loader.getResource("MaFactory.xml");
		
			System.err.println(resURL);
			document = builder.parse(resURL.toString());
		
		
		org.w3c.dom.Element racine=document.getDocumentElement();
		NodeList bases=racine.getElementsByTagName("description");
		for (int i=0;i<bases.getLength();i++)
		{
			org.w3c.dom.Node base = bases.item(i);
			NodeList elements= base.getChildNodes();
			
			String nomkey=null;
			String nomkey2=null;
			for (int j=0;j<bases.getLength();j++)
			{
				
				org.w3c.dom.Node enfant =elements.item(j);
				if(enfant.getNodeName().equals("url_pattern"))
				nomkey = enfant.getTextContent();
				if(enfant.getNodeName().equals("Class_action"))
				nomkey2 = enfant.getTextContent();
				
				if(nomkey!=null && nomkey2 !=null){
					Class<?> c = null;
					
						c = Class.forName(nomkey2);
						table.put(nomkey, (Action) c.newInstance());
					
					
				}
			}
		}}catch(Exception e){e.printStackTrace();
			
		}
		
	}

	

	public static void main(String[] args){
		Factory fact=new Factory();
		fact.remplir();
		//System.out.println(fact.table.toString());
	}
	
	public Action getAction (String provenance){
		return table.get(provenance);
	}

}
