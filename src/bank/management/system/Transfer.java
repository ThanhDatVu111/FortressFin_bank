package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Transfer extends JFrame implements ActionListener
{
    private final String PIN;
    JTextField name_field, card_field, transfer_field;
    JButton back_button, transfer_button;
    Transfer(String pin)
    {
        super();
        this.PIN = pin;

        JLabel label1 = new JLabel("ENTER THE RECIPIENT NAME");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 19));
        label1.setBounds(400,50,300,35);
        add(label1);

        name_field = new JTextField();
        name_field.setBounds(400,100,350,25);
        name_field.setFont(new Font("Rale way", Font.BOLD,19));
        name_field.setForeground(Color.BLACK);
        add(name_field);

        JLabel label2 = new JLabel("ENTER THE RECIPIENT CARD NUMBER");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System", Font.BOLD, 19));
        label2.setBounds(400,150,450,35);
        add(label2);

        card_field = new JTextField();
        card_field.setBounds(400,200,350,25);
        card_field.setFont(new Font("Rale way", Font.BOLD,20));
        card_field.setForeground(Color.BLACK);
        add(card_field);

        JLabel label3 = new JLabel("ENTER TRANSFER AMOUNT");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("System", Font.BOLD, 19));
        label3.setBounds(400,250,450,35);
        add(label3);

        transfer_field = new JTextField();
        transfer_field.setBounds(400,300,350,25);
        transfer_field.setFont(new Font("Rale way", Font.BOLD,20));
        transfer_field.setForeground(Color.BLACK);
        add(transfer_field);

        transfer_button = new JButton("TRANSFER");
        transfer_button.setBounds(400,400,150,35);
        transfer_button.setOpaque(false);
        transfer_button.setForeground(Color.BLACK);
        transfer_button.setContentAreaFilled(false);
        transfer_button.addActionListener(this);
        add(transfer_button);

        back_button = new JButton("BACK");
        back_button.setBounds(600,400,150,35);
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.setForeground(Color.BLACK);
        back_button.addActionListener(this);
        add(back_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/transfer.png"));
        Image i2 = i1.getImage().getScaledInstance(850,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel transfer_bg = new JLabel(i3);
        transfer_bg.setBounds(0,0,850,450);
        add(transfer_bg);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/transfer2.png"));
        Image ii2 = ii1.getImage().getScaledInstance(850,450,Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel transfer2_bg = new JLabel(ii3);
        transfer2_bg.setBounds(0,390,850,450);
        add(transfer2_bg);

        setLayout(null);
        setSize(850,800);
        centerWindowOnScreen();
        setUndecorated(true);
        setVisible(true);
    }

    public void centerWindowOnScreen()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == transfer_button)
        {
            try
            {
                Date date = new Date();
                String recipient_name = name_field.getText();
                String card_number = card_field.getText();
                String amount = transfer_field.getText();
                if (recipient_name.isEmpty() || card_number.isEmpty() || amount.isEmpty()) // Check if the input is not empty and contains only numbers
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid information.");
                    return;
                }
                else if ( recipient_name.matches(".*\\d.*"))
                {
                    JOptionPane.showMessageDialog(null, "Recipient name cannot contain numbers, please try again.");
                    return;
                }
                else if (!card_number.matches("\\d+") || !amount.matches("\\d+"))
                {
                    JOptionPane.showMessageDialog(null, "Please enter only numbers for recipient card number and transfer amount.");
                    return;
                }
                else
                {
                    Custom_connection c = new Custom_connection();
                    ResultSet resultSet = c.j_statement.executeQuery("select form_num from signup1 where name = '" + recipient_name + "'"); //retrieve data
                    if (resultSet.next()) //if there is name match with recipient name, and we can get the form num
                    {

                        String form_num = resultSet.getString("form_num"); //recipient form_num
                        ResultSet resultSet1 = c.j_statement.executeQuery("select * from login where card_number = '" + card_number + "' and form_num = '" + form_num + "'");
                        if (resultSet1.next()) //if the card info also correct.
                        {
                            String recipient_pin = resultSet1.getString("pin");

                            //In JDBC, a connection allows only one ResultSet object to be open at a time per Statement.
                            //If you execute a new query using the same Statement object
                            //while a ResultSet is still open, the previous ResultSet will be automatically closed.

                            //start transfer logic
                            ResultSet resultSet2 = c.j_statement.executeQuery("select * from bank where pin = '" + PIN + "'"); //retrieve data from main account.
                            int balance = 0;
                            while (resultSet2.next()) //Begins a loop that iterates over the result set if the resultSet.next() return true
                            // which mean there are account match the pin.
                            {
                                //add into balance variable so we know the current balance of the account.
                                if (resultSet2.getString("type").equals("Deposit") || resultSet2.getString("type").equals("Received"))
                                    balance += Integer.parseInt(resultSet2.getString("amount"));
                                else
                                    balance -= Integer.parseInt(resultSet2.getString("amount"));
                            }
                            resultSet2.close();
                            if (Integer.parseInt(amount) > balance || Integer.parseInt(amount) < 0)
                                JOptionPane.showMessageDialog(null, "Sorry, the withdrawal amount is invalid or your account balance is insufficient to complete the transfer. Please try again");
                            else {
                                //after everything is right, we take out the money and transfer the amount into recipient account
                                c.j_statement.executeUpdate("insert into bank values('" + PIN + "', '" + date + "', 'Sent', '" + amount + "' )");
                                c.j_statement.executeUpdate("insert into bank values('" + recipient_pin + "', '" + date + "', 'Received', '" + amount + "' )");
                                JOptionPane.showMessageDialog(null, "Successfully sending $" + amount + " to " + recipient_name + " with card number of " + card_number);
                                name_field.setText("");
                                card_field.setText("");
                                transfer_field.setText("");
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "The card number is not correct. Please try again");
                            return;
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"The recipient name does not exist in our data. Please try again");
                        return;
                    }
                }
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if (e.getSource() == back_button)
        {
            new Main(PIN);
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Transfer("");
    }
}
