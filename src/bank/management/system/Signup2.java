package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static bank.management.system.Signup1.rand_form_num;

public class Signup2 extends JFrame implements ActionListener
{
    JComboBox<String> religion_box, income_box, edu_box, occup_box, ethnic_box;
    JRadioButton c1,c2,d1,d2,cv1,cv2,l1,l2,m1,m2;
    JButton next_button;
    JTextField text_driver_license;
    Signup2(String rand_form_num)
    {
        super ();

        JLabel header = new JLabel("APPLICATION FORM"+ rand_form_num);
        header.setBounds(160,20,600,40);
        header.setFont(new Font("Rale way",Font.BOLD,38));
        add(header); //add to the frame for display

        JLabel page_label = new JLabel("Page 2");
        page_label.setFont(new Font("Rale way",Font.BOLD, 22));
        page_label.setBounds(380,70,600,30);
        add(page_label);

        JLabel p_detail = new JLabel("Additional Details");
        p_detail.setFont(new Font("Rale way", Font.BOLD,22));
        p_detail.setBounds(330,100,600,30);
        add(p_detail);

        JLabel religion_text = new JLabel("Religion:");
        religion_text.setFont(new Font("Rale way", Font.BOLD,20));
        religion_text.setBounds(50,150,100,30);
        add(religion_text);

        String[] religion_arr = {"Buddhist","Muslim","Catholic", "Christian", "Other"};
        religion_box = new JComboBox<>(religion_arr);
        religion_box.setFont(new Font("Rale way",Font.BOLD,14));
        religion_box.setBounds(190,150,300,30);
        religion_box.setBackground(new Color(252, 117, 76));
        add(religion_box);

        JLabel income_text = new JLabel("Income:");
        income_text.setFont(new Font("Rale way", Font.BOLD,20));
        income_text.setBounds(50,200,100,30);
        add(income_text);

        String[] income_arr = {"Null","less than 25.000$","less than 50.000$", "less than 75.000$", "less than 100.000$","Above 100.000$"};
        income_box = new JComboBox<>(income_arr);
        income_box.setFont(new Font("Rale way",Font.BOLD,14));
        income_box.setBounds(190,200,300,30);;
        income_box.setBackground(new Color(252, 117,76));
        add(income_box);

        JLabel edu_text = new JLabel("Educational:");
        edu_text.setFont(new Font("Rale way", Font.BOLD,20));
        edu_text.setBounds(50,250,150,30);
        add(edu_text);

        String[] educational_arr = {"Non-Graduate","Graduate","Post-Graduate", "Doctorate", "Others"};
        edu_box = new JComboBox<>(educational_arr);
        edu_box.setBackground(new Color(252, 117,76));
        edu_box.setFont(new Font("Rale way",Font.BOLD,14));
        edu_box.setBounds(190,250,300,30);
        add(edu_box);

        JLabel occup_text = new JLabel("Occupation:");
        occup_text.setFont(new Font("Rale way", Font.BOLD,20));
        occup_text.setBounds(50,300,150,30);
        add(occup_text);

        String[] occupation_arr= {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        occup_box = new JComboBox<>(occupation_arr);
        occup_box.setBackground(new Color(252, 117,76));
        occup_box.setFont(new Font("Rale way",Font.BOLD,14));
        occup_box.setBounds(190,300,300,30);
        add(occup_box);

        JLabel ethnic_text = new JLabel("Ethnicity:");
        ethnic_text.setFont(new Font("Rale way", Font.BOLD,20));
        ethnic_text.setBounds(50,350,150,30);
        add(ethnic_text);

        String[] ethnic_arr = {"Caucasian","Asian","African American", "Native American", "Hispanic"};
        ethnic_box = new JComboBox<>(ethnic_arr);
        ethnic_box.setBackground(new Color(252, 117,76));
        ethnic_box.setFont(new Font("Rale way",Font.BOLD,14));
        ethnic_box.setBounds(190,350,300,30);
        add(ethnic_box);

        JLabel labelDl = new JLabel("DLicense:");
        labelDl.setFont(new Font("Rale way", Font.BOLD, 20));
        labelDl.setBounds(50,400,200,30);
        add(labelDl);

        text_driver_license = new JTextField();
        text_driver_license.setFont(new Font("Rale way",Font.BOLD, 14));
        text_driver_license.setBounds(190,400,300,30);
        text_driver_license.setBackground(new Color(252, 117,76));
        add(text_driver_license);

        JLabel senior_text = new JLabel("Are you a senior citizen:");
        senior_text.setFont(new Font("Rale way", Font.BOLD,18));
        senior_text.setBounds(50,450,250,30);
        add(senior_text);

        c1 = new JRadioButton("Yes");
        c1.setBounds(300,450,100,30);
        c1.setOpaque(false);
        c1.setFont(new Font("Rale way", Font.BOLD,14));
        add(c1);

        c2 = new JRadioButton("No");
        c2.setBounds(400,450,100,30);
        c2.setOpaque(false);
        c2.setFont(new Font("Rale way", Font.BOLD,14));
        add(c2);

        JLabel disab_text = new JLabel("Do you have any disability:");
        disab_text.setFont(new Font("Rale way", Font.BOLD,18));
        disab_text.setBounds(50,500,300,30);
        add(disab_text);

        d1 = new JRadioButton("Yes");
        d1.setBounds(300,500,100,30);
        d1.setOpaque(false);
        d1.setFont(new Font("Rale way", Font.BOLD,14));
        add(d1);

        d2 = new JRadioButton("No");
        d2.setBounds(400,500,100,30);
        d2.setOpaque(false);
        d2.setFont(new Font("Rale way", Font.BOLD,14));
        add(d2);

        JLabel convicted_text= new JLabel("Have you ever been convicted of a felony:");
        convicted_text.setFont(new Font("Rale way", Font.BOLD,18));
        convicted_text.setBounds(50,550,400,30);
        add(convicted_text);

        cv1 = new JRadioButton("Yes");
        cv1.setBounds(450,550,100,30);
        cv1.setOpaque(false);
        cv1.setFont(new Font("Rale way", Font.BOLD,14));
        add(cv1);

        cv2 = new JRadioButton("No");
        cv2.setBounds(550,550,100,30);
        cv2.setOpaque(false);
        cv2.setFont(new Font("Rale way", Font.BOLD,14));
        add(cv2);

        JLabel legal_text= new JLabel("Are you legally to work in this country:");
        legal_text.setFont(new Font("Rale way", Font.BOLD,18));
        legal_text.setBounds(50,600,400,30);
        add(legal_text);

        l1 = new JRadioButton("Yes");
        l1.setBounds(450,600,100,30);
        l1.setOpaque(false);
        l1.setFont(new Font("Rale way", Font.BOLD,14));
        add(l1);

        l2 = new JRadioButton("No");
        l2.setBounds(550,600,100,30);
        l2.setOpaque(false);
        l2.setFont(new Font("Rale way", Font.BOLD,14));
        add(l2);

        JLabel military_text= new JLabel("Are you currently serving in the military:");
        military_text.setFont(new Font("Rale way", Font.BOLD,18));
        military_text.setBounds(50,650,400,30);
        add(military_text);

        m1 = new JRadioButton("Yes");
        m1.setBounds(450,650,100,30);
        m1.setOpaque(false);
        m1.setFont(new Font("Rale way", Font.BOLD,14));
        add(m1);

        m2 = new JRadioButton("No");
        m2.setBounds(550,650,100,30);
        m2.setOpaque(false);
        m2.setFont(new Font("Rale way", Font.BOLD,14));
        add(m2);

        ButtonGroup button_group1 = new ButtonGroup(); //used to group radio buttons together so that only one radio button within the group can be selected at a time
        button_group1.add(c1);
        button_group1.add(c2);

        ButtonGroup button_group2 = new ButtonGroup();
        button_group2.add(d1);
        button_group2.add(d2);

        ButtonGroup button_group3 = new ButtonGroup();
        button_group3.add(cv1);
        button_group3.add(cv2);

        ButtonGroup button_group4 = new ButtonGroup();
        button_group4.add(l1);
        button_group4.add(l2);

        ButtonGroup button_group5 = new ButtonGroup();
        button_group5.add(m1);
        button_group5.add(m2);

        next_button = new JButton("Next");
        next_button.setFont(new Font("Rale way",Font.BOLD, 14));
        next_button.setBounds(700,700,90,30);
        next_button.setOpaque(false);
        next_button.setContentAreaFilled(false);
        next_button.addActionListener(this);// this line will evoke the actionPerformed method to get the user input
        add(next_button);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signup2_bg.png"));
        Image i2 = i1.getImage().getScaledInstance(840,800,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg_image = new JLabel(i3);
        bg_image.setBounds(0,0,840,800);
        add(bg_image);

        setLayout(null);
        setSize(850,800);
        setLocation(360,20);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) //actionPerformed method from the ActionListener, get called when users hit next button
    {
        String religion = (String) religion_box.getSelectedItem();
        String income = (String) income_box.getSelectedItem();
        String education_level = (String) edu_box.getSelectedItem();
        String occupation = (String) occup_box.getSelectedItem();
        String ethnicity = (String) ethnic_box.getSelectedItem();
        String driver_license = text_driver_license.getText();

        String senior_citizen = "";
        if (c1.isSelected())
            senior_citizen = "Yes";
        else if (c2.isSelected())
            senior_citizen = "No";

        String disability = "";
        if (d1.isSelected())
            disability = "Yes";
        else if (d2.isSelected())
            disability = "No";

        String convicted = "";
        if (cv1.isSelected())
            convicted = "Yes";
        else if (cv2.isSelected())
            convicted = "No";

        String legal = "";
        if (l1.isSelected())
            legal = "Yes";
        else if (l2.isSelected())
            legal = "No";

        String milatary = "";
        if (m1.isSelected())
            milatary = "Yes";
        else if (m2.isSelected())
            milatary = "No";

        try{
            if (religion.equals("") || income.equals("") || education_level.equals("") || occupation.equals("") || ethnicity.equals("") || driver_license.equals("") || senior_citizen.equals("") || disability.equals("") || convicted.equals("") || legal.equals("") || milatary.equals(""))
                JOptionPane.showMessageDialog(null,"Please fill all the fields");
            else
            {
                Custom_connection c = new Custom_connection();
                String query = "insert into Signup2 values('"+rand_form_num+"', '"+religion+"', '"+income+"','"+education_level+"','"+occupation+"','"+ethnicity+"','"+driver_license+"','"+senior_citizen+"','"+disability+"','"+convicted+"','"+legal+"','"+milatary+"')";
                c.j_statement.executeUpdate(query);
                new Signup3(rand_form_num);
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
        new Signup2(rand_form_num);
    }
}
