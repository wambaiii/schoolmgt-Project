package schoolmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class StudentDashboard {
    private JFrame frame;
    private int studentId;

    public StudentDashboard() {
        this.studentId = studentId;
        frame = new JFrame("Student Dashboard");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Student Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(130, 128, 185));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setPreferredSize(new Dimension(600, 60));

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(236, 240, 241));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton viewCourses = createStyledButton("View Courses");
        JButton checkAttendance = createStyledButton("Check Attendance");
        JButton viewProgress = createStyledButton("View Progress Report");
        JButton logout = createStyledButton("Logout");

        for (JButton button : new JButton[]{viewCourses, checkAttendance, viewProgress, logout}) {
            panel.add(button);
        }

        viewCourses.addActionListener(e -> showCourses());
        checkAttendance.addActionListener(e -> showAttendance());
        viewProgress.addActionListener(e -> showProgressReport());
        logout.addActionListener(e -> {
            frame.dispose();
            JOptionPane.showMessageDialog(null, "Logged Out Successfully!");
        });

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(80, 152, 29));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return button;
    }

    private void showCourses() {
        JFrame coursesFrame = new JFrame("Enrolled Courses");
        coursesFrame.setSize(500, 300);
        coursesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Course ID", "Course Name"}, 0);
        JTable table = new JTable(model);
        try (Connection con = JDBconnector.get_connection();
             PreparedStatement stmt = con.prepareStatement("SELECT course_id, course_name FROM courses WHERE student_id = ?")) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("course_id"), rs.getString("course_name")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching courses!");
            e.printStackTrace();
        }
        coursesFrame.add(new JScrollPane(table));
        coursesFrame.setLocationRelativeTo(null);
        coursesFrame.setVisible(true);
    }

    private void showAttendance() {
        JFrame attendanceFrame = new JFrame("Attendance");
        attendanceFrame.setSize(500, 300);
        attendanceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Course ID", "Attendance"}, 0);
        JTable table = new JTable(model);
        try (Connection con = JDBconnector.get_connection();
             PreparedStatement stmt = con.prepareStatement("SELECT course_id, attendance_count FROM attendance WHERE student_id = ?")) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("course_id"), rs.getInt("attendance_count")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching attendance!");
            e.printStackTrace();
        }
        attendanceFrame.add(new JScrollPane(table));
        attendanceFrame.setLocationRelativeTo(null);
        attendanceFrame.setVisible(true);
    }

    private void showProgressReport() {
        JFrame progressFrame = new JFrame("Progress Report");
        progressFrame.setSize(500, 300);
        progressFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel(new String[]{"Course ID", "Grade", "Marks"}, 0);
        JTable table = new JTable(model);
        try (Connection con = JDBconnector.get_connection();
             PreparedStatement stmt = con.prepareStatement("SELECT course_id, grade, marks FROM units WHERE student_id = ?")) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("course_id"), rs.getString("grade"), rs.getInt("marks")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching progress report!");
            e.printStackTrace();
        }
        progressFrame.add(new JScrollPane(table));
        progressFrame.setLocationRelativeTo(null);
        progressFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new StudentDashboard(); // Example student ID for testing
    }
}
