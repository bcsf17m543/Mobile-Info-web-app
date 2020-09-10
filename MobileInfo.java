import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class MobileInfo extends HttpServlet {

  //Process the HTTP Get request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    
    PrintWriter out = response.getWriter();

    //String u_name=request.getParameter("name");
    
    out.println("<html>");
    out.println("<head><title>Mobile Info</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/mobileinfo";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
    
     String query="Select * from mobileOutlet";
   
     ResultSet rs = st.executeQuery( query );
     out.println("<h3>Mobile Info</h3><br>");

     out.println("<table>");
     out.println("<tr>");
     out.println(" <th  style='width:30%; text-align=left;border:1px solid black'>CompanyName</th>");
     out.println("<th  style='width:30%; text-align=left;border:1px solid black'>Model</th>");
     out.println("<th  style='width:30%; text-align=left;border:1px solid black'>Price</th>");
    out.println("</tr>");
     
     while(rs.next()){ 

      String name = rs.getString("CompanyName");
      String model2 = rs.getString("Model");
      String price = rs.getString("price");

      out.println("<tr>");
      out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+name+"</td>");
      out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+model2+"</td>");
      out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+price+"</td>");      
      out.println("</tr>");

   }
   out.println("</table>");
out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
    out.println("<br><br><button onclick=window.location.href='http://localhost:8080/lab12/main.html'>Main Menu</button>");

  }

}