package schoolmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard {
    private JFrame frame;

    public AdminDashboard() {
        frame = new JFrame("Admin Dashboard");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        JLabel background = new JLabel(new ImageIcon("src/resources/university.png"));
        background.setLayout(new BorderLayout());


        JPanel panel = new JPanel(new GridLayout(3, 2, 100, 100));
        panel.setOpaque(false);

        JButton addStudent = new JButton("Add Student");
        JButton addLecturer = new JButton("Add Lecturer");
        JButton viewReports = new JButton("View Progress Reports");
        JButton manageCourses = new JButton("Manage Courses");
        JButton viewFaculty = new JButton("View Faculty");
        JButton logout = new JButton("Logout");


        addStudent.setBackground(new Color(0, 102, 204));
        addLecturer.setBackground(new Color(0, 13, 76));
        viewReports.setBackground(new Color(204, 12, 0));
        manageCourses.setBackground(new Color(153, 51, 255));
        viewFaculty.setBackground(new Color(255, 102, 102));
        logout.setBackground(Color.PINK);

        addStudent.setForeground(Color.WHITE);
        addLecturer.setForeground(Color.WHITE);
        viewReports.setForeground(Color.WHITE);
        manageCourses.setForeground(Color.WHITE);
        viewFaculty.setForeground(Color.WHITE);
        logout.setForeground(Color.WHITE);


        panel.add(addStudent);
        panel.add(addLecturer);
        panel.add(viewReports);
        panel.add(manageCourses);
        panel.add(viewFaculty);
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
        new AdminDashboard();
    }
}

