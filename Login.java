import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Login implements ActionListener{
	Frame f;
	Button b1,b2;
	Label l1,l2;
	TextField t1;
	JPasswordField t2;
	Connection con;
    Statement st;
    ResultSet rs;
	{
		try{
		    Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileshop","root","");
			st=con.createStatement();
			//JOptionPane.showMessageDialog(null,"Connected","",0);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"",0);
		}
	}

	Login(){
		f=new Frame("Login Page");
		f.setLayout(null);
		f.setVisible(true);
		Font f1=new Font("TimesNewRoman",Font.PLAIN,15);
		f.setFont(f1);
		f.setBackground(Color.lightGray);
		b1= new Button("Proceed");
		b1.setBounds(200,400,80,30);
		f.add(b1);
		b2= new Button("Cancel");
		b2.setBounds(360,400,80,30);
		f.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		l1 = new Label("Username");
		l1.setBounds(150,200,100,20);
		f.add(l1);
        l2 = new Label("Password");
		l2.setBounds(150,270,100,20);
		f.add(l2);
		t1= new TextField();
		t1.setBounds(280,200,100,20);
		f.add(t1);
		t2= new JPasswordField();
		t2.setBounds(280,270,100,20);
		f.add(t2);
		f.setSize(600,600);
		//Mobile a= new Mobile();

	}
public void actionPerformed(ActionEvent ae){
	Object ob=ae.getSource();
	if(ob==b1){
		String a,b;
		a=t1.getText();
		b=t2.getText();
    try{
		rs=st.executeQuery("Select * from login where username='"+a+"' and password='"+b+"'");
	if(rs.next()){
		f.setVisible(false);
		Mobile A= new Mobile();
	   }
	else{
		JOptionPane.showMessageDialog(null,"incorrect","",0);
	    }
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null,e,"",0);
       }
    }
    if(ob==b2){
    	System.exit(0);
    }
  }
}
