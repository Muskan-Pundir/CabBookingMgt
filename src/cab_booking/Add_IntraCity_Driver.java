package cab_booking;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class Add_IntraCity_Driver extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JPasswordField pf;
    Font f,f1;
    
    Add_IntraCity_Driver()
    {
        super("Add Intracity Driver");
        setLocation(450,50);
        setSize(450,400);
        
        f=new Font("Arial",Font.BOLD,20);
        f1=new Font("Arial",Font.BOLD,15);
        
        l1=new JLabel("Add Intracity Driver");
        l2=new JLabel("Driver Name");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Car");
        l6=new JLabel("Price");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
              
        bt1=new JButton("Add Intracity Driver");
        bt2=new JButton("Back");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        
        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(l4);
        p2.add(tf3);
        p2.add(l5);
        p2.add(tf4);
        p2.add(l6);
        p2.add(tf5);
        p2.add(bt1);
        p2.add(bt2);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e)
    {
        String name=tf1.getText();
        String source=tf2.getText();
        String destination=tf3.getText();
        String car=tf4.getText();
        String price=tf5.getText();
        
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String q="insert into intracity_driver(driver,source,destination,car,price) values('"+name+"','"+source+"','"+destination+"','"+car+"','"+price+"')";
                int aa=obj.stm.executeUpdate(q);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "your data successfully Inserted");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Plese!, Fill all details carefully");
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new AdminSection().setVisible(true);
        }
    }
    public static void main(String[] args) 
    {
        new Add_IntraCity_Driver().setVisible(true);
    }
}
