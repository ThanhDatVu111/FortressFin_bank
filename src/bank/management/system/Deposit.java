package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener
{
    private final String PIN; //final make pin constant
    JTextField deposit_field;
    JButton back_button, deposit_button;
    Deposit(String pin)
    {
        super();
        this.PIN = pin;
        JLabel label1 = new JLabel("ENTER THE AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(90,150,500,35);
        add(label1);

        deposit_field = new JTextField();
        deposit_field.setBounds(90,200,450,25);
        deposit_field.setFont(new Font("Rale way", Font.BOLD,22));
        deposit_field.setOpaque(false);
        add(deposit_field);

        deposit_button = new JButton("DEPOSIT");
        deposit_button.setBounds(90,300,150,35);
        deposit_button.setOpaque(false);
        deposit_button.setForeground(Color.BLACK);
        deposit_button.setContentAreaFilled(false);
        deposit_button.addActionListener(this);
        add(deposit_button);

        back_button = new JButton("BACK");
        back_button.setBounds(300,300,150,35);
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.setForeground(Color.BLACK);
        back_button.addActionListener(this);
        add(back_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/deposit.png"));
        Image i2 = i1.getImage().getScaledInstance(840,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(5,0,840,800);
        add(deposit_bg);

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
        if (e.getSource() == deposit_button)
        {
            try
            {
                String amount = deposit_field.getText();
                Date date = new Date();
                if (deposit_field.getText().isEmpty() || !amount.matches("\\d+")) // Check if the input is not empty and contains only numbers
                    JOptionPane.showMessageDialog(null,"Please enter the valid amount to deposit");
                else
                {
                    Custom_connection c = new Custom_connection();
                    c.j_statement.executeUpdate("insert into bank values('"+PIN+"', '"+date+"','Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Successfully deposited "+amount+"$");
                    deposit_field.setText("");
                }
            }
            catch (Exception E){
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
        new Deposit(""); // empty string as a placeholder in the main method, the actual value used by Deposit is
        // determined by whatever value I pass to it when you create an instance of the class. either from sign in for sign up
    }
}
