import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Menu7 extends Panel implements ActionListener{
  //Frame f;
  Label l1,l2,l3,l4;
  TextField t1;
  JPasswordField t2,t4,t3;
  Button b1,b2;
  Connection con;
  ResultSet rs;
  Statement st;
  {
    try{
      Class.forName("com.mysql.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileshop","root","");
      st= con.createStatement();
  //    JOptionPane.showMessageDialog(null,"connected","",0);
    }
    catch(Exception e){
      JOptionPane.showMessageDialog(null,e,"",0);
    }
  }
  Menu7(){
    //f= new Frame("Password Change");
    setLayout(null);
    Font f= new Font("TimesNewRoman",Font.BOLD,15);
    setFont(f);
    l1= new Label("Username");
    l1.setBounds(100,50,100,20);
    add(l1);
    l2= new Label("Current Password");
    l2.setBounds(100,100,120,20);
    add(l2);
      l3= new Label("New Password");
    l3.setBounds(100,150,120,20);
    add(l3);
    l4= new Label("Confirm");
    l4.setBounds(100,200,100,20);
    add(l4);
    t1= new TextField();
    t1.setBounds(250,50,200,20);
    add(t1);
    t2= new JPasswordField();
    t2.setBounds(250,100,200,20);
    add(t2);
    t3= new JPasswordField();
    t3.setBounds(250,150,200,20);
    add(t3);
    t4= new JPasswordField();
    t4.setBounds(250,200,200,20);
    add(t4);
    b1= new Button("Save");
    b1.setBounds(150,280,100,20);
    add(b1);
    b2= new Button("Cancel");
    b2.setBounds(300,280,100,20);
    add(b2);
    b1.addActionListener(this);
  //  setVisible(true);
  //  setSize(530,530);
  }
  public void actionPerformed(ActionEvent ae){
    Object ob=ae.getSource();
    if(ob==b1){
      String user=t1.getText();
      String pass=t2.getText();
      String npass=t3.getText();
      String npass2= t4.getText();
      String cpass="";
      try{
      rs=st.executeQuery("select * from Login Where Username='"+user+"'");
      if(rs.next()){
        cpass= rs.getString("Password");
      }
      else{
        JOptionPane.showMessageDialog(null,"user not found","",0);
      }
        if(cpass.equals(pass)){
         
          if(npass.equals(npass2)){
            st.executeUpdate("update Login set Password='"+npass+"' where Username ='"+user+"'");
            JOptionPane.showMessageDialog(null,"saved","",0);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t1.requestFocus();
          }
          else{
            JOptionPane.showMessageDialog(null,"Password does not match","",0);
          }
        }
          else{
            JOptionPane.showMessageDialog(null,"Username Password not match","",0);
          }
        }  
        catch(Exception e){ 
          System.out.print(e);
          JOptionPane.showMessageDialog(null,e,"",0);

          }
        }
      }
    }