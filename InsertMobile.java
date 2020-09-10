import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class InsertMobile extends HttpServlet {
 
  public boolean Check_num(String Num)
  {
    if (Num == null || Num.length()>8) {
      return false;
  }
  try {
      double d = Double.parseDouble(Num);
  } catch (NumberFormatException nfe) {
      return false;
  }
  return true;
}
  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    
	// get PrintWriter object
	PrintWriter out = response.getWriter();

    String CompanyName=request.getParameter("CompanyName");
    String Model=request.getParameter("Model");
    String price=request.getParameter("price");

    out.println("<html>");
    out.println("<head><title>InsertMobile</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/mobileinfo";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();
     
     if(Model !="" && CompanyName != "" && price!="" && Check_num(price))
     {
      String query = "INSERT INTO mobileOutlet(CompanyName,Model,price)VALUES('"+ CompanyName + "','" + Model+ "','" + price+ "') ";

      System.out.println(query);
      int rs = st.executeUpdate( query );
      if(rs==1){	out.println("<h1>Insertion successful</h1>"); 		}
   else{	out.println("<h1>Record could not be inserted.</h1>"); 		}
 
      out.println("</body></html>");
    
     }
     else
     {
      out.println("<h1>Record could not be inserted.</h1>"); 
      out.println("</body></html>");
     }
    
    

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
    out.println("<button onclick=window.location.href='http://localhost:8080/lab12/main.html'>Main Menu</button>");

  }

}
