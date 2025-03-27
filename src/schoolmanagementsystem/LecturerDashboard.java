package schoolmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class LecturerDashboard {
    private JFrame frame;

    public LecturerDashboard() {
        frame = new JFrame("Lecturer Dashboard");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("src/resources/university.jpg.png"));
        background.setLayout(new BorderLayout());


        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setOpaque(false);

        JButton manageCourses = new JButton("Manage Courses");
        JButton enrollStudents = new JButton("Enroll Students");
        JButton markAttendance = new JButton("Mark Attendance");
        JButton viewAnalytics = new JButton("View Analytics");
        JButton viewStudents = new JButton("View Students");
        JButton logout = new JButton("Logout");

        manageCourses.setBackground(new Color(10, 153, 176));
        enrollStudents.setBackground(new Color(200, 200, 0));
        markAttendance.setBackground(new Color(255, 153, 51));
        viewAnalytics.setBackground(new Color(122, 51, 25));
        viewStudents.setBackground(new Color(200, 10, 102));
        logout.setBackground(Color.MAGENTA);

        manageCourses.setForeground(Color.WHITE);
        enrollStudents.setForeground(Color.WHITE);
        markAttendance.setForeground(Color.WHITE);
        viewAnalytics.setForeground(Color.WHITE);
        viewStudents.setForeground(Color.WHITE);
        logout.setForeground(Color.WHITE);

        panel.add(manageCourses);
        panel.add(enrollStudents);
        panel.add(markAttendance);
        panel.add(viewAnalytics);
        panel.add(viewStudents);
        panel.add(logout);

        background.add(panel, BorderLayout.CENTER);
        frame.add(background);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        logout.addActionListener(e -> {
            frame.dispose();
            new LoginGui();
        });
    }

    public static void main(String[] args) {
        new LecturerDashboard();
    }
}
