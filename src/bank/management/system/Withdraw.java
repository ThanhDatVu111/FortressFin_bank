package bank.management.system;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener
{
    private final String PIN; //final make pin constant
    JTextField withdraw_field;
    JButton with_button, back_button;
    Withdraw(String pin)
    {
        super();
        this.PIN = pin;

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS 3000$ PER DAY");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 25));
        label1.setBounds(150,180,700,35);
        add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Rale way", Font.BOLD, 20));
        label2.setBounds(100,240,400,35);
        add(label2);

        withdraw_field = new JTextField();
        withdraw_field.setFont(new Font("Rale way", Font.BOLD,22));
        withdraw_field.setOpaque(false);
        withdraw_field.setForeground(Color.WHITE);
        withdraw_field.setBounds(450,250,320,25);
        add(withdraw_field);

        with_button = new JButton("WITHDRAW");
        with_button.setBounds(150,300,150,35);
        with_button.setForeground(Color.WHITE);
        with_button.setBorder(new LineBorder(Color.WHITE));
        with_button.setOpaque(false);
        with_button.setContentAreaFilled(false);
        with_button.addActionListener(this);
        add(with_button);

        back_button = new JButton("BACK");
        back_button.setBounds(550,300,150,35);
        back_button.setForeground(Color.WHITE);
        back_button.setBorder(new LineBorder(Color.WHITE));
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.addActionListener(this);
        add(back_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/withdraw.png"));
        Image i2 = i1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(25,0,800,800);
        add(deposit_bg);

        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        setSize(850,800);
        setLocation(360,20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == with_button)
        {
            try
            {
                String amount = withdraw_field.getText();
                Date date = new Date();
                if (withdraw_field.getText().isEmpty())
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                else
                {
                    Custom_connection c = new Custom_connection();
                    ResultSet resultSet = c.j_statement.executeQuery("select * from bank where pin = '" + PIN + "'"); //retrieve data from bank and compare with the pin.
                    int balance = 0;
                    while (resultSet.next()) //Begins a loop that iterates over the result set if the resultSet.next() return true
                                            // which mean there are account match the pin.
                    {
                        //add into balance variable so we know the current balance of the account.
                        if (resultSet.getString("type").equals("Deposit"))
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        else
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                    }
                    if (balance < Integer.parseInt(amount))
                    {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance, Please try again");
                        return;
                    }
                    c.j_statement.executeUpdate("insert into bank values('" + PIN + "', '" + date + "', 'Withdraw', '" + amount + "' )");
                    JOptionPane.showMessageDialog(null, "Successfully withdraw "+amount+"$");
                    withdraw_field.setText("");
                }
            } catch (Exception E) {
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
        new Withdraw("");
    }
}
