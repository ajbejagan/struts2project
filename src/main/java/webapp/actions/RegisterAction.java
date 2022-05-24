package webapp.actions;

import webapp.models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    
    private User userBean;
    private String error = "Random";

    public String execute() throws Exception {

        userBean = getUserBean();

        if(saveToDB()) {
            return "success";
        } else {
            return "error";
        }

    }

    public boolean saveToDB() throws SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            String URL = "jdbc:mysql://localhost:3306/struts2project?useTimezone=true&serverTimezone=UTC";
            String root = "root";
            String password = "password";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, root, password);

            if(connection != null) {
                statement = connection.createStatement();
                String sql = "INSERT INTO users(first_name, last_name, email, age, username, password) " +
                    "VALUES('" + userBean.getFirstname() + "','" + userBean.getLastname() + "','" + userBean.getEmail() + "','" + userBean.getAge() + "','" + userBean.getUsername() + "','" + userBean.getPassword() + "')";
                statement.executeUpdate(sql);
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    public String getError() {
        return error;
    }
    
    public User getUserBean() {
        return userBean;
    }
    
    public void setUserBean(User user) {
        userBean = user;
    }

}
