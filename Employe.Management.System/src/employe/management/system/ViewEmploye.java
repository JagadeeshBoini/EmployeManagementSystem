
package employe.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmploye extends JFrame implements ActionListener{
    JTable tb;
    Choice employid;
    JButton search,print,update,back;
    ViewEmploye(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    tb=new JTable();
    
    JLabel searchemp=new JLabel("Search Employe Details");
    searchemp.setBounds(20,20,150,20);
    add(searchemp);
    
    employid=new Choice();
    employid.setBounds(180,20,150,20);
    add(employid);
    try{
      Conn conn=new Conn();
      ResultSet rs=conn.s.executeQuery("select * from employe");
      while(rs.next()){
        employid.add(rs.getString("empid"));
      }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    try{
      Conn conn=new Conn();
      ResultSet rs=conn.s.executeQuery("select * from employe");
      tb.setModel(DbUtils.resultSetToTableModel(rs));
    }catch(Exception e){
        e.printStackTrace();
    }
    
    JScrollPane jsp=new JScrollPane(tb);
    jsp.setBounds(0,100,900,400);
    add(jsp);
    
    search=new JButton("Search");
    search.setBounds(20,70,80,20);
    search.addActionListener(this);
    add(search);
    
    print=new JButton("Print");
    print.setBounds(120,70,80,20);
    print.addActionListener(this);
    add(print);
    
    update=new JButton("Update");
    update.setBounds(220,70,80,20);
    update.addActionListener(this);
    add(update);
    
    back=new JButton("Back");
    back.setBounds(320,70,80,20);
    back.addActionListener(this);
    add(back);
    
    setSize(900,500);
    setLocation(250,100);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="select * from employe where empid='"+employid.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                tb.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
              e.printStackTrace();
            }
        }else if(ae.getSource()==print){
            try{
                tb.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmploye(employid.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String []args){
       new ViewEmploye();
    }
}
