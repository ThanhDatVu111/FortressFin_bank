package bank.management.system;
import javax.swing.*; // package contains classes and interfaces for creating
                     // graphical user interface (GUI) components in Java applications
import java.awt.*;  //Abstract Window Toolkit contains classes for creating and managing
                   // graphical user interfaces (GUIs) in Java applications
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //handling events triggered by user interactions with GUI components like buttons
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener //Login class inherits all the properties and methods of the JFrame class
{
    JLabel card_no_msg, pin_msg;
    JTextField card_field;
    JPasswordField pin_field;
    JButton sign_in_button, clear_button, sign_up_button;
    Login()
    {
        ///calling the constructor to set up JFrame default function of the superclass (JFrame) with the specified title
        super();

        card_no_msg = new JLabel("Card No:");
        card_no_msg.setFont(new Font("Ralway", Font.BOLD, 28));
        card_no_msg.setForeground(Color.WHITE);
        card_no_msg.setBounds(200,100,375,30);
        add(card_no_msg);

        //set up card field
        card_field = new JTextField(15); //preferred width of the text field, JTextField already handles user interactions such as clicking to insert text
        card_field.setBounds(325,100,230,30);
        card_field.setOpaque(false); // Make the text field transparent
        card_field.setFont(new Font("Arial", Font.BOLD,14));
        card_field.setForeground(Color.WHITE); //set the text inside become white
        add(card_field);

        //display pin text
        pin_msg = new JLabel("PIN: ");
        pin_msg.setFont(new Font("Ralway", Font.BOLD, 28));
        pin_msg.setForeground(Color.WHITE);
        pin_msg.setBounds(200,150,375,30);
        add(pin_msg);

        //set up pin field
        pin_field = new JPasswordField(15);
        pin_field.setBounds(325,150,230,30);
        pin_field.setOpaque(false); // Make the text field transparent
        pin_field.setFont(new Font("Arial", Font.BOLD, 14));
        pin_field.setForeground(Color.WHITE);
        add(pin_field);

        //create sign in button
        sign_in_button = new JButton("SIGN IN");
        sign_in_button.setFont(new Font("Arial", Font.BOLD, 14));
        sign_in_button.setForeground(Color.WHITE);
        sign_in_button.setOpaque(false);
        sign_in_button.setContentAreaFilled(false); //prevents the JButton from painting the content area with the default light grey color.
        sign_in_button.setBounds(325,200,100, 30);
        sign_in_button.addActionListener(this);
        add(sign_in_button);

        //create clear button
        clear_button = new JButton("CLEAR");
        clear_button.setFont(new Font("Arial", Font.BOLD, 14));
        clear_button.setForeground(Color.WHITE);
        clear_button.setOpaque(false);
        clear_button.setContentAreaFilled(false);
        clear_button.setBounds(455,200,100, 30);
        clear_button.addActionListener(this);
        add(clear_button);

        //create sign up button
        sign_up_button = new JButton("SIGN UP");
        sign_up_button.setFont(new Font("Arial", Font.BOLD, 14));
        sign_up_button.setForeground(Color.WHITE);
        sign_up_button.setOpaque(false);
        sign_up_button.setContentAreaFilled(false);
        sign_up_button.setBounds(325,240,230, 30);
        sign_up_button.addActionListener(this);
        add(sign_up_button);

        //load bank bg
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg_image = new JLabel(i3); //JLabel itself does not directly accept images; it requires an Icon object, such as ImageIcon, to display an image.
        bg_image.setBounds(0,0,850,480);
        add(bg_image);

        //set up window
        setLayout(null); //disables automatic component arrangement, allowing manual control of component positions and sizes with setBounds().
        setSize(850, 480);
        setLocation(350,200);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) //This method is called whenever an action event occurs, such as clicking a button
    {
        try
        {
            if(e.getSource() == sign_in_button)
            {
                Custom_connection c = new Custom_connection();
                String card_num = card_field.getText();
                String pin = pin_field.getText();
                String query = "select * from login where card_number = '"+card_num+"' and pin = '"+pin+"'"; //retrieve data from login table
                ResultSet resultSet = c.j_statement.executeQuery(query); //contains the records retrieved by the query.
                if (resultSet.next()) //If resultSet.next() returns true, it means there is at least one matching record (card_num,pin) in the MySQL database.
                {
                    setVisible(false);
                    new Main(pin);
                }
                else
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
            }
            else if(e.getSource() == clear_button)
            {
                card_field.setText("");
                pin_field.setText("");
            }
            else if(e.getSource() == sign_up_button)
            {
                new Signup1();
                setVisible(false);
            }
        }
        catch (Exception error)
        {
            error.printStackTrace();
        }

    }
    public static void main(String[] args)
    {
        new Login();
    }
}
