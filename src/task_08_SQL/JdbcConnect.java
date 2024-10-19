package task_06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcConnect {
	
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/demo";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "12345";

    private static Connection connection;

    public static void main(String[] args) throws SQLException{
        try {
            Connection con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            
            String[] empname = {"Jenny","Jacky","Joe","John","Shameer"};
            int[] empage = {25,30,20,40,25};
            int[] esalary = {10000,20000,40000,80000,90000};
            int[] empcode = {101,102,103,104,105};
            
            String sql = "INSERT INTO employeeTable (empcode,empname,empage,esalary) VALUES (?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            
            for (int i = 0; i < empcode.length; i++) {
                preparedStatement.setInt(1, empcode[i]);
                preparedStatement.setString(2, empname[i]);
                preparedStatement.setInt(3, empage[i]);
                preparedStatement.setInt(4, esalary[i]);
                
                int rowsInserted = preparedStatement.executeUpdate();
                
                if (rowsInserted > 0) {
                    System.out.println("EmpCode "+empcode[i]+ " name " + empname[i]+ "'s record was inserted successfully!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

//output
//EmpCode 101 name Jenny's record was inserted successfully!
//EmpCode 102 name Jacky's record was inserted successfully!
//EmpCode 103 name Joe's record was inserted successfully!
//EmpCode 104 name John's record was inserted successfully!
//EmpCode 105 name Shameer's record was inserted successfully!