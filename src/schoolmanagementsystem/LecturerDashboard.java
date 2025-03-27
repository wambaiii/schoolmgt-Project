package schoolmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class LecturerDashboard {
    private JFrame frame;
    private JPanel panel;

    public LecturerDashboard() {
        frame = new JFrame("Lecturer Dashboard");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Title Label
        JLabel titleLabel = new JLabel("Lecturer Dashboard", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(153, 0, 51));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setPreferredSize(new Dimension(600, 50));

        // Panel for Buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));
        panel.setBackground(new Color(255, 230, 230));

        // Buttons
        JButton manageCourses = new JButton("Manage Courses");
        JButton manageEnrollments = new JButton("Manage Enrollments");
        JButton manageAttendance = new JButton("Manage Attendance");
        JButton viewAnalytics = new JButton("View Analytics");
        JButton logout = new JButton("Logout");

        // Button Styling
        JButton[] buttons = {manageCourses, manageEnrollments, manageAttendance, viewAnalytics, logout};
        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.setBackground(new Color(204, 0, 51));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            panel.add(button);
        }

        // Event Listeners for Buttons
        manageCourses.addActionListener(e -> new LecCourseMgt());
        manageEnrollments.addActionListener(e -> new LecEnrollMgt());
        manageAttendance.addActionListener(e -> new LecAttendanceMgt());
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
        new LecturerDashboard();
    }
}
