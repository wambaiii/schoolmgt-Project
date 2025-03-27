package schoolmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class StudentDashboard {
    private JFrame frame;

    public StudentDashboard() {
        frame = new JFrame("Student Dashboard");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel background = new JLabel(new ImageIcon("src/resources/university.png"));
        background.setLayout(new BorderLayout());


        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); // Added 4th button for logout
        panel.setOpaque(false);

        JButton viewCourses = new JButton("View Courses");
        JButton checkAttendance = new JButton("Check Attendance");
        JButton viewProgress = new JButton("View Progress Report");
        JButton logout = new JButton("Logout"); // Logout Button

        viewCourses.setBackground(new Color(100, 2, 204));
        checkAttendance.setBackground(new Color(10, 13, 176));
        viewProgress.setBackground(new Color(240, 70, 90));
        logout.setBackground(Color.blue);

        viewCourses.setForeground(Color.WHITE);
        checkAttendance.setForeground(Color.WHITE);
        viewProgress.setForeground(Color.WHITE);
        logout.setForeground(Color.WHITE);

        panel.add(viewCourses);
        panel.add(checkAttendance);
        panel.add(viewProgress);
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
        new StudentDashboard();
    }
}
