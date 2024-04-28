package bank.management.system;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame implements ActionListener
{
    private final String PIN;
    JButton back_button;
    Tutorial(String pin)
    {
        super();
        this.PIN = pin;

        JLabel tutorialLabel = new JLabel("<html><p style='color:white; font-size:16px;'>Tutorial Information:<br>"+
                "1. Sign up: Create an account to access banking services.<br>" +
                "2. Login: Access your account securely by entering your username and password. <br>" +
                "2. Deposit: Add funds to your account.<br>" +
                "3. Withdraw: Withdraw funds from your account.<br>" +
                "4. Get Balance: Retrieve your account balance.<br>" +
                "5. Pin Change: Change your PIN.<br>" +
                "6. Transaction History: View your transaction history.<br>" +
                "7. Transfer: Transfer funds to another account.<br>" +
                "8. Back: Return to the previous screen.</p></html>");
        tutorialLabel.setBounds(50, 100, 700, 600);
        add(tutorialLabel);

        back_button = new JButton("BACK");
        back_button.setBounds(600, 700, 150, 35);
        back_button.setForeground(Color.BLACK);
        back_button.setBorder(new LineBorder(Color.BLACK));
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.addActionListener(this);
        add(back_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/tutorial.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(0, 0, 850, 800);
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
        int x = (screenSize.width - getWidth())/ 2;
        int y = (screenSize.height - getHeight())/ 2;
        setLocation(x, y);
    }

    public void actionPerformed(ActionEvent e)
    {
        new Main(PIN);
        setVisible(false);
    }

    public static void main(String[] args)
    {
        new Tutorial("");
    }
}
