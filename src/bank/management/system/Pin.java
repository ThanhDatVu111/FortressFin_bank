package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener
{
    String PIN; //this allow access the PIN value at multiple points within the class (beyond just the constructor)
    JPasswordField p1,p2;
    JButton b1,b2;
    Pin(String pin)
    {
        super();
        this.PIN = pin;

        JLabel label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("System", Font.BOLD, 20));
        label2.setBounds(300,220,150,35);
        add(label2);

        p1 = new JPasswordField();
        p1.setBackground(Color.WHITE);
        p1.setForeground(Color.BLACK);
        p1.setBounds(420,220,180,25);
        p1.setFont(new Font("Rale way", Font.BOLD,22));
        add(p1);

        JLabel label3 = new JLabel("Re-Enter New PIN:");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("System", Font.BOLD, 20));
        label3.setBounds(200,250,400,35);
        add(label3);

        p2 = new JPasswordField();
        p2.setBackground(Color.WHITE);;
        p2.setForeground(Color.BLACK);
        p2.setBounds(420,255,180,25);
        p2.setFont(new Font("Rale way", Font.BOLD,22));
        add(p2);

        b1 = new JButton("CHANGE");
        b1.setBounds(250,300,150,35);
        b1.setForeground(Color.BLACK);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(450,300,150,35);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        add(b2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pinchange.png"));
        Image i2 = i1.getImage().getScaledInstance(600,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel deposit_bg = new JLabel(i3);
        deposit_bg.setBounds(125,0,600,800);
        add(deposit_bg);

        getContentPane().setBackground(new Color(210, 180, 140));
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
        try
        {
            String pin1 = p1.getText();
            String pin2 = p2.getText();
            if (e.getSource()==b1)
            {
                if (pin1.equals("") || pin1.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter new PIN in both fields.");
                    return;
                }
                if (pin1.length() != 4 && pin2.length() != 4)
                {
                    JOptionPane.showMessageDialog(null,"PLease insert 4 digit pin only.");
                    return;
                }
                if (!pin1.matches("\\d+") && !pin2.matches("\\d+"))
                {
                    JOptionPane.showMessageDialog(null,"Please use number for your new pin.");
                    return;
                }
                if (!pin1.equals(pin2))
                {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    p1.setText("");
                    p2.setText("");
                    return; //exits the actionPerformed method, effectively stopping further execution of the method at that point
                }
                Custom_connection c = new Custom_connection();
                String q1 = "update bank set pin = '"+pin2+"' where pin = '"+PIN+"'";
                c.j_statement.executeUpdate(q1);
                String q2 = "update login set pin = '"+pin2+"' where pin = '"+PIN+"'";
                c.j_statement.executeUpdate(q2);
                String q3 = "update signup3 set pin = '"+pin2+"' where pin = '"+PIN+"'";
                c.j_statement.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                PIN = pin2;
                p1.setText("");
                p2.setText("");
            }
            else if (e.getSource()==b2)
            {
                new Main(PIN);
                setVisible(false);
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Pin("");
    }
}
