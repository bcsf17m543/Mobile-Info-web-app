import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class SearchMobile extends HttpServlet {

  public String Query1(String abc)
  {
    String query="Select * from mobileOutlet where CompanyName='"+abc+"'";
    return query;
    
  }
  public String Query2(String abc)
  {
    String query="Select * from mobileOutlet where Model='"+abc+"'";
    return query;
  }
  public String Query3(String num)
  {
    String query="Select * from mobileOutlet where price='"+num+"'";
    return query;
  }
  public String Query4(String a,String b)
  {
    String query="Select * from mobileOutlet where CompanyName='"+a+"' and Model ='"+b+"' ";
    return query;
  }
  public String Query5(String a,String c)
  {
    String query="Select * from mobileOutlet where CompanyName='"+a+"' and price ='"+c+"' ";
    return query;
  }
  public String Query6(String a,String b,String c)
  {
    String query="Select * from mobileOutlet where CompanyName='"+a+"' and Model ='"+b+"' and price = '"+c+"' ";
    return query;
  }
  public String Query7(String b,String c)
  {
    String query="Select * from mobileOutlet where Model ='"+b+"' and price = '"+c+"' ";
    return query;
  }

  public String DecideQuery(String a,String b,String c)
  {
    if(b=="" && c =="")
    {
       return Query1(a);
    }
    else if(a=="" && c == "")
    {
      return Query2(b);
    }
    else if(a=="" && b=="")
    {
      return Query3(c);
    }
    else if(c=="")
    {
      return Query4(a,b);

    }
    else if(b=="")
    {
      return Query5(a,c);
    }
    else if(a=="")
    {
      return Query7(b,c);
    }
    else
    {
      return Query6(a,b,c);
    }
  }
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

    
    PrintWriter out = response.getWriter();

    String u_name=request.getParameter("CompanyName");
    String model=request.getParameter("Model");
    String price=request.getParameter("price");


    
    out.println("<html>");
    out.println("<head><title>Search Mobile</title></head>");
    out.println("<body bgcolor=\"#ffffff\">");


    try{
    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/mobileinfo";

    Connection con=DriverManager.getConnection(url,"root","root");

    Statement st=con.createStatement();
     if(u_name=="" && model =="" && price =="")
     {
       out.println("<h1>Please Enter a value<h1>");
       out.println("<button onclick=window.location.href='http://localhost:8080/lab12/search.html'>Search Mobile</button>");
     }
    //  else if(!Check_num(price))
    //  {
    //   out.println("<h1>Please Enter valid price e.g 12000<h1>");
    //   out.println("<button onclick=window.location.href='http://localhost:8080/lab12/search.html'>Search Mobile</button>"); 
    //  }
     else
     {
      String query=DecideQuery(u_name, model, price);
   
      ResultSet rs = st.executeQuery( query );
      if(rs.next())
     {
      out.println("<table>");
      out.println("<tr>");
      out.println(" <th  style='width:30%; text-align=left;border:1px solid black'>CompanyName</th>");
      out.println("<th  style='width:30%; text-align=left;border:1px solid black'>Model</th>");
      out.println("<th  style='width:30%; text-align=left;border:1px solid black'>Price</th>");
      out.println("</tr>");

    	    String name = rs.getString("CompanyName");
          String model2 = rs.getString("Model");
          String price2 = rs.getString("price");

    	    out.println("<tr>");
      out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+name+"</td>");
      out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+model2+"</td>");
      out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+price2+"</td>");      
      out.println("</tr>");
	  
  }
     else{
       out.println("<h1>Error ..! the desired record does not exsist </h1>");
       out.println("<button onclick=window.location.href='http://localhost:8080/lab12/search.html'>Search again</button>");

          }
          while(rs.next())
          {
            String name = rs.getString("CompanyName");
            String model2 = rs.getString("Model");
            String price2 = rs.getString("price");
  
            out.println("<tr>");
            out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+name+"</td>");
            out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+model2+"</td>");
            out.println("<td  style='width:30%; text-align=left;border:1px solid black'>"+price2+"</td>");      
            out.println("</tr>");

          }

        }
        out.println("</table>");
out.println("</body></html>");
           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }
    out.println("<button onclick=window.location.href='http://localhost:8080/lab12/main.html'>Main Menu</button>");

  }

}