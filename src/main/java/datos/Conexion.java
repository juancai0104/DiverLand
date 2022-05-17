/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Juan Esteban Caicedo
 */
public class Conexion
{
    private static final String JDBC_URL = "jdbc:mysql://localhost/afiliadosdiverland?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "admin";
    
    public static DataSource getDataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        
        ds.setUrl(JDBC_URL);
        ds.setUsername(JDBC_USER);
        ds.setPassword(JDBC_PASS);
        
        ds.setInitialSize(5);
        return ds;
    }
    
    public static Connection getConnection() throws SQLException
    {
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs)
    {
        try
        {
            rs.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt)
    {
        try
        {
            stmt.close();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn)
    {
        try
        {
            conn.close();
        }
        catch(SQLException ex)
        {
           ex.printStackTrace(System.out);
        }
    }
}
