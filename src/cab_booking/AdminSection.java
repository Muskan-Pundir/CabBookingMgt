package cab_booking;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AdminSection extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JButton bt1,bt2,bt3,bt4;
    JPanel p1,p2;
    Font f,f1;
    
    AdminSection()
    {
        super("Admin Section");
        setLocation(450,250);
        setSize(400,270);
        
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1=new JLabel("Admin Section");
        bt1=new JButton("Intercity Driver");
        bt2=new JButton("Intracity Driver");
        bt3=new JButton("Transport Driver");
        bt4=new JButton("SignUp");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("cab_booking/Icons/focus.png"));
        Image img2=img.getImage().getScaledInstance(100,180,Image.SCALE_DEFAULT);
        ImageIcon img3=new ImageIcon(img2);
        l2=new JLabel(img3);
        
        l1.setFont(f);
        l2.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        bt3.setFont(f1);
        bt4.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(5,1,10,10));
        p1.add(l1);
        p1.add(bt1);
        p1.add(bt2);
        p1.add(bt3);
        p1.add(bt4);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"Center");
        add(p2,"East");
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            new  Add_InterCity_Driver().setVisible(true);
        }
        if(e.getSource()==bt2)
        {
            new  Add_IntraCity_Driver().setVisible(true);
        }
        if(e.getSource()==bt3)
        {
            new  Add_Transport_Driver().setVisible(true);
        }
        if(e.getSource()==bt4)
        {
            new  Signup().setVisible(true);
            this.setVisible(true);
        }
    }
    public static void main(String[] args) 
    {
        new AdminSection().setVisible(true);
    }
}
