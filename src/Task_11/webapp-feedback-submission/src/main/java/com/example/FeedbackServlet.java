package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet()
public class FeedbackServlet extends HttpServlet {

    // JDBC connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/feedback_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("name");
        String book = request.getParameter("book");
        String feedback = request.getParameter("feedback");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare SQL query
            String sql = "INSERT INTO feedback (name, book, feedback) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, book);
            stmt.setString(3, feedback);

            // Execute the query
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                // Redirect to the feedback saved page
                response.sendRedirect("feedbackSaved.jsp");
            } else {
                // Respond in case of failure
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error saving feedback.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error saving feedback.");
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
