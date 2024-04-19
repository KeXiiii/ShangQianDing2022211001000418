package com.ShangQianDing.week6;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author dabing
 */
@WebListener
public class JDBCServletContextListener implements ServletContextListener {//not a servlet 
    /**
     * @author dabing
     */
    public JDBCServletContextListener() {
    }

    /**
     *
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("i am in contextDestroyed()");
        ServletContext context = event.getServletContext();
        Connection con=(Connection) context.getAttribute("con");
        try {
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        context.removeAttribute("con");
    }

    /**
     *
     * @param event
     */
    public void contextInitialized(ServletContextEvent event) {//like main in java program 
        System.out.println("i am in contextInitialized()");
        ServletContext context = event.getServletContext();
        String driver = context.getInitParameter("driver");//set in web.xml and get it here ? its easy to change 
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("in contextInitialized()-->con --> " + con);
            context.setAttribute("con", con);//for all jsp and servlet 
        } catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

