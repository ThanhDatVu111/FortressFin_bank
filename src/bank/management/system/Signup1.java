package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup1 extends JFrame implements ActionListener
{
    static Random random = new Random(); //static to access from all class
    static long num = Math.abs(random.nextLong() % 9998L) + 1L; //rand form 1 to 9999
    static String rand_form_num = " " + num;   // Java's automatic type conversion feature,
                                  // where if one operand of the + operator is a String,
                                 // the other operand is converted to a String
    JTextField text_name, text_hero, text_email, text_address, text_zip, text_state, text_city;
    JDateChooser dateChooser;
    JRadioButton g1, g2, g3, m1, m2;
    JButton next_button;
    Signup1()
    {
        super ();

        JLabel header = new JLabel("APPLICATION FORM NO."+ rand_form_num);
        header.setBounds(160,20,600,40);
        header.setFont(new Font("Rale way",Font.BOLD,38));
        add(header); //add to the frame for display

        JLabel page_label = new JLabel("Page 1");
        page_label.setFont(new Font("Rale way",Font.BOLD, 22));
        page_label.setBounds(380,70,600,30);
        add(page_label);

        JLabel p_detail = new JLabel("Personal Details");
        p_detail.setFont(new Font("Rale way", Font.BOLD,22));
        p_detail.setBounds(330,100,600,30);
        add(p_detail);

        JLabel label_name = new JLabel("Name:");
        label_name.setFont(new Font("Rale way", Font.BOLD, 20));
        label_name.setBounds(50,150,100,30);
        add(label_name);

        text_name = new JTextField();
        text_name.setFont(new Font("Rale way",Font.BOLD, 14));
        text_name.setBounds(190,150,300,30);
        text_name.setOpaque(false); // Make the text field transparent
        add(text_name);

        JLabel fav_hero = new JLabel("Hero's Name:");
        fav_hero.setFont(new Font("Rale way", Font.BOLD, 20));
        fav_hero.setBounds(50,200,200,30);
        add(fav_hero);

        text_hero = new JTextField();
        text_hero.setFont(new Font("Rale way",Font.BOLD, 14));
        text_hero.setBounds(190,200,300,30);
        text_hero.setOpaque(false); // Make the text field transparent
        add(text_hero);

        JLabel DOB = new JLabel("DOB:");
        DOB.setFont(new Font("Rale way", Font.BOLD, 20));
        DOB.setBounds(50,250,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(190,250,120,30);
        dateChooser.setOpaque(false);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Rale way", Font.BOLD, 20));
        gender.setBounds(50,300,100,30);
        add(gender);

        g1 = new JRadioButton("Male");
        g1.setFont(new Font("Rale way", Font.BOLD,14));
        g1.setOpaque(false);
        g1.setBounds(190,300,80,30);
        add(g1);

        g2 = new JRadioButton("Female");
        g2.setFont(new Font("Rale way", Font.BOLD,14));
        g2.setOpaque(false);
        g2.setBounds(290,300,100,30);
        add(g2);

        g3 = new JRadioButton("Others");
        g3.setFont(new Font("Rale way", Font.BOLD,14));
        g3.setOpaque(false);
        g3.setBounds(400,300,100,30);
        add(g3);

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("Rale way", Font.BOLD, 20));
        labelEmail.setBounds(50,350,200,30);
        add(labelEmail);

        text_email = new JTextField();
        text_email.setFont(new Font("Rale way",Font.BOLD, 14));
        text_email.setBounds(190,350,300,30);
        text_email.setOpaque(false);
        add(text_email);

        JLabel marry_status = new JLabel("Marry Status:");
        marry_status.setFont(new Font("Rale way", Font.BOLD, 20));
        marry_status.setBounds(50,400,200,30);
        add(marry_status);

        m1 = new JRadioButton("Married");
        m1.setBounds(190,400,100,30);
        m1.setOpaque(false);
        m1.setFont(new Font("Rale way", Font.BOLD,14));
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setBounds(290,400,110,30);
        m2.setOpaque(false);
        m2.setFont(new Font("Rale way", Font.BOLD,14));
        add(m2);

        JLabel labelAdd = new JLabel("Address:");
        labelAdd.setFont(new Font("Rale way", Font.BOLD, 20));
        labelAdd.setBounds(50,450,200,30);
        add(labelAdd);

        text_address = new JTextField();
        text_address.setFont(new Font("Rale way",Font.BOLD, 14));
        text_address.setBounds(190,450,300,30);
        text_address.setOpaque(false);
        add(text_address);

        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Rale way", Font.BOLD, 20));
        labelCity.setBounds(50,500,200,30);
        add(labelCity);

        text_city = new JTextField();
        text_city.setFont(new Font("Rale way",Font.BOLD, 14));
        text_city.setBounds(190,500,300,30);
        text_city.setOpaque(false);
        add(text_city);

        JLabel labelZip = new JLabel("Zip Code:");
        labelZip.setFont(new Font("Rale way", Font.BOLD, 20));
        labelZip.setBounds(50,550,200,30);
        add(labelZip);

        text_zip = new JTextField();
        text_zip.setFont(new Font("Rale way",Font.BOLD, 14));
        text_zip.setBounds(190,550,300,30);
        text_zip.setOpaque(false);
        add(text_zip);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Rale way", Font.BOLD, 20));
        labelState.setBounds(50,600,200,30);
        add(labelState);

        text_state = new JTextField();
        text_state.setFont(new Font("Rale way",Font.BOLD, 14));
        text_state.setBounds(190,600,300,30);
        text_state.setOpaque(false);
        add(text_state);

        ButtonGroup button_group1 = new ButtonGroup();
        button_group1.add(g1);
        button_group1.add(g2);
        button_group1.add(g3);

        ButtonGroup button_group2 = new ButtonGroup();
        button_group2.add(m1);
        button_group2.add(m2);

        next_button = new JButton("Next");
        next_button.setFont(new Font("Rale way",Font.BOLD, 14));
        next_button.setBounds(700,700,90,30);
        next_button.setOpaque(false);
        next_button.setContentAreaFilled(false);
        next_button.addActionListener(this);// this line will evoke the actionPerformed method to get the user input
        add(next_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup1_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg_image = new JLabel(i3);
        bg_image.setBounds(0,0,850,800);
        add(bg_image);

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

    public void actionPerformed(ActionEvent e) //actionPerformed method from the ActionListener, get called when users hit next button
    {
        String name = text_name.getText();
        String hero_name = text_hero.getText();
        String date_of_birth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (g1.isSelected())
            gender = "Male";
        else if (g2.isSelected())
            gender = "Female";
        else
            gender = "Other";

        String email = text_email.getText();
        String marry_status = null;
        if (m1.isSelected())
            marry_status = "Married";
        else
            marry_status = "Unmarried";

        String address = text_address.getText();
        String city = text_city.getText();
        String zipcode = text_zip.getText();
        String state = text_state.getText();

        try {
            if (text_name.getText().isEmpty() || text_hero.getText().isEmpty() || text_email.getText().isEmpty() || text_address.getText().isEmpty() || text_city.getText().isEmpty() || text_state.getText().isEmpty() || text_zip.getText().isEmpty())
                JOptionPane.showMessageDialog(null, "Please fill all the fields in the sign up form.");
            else
            {
                Custom_connection c = new Custom_connection();
                // Constructing an SQL INSERT query to add a new record to the signup_data_table
                // with values obtained from form inputs: form_num, name, hero_name, etc.
                String query = "insert into signup1 values('" + rand_form_num + "','" + name + "','" + hero_name + "','" + date_of_birth + "','" + gender + "','" + email + "','" + marry_status + "', '" + address + "', '" + city + "','" + zipcode + "','" + state + "' )";
                c.j_statement.executeUpdate(query); //executing SQL statements that modify the database
                if (e.getSource() == next_button)
                    new Signup2(rand_form_num);
                setVisible(false);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new Signup1();
    }
}
