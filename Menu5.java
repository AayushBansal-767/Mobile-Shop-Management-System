
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Menu5 extends Panel implements ActionListener{
	Button b1,b2,b3;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	TextField t1,t2,t3,t4,t5,t6;
	Checkbox c1,c2,c3,c4,c5,c6,c7;
    Connection con;
    Statement st;
    ResultSet rs;
   {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileshop","root","");
            st=con.createStatement();
         //   JOptionPane.showMessageDialog(null,"connected","",0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"",0);
        }
    }
	Menu5(){
		setLayout(null);
        Font f= new Font("TimesNewRoman",Font.BOLD,15);
        setFont(f);
        Font s= new Font("TimesNewRoman",Font.PLAIN,10);
        l1=new Label("Coustmer ID");
        l1.setBounds(100,20,100,20);
        add(l1);
        l2=new Label("Coustmer Name");
        l2.setBounds(100,60,120,20);
        add(l2);
        l3=new Label("Address");
        l3.setBounds(100,100,100,20);
        add(l3);
        l4=new Label("DOB");
        l4.setBounds(100,140,100,20);
        add(l4);
        l5=new Label("Phone No");
        l5.setBounds(100,180,100,20);
        add(l5);
        l6= new Label("Email");
        l6.setBounds(100,220,100,20);
        add(l6);
        l9= new Label("yyyy/mm/dd");
        l9.setBounds(431,140,100,20);
        add(l9);
        l9.setFont(s);
        t1= new TextField();
        t1.setBounds(230,20,200,20);
        add(t1);
        t2= new TextField();
        t2.setBounds(230,60,200,20);
        add(t2);
        t3= new TextField();
        t3.setBounds(230,100,200,20);
        add(t3);
        t4= new TextField();
        t4.setBounds(230,140,200,20);
        add(t4);
        t5= new TextField();
        t5.setBounds(230,180,200,20);
        add(t5);
        t6 = new TextField();
        t6.setBounds(230,220,200,20);
        add(t6);
        l7= new Label("Gender");
        l7.setBounds(100,280,100,20);
        add(l7);
        c1= new Checkbox("Male");
        c1.setBounds(200,310,60,15);
         add(c1);
        c2= new Checkbox("Female");
        c2.setBounds(290,310,70,15);
        add(c2);
        l8= new Label("Payment Mode");
        l8.setBounds(100,370,110,20);
        add(l8);
        c4= new Checkbox("Cash");
        c4.setBounds(200,400,120,15);
         add(c4);
        c5= new Checkbox("Digital");
        c5.setBounds(340,400,120,15);
        add(c5);
        b1= new Button("Delete");
        b1.setBounds(100,450,80,20);
        add(b1);
        b2= new Button("Cancel");
        b2.setBounds(220,450,80,20);
        add(b2);
        b3= new Button("Find");
        b3.setBounds(340,450,80,20);
        add(b3);
        b3.addActionListener(this);
        b1.addActionListener(this);
		//setBounds(0,0,530,530);
		//setVisible(true);

	}
public void actionPerformed(ActionEvent ae){
    Object ob=ae.getSource();
      if(ob==b3){
 //if(b3.getLabel().equals("Find")){

        int a=Integer.parseInt(t1.getText());
    try{
        rs=st.executeQuery("select * from Coustmer where Cid="+a+" ");
        if(rs.next()){
            t2.setText(rs.getString("Cname"));
            t3.setText(rs.getString("Address"));
            t4.setText(rs.getString("Dob"));
            t5.setText(rs.getString("Contact"));
            t6.setText(rs.getString("Email"));
            String c=rs.getString("Gender");
            if(c.equals("male")){
                c1.setState(true);
               }
               else {
                    c2.setState(true);
                }
            String d=rs.getString("Pmod");
             if(d.equals("cash")){
                c4.setState(true);
               }
                if(d.equals("digital")){
                    c5.setState(true);
                }
               JOptionPane.showMessageDialog(null,"Record found","",0);
             }
             else{
                JOptionPane.showMessageDialog(null,"not found","",0);
             }
         }
             catch(Exception e){
                 JOptionPane.showMessageDialog(null,e,"",0);
          }
      }
      if(ob==b1){
          try{
     int a=Integer.parseInt(t1.getText());
     int yy=JOptionPane.showConfirmDialog(null,"Do you wanaa delete","",0);
     if(yy==0){
           st.execute("Delete from Coustmer where Cid="+a+"");
           JOptionPane.showMessageDialog(null,"deleted","",0);
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            c1.setState(false);
            c2.setState(false);
            //c3.setState(false);
             c4.setState(false);
            c5.setState(false);
            }
         }
     catch(Exception e){
        JOptionPane.showMessageDialog(null,e,"",0);
         }
  
      }

   }

}