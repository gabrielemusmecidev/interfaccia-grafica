import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Gestione Studenti e Professori");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField();
        JLabel surnameLabel = new JLabel("Cognome:");
        JTextField surnameField = new JTextField();
        JLabel mediaLabel = new JLabel("Media:");
        JTextField mediaField = new JTextField();

        studentPanel.add(nameLabel);
        studentPanel.add(nameField);
        studentPanel.add(surnameLabel);
        studentPanel.add(surnameField);
        studentPanel.add(mediaLabel);
        studentPanel.add(mediaField);

        JButton studentButton = new JButton("OK");
        JTextArea studentTextArea = new JTextArea();
        studentTextArea.setEditable(false);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String cognome = surnameField.getText();
                Float media = Float.parseFloat(mediaField.getText())    ;

                //Visualizza i dati
                studentTextArea.append("Nome "+nome+"\n");
                studentTextArea.append("Cognome "+cognome+"\n");
                studentTextArea.append("Media "+media+"\n");

                // Svuota i campi
                nameField.setText("");
                surnameField.setText("");
                mediaField.setText("");
            }
        });

        studentPanel.add(studentButton);
        studentPanel.add(studentTextArea);

        JPanel professorPanel = new JPanel();
        professorPanel.setLayout(new GridLayout(4, 2));

        JLabel profNameLabel = new JLabel("Nome:");
        JTextField profNameField = new JTextField();
        JLabel profSurnameLabel = new JLabel("Cognome:");
        JTextField profSurnameField = new JTextField();
        JLabel subjectLabel = new JLabel("Materia:");
        JTextField subjectField = new JTextField();

        professorPanel.add(profNameLabel);
        professorPanel.add(profNameField);
        professorPanel.add(profSurnameLabel);
        professorPanel.add(profSurnameField);
        professorPanel.add(subjectLabel);
        professorPanel.add(subjectField);

        JButton professorButton = new JButton("OK");
        JTextArea profTextArea= new JTextArea();
        profTextArea.setEditable(false);
        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String profNome = profNameField.getText();
                String profCognome = profSurnameField.getText();
                String materia = subjectField.getText();

                //Visualizza i dati
                profTextArea.append("Nome "+profNome+"\n");
                profTextArea.append("Cognome "+profCognome+"\n");
                profTextArea.append("Materia "+materia+"\n");

                // Svuota i campi
                profNameField.setText("");
                profSurnameField.setText("");
                subjectField.setText("");
            }
        });

        professorPanel.add(professorButton);
        professorPanel.add(profTextArea);

        tabbedPane.addTab("Studente", studentPanel);
        tabbedPane.addTab("Professore", professorPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
