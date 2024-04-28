package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import static bank.management.system.Signup1.rand_form_num;

public class Signup3 extends JFrame implements ActionListener
{
    JRadioButton a1,a2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit_button,cancel_button;

    Signup3(String rand_form_num)
    {
        super();

        JLabel header = new JLabel("APPLICATION FORM" + rand_form_num);
        header.setBounds(180, 80, 600, 40);
        header.setFont(new Font("Rale way", Font.BOLD, 36));
        add(header); //add to the frame for display

        JLabel page_label = new JLabel("Page 3");
        page_label.setFont(new Font("Rale way", Font.BOLD, 22));
        page_label.setBounds(380, 120, 600, 30);
        add(page_label);

        JLabel a_detail = new JLabel("Account Details");
        a_detail.setFont(new Font("Rale way", Font.BOLD, 22));
        a_detail.setBounds(330, 150, 600, 30);
        add(a_detail);

        JLabel acc_type_text = new JLabel("Account Type:");
        acc_type_text.setFont(new Font("Rale way",Font.BOLD,18));
        acc_type_text.setBounds(50,200,200,30);
        add(acc_type_text);

        a1 = new JRadioButton("Saving");
        a1.setFont(new Font("Rale way",Font.BOLD,18));
        a1.setOpaque(false);
        a1.setBounds(200,200,150,30);
        add(a1);

        a2 = new JRadioButton("Checking");
        a2.setFont(new Font("Rale way",Font.BOLD,18));
        a2.setOpaque(false);
        a2.setBounds(350,200,150,30);
        add(a2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(a1);
        buttonGroup.add(a2);

        JLabel card_info = new JLabel("Card Number:");
        card_info.setFont(new Font("Rale way",Font.BOLD,18));
        card_info.setBounds(50,250,200,30);
        add(card_info);

        //set up card field
        JLabel card = new JLabel("The bank system will generate random XXXX-XXXX-XXXX-XXXX");
        card.setFont(new Font("Rale way",Font.BOLD,18));
        card.setBounds(200,250,700,30);
        add(card);

        //display pin text
        JLabel pin_msg = new JLabel("PIN:");
        pin_msg.setFont(new Font("Rale way", Font.BOLD, 18));
        pin_msg.setBounds(50,300,200,30);
        add(pin_msg);

        //set up pin field
        JLabel PIN = new JLabel("The bank system will generate random XXXX");
        PIN.setBounds(200,300,700,30);
        PIN.setFont(new Font("Arial", Font.BOLD, 18));
        add(PIN);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Rale way",Font.BOLD,18));
        services.setBounds(50,350,200,30);
        add(services);

        c1 = new JCheckBox("Deposit",true);
        c1.setOpaque(false);
        c1.setFont(new Font("Rale way",Font.BOLD,18));
        c1.setBounds(50,400,200,30);
        add(c1);

        c2 = new JCheckBox("Withdraw",true);
        c2.setOpaque(false);
        c2.setFont(new Font("Rale way",Font.BOLD,18));
        c2.setBounds(300,400,200,30);
        add(c2);

        c3 = new JCheckBox("Balance",true);
        c3.setOpaque(false);
        c3.setFont(new Font("Rale way",Font.BOLD,18));
        c3.setBounds(50,450,200,30);
        add(c3);

        c4 = new JCheckBox("Pin change",true);
        c4.setOpaque(false);
        c4.setFont(new Font("Rale way",Font.BOLD,18));
        c4.setBounds(300,450,200,30);
        add(c4);

        c5 = new JCheckBox("Mini statement",true);
        c5.setOpaque(false);
        c5.setFont(new Font("Rale way",Font.BOLD,18));
        c5.setBounds(50,500,200,30);
        add(c5);

        c6 = new JCheckBox("Fast cash",true);
        c6.setOpaque(false);
        c6.setFont(new Font("Rale way",Font.BOLD,18));
        c6.setBounds(300,500,200,30);
        add(c6);

        c7 = new JCheckBox("I here by declares that the above entered details correct to the best of my knowledge.",true); //checked by default
        c7.setOpaque(false);;
        c7.setFont(new Font("Rale way",Font.BOLD,16));
        c7.setBounds(50,550,800,20);
        add(c7);

        submit_button = new JButton("Submit");
        submit_button.setFont(new Font("Rale way",Font.BOLD, 16));
        submit_button.setBounds(500,650,90,30);
        submit_button.setOpaque(false);
        submit_button.setContentAreaFilled(false);
        submit_button.addActionListener(this);// this line will evoke the actionPerformed method to get the user input
        add(submit_button);

        cancel_button = new JButton("Cancel");
        cancel_button.setFont(new Font("Rale way",Font.BOLD, 16));
        cancel_button.setBounds(650,650,90,30);
        cancel_button.setOpaque(false);
        cancel_button.setContentAreaFilled(false);
        cancel_button.addActionListener(this);
        add(cancel_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup3_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg_image = new JLabel(i3);
        bg_image.setBounds(0, 0, 850, 800);
        add(bg_image);

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
        String atype = null;
        if (a1.isSelected())
            atype = "Saving Account";
        else if (a2.isSelected())
            atype = "Checking Account";

        Random rand = new Random();
        // Generate the first digit of the card number (must be between 4 and 6 for Visa, Mastercard, and Discover)
        int firstDigit = 4 + rand.nextInt(3); // Random number between 4 and 6 (inclusive)
        // Generate the remaining 15 digits
        StringBuilder cardNumberBuilder = new StringBuilder();
        cardNumberBuilder.append(firstDigit); // Append the first digit
        for (int i = 0; i < 15; i++)
        {
            cardNumberBuilder.append(rand.nextInt(10)); // Append a random digit (0-9)
        }
        String card_no = cardNumberBuilder.toString();

        StringBuilder pinBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++)
        {
            pinBuilder.append(rand.nextInt(10)); // Append a random digit (0-9)
        }
        String pin = pinBuilder.toString();

        String fac = "";
        if(c1.isSelected())
            fac = fac+"Deposit";
        else if (c2.isSelected())
            fac = fac+"Withdraw";
        else if (c3.isSelected())
            fac = fac+"Fast cash";
        else if (c4.isSelected())
            fac = fac+"Balance";
        else if (c5.isSelected())
            fac=fac+"Mini Statement";
        else if (c6.isSelected())
            fac=fac+"Pin change";

        try
        {
            if (e.getSource() == submit_button)
            {
                if (atype.equals("") || !c7.isSelected() || !c6.isSelected() || !c5.isSelected()|| !c4.isSelected()|| !c3.isSelected()|| !c2.isSelected()|| !c1.isSelected())
                    JOptionPane.showMessageDialog(null, "Choose your account type and we offer same service for every account, please select all.");
                else
                {
                    Custom_connection c = new Custom_connection();
                    String query1 = "insert into signup3 values('"+ rand_form_num+"', '"+atype+"','"+card_no+"','"+pin+"','"+fac+"')";
                    String query2 = "insert into login values('"+rand_form_num+"','"+card_no+"','"+pin+"')";
                    c.j_statement.executeUpdate(query1);
                    c.j_statement.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number: " + card_no + "\nPin: " + pin );
                    new Deposit(pin);
                    setVisible(false);
                }
            }
            else if (e.getSource()== cancel_button)
            {
                new Login();
                setVisible(false);
            }
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }

    public static void main(String[]args)
    {
        new Signup3(rand_form_num);
    }

}