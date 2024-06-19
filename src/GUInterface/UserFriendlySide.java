package GUInterface;

import javax.swing.*;
import Oracle.BibleVerse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserFriendlySide extends JFrame{
    private JLabel topicLabel;
    private JTextField topicField;
    private JPanel panelMain;
    private JLabel messageLabel;
    private JTextArea messageField;
    private JTextField dateField;
    private JLabel dateLabel;
    private JButton insertVerseButton;
    private JButton deleteVerseButton;
    private JLabel referenceLabel;
    private JTextField referenceField;
    //private JTextArea displayScreen;
    //private JButton displayTableInformation;

    public UserFriendlySide(){
        insertVerseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = topicField.getText();
                String reference = referenceField.getText();
                String message = messageField.getText();
                String date = dateField.getText();

                try {
                    BibleVerse.insertVerse(topic,reference,message,date);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        deleteVerseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topic = topicField.getText();

                try {
                    BibleVerse.deleteVerse(topic);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        UserFriendlySide gui = new UserFriendlySide();

        gui.setTitle("Bible Verses");
        gui.setContentPane(gui.panelMain);
        gui.setSize(600,480);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
