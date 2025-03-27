package schoolmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class LecAttendanceMgt {
    public LecAttendanceMgt() {
        JFrame frame = new JFrame("Attendance Management");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Student Attendance", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(0, 153, 76));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setPreferredSize(new Dimension(400, 50));

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(204, 255, 204));

        JButton markAttendance = new JButton("Mark Attendance");
        JButton viewAttendance = new JButton("View Attendance");
        JButton studentAttendance = new JButton("Student Attendance Report");
        JButton goBack = new JButton("Go Back");

        for (JButton button : new JButton[]{markAttendance, viewAttendance, studentAttendance, goBack}) {
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setBackground(new Color(0, 102, 51));
            button.setForeground(Color.WHITE);
            panel.add(button);
        }

        goBack.addActionListener(e -> frame.dispose());

        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
