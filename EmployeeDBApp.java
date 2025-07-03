import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {
    static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root"; // replace with your MySQL username
    static final String PASS = "oppof19pro";     // replace with your MySQL password

    public static void main(String[] args) {
        try {
        // Register the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        System.out.println("MySQL JDBC Driver not found.");
        e.printStackTrace();
        return;
    }
        try (
            
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Scanner sc = new Scanner(System.in)
        ) {
            while (true) {
                System.out.println("\n1. Add Employee\n2. View Employees\n3. Update Employee\n4. Delete Employee\n5. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> addEmployee(conn, sc);
                    case 2 -> viewEmployees(conn);
                    case 3 -> updateEmployee(conn, sc);
                    case 4 -> deleteEmployee(conn, sc);
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter designation: ");
        String desig = sc.next();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employee (name, designation, salary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, desig);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("Employee added.");
        }
    }

    static void viewEmployees(Connection conn) throws SQLException {
        String sql = "SELECT * FROM employee";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("ID\tName\tDesignation\tSalary");
            while (rs.next()) {
                System.out.printf("%d\t%s\t%s\t%.2f\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("designation"),
                    rs.getDouble("salary")
                );
            }
        }
    }

    static void updateEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID of employee to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new name: ");
        String name = sc.next();
        System.out.print("Enter new designation: ");
        String desig = sc.next();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employee SET name=?, designation=?, salary=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, desig);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Employee updated." : "Employee not found.");
        }
    }

    static void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID of employee to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employee WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Employee deleted." : "Employee not found.");
        }
    }
}
