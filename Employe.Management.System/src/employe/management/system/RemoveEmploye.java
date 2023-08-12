
package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RemoveEmploye extends JFrame implements ActionListener{
    Choice cempid;
    JButton delete,back;
    RemoveEmploye(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lbempid=new JLabel("Employ Id");
        lbempid.setBounds(50,50,100,30);
        add(lbempid);
        
        cempid=new Choice();
        cempid.setBounds(150,50,150,50);
        add(cempid);
        
        try{
          Conn c=new Conn();
          String query="select * from employe";
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next()){
          cempid.add(rs.getString("empid"));
          }
        }catch(Exception e){
          e.printStackTrace();
        }
        JLabel lbname=new JLabel("Name");
        lbname.setBounds(50,100,100,30);
        add(lbname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(150,100,100,30);
        add(lblname);
        
        JLabel lbphone=new JLabel("Phone No.");
        lbphone.setBounds(50,150,100,30);
        add(lbphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(150,150,100,30);
        add(lblphone);
        
        JLabel lbemail=new JLabel("Email Id");
        lbemail.setBounds(50,200,100,30);
        add(lbemail);
        
        JLabel lblEmail=new JLabel();
        lblEmail.setBounds(150,200,200,30);
        add(lblEmail);
        
        try{
        Conn c=new Conn();
        String query ="select * from employe where empid ='"+cempid.getSelectedItem()+"'";
        ResultSet rs=c.s.executeQuery(query);
        while(rs.next()){
          lblname.setText(rs.getString("name"));
          lblphone.setText(rs.getString("phone"));
          lblEmail.setText(rs.getString("email"));

        }
        }catch(Exception e){
        }
        cempid.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ie){
            try{
            Conn c=new Conn();
            String query ="select * from employe where empid ='"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
              lblname.setText(rs.getString("name"));
              lblphone.setText(rs.getString("phone"));
              lblEmail.setText(rs.getString("email"));

            }
            }catch(Exception e){
            }
               }
        });
        delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        add(image);
        
        setSize(1000,400);
        setLocation(250,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==delete){
            try{
             Conn c= new Conn();
             String query="delete from employe where empid = '"+cempid.getSelectedItem()+"'";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Details Deleted Succefully");
             setVisible(false);
            }catch(Exception e){
            e.printStackTrace();
            
            }
        }else{
         setVisible(false);
         new Home();
        }
    
    }
    public static void main(String []args){
        new RemoveEmploye();
    }
}
