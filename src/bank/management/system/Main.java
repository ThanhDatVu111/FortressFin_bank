package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    private final String PIN; //final make pin constant
    JButton deposit_button, withdraw_button, fc_button, mini_button, pin_change_button, balance_button, exit_button;
    Main(String pin)
    {
        super();

        this.PIN = pin;
        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(225,100,700,35);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("System",Font.BOLD,28));
        add(label);

        deposit_button = new JButton("DEPOSIT");
        deposit_button.setForeground(Color.BLACK);
        deposit_button.setOpaque(false);
        deposit_button.setContentAreaFilled(false);
        deposit_button.setBounds(200,180,150,35);
        deposit_button.addActionListener(this);
        add(deposit_button);

        withdraw_button = new JButton("CASH WITHDRAW");
        withdraw_button.setForeground(Color.BLACK);
        withdraw_button.setOpaque(false);
        withdraw_button.setContentAreaFilled(false);
        withdraw_button.setBounds(500,180,150,35);
        withdraw_button.addActionListener(this);
        add(withdraw_button);

        fc_button = new JButton("FAST CASH");
        fc_button.setForeground(Color.BLACK);
        fc_button.setOpaque(false);
        fc_button.setContentAreaFilled(false);
        fc_button.setBounds(200,260,150,35);
        fc_button.addActionListener(this);
        add(fc_button);

        mini_button = new JButton("MINI STATEMENT");
        mini_button.setForeground(Color.BLACK);
        mini_button.setOpaque(false);
        mini_button.setContentAreaFilled(false);
        mini_button.setBounds(500,260,150,35);
        mini_button.addActionListener(this);
        add(mini_button);

        pin_change_button = new JButton("PIN CHANGE");
        pin_change_button.setForeground(Color.BLACK);
        pin_change_button.setOpaque(false);
        pin_change_button.setContentAreaFilled(false);
        pin_change_button.setBounds(200,340,150,35);
        pin_change_button.addActionListener(this);
        add(pin_change_button);

        balance_button = new JButton("BALANCE ENQUIRY");
        balance_button.setForeground(Color.BLACK);
        balance_button.setOpaque(false);
        balance_button.setContentAreaFilled(false);
        balance_button.setBounds(500,340,150,35);
        balance_button.addActionListener(this);
        add(balance_button);

        exit_button = new JButton("EXIT");
        exit_button.setForeground(Color.WHITE);
        exit_button.setBackground(new Color(65,125,128));
        exit_button.setBounds(620,650,150,35);
        exit_button.addActionListener(this);
        add(exit_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/main_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(840, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(0, 0, 840, 750);
        add(deposit_bg);

        setLayout(null);
        setSize(850, 800);
        setLocation(360, 20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == deposit_button){
            new Deposit(PIN);
            setVisible(false);
        }else if (e.getSource() == exit_button)
            System.exit(0);
        else if (e.getSource() == withdraw_button) {
            new Withdraw(PIN);
            setVisible(false);
        } else if (e.getSource() == balance_button) {
            new Balance(PIN);
            setVisible(false);
        }
        /*else if (e.getSource() == fc_button) {
            new FastCash(pin);
            setVisible(false);
        } else if (e.getSource() == pin_change_button) {
            new Pin(pin);
            setVisible(false);
        } else if (e.getSource() == mini_button) {
            new mini(pin);
        }
        */
    }

    public static void main(String[] args)
    {
        new Main("");
    }
}
