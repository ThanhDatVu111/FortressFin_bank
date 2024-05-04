package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener
{
    private final String PIN; //final make pin constant
    JButton deposit_button, withdraw_button, tr_button, mini_button, pin_change_button, balance_button, exit_button, tutorial_button;
    Main(String pin)
    {
        super();

        this.PIN = pin;
        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(200,100,700,35);
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

        withdraw_button = new JButton("WITHDRAW");
        withdraw_button.setForeground(Color.BLACK);
        withdraw_button.setOpaque(false);
        withdraw_button.setContentAreaFilled(false);
        withdraw_button.setBounds(500,180,150,35);
        withdraw_button.addActionListener(this);
        add(withdraw_button);

        tr_button = new JButton("TRANSFER");
        tr_button.setForeground(Color.BLACK);
        tr_button.setOpaque(false);
        tr_button.setContentAreaFilled(false);
        tr_button.setBounds(200,260,150,35);
        tr_button.addActionListener(this);
        add(tr_button);

        mini_button = new JButton("TRANSACTION HISTORY");
        mini_button.setForeground(Color.BLACK);
        mini_button.setOpaque(false);
        mini_button.setContentAreaFilled(false);
        mini_button.setBounds(500,260,200,35);
        mini_button.addActionListener(this);
        add(mini_button);

        pin_change_button = new JButton("PIN CHANGE");
        pin_change_button.setForeground(Color.BLACK);
        pin_change_button.setOpaque(false);
        pin_change_button.setContentAreaFilled(false);
        pin_change_button.setBounds(200,340,150,35);
        pin_change_button.addActionListener(this);
        add(pin_change_button);

        balance_button = new JButton("BALANCE INQUIRY");
        balance_button.setForeground(Color.BLACK);
        balance_button.setOpaque(false);
        balance_button.setContentAreaFilled(false);
        balance_button.setBounds(500,340,150,35);
        balance_button.addActionListener(this);
        add(balance_button);

        tutorial_button = new JButton("TUTORIAL");
        tutorial_button.setForeground(Color.BLACK);
        tutorial_button.setOpaque(false);
        tutorial_button.setContentAreaFilled(false);
        tutorial_button.setBounds(620,600,150,35);
        tutorial_button.addActionListener(this);
        add(tutorial_button);

        exit_button = new JButton("lOG OUT");
        exit_button.setForeground(Color.BLACK);
        exit_button.setBackground(new Color(65,125,128));
        exit_button.setBounds(620,650,150,35);
        exit_button.addActionListener(this);
        add(exit_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/main_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(840, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(0, 0, 840, 800);
        add(deposit_bg);

        setLayout(null);
        setSize(850, 800);
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
        if (e.getSource() == deposit_button){
            new Deposit(PIN);
            setVisible(false);
        }else if (e.getSource() == exit_button) {
            new Login();
            setVisible(false);
        } else if (e.getSource() == withdraw_button) {
            new Withdraw(PIN);
            setVisible(false);
        } else if (e.getSource() == balance_button) {
            new Balance(PIN);
            setVisible(false);
        }
        else if (e.getSource() == tr_button) {
            new Transfer(PIN);
            setVisible(false);
        }
        else if (e.getSource() == pin_change_button) {
            new Pin(PIN);
            setVisible(false);
        }
        else if (e.getSource() == mini_button) {
            new TransactionHistory(PIN);
            setVisible(false);
        }
        else
        {
            new Tutorial(PIN);
            setVisible(false);
        }

    }

    public static void main(String[] args)
    {
        new Main("");
    }
}
