package bank.management.system;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TransactionHistory extends JFrame implements ActionListener
{
    private final String PIN;
    JButton back_button;
    TransactionHistory(String pin)
    {
        super();
        this.PIN = pin;

        JLabel card_info = new JLabel();
        card_info.setBounds(150,200,400,19);
        card_info.setFont(new Font("Rale way", Font.BOLD,19));
        add(card_info);

        JLabel transac_statement = new JLabel();
        transac_statement.setBounds(150,250,500,400);
        transac_statement.setFont(new Font("Rale way", Font.BOLD,15));
        add(transac_statement);

        JLabel balance_info = new JLabel();
        balance_info.setBounds(150,650,300,19);
        balance_info.setFont(new Font("Rale way", Font.BOLD,19));
        add(balance_info);

        JPanel content_panel = new JPanel(); // Panel to hold transaction records
        content_panel.setLayout(new BoxLayout(content_panel, BoxLayout.Y_AXIS));
        //we are using BoxLayout with BoxLayout.Y_AXIS alignment.
        //This means that the components added to contentPanel will be arranged vertically
        try
        {
            Custom_connection c = new Custom_connection();
            ResultSet resultSet = c.j_statement.executeQuery("select * from login where pin = '"+PIN+"'");
            while (resultSet.next())
            {
                card_info.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + " XXXX XXXX "+ resultSet.getString("card_number").substring(12));
            }
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }

        try
        {
            int balance = 0;
            Custom_connection c = new Custom_connection();
            ResultSet resultSet = c.j_statement.executeQuery("select * from bank where pin = '"+PIN+"'");
            transac_statement.setText("<html>");
            while (resultSet.next())
            {

                transac_statement.setText(transac_statement.getText() +
                        resultSet.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ //space
                        resultSet.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ //space
                        resultSet.getString("amount")+ "$<br><br>"); //break line
                content_panel.add(transac_statement);

                if (resultSet.getString("type").equals("Deposit") || resultSet.getString("type").equals("Received"))
                    balance += Integer.parseInt(resultSet.getString("amount"));
                else
                    balance -= Integer.parseInt(resultSet.getString("amount"));
            }

            balance_info.setText("Your Total Balance is $ "+balance);
            content_panel.add(balance_info);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane scroll_pane = new JScrollPane(content_panel); // Add contentPanel to JScrollPane
        scroll_pane.setBounds(150, 250, 500, 400); // Set bounds for the scroll pane
        add(scroll_pane);
        //adding contentPanel to a JScrollPane provides scrolling
        //functionality and ensures that all contents of contentPanel are visible

        back_button = new JButton("BACK");
        back_button.setBounds(350,700,150,35);
        back_button.setForeground(Color.BLACK);
        back_button.setBorder(new LineBorder(Color.BLACK));
        back_button.setOpaque(false);
        back_button.setContentAreaFilled(false);
        back_button.addActionListener(this);
        add(back_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/transac.png"));
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
        new TransactionHistory("");
    }
}
