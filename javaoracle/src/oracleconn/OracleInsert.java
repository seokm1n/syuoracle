package oracleconn;

import java.sql.*;

public class OracleInsert {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "c##syu";
        String password = "syu1234";

        try {
            Class.forName(driver);
            System.out.println("jdbc driver loading success.");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("oracle connection success.\n");
            Statement stmt = conn.createStatement();
            
            
            String sql1 = "SELECT MAX(deptno) FROM dept";
            ResultSet rs1 = stmt.executeQuery(sql1);
            rs1.next();
            int max = rs1.getInt("MAX(deptno)");
            
            
            String sdname = "IT", sloc = "SEOUL";
            String sql = "INSERT INTO dept VALUES ('" + (max+10) + "','" + sdname + "','" + sloc + "')";
            boolean b = stmt.execute(sql);
            if (!b) {
            	System.out.println("Insert success. \n");
            } else {
            	System.out.println("Insert fail. \n");
            }
            
            String sql2 = "SELECT deptno, dname, loc FROM dept ORDER BY deptno ASC";
            ResultSet rs = stmt.executeQuery(sql2);
            while (rs.next()) {
                System.out.print(rs.getString("deptno") + " ");
                System.out.print(rs.getString("dname") + " ");
                System.out.println(rs.getString("loc") + " ");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("jdbc driver loading fail.");
//            e.printStackTrace();
            
        } catch (SQLException e) {
            System.out.println("oracle connection fail.");
//            e.printStackTrace();
        }
    }
}
