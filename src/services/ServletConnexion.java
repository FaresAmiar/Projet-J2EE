package services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mediatek2020.Mediatheque;
import mediatek2020.items.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		String login = req.getParameter("login");
        String password = req.getParameter("password");

        //if(login == "" || password == "")
        
        PrintWriter out = rep.getWriter();

        Mediatheque md = Mediatheque.getInstance();
        
        Utilisateur user = null;
        
        try {
        	user = md.getUser(login, password);
        }catch(NullPointerException n) {
        	

        }
        
        HttpSession session = req.getSession(true);
        session.setAttribute("utilisateur", user);
        
        req.getRequestDispatcher("accueil.jsp").forward(req, rep);
     	
        

	}

}
