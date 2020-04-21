import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
//import java.util.*:
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
class Loading{
	Frame f;
	Label l1,l2,l3,l4;
	JProgressBar jpb;
	JLabel jl,jl2;
	ImageIcon img;
Loading(){
	f=new Frame("Loading......");
	f.setLayout(null);
	f.setVisible(true);
	Font f2= new Font("TimesNewRoman",Font.PLAIN,12);
	l4 = new Label("");
	l4.setBounds(550,675,150,20);
f.setBackground(Color.CYAN);
	f.add(l4);
	try{
	DateTimeFormatter dtf=   DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	l4.setText(dtf.format(now));
	l4.setFont(f2);
}
catch(Exception e){
JOptionPane.showMessageDialog(null,e,"",0);
}
	jl=new JLabel();
	jl.setBounds(220,200,300,200);
	img= new ImageIcon("mobile.jfif");
	jl.setIcon(img);
	f.add(jl);
	Font f1= new Font("TimesNewRoman",Font.BOLD,20);
	f.setFont(f1);
	jpb= new JProgressBar(1,100);
	jpb.setBounds(270,450,200,20);
	f.add(jpb);
	l1= new Label("Loading......");
    l1.setBounds(320,420,200,20);
    f.add(l1);
    l2= new Label("www.mobileshop.com");
    l2.setBounds(25,650,220,20);
    f.add(l2);
    l3= new Label("MobileShop Branch SGNR");
    l3.setBounds(510,650,250,20);
    f.add(l3);
	f.setSize(800,700);
	for(int i=1;i<=100;i=i+20){
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"",0);
		}
    jpb.setValue(i);
    }
    f.setVisible(false);
    Login A =new Login();
}
class Login implements ActionListener{
	Frame f;
	Button b1,b2;
	Label l1,l2,l4;
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
			JOptionPane.showMessageDialog(null,"Connected","",1);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"",0);
		}
	}

	Login(){
		f=new Frame("Login Page");
		f.setLayout(null);
		f.setVisible(true);
		Font f2= new Font("TimesNewRoman",Font.PLAIN,12);
	    l4 = new Label("");
	    l4.setBounds(450,550,150,20);
	    f.add(l4);
	    l4.setBackground(Color.lightGray);
	    DateTimeFormatter dtf=   DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    l4.setText(dtf.format(now));
     	l4.setFont(f2);
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
public static void main(String z[]){
	Loading a=new Loading();
}
}