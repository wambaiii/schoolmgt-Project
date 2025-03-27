package schoolmanagementsystem;


import javax.swing.*;
import java.awt.*;

public class AdminDashboard {
    private JFrame frame;
    private JPanel panel;

    public AdminDashboard() {
        frame = new JFrame("Admin");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Admin", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(100, 102, 204));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setPreferredSize(new Dimension(600, 50));

        // Panel for Buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 10));
        panel.setBackground(new Color(230, 240, 255));

        // Buttons
        JButton manageStudents = new JButton("Students");
        JButton manageLecturers = new JButton("Lecturers");
        JButton manageCourses = new JButton("Courses");
        JButton manageFaculty = new JButton("Faculty");
        JButton manageUnits = new JButton("Units");
        JButton manageAttendance = new JButton("Attendance");
        JButton viewAnalytics = new JButton("Analytics");
        JButton logout = new JButton("Logout");

        // Button Styling
        JButton[] buttons = {manageStudents, manageLecturers, manageCourses, manageFaculty,
                manageUnits, manageAttendance, viewAnalytics, logout};
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBackground(new Color(50, 50, 200));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            panel.add(button);
        }

        // Event Listeners for Buttons
        manageStudents.addActionListener(e -> new StudentMgt());
        manageLecturers.addActionListener(e -> new LecturerMgt());
        manageCourses.addActionListener(e -> new CourseMgt());
        manageFaculty.addActionListener(e -> new FacultyMgt());
        manageUnits.addActionListener(e -> new UnitMgt());
        manageAttendance.addActionListener(e -> new AttendanceMgt());
        viewAnalytics.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Analytics Page (To be implemented)"));
        logout.addActionListener(e -> {
            frame.dispose();
            new LoginGui(); // Navigate back to login
        });

        // Adding Components to Frame
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new schoolmanagementsystem.AdminDashboard();
    }
}