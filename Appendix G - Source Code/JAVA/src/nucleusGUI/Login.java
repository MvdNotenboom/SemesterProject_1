package nucleusGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Class for providing basic login capabilities
 * @author Group6
 * @version 3.4.1
 * @extends JFrame
 */
public class Login extends JFrame
{
   private ButtonListener buttonListener;
   
   private JPanel buttonPanel, loginPanel, credentialsPanel, passwordPanel;
   
   private JPasswordField passwordField;
   
   private JLabel loginLabel, passwordLabel, logoLabel;
   
   private ImageIcon logoIcon, icon;
   
   private JTextField loginTextField;
   
   private JButton loginButton, cancelButton;
   
   /**
    * No argument constructor for initializing the elements
    */
   public Login()
   {
      super("Nucleus Login"); //Title
      
      //Initializing and setting up the elements
      buttonListener = new ButtonListener();
      
      logoIcon = new ImageIcon("img/1.png");
      logoLabel = new JLabel("", SwingConstants.CENTER);
      logoLabel.setIcon(logoIcon);
      logoLabel.setPreferredSize(new Dimension(450, 50));
      
      credentialsPanel = new JPanel();
      credentialsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
      
      loginPanel = new JPanel();
      loginTextField = new JTextField(15);
      loginLabel = new JLabel("Login:", SwingConstants.RIGHT);
      loginLabel.setPreferredSize(new Dimension(70, 20));
     
      passwordPanel = new JPanel();
      passwordLabel = new JLabel("Password:", SwingConstants.RIGHT);
      passwordField = new JPasswordField(15);
      passwordLabel.setPreferredSize(new Dimension(70, 20));
      
      buttonPanel = new JPanel();
      buttonPanel.setPreferredSize(new Dimension(450, 50));
      
      loginButton = new JButton("Login");
      loginButton.addActionListener(buttonListener);
      cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(buttonListener);
     
      loginPanel.add(loginLabel);
      loginPanel.add(loginTextField);
      passwordPanel.add(passwordLabel);
      passwordPanel.add(passwordField);
      credentialsPanel.add(loginPanel);
      credentialsPanel.add(passwordPanel);
      buttonPanel.add(loginButton);
      buttonPanel.add(cancelButton);
     
      add(credentialsPanel, BorderLayout.CENTER);
      add(logoLabel, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.SOUTH);
      
      setSize(450, 200);
      setVisible(true);
      setResizable(false);
      
      icon = new ImageIcon("img/Nucleus_logo_bg_ligh_no_text.png");
      setIconImage(icon.getImage());
      
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }
   
   /**
    * Action listener for the buttons
    * @author Group6
    * @version 2.1.3
    * @implements ActionListener
    */
   private class ButtonListener implements ActionListener
   {
      /**
       * Listens to actions and executes accordingly
       */
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == loginButton)
         {
            String login = loginTextField.getText();                       //Retrieves the login
            String password = String.valueOf(passwordField.getPassword()); //Retrieves the password and makes it into a String
            
            //Checks credentials and initializes the mainFrame
            if(login.equals("admin") && password.equals("admin"))
            {
               MainFrame mainGUI = new MainFrame();
               setVisible(false); //Becomes invisible afterwards
            }
            else
            {
               JOptionPane.showMessageDialog(new JFrame(), "Wrong login and/or password");
               
               loginTextField.setText("");
               passwordField.setText("");
            }
            
         }
         else if(e.getSource() == cancelButton)
         {
            System.exit(0);
         }
      }
   }
   
   /**
    * Starts the main Frame
    * @param String[] args
    */
   public static void main(String[] args)
   {
      Login login = new Login();
   }
}
