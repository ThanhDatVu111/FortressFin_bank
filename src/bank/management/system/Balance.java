package bank.management.system;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener
{
    private final String PIN;
    JLabel balance_msg, balance_result;
    JButton back_button;
    Balance(String pin)
    {
        super();
        this.PIN = pin;

        balance_msg = new JLabel("Your Current Balance is $");
        balance_msg.setForeground(Color.BLACK);
        balance_msg.setFont(new Font("System", Font.BOLD, 24));
        balance_msg.setBounds(100,150,330,35);
        add(balance_msg);

        back_button = new JButton("BACK");
        back_button.setBounds(100,200,150,35);
        back_button.setForeground(Color.BLACK);
        back_button.setBorder(new LineBorder(Color.BLACK));
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.addActionListener(this);
        add(back_button);

        int balance = 0;
        try
        {

            Custom_connection c = new Custom_connection();
            ResultSet resultSet = c.j_statement.executeQuery("select * from bank where pin = '" + PIN + "'"); //retrieve data from bank and compare with the pin.
            while (resultSet.next()) //Begins a loop that iterates over the result set if the resultSet.next() return true
            {
                //add into balance variable so we know the current balance of the account.
                if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Received"))
                    balance += Integer.parseInt(resultSet.getString("amount"));
                else
                    balance -= Integer.parseInt(resultSet.getString("amount"));
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        balance_result = new JLabel();
        balance_result.setForeground(Color.BLACK);
        balance_result.setFont(new Font("System", Font.BOLD, 24));
        balance_result.setBounds(420,150,400,35);
        balance_result.setText(""+balance);
        add(balance_result);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/balance.png"));
        Image i2 = i1.getImage().getScaledInstance(700,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(75,0,700,800);
        add(deposit_bg);

        getContentPane().setBackground(Color.WHITE);
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
        if (e.getSource() == back_button)
        {
            new Main(PIN);
            setVisible(false);
        }
    }

    public static void main(String[] args)
    {
        new Balance("");
    }

}
