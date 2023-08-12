
package employe.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmploye extends JFrame implements ActionListener{
    
    
     JTextField tfeducation, tffname, tfaddress, tfphone, tfadhar, tfemail, tfsalary, tfdesignation;
    JLabel lbid;
    JButton addbutton, backbutton;
    String empid;
     UpdateEmploye(String empid){
         this.empid=empid;
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
         
         JLabel heading = new JLabel("Add Employe Details");
         heading.setBounds(320,30,500,50);
         heading.setFont(new Font("serif",Font.BOLD,25));
         add(heading);
         
         JLabel lbname=new JLabel("Name");
         lbname.setBounds(100,100,150,30);
         lbname.setFont(new Font("serif",Font.PLAIN,20));
         add(lbname);
         
          JLabel lblname=new JLabel();
         lblname.setBounds(220,100,150,30);
         add(lblname);
         
         JLabel lbfname=new JLabel("Father's Name");
         lbfname.setBounds(400,100,150,30);
         lbfname.setFont(new Font("serif",Font.PLAIN,20));
         add(lbfname);
         
          tffname=new JTextField();
         tffname.setBounds(550,100,150,30);
         add(tffname);
         
         JLabel lbDob=new JLabel("Date of Birth");
         lbDob.setBounds(100,150,150,30);
         lbDob.setFont(new Font("serif",Font.PLAIN,20));
         add(lbDob);
        
          JLabel dob=new JLabel();
         dob.setBounds(220,150,150,30);
         add(dob);
         
         JLabel lbsalary=new JLabel("Salary");
         lbsalary.setBounds(400,150,150,30);
         lbsalary.setFont(new Font("serif",Font.PLAIN,20));
         add(lbsalary);
         
          tfsalary=new JTextField();
         tfsalary.setBounds(550,150,150,30);
         add(tfsalary);
         
         JLabel lbaddress=new JLabel("Address");
         lbaddress.setBounds(100,200,150,30);
         lbaddress.setFont(new Font("serif",Font.PLAIN,20));
         add(lbaddress);
         
          tfaddress=new JTextField();
         tfaddress.setBounds(220,200,150,30);
         add(tfaddress);
         
         JLabel lbphone=new JLabel("Phone No.");
         lbphone.setBounds(400,200,150,30);
         lbphone.setFont(new Font("serif",Font.PLAIN,20));
         add(lbphone);
         
          tfphone=new JTextField();
         tfphone.setBounds(550,200,150,30);
         add(tfphone);
         
         JLabel lbemail=new JLabel("Email");
         lbemail.setBounds(100,250,150,30);
         lbemail.setFont(new Font("serif",Font.PLAIN,20));
         add(lbemail);
         
          tfemail=new JTextField();
         tfemail.setBounds(220,250,150,30);
         add(tfemail);
         
         JLabel lbHighereducation=new JLabel("Higher Education");
         lbHighereducation.setBounds(400,250,150,30);
         lbHighereducation.setFont(new Font("serif",Font.PLAIN,20));
         add(lbHighereducation);
         
          tfeducation= new JTextField();
         tfeducation.setBounds(550,250,150,30);
         add(tfeducation);
         
         JLabel lbdesignation=new JLabel("Designation");
         lbdesignation.setBounds(100,300,150,30);
         lbdesignation.setFont(new Font("serif",Font.PLAIN,20));
         add(lbdesignation);
         
          tfdesignation=new JTextField();
         tfdesignation.setBounds(220,300,150,30);
         add(tfdesignation);
         
         JLabel lbadhar=new JLabel("Adhar No.");
         lbadhar.setBounds(400,300,150,30);
         lbadhar.setFont(new Font("serif",Font.PLAIN,20));
         add(lbadhar);
         
          JLabel  lbladhar=new JLabel();
         lbladhar.setBounds(550,300,150,30);
         add(lbladhar);
         
         JLabel lbemployeid=new JLabel("Employe Id");
         lbemployeid.setBounds(100,350,150,30);
         lbemployeid.setFont(new Font("serif",Font.PLAIN,20));
         add(lbemployeid);
         
          lbid = new JLabel();
         lbid.setBounds(220,350,150,30);
         lbid.setFont(new Font("serif",Font.PLAIN,20));
         add(lbid);
         
         try{
         Conn c=new Conn();
         String query="select * from employe where empid ='"+empid+"'";
         ResultSet rs=c.s.executeQuery(query);
         while(rs.next()){
         lblname.setText(rs.getString("name"));
         tffname.setText(rs.getString("fname"));
         dob.setText(rs.getString("dob"));
         tfsalary.setText(rs.getString("salary"));
         tfaddress.setText(rs.getString("address"));
         tfphone.setText(rs.getString("phone"));
         tfemail.setText(rs.getString("email"));
         tfeducation.setText(rs.getString("education"));
         tfdesignation.setText(rs.getString("designation"));
         lbladhar.setText(rs.getString("adhar"));
         lbid.setText(rs.getString("empid"));
         }
         }catch(Exception e){
           e.printStackTrace();
         }
        
          addbutton=new JButton("Update Details");
        addbutton.setBounds(250,450,150,30);
        addbutton.setBackground(Color.BLACK);
        addbutton.setForeground(Color.WHITE);
        addbutton.addActionListener(this);
        add(addbutton);
        
         backbutton=new JButton("Back");
        backbutton.setBounds(450,450,150,30);
        backbutton.setBackground(Color.BLACK);
        backbutton.setForeground(Color.WHITE);
        backbutton.addActionListener(this);
        add(backbutton);
        
        
       setSize(900,550);
       setLocation(200,50);
       setVisible(true);
     }
     
   public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==addbutton){
               String fname =tffname.getText();
               String salary=tfsalary.getText();
               String address=tfaddress.getText();
               String phone=tfphone.getText();
               String email=tfemail.getText();
               String education= tfeducation.getText();
               String designation=tfdesignation.getText();
               
               try{
                 Conn conn=new Conn();
                String query="update employe set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where empid='"+empid+"'";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Details Updated Succesfully");
                 setVisible(false);
                 new Home();
               }catch(Exception e){
                   e.printStackTrace();
               }
           }else{
                setVisible(false);
                new Home();
           }
     }
//     
    public static void main(String []args){
         new UpdateEmploye("");
    }
}

