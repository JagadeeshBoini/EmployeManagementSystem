
package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername,tfpass;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel lbusername=new JLabel("Username");
         lbusername.setBounds(40,20,100,30);
         add(lbusername);
         
          tfusername=new JTextField();
         tfusername.setBounds(150,20,150,30);
         add(tfusername);
        
         JLabel lbpassword=new JLabel("Password");
         lbpassword.setBounds(40,70,100,30);
         add(lbpassword);
         
         tfpass=new JTextField();
         tfpass.setBounds(150,70,150,30);
         add(tfpass);
         
         JButton login=new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        setSize(600,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=tfusername.getText();
            String password=tfpass.getText();
        
            Conn cs=new Conn();
            String query="select * from login where useername = '"+username+"'and password ='"+password+"'";
            ResultSet rs=cs.s.executeQuery(query);
            if(rs.next()){
              setVisible(false);
              //new class
              new Home();
            }else{
            JOptionPane.showMessageDialog(null, "Invalid Username or Password");
            setVisible(false);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    public static void main(String args[]){
    new Login();
    }
}
