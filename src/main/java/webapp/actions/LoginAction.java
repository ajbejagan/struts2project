package webapp.actions;

import webapp.models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

  static User user = new User();
  private User userBean;
  
  public String execute() throws Exception {
    userBean = getUserBean();
    if(validate(userBean.getUsername(), userBean.getPassword())){  
        setUserBean(user);
        return "success";  
    }  
    else{  
        return "error";  
    } 
  }

  public static boolean validate(String username, String password){

    boolean status = false;

    try{  
        Class.forName("com.mysql.jdbc.Driver");  
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root","password");  
        PreparedStatement ps = connection.prepareStatement(  
        "select * from users where username=? and password=?");  
        ps.setString(1,username);  
        ps.setString(2,password);  
        ResultSet rs = ps.executeQuery();  
        status=rs.next(); 
        user.setId(rs.getInt(1));
        user.setRole(rs.getString(4));
        user.setUsername(rs.getString(2));
        user.setLastname(rs.getString(7));   
        user.setFirstname(rs.getString(6)); 
        user.setEmail(rs.getString(9));
        user.setAge(rs.getInt(8)); 
    } catch (Exception e) { e.printStackTrace(); }
    
    return status;
  }

  public User getUserBean() {
      return userBean;
  }

  public void setUserBean(User userBean) {
      this.userBean = userBean;
  }

}
