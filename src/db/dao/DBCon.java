package db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
    PreparedStatement pstmt;
    Statement stmt;
    ResultSet rs;
    Connection conn;

    
    public Connection conn() throws SQLException{
        String driver = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "db";
        String pass = "1234";
        conn = DriverManager.getConnection(driver, user, pass);
        return conn;
    }

    public void closeDB(){
        try {
            if(conn!=null)conn.close();
            if(pstmt!=null)pstmt.close();
            if(stmt!=null)stmt.close();
            if(rs!=null)rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    


}
