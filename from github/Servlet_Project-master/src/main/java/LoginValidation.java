    import java.io.IOException;  
    import java.io.PrintWriter;  
      
    import javax.servlet.RequestDispatcher;  
    import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;  
    import javax.servlet.http.HttpServletRequest;  
    import javax.servlet.http.HttpServletResponse;  
      
      @WebServlet("/LoginValidation")
    public class LoginValidation extends HttpServlet {  
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
      
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
              
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass");  
        String u=request.getParameter("user"); 
        //if(u=="Admin") {    
        if(LoginDao.validateAdmin(n,p)){  
            RequestDispatcher rd=request.getRequestDispatcher("eventregister.jsp");  
            rd.forward(request,response);  
        }  
          if(LoginDao.validateUser(n,p)){  
            RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
            rd.forward(request,response);  
        }  

        else{  
            out.print("Sorry username or password error");  
            RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
            rd.include(request,response);  
        }  
      //  }  
        out.close();  
        }  
    }  