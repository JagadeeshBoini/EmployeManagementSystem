
package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    JButton addemp,Veiwemp,updateemp,removeemp;
    Home(){
        setLayout(null);
        
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120, 550, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,550);
        add(image);
       
        JLabel heading = new JLabel("Employ Management System");
        heading.setBounds(600,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        
        addemp=new JButton("Add Employe");
        addemp.setBounds(600,80,150,40);
        addemp.addActionListener(this);
        image.add(addemp);
        
        Veiwemp=new JButton("View Employe");
        Veiwemp.setBounds(800,80,150,40);
        Veiwemp.addActionListener(this);
        image.add(Veiwemp);
        
        updateemp=new JButton("Update Empolye");
        updateemp.setBounds(600,140,150,40);
        updateemp.addActionListener(this);
        image.add(updateemp);
        
        removeemp=new JButton("Remove Employe");
        removeemp.setBounds(800,140,150,40);   
        removeemp.addActionListener(this);
        image.add(removeemp);

        
       setSize(1120,550);
       setLocation(100,100);
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addemp){
            setVisible(false);
            new AddEmploye();
       }else if(ae.getSource() == Veiwemp){
           setVisible(false);
            new ViewEmploye();
       }else if(ae.getSource() == updateemp){
           setVisible(false);
            new ViewEmploye();
       }else{
           setVisible(false);
           new RemoveEmploye();
       }
    
    }
    public static void main (String [] args){
      new Home();
    }

   
}
