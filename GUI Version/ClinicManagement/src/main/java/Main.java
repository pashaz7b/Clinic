import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Main {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel menuPanel;
    private JToggleButton toggleButton;

    public static void main(String[] args) {
        MyFile.readDoctors();
        MyFile.readPatient();
        MyFile.readVisit();
        MyFile.readPersonnels();
        MyFile.readNurse();
        MyFile.readDrugs();
        Main main = new Main();
        main.showMenu();
    }

    public void showMenu() {
        frame = new JFrame("Medical Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#212121"));
        mainPanel.setLayout(new BorderLayout());

        // Create a custom font for the title
        Font titleFont = new Font("Arial", Font.BOLD, 24);

        menuPanel = new JPanel();
        menuPanel.setBackground(Color.decode("#212121"));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("MENU");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton doctorsButton = new JButton("Doctors menu");
        JButton patientsButton = new JButton("Patients menu");
        JButton nursesButton = new JButton("Nurses menu");
        JButton personnelsButton = new JButton("Personnels menu");
        JButton visitsButton = new JButton("Visits menu");
        JButton drugsButton = new JButton("Drugs menu");
        JButton exitButton = new JButton("Exit");

        // Add a toggle button for light/dark mode
        toggleButton = new JToggleButton("Dark Mode");
        toggleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toggleButton.isSelected()) {
                    mainPanel.setBackground(Color.decode("#212121"));
                    titleLabel.setForeground(Color.WHITE);
                    menuPanel.setBackground(Color.decode("#212121"));
                    menuPanel.setForeground(Color.WHITE);
                    toggleButton.setForeground(Color.WHITE);
                } else {
                    mainPanel.setBackground(Color.WHITE);
                    titleLabel.setForeground(Color.BLACK);
                    menuPanel.setBackground(Color.WHITE);
                    menuPanel.setForeground(Color.BLACK);
                    toggleButton.setForeground(Color.BLACK);
                }
            }
        });

        doctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoctorsMenu();
            }
        });

        patientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientsMenu();
            }
        });

        nursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NursesMenu();
            }
        });

        personnelsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PersonnelsMenu();
            }
        });

        visitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisitsMenu();
            }
        });

        drugsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DrugsMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuPanel.add(Box.createVerticalStrut(20));
        menuPanel.add(titleLabel);
        menuPanel.add(Box.createVerticalStrut(30));
        menuPanel.add(doctorsButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(patientsButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(nursesButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(personnelsButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(visitsButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(drugsButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(exitButton);

        mainPanel.add(menuPanel, BorderLayout.CENTER);

        // Add the toggle button to the top-right corner of the window
        JPanel togglePanel = new JPanel();
        togglePanel.setBackground(Color.decode("#212121"));
        togglePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        togglePanel.add(toggleButton);
        mainPanel.add(togglePanel, BorderLayout.NORTH);

        frame.setContentPane(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void DoctorsMenu() {
        JFrame doctorsFrame = new JFrame("Doctor's Menu");
        doctorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        doctorsFrame.setSize(600, 400);
        doctorsFrame.setLocationRelativeTo(null);

        JPanel doctorsPanel = new JPanel();
        doctorsPanel.setBackground(Color.black);
        doctorsPanel.setLayout(new BoxLayout(doctorsPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Doctor's Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        doctorsPanel.add(titleLabel);
        doctorsPanel.add(Box.createVerticalStrut(10));

        JButton addDoctorButton = new JButton("Add Doctor");
        JButton removeDoctorButton = new JButton("Remove Doctor");
        JButton viewDoctorsButton = new JButton("View Doctors");
        JButton backButton = new JButton("Back to Main");
        JButton exitButton = new JButton("Exit");

        addDoctorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeDoctorButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewDoctorsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctor();
            }
        });

        removeDoctorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeDoctor();
            }
        });

        viewDoctorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDoctors();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doctorsFrame.dispose();
                showMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        doctorsPanel.add(addDoctorButton);
        doctorsPanel.add(Box.createVerticalStrut(10));
        doctorsPanel.add(removeDoctorButton);
        doctorsPanel.add(Box.createVerticalStrut(10));
        doctorsPanel.add(viewDoctorsButton);
        doctorsPanel.add(Box.createVerticalStrut(10));
        doctorsPanel.add(backButton);
        doctorsPanel.add(Box.createVerticalStrut(10));
        doctorsPanel.add(exitButton);

        doctorsFrame.setContentPane(doctorsPanel);
        doctorsFrame.setVisible(true);
    }

    public void addDoctor() {
        JFrame addDoctorFrame = new JFrame("Add Doctor");
        addDoctorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDoctorFrame.setSize(600, 400);
        addDoctorFrame.setLocationRelativeTo(null);

        JPanel addDoctorPanel = new JPanel();
        addDoctorPanel.setBackground(Color.BLACK);
        addDoctorPanel.setLayout(new BoxLayout(addDoctorPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Add Doctor");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        addDoctorPanel.add(titleLabel);
        addDoctorPanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField specializationField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        specializationField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        specializationField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        specializationField.setCaretColor(Color.WHITE);

        // Set the background color of the text fields to light gray
        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        specializationField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Specialization:"));
        inputPanel.add(specializationField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addDoctorPanel.add(inputPanel);

        addDoctorPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.GREEN);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctorFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addDoctorPanel.add(buttonPanel);

        JButton addButton = new JButton("Add Doctor");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String specialization = specializationField.getText();

                    Doctor doctor = new Doctor(fullName, address, phoneNumber, nationalCode, specialization);
                    doctor.save();
                    JOptionPane.showMessageDialog(addDoctorFrame, "Doctor added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addDoctorFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addDoctorPanel.add(addButton);

        addDoctorFrame.setContentPane(addDoctorPanel);
        addDoctorFrame.setVisible(true);
    }

    public static void removeDoctor() {
        JFrame addDoctorFrame = new JFrame("Remove Doctor");
        addDoctorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDoctorFrame.setSize(600, 400);
        addDoctorFrame.setLocationRelativeTo(null);

        JPanel addDoctorPanel = new JPanel();
        addDoctorPanel.setBackground(Color.BLACK);
        addDoctorPanel.setLayout(new BoxLayout(addDoctorPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Remove Doctor");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.RED);
        addDoctorPanel.add(titleLabel);
        addDoctorPanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField specializationField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        specializationField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        specializationField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        specializationField.setCaretColor(Color.WHITE);

        // Set the background color of the text fields to light gray
        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        specializationField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Specialization:"));
        inputPanel.add(specializationField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addDoctorPanel.add(inputPanel);

        addDoctorPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.RED);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctorFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addDoctorPanel.add(buttonPanel);

        JButton addButton = new JButton("Remove Doctor");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.RED);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String specialization = specializationField.getText();

                    Doctor doctor = new Doctor(fullName, address, phoneNumber, nationalCode, specialization);
                    MyFile.search(doctor);
                    JOptionPane.showMessageDialog(addDoctorFrame, "Doctor removed successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addDoctorFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addDoctorPanel.add(addButton);

        addDoctorFrame.setContentPane(addDoctorPanel);
        addDoctorFrame.setVisible(true);
    }

    public static void viewDoctors() {
        JFrame viewDoctorsFrame = new JFrame("View Doctors");
        viewDoctorsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewDoctorsFrame.setSize(600, 400);
        viewDoctorsFrame.setLocationRelativeTo(null);

        JPanel viewDoctorsPanel = new JPanel();
        viewDoctorsPanel.setBackground(Color.BLACK);
        viewDoctorsPanel.setLayout(new BoxLayout(viewDoctorsPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("View Doctors");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        viewDoctorsPanel.add(titleLabel);
        viewDoctorsPanel.add(Box.createVerticalStrut(10));

        JTextArea doctorsTextArea = new JTextArea(20, 40);
        doctorsTextArea.setEditable(false);
        doctorsTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        doctorsTextArea.setForeground(Color.WHITE);
        doctorsTextArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(doctorsTextArea);

        viewDoctorsPanel.add(scrollPane);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDoctorsFrame.dispose();
            }
        });

        viewDoctorsPanel.add(closeButton);

        viewDoctorsFrame.setContentPane(viewDoctorsPanel);
        viewDoctorsFrame.setVisible(true);

        // Get the list of doctors from MyFile.doctors
        ArrayList<Doctor> doctorsList = MyFile.doctors;

        // Display the list of doctors in the text area
        for (Doctor doctor : doctorsList) {
            doctorsTextArea.append(doctor.toString() + "\n");
        }
    }

    public void PatientsMenu() {
        JFrame patientsFrame = new JFrame("Patient's Menu");
        patientsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        patientsFrame.setSize(600, 400);
        patientsFrame.setLocationRelativeTo(null);

        JPanel patientsPanel = new JPanel();
        patientsPanel.setBackground(Color.black);
        patientsPanel.setLayout(new BoxLayout(patientsPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Patient's Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        patientsPanel.add(titleLabel);
        patientsPanel.add(Box.createVerticalStrut(10));

        JButton addPatientButton = new JButton("Add Patient");
        JButton removePatientButton = new JButton("Remove Patient");
        JButton viewPatientsButton = new JButton("View Patients");
        JButton backButton = new JButton("Back to Main");
        JButton exitButton = new JButton("Exit");

        addPatientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removePatientButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewPatientsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addPatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatient();
            }
        });

        removePatientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePatient();
            }
        });

        viewPatientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatients();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientsFrame.dispose();
                showMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        patientsPanel.add(addPatientButton);
        patientsPanel.add(Box.createVerticalStrut(10));
        patientsPanel.add(removePatientButton);
        patientsPanel.add(Box.createVerticalStrut(10));
        patientsPanel.add(viewPatientsButton);
        patientsPanel.add(Box.createVerticalStrut(10));
        patientsPanel.add(backButton);
        patientsPanel.add(Box.createVerticalStrut(10));
        patientsPanel.add(exitButton);

        patientsFrame.setContentPane(patientsPanel);
        patientsFrame.setVisible(true);
    }

    public void addPatient() {
        JFrame addPatientFrame = new JFrame("Add Patient");
        addPatientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPatientFrame.setSize(600, 400);
        addPatientFrame.setLocationRelativeTo(null);

        JPanel addPatientPanel = new JPanel();
        addPatientPanel.setBackground(Color.BLACK);
        addPatientPanel.setLayout(new BoxLayout(addPatientPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Add Patient");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        addPatientPanel.add(titleLabel);
        addPatientPanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        diseaseField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        diseaseField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        diseaseField.setCaretColor(Color.WHITE);

        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        diseaseField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Disease:"));
        inputPanel.add(diseaseField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addPatientPanel.add(inputPanel);

        addPatientPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.GREEN);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatientFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addPatientPanel.add(buttonPanel);

        JButton addButton = new JButton("Add Patient");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String disease = diseaseField.getText();

                    Patient patient = new Patient(fullName, address, phoneNumber, nationalCode, disease);
                    patient.save();
                    JOptionPane.showMessageDialog(addPatientFrame, "Patient added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addPatientFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addPatientPanel.add(addButton);

        addPatientFrame.setContentPane(addPatientPanel);
        addPatientFrame.setVisible(true);
    }

    public void removePatient() {
        JFrame addPatientFrame = new JFrame("Remove Patient");
        addPatientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPatientFrame.setSize(600, 400);
        addPatientFrame.setLocationRelativeTo(null);

        JPanel addPatientPanel = new JPanel();
        addPatientPanel.setBackground(Color.BLACK);
        addPatientPanel.setLayout(new BoxLayout(addPatientPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Remove Patient");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.RED);
        addPatientPanel.add(titleLabel);
        addPatientPanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        diseaseField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        diseaseField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        diseaseField.setCaretColor(Color.WHITE);

        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        diseaseField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Disease:"));
        inputPanel.add(diseaseField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addPatientPanel.add(inputPanel);

        addPatientPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.RED);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPatientFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addPatientPanel.add(buttonPanel);

        JButton addButton = new JButton("Remove Patient");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.RED);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String disease = diseaseField.getText();

                    Patient patient = new Patient(fullName, address, phoneNumber, nationalCode, disease);
                    MyFile.search(patient);
                    JOptionPane.showMessageDialog(addPatientFrame, "Patient removed successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addPatientFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addPatientPanel.add(addButton);

        addPatientFrame.setContentPane(addPatientPanel);
        addPatientFrame.setVisible(true);
    }

    public static void viewPatients() {
        JFrame viewPatientsFrame = new JFrame("View Patients");
        viewPatientsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewPatientsFrame.setSize(600, 400);
        viewPatientsFrame.setLocationRelativeTo(null);

        JPanel viewPatientsPanel = new JPanel();
        viewPatientsPanel.setBackground(Color.BLACK);
        viewPatientsPanel.setLayout(new BoxLayout(viewPatientsPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("View Patients");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        viewPatientsPanel.add(titleLabel);
        viewPatientsPanel.add(Box.createVerticalStrut(10));

        JTextArea patientsTextArea = new JTextArea(20, 40);
        patientsTextArea.setEditable(false);
        patientsTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        patientsTextArea.setForeground(Color.WHITE);
        patientsTextArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(patientsTextArea);

        viewPatientsPanel.add(scrollPane);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPatientsFrame.dispose();
            }
        });

        viewPatientsPanel.add(closeButton);

        viewPatientsFrame.setContentPane(viewPatientsPanel);
        viewPatientsFrame.setVisible(true);

        // Get the list of patients from MyFile.patients
        ArrayList<Patient> patientsList = MyFile.patients;

        // Display the list of patients in the text area
        for (Patient patient : patientsList) {
            patientsTextArea.append(patient.toString() + "\n");
        }
    }

    public void NursesMenu() {
        JFrame nursesFrame = new JFrame("Nurse's Menu");
        nursesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nursesFrame.setSize(600, 400);
        nursesFrame.setLocationRelativeTo(null);

        JPanel nursesPanel = new JPanel();
        nursesPanel.setBackground(Color.black);
        nursesPanel.setLayout(new BoxLayout(nursesPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Nurse's Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        nursesPanel.add(titleLabel);
        nursesPanel.add(Box.createVerticalStrut(10));

        JButton addNurseButton = new JButton("Add Nurse");
        JButton removeNurseButton = new JButton("Remove Nurse");
        JButton viewNursesButton = new JButton("View Nurses");
        JButton backButton = new JButton("Back to Main");
        JButton exitButton = new JButton("Exit");

        addNurseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeNurseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewNursesButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addNurseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNurse();
            }
        });

        removeNurseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeNurse();
            }
        });

        viewNursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewNurses();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nursesFrame.dispose();
                showMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        nursesPanel.add(addNurseButton);
        nursesPanel.add(Box.createVerticalStrut(10));
        nursesPanel.add(removeNurseButton);
        nursesPanel.add(Box.createVerticalStrut(10));
        nursesPanel.add(viewNursesButton);
        nursesPanel.add(Box.createVerticalStrut(10));
        nursesPanel.add(backButton);
        nursesPanel.add(Box.createVerticalStrut(10));
        nursesPanel.add(exitButton);

        nursesFrame.setContentPane(nursesPanel);
        nursesFrame.setVisible(true);
    }

    public void addNurse() {
        JFrame addNurseFrame = new JFrame("Add Nurse");
        addNurseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addNurseFrame.setSize(600, 400);
        addNurseFrame.setLocationRelativeTo(null);

        JPanel addNursePanel = new JPanel();
        addNursePanel.setBackground(Color.BLACK);
        addNursePanel.setLayout(new BoxLayout(addNursePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Add Nurse");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        addNursePanel.add(titleLabel);
        addNursePanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField responsibilitiesField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        responsibilitiesField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        responsibilitiesField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        responsibilitiesField.setCaretColor(Color.WHITE);

        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        responsibilitiesField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(responsibilitiesField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addNursePanel.add(inputPanel);

        addNursePanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.GREEN);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNurseFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addNursePanel.add(buttonPanel);

        JButton addButton = new JButton("Add Nurse");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String responsibilities = responsibilitiesField.getText();

                    Nurse nurse = new Nurse(fullName, address, phoneNumber, nationalCode, responsibilities);
                    nurse.save();
                    JOptionPane.showMessageDialog(addNurseFrame, "Nurse added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addNurseFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addNursePanel.add(addButton);

        addNurseFrame.setContentPane(addNursePanel);
        addNurseFrame.setVisible(true);
    }

    public void removeNurse() {
        JFrame addNurseFrame = new JFrame("Remove Nurse");
        addNurseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addNurseFrame.setSize(600, 400);
        addNurseFrame.setLocationRelativeTo(null);

        JPanel addNursePanel = new JPanel();
        addNursePanel.setBackground(Color.BLACK);
        addNursePanel.setLayout(new BoxLayout(addNursePanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Remove Nurse");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.RED);
        addNursePanel.add(titleLabel);
        addNursePanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField responsibilitiesField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        responsibilitiesField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        responsibilitiesField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        responsibilitiesField.setCaretColor(Color.WHITE);

        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        responsibilitiesField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(responsibilitiesField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addNursePanel.add(inputPanel);

        addNursePanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.RED);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNurseFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addNursePanel.add(buttonPanel);

        JButton addButton = new JButton("Remove Nurse");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.RED);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String responsibilities = responsibilitiesField.getText();

                    Nurse nurse = new Nurse(fullName, address, phoneNumber, nationalCode, responsibilities);
                    MyFile.search(nurse);
                    JOptionPane.showMessageDialog(addNurseFrame, "Nurse removed successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addNurseFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addNursePanel.add(addButton);

        addNurseFrame.setContentPane(addNursePanel);
        addNurseFrame.setVisible(true);
    }

    public void viewNurses() {
        JFrame viewNursesFrame = new JFrame("View Nurses");
        viewNursesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewNursesFrame.setSize(600, 400);
        viewNursesFrame.setLocationRelativeTo(null);

        JPanel viewNursesPanel = new JPanel();
        viewNursesPanel.setBackground(Color.BLACK);
        viewNursesPanel.setLayout(new BoxLayout(viewNursesPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("View Nurses");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        viewNursesPanel.add(titleLabel);
        viewNursesPanel.add(Box.createVerticalStrut(10));

        JTextArea nursesTextArea = new JTextArea(20, 40);
        nursesTextArea.setEditable(false);
        nursesTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        nursesTextArea.setForeground(Color.WHITE);
        nursesTextArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(nursesTextArea);

        viewNursesPanel.add(scrollPane);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewNursesFrame.dispose();
            }
        });

        viewNursesPanel.add(closeButton);

        viewNursesFrame.setContentPane(viewNursesPanel);
        viewNursesFrame.setVisible(true);

        // Get the list of nurses from MyFile.nurses
        ArrayList<Nurse> nursesList = MyFile.nurses;

        // Display the list of nurses in the text area
        for (Nurse nurse : nursesList) {
            nursesTextArea.append(nurse.toString() + "\n");
        }
    }

    public void PersonnelsMenu() {
        JFrame personnelFrame = new JFrame("Personnel Menu");
        personnelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        personnelFrame.setSize(600, 400);
        personnelFrame.setLocationRelativeTo(null);

        JPanel personnelPanel = new JPanel();
        personnelPanel.setBackground(Color.black);
        personnelPanel.setLayout(new BoxLayout(personnelPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Personnel Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        personnelPanel.add(titleLabel);
        personnelPanel.add(Box.createVerticalStrut(10));

        JButton addPersonnelButton = new JButton("Add Personnel");
        JButton removePersonnelButton = new JButton("Remove Personnel");
        JButton viewPersonnelButton = new JButton("View Personnel");
        JButton backButton = new JButton("Back to Main");
        JButton exitButton = new JButton("Exit");

        addPersonnelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removePersonnelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewPersonnelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addPersonnelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonnel();
            }
        });

        removePersonnelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePersonnel();
            }
        });

        viewPersonnelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPersonnel();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personnelFrame.dispose();
                showMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        personnelPanel.add(addPersonnelButton);
        personnelPanel.add(Box.createVerticalStrut(10));
        personnelPanel.add(removePersonnelButton);
        personnelPanel.add(Box.createVerticalStrut(10));
        personnelPanel.add(viewPersonnelButton);
        personnelPanel.add(Box.createVerticalStrut(10));
        personnelPanel.add(backButton);
        personnelPanel.add(Box.createVerticalStrut(10));
        personnelPanel.add(exitButton);

        personnelFrame.setContentPane(personnelPanel);
        personnelFrame.setVisible(true);
    }

    public void addPersonnel() {
        JFrame addPersonnelFrame = new JFrame("Add Personnel");
        addPersonnelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addPersonnelFrame.setSize(600, 400);
        addPersonnelFrame.setLocationRelativeTo(null);

        JPanel addPersonnelPanel = new JPanel();
        addPersonnelPanel.setBackground(Color.BLACK);
        addPersonnelPanel.setLayout(new BoxLayout(addPersonnelPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Add Personnel");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        addPersonnelPanel.add(titleLabel);
        addPersonnelPanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField responsibilitiesField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        responsibilitiesField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        responsibilitiesField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        responsibilitiesField.setCaretColor(Color.WHITE);

        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        responsibilitiesField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(responsibilitiesField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addPersonnelPanel.add(inputPanel);

        addPersonnelPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.GREEN);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPersonnelFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addPersonnelPanel.add(buttonPanel);

        JButton addButton = new JButton("Add Personnel");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String responsibilities = responsibilitiesField.getText();

                    Personnel personnel = new Personnel(fullName, address, phoneNumber, nationalCode, responsibilities);
                    personnel.save(); // Assuming you have a save method to save personnel details
                    JOptionPane.showMessageDialog(addPersonnelFrame, "Personnel added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addPersonnelFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addPersonnelPanel.add(addButton);

        addPersonnelFrame.setContentPane(addPersonnelPanel);
        addPersonnelFrame.setVisible(true);
    }

    public void removePersonnel() {
        JFrame removePersonnelFrame = new JFrame("Remove Personnel");
        removePersonnelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removePersonnelFrame.setSize(600, 400);
        removePersonnelFrame.setLocationRelativeTo(null);

        JPanel removePersonnelPanel = new JPanel();
        removePersonnelPanel.setBackground(Color.BLACK);
        removePersonnelPanel.setLayout(new BoxLayout(removePersonnelPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Remove Personnel");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.RED);
        removePersonnelPanel.add(titleLabel);
        removePersonnelPanel.add(Box.createVerticalStrut(10));

        JTextField fullNameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(20);
        JTextField nationalCodeField = new JTextField(20);
        JTextField responsibilitiesField = new JTextField(20);

        fullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        addressField.setFont(new Font("Arial", Font.PLAIN, 18));
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        nationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        responsibilitiesField.setFont(new Font("Arial", Font.PLAIN, 18));

        fullNameField.setForeground(Color.WHITE);
        addressField.setForeground(Color.WHITE);
        phoneNumberField.setForeground(Color.WHITE);
        nationalCodeField.setForeground(Color.WHITE);
        responsibilitiesField.setForeground(Color.WHITE);

        fullNameField.setCaretColor(Color.WHITE);
        addressField.setCaretColor(Color.WHITE);
        phoneNumberField.setCaretColor(Color.WHITE);
        nationalCodeField.setCaretColor(Color.WHITE);
        responsibilitiesField.setCaretColor(Color.WHITE);

        fullNameField.setBackground(Color.BLACK);
        addressField.setBackground(Color.BLACK);
        phoneNumberField.setBackground(Color.BLACK);
        nationalCodeField.setBackground(Color.BLACK);
        responsibilitiesField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Full Name:"));
        inputPanel.add(fullNameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel("National Code:"));
        inputPanel.add(nationalCodeField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(responsibilitiesField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        removePersonnelPanel.add(inputPanel);

        removePersonnelPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.RED);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removePersonnelFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        removePersonnelPanel.add(buttonPanel);

        JButton removeButton = new JButton("Remove Personnel");
        removeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeButton.setForeground(Color.RED);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String fullName = fullNameField.getText();
                    String address = addressField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    int nationalCode = Integer.parseInt(nationalCodeField.getText());
                    String responsibilities = responsibilitiesField.getText();

                    Personnel personnel = new Personnel(fullName, address, phoneNumber, nationalCode, responsibilities);

                    MyFile.search(personnel);

                    JOptionPane.showMessageDialog(removePersonnelFrame, "Personnel removed successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(removePersonnelFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeButton.setFont(new Font("Arial", Font.PLAIN, 18));

        removePersonnelPanel.add(removeButton);

        removePersonnelFrame.setContentPane(removePersonnelPanel);
        removePersonnelFrame.setVisible(true);
    }

    public void viewPersonnel() {
        JFrame viewPersonnelFrame = new JFrame("View Personnel");
        viewPersonnelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewPersonnelFrame.setSize(600, 400);
        viewPersonnelFrame.setLocationRelativeTo(null);

        JPanel viewPersonnelPanel = new JPanel();
        viewPersonnelPanel.setBackground(Color.BLACK);
        viewPersonnelPanel.setLayout(new BoxLayout(viewPersonnelPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("View Personnel");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        viewPersonnelPanel.add(titleLabel);
        viewPersonnelPanel.add(Box.createVerticalStrut(10));

        JTextArea personnelTextArea = new JTextArea(20, 40);
        personnelTextArea.setEditable(false);
        personnelTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        personnelTextArea.setForeground(Color.WHITE);
        personnelTextArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(personnelTextArea);

        viewPersonnelPanel.add(scrollPane);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewPersonnelFrame.dispose();
            }
        });

        viewPersonnelPanel.add(closeButton);

        viewPersonnelFrame.setContentPane(viewPersonnelPanel);
        viewPersonnelFrame.setVisible(true);

        // Get the list of personnel from MyFile.personnel
        ArrayList<Personnel> personnelList = MyFile.personnels;

        // Display the list of personnel in the text area
        for (Personnel personnel : personnelList) {
            personnelTextArea.append(personnel.toString() + "\n");
        }
    }

    public void VisitsMenu() {
        JFrame visitsFrame = new JFrame("Visits Menu");
        visitsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        visitsFrame.setSize(600, 400);
        visitsFrame.setLocationRelativeTo(null);

        JPanel visitsPanel = new JPanel();
        visitsPanel.setBackground(Color.BLACK);
        visitsPanel.setLayout(new BoxLayout(visitsPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Visits Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        visitsPanel.add(titleLabel);
        visitsPanel.add(Box.createVerticalStrut(10));

        JButton addVisitButton = new JButton("Add Visit");
        JButton removeVisitButton = new JButton("Remove Visit");
        JButton viewVisitsButton = new JButton("View Visits");
        JButton backButton = new JButton("Back to Main");
        JButton exitButton = new JButton("Exit");

        addVisitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeVisitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewVisitsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addVisitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVisit();
            }
        });

        removeVisitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeVisit();
            }
        });

        viewVisitsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewVisit();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitsFrame.dispose();
                showMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        visitsPanel.add(addVisitButton);
        visitsPanel.add(Box.createVerticalStrut(10));
        visitsPanel.add(removeVisitButton);
        visitsPanel.add(Box.createVerticalStrut(10));
        visitsPanel.add(viewVisitsButton);
        visitsPanel.add(Box.createVerticalStrut(10));
        visitsPanel.add(backButton);
        visitsPanel.add(Box.createVerticalStrut(10));
        visitsPanel.add(exitButton);

        visitsFrame.setContentPane(visitsPanel);
        visitsFrame.setVisible(true);
    }

    public void addVisit() {
        JFrame addVisitFrame = new JFrame("Add Visit");
        addVisitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addVisitFrame.setSize(600, 500);
        addVisitFrame.setLocationRelativeTo(null);

        JPanel addVisitPanel = new JPanel();
        addVisitPanel.setBackground(Color.BLACK);
        addVisitPanel.setLayout(new BoxLayout(addVisitPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Add Visit");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        addVisitPanel.add(titleLabel);
        addVisitPanel.add(Box.createVerticalStrut(10));

        JTextField doctorFullNameField = new JTextField(20);
        JTextField doctorAddressField = new JTextField(20);
        JTextField doctorPhoneNumberField = new JTextField(20);
        JTextField doctorNationalCodeField = new JTextField(20);
        JTextField doctorSpecialityField = new JTextField(20);
        JTextField prescriptionField = new JTextField(20);

        doctorFullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorAddressField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorPhoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorNationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorSpecialityField.setFont(new Font("Arial", Font.PLAIN, 18));
        prescriptionField.setFont(new Font("Arial", Font.PLAIN, 18));

        doctorFullNameField.setForeground(Color.WHITE);
        doctorAddressField.setForeground(Color.WHITE);
        doctorPhoneNumberField.setForeground(Color.WHITE);
        doctorNationalCodeField.setForeground(Color.WHITE);
        doctorSpecialityField.setForeground(Color.WHITE);
        prescriptionField.setForeground(Color.WHITE);

        doctorFullNameField.setCaretColor(Color.WHITE);
        doctorAddressField.setCaretColor(Color.WHITE);
        doctorPhoneNumberField.setCaretColor(Color.WHITE);
        doctorNationalCodeField.setCaretColor(Color.WHITE);
        doctorSpecialityField.setCaretColor(Color.WHITE);
        prescriptionField.setCaretColor(Color.WHITE);

        doctorFullNameField.setBackground(Color.BLACK);
        doctorAddressField.setBackground(Color.BLACK);
        doctorPhoneNumberField.setBackground(Color.BLACK);
        doctorNationalCodeField.setBackground(Color.BLACK);
        doctorSpecialityField.setBackground(Color.BLACK);
        prescriptionField.setBackground(Color.BLACK);

        JPanel doctorInputPanel = new JPanel();
        doctorInputPanel.setLayout(new GridLayout(6, 2));
        doctorInputPanel.setBackground(Color.BLACK);
        doctorInputPanel.setForeground(Color.WHITE);
        doctorInputPanel.add(new JLabel("Doctor's Full Name:"));
        doctorInputPanel.add(doctorFullNameField);
        doctorInputPanel.add(new JLabel("Doctor's Address:"));
        doctorInputPanel.add(doctorAddressField);
        doctorInputPanel.add(new JLabel("Doctor's Phone Number:"));
        doctorInputPanel.add(doctorPhoneNumberField);
        doctorInputPanel.add(new JLabel("Doctor's National Code:"));
        doctorInputPanel.add(doctorNationalCodeField);
        doctorInputPanel.add(new JLabel("Doctor's Speciality:"));
        doctorInputPanel.add(doctorSpecialityField);
        doctorInputPanel.add(new JLabel("Prescription:"));
        doctorInputPanel.add(prescriptionField);

        for (Component c : doctorInputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addVisitPanel.add(doctorInputPanel);

        addVisitPanel.add(Box.createVerticalStrut(20));

        JTextField patientFullNameField = new JTextField(20);
        JTextField patientAddressField = new JTextField(20);
        JTextField patientPhoneNumberField = new JTextField(20);
        JTextField patientNationalCodeField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);

        patientFullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        patientAddressField.setFont(new Font("Arial", Font.PLAIN, 18));
        patientPhoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        patientNationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        diseaseField.setFont(new Font("Arial", Font.PLAIN, 18));

        patientFullNameField.setForeground(Color.WHITE);
        patientAddressField.setForeground(Color.WHITE);
        patientPhoneNumberField.setForeground(Color.WHITE);
        patientNationalCodeField.setForeground(Color.WHITE);
        diseaseField.setForeground(Color.WHITE);

        patientFullNameField.setCaretColor(Color.WHITE);
        patientAddressField.setCaretColor(Color.WHITE);
        patientPhoneNumberField.setCaretColor(Color.WHITE);
        patientNationalCodeField.setCaretColor(Color.WHITE);
        diseaseField.setCaretColor(Color.WHITE);

        patientFullNameField.setBackground(Color.BLACK);
        patientAddressField.setBackground(Color.BLACK);
        patientPhoneNumberField.setBackground(Color.BLACK);
        patientNationalCodeField.setBackground(Color.BLACK);
        diseaseField.setBackground(Color.BLACK);

        JPanel patientInputPanel = new JPanel();
        patientInputPanel.setLayout(new GridLayout(5, 2));
        patientInputPanel.setBackground(Color.BLACK);
        patientInputPanel.setForeground(Color.WHITE);
        patientInputPanel.add(new JLabel("Patient's Full Name:"));
        patientInputPanel.add(patientFullNameField);
        patientInputPanel.add(new JLabel("Patient's Address:"));
        patientInputPanel.add(patientAddressField);
        patientInputPanel.add(new JLabel("Patient's Phone Number:"));
        patientInputPanel.add(patientPhoneNumberField);
        patientInputPanel.add(new JLabel("Patient's National Code:"));
        patientInputPanel.add(patientNationalCodeField);
        patientInputPanel.add(new JLabel("Disease:"));
        patientInputPanel.add(diseaseField);

        for (Component c : patientInputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addVisitPanel.add(patientInputPanel);

        addVisitPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.GREEN);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVisitFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addVisitPanel.add(buttonPanel);

        JButton addButton = new JButton("Add Visit");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String doctorFullName = doctorFullNameField.getText();
                    String doctorAddress = doctorAddressField.getText();
                    String doctorPhoneNumber = doctorPhoneNumberField.getText();
                    int doctorNationalCode = Integer.parseInt(doctorNationalCodeField.getText());
                    String doctorSpeciality = doctorSpecialityField.getText();
                    String prescription = prescriptionField.getText();

                    Doctor doctor = new Doctor(doctorFullName, doctorAddress, doctorPhoneNumber, doctorNationalCode, doctorSpeciality);

                    String patientFullName = patientFullNameField.getText();
                    String patientAddress = patientAddressField.getText();
                    String patientPhoneNumber = patientPhoneNumberField.getText();
                    int patientNationalCode = Integer.parseInt(patientNationalCodeField.getText());
                    String disease = diseaseField.getText();

                    Patient patient = new Patient(patientFullName, patientAddress, patientPhoneNumber, patientNationalCode, disease);

                    Date today = new Date();

                    Visit visit = new Visit(doctor, patient, today, prescription);
                    visit.save(); // Assuming you have a save method to save visit details
                    JOptionPane.showMessageDialog(addVisitFrame, "Visit added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addVisitFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addVisitPanel.add(addButton);

        addVisitFrame.setContentPane(addVisitPanel);
        addVisitFrame.setVisible(true);
    }

    public void removeVisit() {
        JFrame addVisitFrame = new JFrame("Add Visit");
        addVisitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addVisitFrame.setSize(600, 500);
        addVisitFrame.setLocationRelativeTo(null);

        JPanel addVisitPanel = new JPanel();
        addVisitPanel.setBackground(Color.BLACK);
        addVisitPanel.setLayout(new BoxLayout(addVisitPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Remove Visit");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.RED);
        addVisitPanel.add(titleLabel);
        addVisitPanel.add(Box.createVerticalStrut(10));

        JTextField doctorFullNameField = new JTextField(20);
        JTextField doctorAddressField = new JTextField(20);
        JTextField doctorPhoneNumberField = new JTextField(20);
        JTextField doctorNationalCodeField = new JTextField(20);
        JTextField doctorSpecialityField = new JTextField(20);
        JTextField prescriptionField = new JTextField(20);

        doctorFullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorAddressField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorPhoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorNationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        doctorSpecialityField.setFont(new Font("Arial", Font.PLAIN, 18));
        prescriptionField.setFont(new Font("Arial", Font.PLAIN, 18));

        doctorFullNameField.setForeground(Color.WHITE);
        doctorAddressField.setForeground(Color.WHITE);
        doctorPhoneNumberField.setForeground(Color.WHITE);
        doctorNationalCodeField.setForeground(Color.WHITE);
        doctorSpecialityField.setForeground(Color.WHITE);
        prescriptionField.setForeground(Color.WHITE);

        doctorFullNameField.setCaretColor(Color.WHITE);
        doctorAddressField.setCaretColor(Color.WHITE);
        doctorPhoneNumberField.setCaretColor(Color.WHITE);
        doctorNationalCodeField.setCaretColor(Color.WHITE);
        doctorSpecialityField.setCaretColor(Color.WHITE);
        prescriptionField.setCaretColor(Color.WHITE);

        doctorFullNameField.setBackground(Color.BLACK);
        doctorAddressField.setBackground(Color.BLACK);
        doctorPhoneNumberField.setBackground(Color.BLACK);
        doctorNationalCodeField.setBackground(Color.BLACK);
        doctorSpecialityField.setBackground(Color.BLACK);
        prescriptionField.setBackground(Color.BLACK);

        JPanel doctorInputPanel = new JPanel();
        doctorInputPanel.setLayout(new GridLayout(6, 2));
        doctorInputPanel.setBackground(Color.BLACK);
        doctorInputPanel.setForeground(Color.WHITE);
        doctorInputPanel.add(new JLabel("Doctor's Full Name:"));
        doctorInputPanel.add(doctorFullNameField);
        doctorInputPanel.add(new JLabel("Doctor's Address:"));
        doctorInputPanel.add(doctorAddressField);
        doctorInputPanel.add(new JLabel("Doctor's Phone Number:"));
        doctorInputPanel.add(doctorPhoneNumberField);
        doctorInputPanel.add(new JLabel("Doctor's National Code:"));
        doctorInputPanel.add(doctorNationalCodeField);
        doctorInputPanel.add(new JLabel("Doctor's Speciality:"));
        doctorInputPanel.add(doctorSpecialityField);
        doctorInputPanel.add(new JLabel("Prescription:"));
        doctorInputPanel.add(prescriptionField);

        for (Component c : doctorInputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addVisitPanel.add(doctorInputPanel);

        addVisitPanel.add(Box.createVerticalStrut(20));

        JTextField patientFullNameField = new JTextField(20);
        JTextField patientAddressField = new JTextField(20);
        JTextField patientPhoneNumberField = new JTextField(20);
        JTextField patientNationalCodeField = new JTextField(20);
        JTextField diseaseField = new JTextField(20);

        patientFullNameField.setFont(new Font("Arial", Font.PLAIN, 18));
        patientAddressField.setFont(new Font("Arial", Font.PLAIN, 18));
        patientPhoneNumberField.setFont(new Font("Arial", Font.PLAIN, 18));
        patientNationalCodeField.setFont(new Font("Arial", Font.PLAIN, 18));
        diseaseField.setFont(new Font("Arial", Font.PLAIN, 18));

        patientFullNameField.setForeground(Color.WHITE);
        patientAddressField.setForeground(Color.WHITE);
        patientPhoneNumberField.setForeground(Color.WHITE);
        patientNationalCodeField.setForeground(Color.WHITE);
        diseaseField.setForeground(Color.WHITE);

        patientFullNameField.setCaretColor(Color.WHITE);
        patientAddressField.setCaretColor(Color.WHITE);
        patientPhoneNumberField.setCaretColor(Color.WHITE);
        patientNationalCodeField.setCaretColor(Color.WHITE);
        diseaseField.setCaretColor(Color.WHITE);

        patientFullNameField.setBackground(Color.BLACK);
        patientAddressField.setBackground(Color.BLACK);
        patientPhoneNumberField.setBackground(Color.BLACK);
        patientNationalCodeField.setBackground(Color.BLACK);
        diseaseField.setBackground(Color.BLACK);

        JPanel patientInputPanel = new JPanel();
        patientInputPanel.setLayout(new GridLayout(5, 2));
        patientInputPanel.setBackground(Color.BLACK);
        patientInputPanel.setForeground(Color.WHITE);
        patientInputPanel.add(new JLabel("Patient's Full Name:"));
        patientInputPanel.add(patientFullNameField);
        patientInputPanel.add(new JLabel("Patient's Address:"));
        patientInputPanel.add(patientAddressField);
        patientInputPanel.add(new JLabel("Patient's Phone Number:"));
        patientInputPanel.add(patientPhoneNumberField);
        patientInputPanel.add(new JLabel("Patient's National Code:"));
        patientInputPanel.add(patientNationalCodeField);
        patientInputPanel.add(new JLabel("Disease:"));
        patientInputPanel.add(diseaseField);

        for (Component c : patientInputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addVisitPanel.add(patientInputPanel);

        addVisitPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.RED);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVisitFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addVisitPanel.add(buttonPanel);

        JButton addButton = new JButton("Remove Visit");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.RED);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String doctorFullName = doctorFullNameField.getText();
                    String doctorAddress = doctorAddressField.getText();
                    String doctorPhoneNumber = doctorPhoneNumberField.getText();
                    int doctorNationalCode = Integer.parseInt(doctorNationalCodeField.getText());
                    String doctorSpeciality = doctorSpecialityField.getText();
                    String prescription = prescriptionField.getText();

                    Doctor doctor = new Doctor(doctorFullName, doctorAddress, doctorPhoneNumber, doctorNationalCode, doctorSpeciality);

                    String patientFullName = patientFullNameField.getText();
                    String patientAddress = patientAddressField.getText();
                    String patientPhoneNumber = patientPhoneNumberField.getText();
                    int patientNationalCode = Integer.parseInt(patientNationalCodeField.getText());
                    String disease = diseaseField.getText();

                    Patient patient = new Patient(patientFullName, patientAddress, patientPhoneNumber, patientNationalCode, disease);

                    Date today = new Date();

                    Visit visit = new Visit(doctor, patient, today, prescription);

                    MyFile.search(visit);

                    JOptionPane.showMessageDialog(addVisitFrame, "Visit added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addVisitFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addVisitPanel.add(addButton);

        addVisitFrame.setContentPane(addVisitPanel);
        addVisitFrame.setVisible(true);
    }

    public void viewVisit() {
        JFrame viewVisitFrame = new JFrame("View Visit");
        viewVisitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewVisitFrame.setSize(600, 400);
        viewVisitFrame.setLocationRelativeTo(null);

        JPanel viewVisitPanel = new JPanel();
        viewVisitPanel.setBackground(Color.BLACK);
        viewVisitPanel.setLayout(new BoxLayout(viewVisitPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("View Visit");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        viewVisitPanel.add(titleLabel);
        viewVisitPanel.add(Box.createVerticalStrut(10));

        JTextArea visitTextArea = new JTextArea(20, 40);
        visitTextArea.setEditable(false);
        visitTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        visitTextArea.setForeground(Color.WHITE);
        visitTextArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(visitTextArea);

        viewVisitPanel.add(scrollPane);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewVisitFrame.dispose();
            }
        });

        viewVisitPanel.add(closeButton);

        viewVisitFrame.setContentPane(viewVisitPanel);
        viewVisitFrame.setVisible(true);

        // Get the list of visits from MyFile.visits
        ArrayList<Visit> visitList = MyFile.visits;

        // Display the list of visits in the text area
        for (Visit visit : visitList) {
            visitTextArea.append(visit.toString() + "\n");
        }
    }

    public void DrugsMenu() {
        JFrame drugFrame = new JFrame("Drug Menu");
        drugFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        drugFrame.setSize(600, 400);
        drugFrame.setLocationRelativeTo(null);

        JPanel drugPanel = new JPanel();
        drugPanel.setBackground(Color.black);
        drugPanel.setLayout(new BoxLayout(drugPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Drug Menu");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.white);
        drugPanel.add(titleLabel);
        drugPanel.add(Box.createVerticalStrut(10));

        JButton addDrugButton = new JButton("Add Drug");
        JButton removeDrugButton = new JButton("Remove Drug");
        JButton viewDrugButton = new JButton("View Drug");
        JButton backButton = new JButton("Back to Main");
        JButton exitButton = new JButton("Exit");

        addDrugButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeDrugButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewDrugButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDrug();
            }
        });

        removeDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeDrug();
            }
        });

        viewDrugButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDrug();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drugFrame.dispose();
                showMenu();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        drugPanel.add(addDrugButton);
        drugPanel.add(Box.createVerticalStrut(10));
        drugPanel.add(removeDrugButton);
        drugPanel.add(Box.createVerticalStrut(10));
        drugPanel.add(viewDrugButton);
        drugPanel.add(Box.createVerticalStrut(10));
        drugPanel.add(backButton);
        drugPanel.add(Box.createVerticalStrut(10));
        drugPanel.add(exitButton);

        drugFrame.setContentPane(drugPanel);
        drugFrame.setVisible(true);
    }

    public void addDrug() {
        JFrame addDrugFrame = new JFrame("Add Drug");
        addDrugFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDrugFrame.setSize(600, 400);
        addDrugFrame.setLocationRelativeTo(null);

        JPanel addDrugPanel = new JPanel();
        addDrugPanel.setBackground(Color.BLACK);
        addDrugPanel.setLayout(new BoxLayout(addDrugPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Add Drug");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.GREEN);
        addDrugPanel.add(titleLabel);
        addDrugPanel.add(Box.createVerticalStrut(10));

        JTextField nameField = new JTextField(20);
        JTextField manufacturerField = new JTextField(20);
        JTextField dosageField = new JTextField(20);
        JTextField descriptionField = new JTextField(20);

        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        manufacturerField.setFont(new Font("Arial", Font.PLAIN, 18));
        dosageField.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionField.setFont(new Font("Arial", Font.PLAIN, 18));

        nameField.setForeground(Color.WHITE);
        manufacturerField.setForeground(Color.WHITE);
        dosageField.setForeground(Color.WHITE);
        descriptionField.setForeground(Color.WHITE);

        nameField.setCaretColor(Color.WHITE);
        manufacturerField.setCaretColor(Color.WHITE);
        dosageField.setCaretColor(Color.WHITE);
        descriptionField.setCaretColor(Color.WHITE);

        nameField.setBackground(Color.BLACK);
        manufacturerField.setBackground(Color.BLACK);
        dosageField.setBackground(Color.BLACK);
        descriptionField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Manufacturer:"));
        inputPanel.add(manufacturerField);
        inputPanel.add(new JLabel("Dosage:"));
        inputPanel.add(dosageField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addDrugPanel.add(inputPanel);

        addDrugPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.GREEN);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDrugFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addDrugPanel.add(buttonPanel);

        JButton addButton = new JButton("Add Drug");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.GREEN);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String manufacturer = manufacturerField.getText();
                    String dosage = dosageField.getText();
                    String description = descriptionField.getText();

                    Drug drug = new Drug(name, manufacturer, dosage, description);
                    drug.save(); // Assuming you have a save method to save drug details
                    JOptionPane.showMessageDialog(addDrugFrame, "Drug added successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addDrugFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addDrugPanel.add(addButton);

        addDrugFrame.setContentPane(addDrugPanel);
        addDrugFrame.setVisible(true);
    }

    public void removeDrug() {
        JFrame addDrugFrame = new JFrame("Remove Drug");
        addDrugFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addDrugFrame.setSize(600, 400);
        addDrugFrame.setLocationRelativeTo(null);

        JPanel addDrugPanel = new JPanel();
        addDrugPanel.setBackground(Color.BLACK);
        addDrugPanel.setLayout(new BoxLayout(addDrugPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Remove Drug");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.RED);
        addDrugPanel.add(titleLabel);
        addDrugPanel.add(Box.createVerticalStrut(10));

        JTextField nameField = new JTextField(20);
        JTextField manufacturerField = new JTextField(20);
        JTextField dosageField = new JTextField(20);
        JTextField descriptionField = new JTextField(20);

        nameField.setFont(new Font("Arial", Font.PLAIN, 18));
        manufacturerField.setFont(new Font("Arial", Font.PLAIN, 18));
        dosageField.setFont(new Font("Arial", Font.PLAIN, 18));
        descriptionField.setFont(new Font("Arial", Font.PLAIN, 18));

        nameField.setForeground(Color.WHITE);
        manufacturerField.setForeground(Color.WHITE);
        dosageField.setForeground(Color.WHITE);
        descriptionField.setForeground(Color.WHITE);

        nameField.setCaretColor(Color.WHITE);
        manufacturerField.setCaretColor(Color.WHITE);
        dosageField.setCaretColor(Color.WHITE);
        descriptionField.setCaretColor(Color.WHITE);

        nameField.setBackground(Color.BLACK);
        manufacturerField.setBackground(Color.BLACK);
        dosageField.setBackground(Color.BLACK);
        descriptionField.setBackground(Color.BLACK);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.setBackground(Color.BLACK);
        inputPanel.setForeground(Color.WHITE);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Manufacturer:"));
        inputPanel.add(manufacturerField);
        inputPanel.add(new JLabel("Dosage:"));
        inputPanel.add(dosageField);
        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);

        for (Component c : inputPanel.getComponents()) {
            if (c instanceof JLabel) {
                JLabel label = (JLabel) c;
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.WHITE);
            }
        }

        addDrugPanel.add(inputPanel);

        addDrugPanel.add(Box.createVerticalStrut(20));

        JButton backButton = new JButton("Back");
        backButton.setForeground(Color.RED);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDrugFrame.dispose();
            }
        });

        backButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(backButton);
        addDrugPanel.add(buttonPanel);

        JButton addButton = new JButton("Remove Drug");
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addButton.setForeground(Color.RED);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    String manufacturer = manufacturerField.getText();
                    String dosage = dosageField.getText();
                    String description = descriptionField.getText();

                    Drug drug = new Drug(name, manufacturer, dosage, description);
                    MyFile.search(drug);
                    JOptionPane.showMessageDialog(addDrugFrame, "Drug removed successfully.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addDrugFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        addButton.setFont(new Font("Arial", Font.PLAIN, 18));

        addDrugPanel.add(addButton);

        addDrugFrame.setContentPane(addDrugPanel);
        addDrugFrame.setVisible(true);
    }

    public void viewDrug() {
        JFrame viewDrugFrame = new JFrame("View Drugs");
        viewDrugFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewDrugFrame.setSize(600, 400);
        viewDrugFrame.setLocationRelativeTo(null);

        JPanel viewDrugPanel = new JPanel();
        viewDrugPanel.setBackground(Color.BLACK);
        viewDrugPanel.setLayout(new BoxLayout(viewDrugPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("View Drugs");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(Color.BLUE);
        viewDrugPanel.add(titleLabel);
        viewDrugPanel.add(Box.createVerticalStrut(10));

        JTextArea drugTextArea = new JTextArea(20, 40);
        drugTextArea.setEditable(false);
        drugTextArea.setFont(new Font("Arial", Font.PLAIN, 24));
        drugTextArea.setForeground(Color.WHITE);
        drugTextArea.setBackground(Color.BLACK);
        JScrollPane scrollPane = new JScrollPane(drugTextArea);

        viewDrugPanel.add(scrollPane);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDrugFrame.dispose();
            }
        });

        viewDrugPanel.add(closeButton);

        viewDrugFrame.setContentPane(viewDrugPanel);
        viewDrugFrame.setVisible(true);

        // Get the list of drugs from MyFile.drugs
        ArrayList<Drug> drugList = MyFile.drugs;

        // Display the list of drugs in the text area
        for (Drug drug : drugList) {
            drugTextArea.append(drug.toString() + "\n");
        }
    }

}