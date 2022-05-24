package webapp.actions;

import webapp.models.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;                
import java.sql.DriverManager;
// import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {

    ArrayList<User> users = new ArrayList<User>();

    public ArrayList<User> getUsers() {  
        return users;  
    }  
    public void setList(ArrayList<User> users) {  
        this.users = users;  
    }  

    public String execute() throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/struts2project?useTimezone=true&serverTimezone=UTC";
            String root = "root";
            String password = "password";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, root, password);
            if (connection != null) {
                String sql = "SELECT * FROM users";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    User user = new User();
                    user.setUsername(rs.getString(2));
                    user.setLastname(rs.getString(7));   
                    user.setFirstname(rs.getString(6)); 
                    user.setEmail(rs.getString(9));
                    user.setAge(rs.getInt(8)); 
                    users.add(user);  
                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return SUCCESS;
    }
    
}