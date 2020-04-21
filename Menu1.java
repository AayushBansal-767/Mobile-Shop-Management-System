import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class Menu1 extends Panel implements ActionListener{
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
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileshop","root","");
			st=con.createStatement();
			//JOptionPane.showMessageDialog(null,"Connected","",0);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"",0);
		}
	}
	Menu1(){

		setLayout(null);
		Font f= new Font("TimesNewRoman",Font.BOLD,15);
		setFont(f);
		l1=new Label("Mobile ID");
		l1.setBounds(100,20,100,20);
		add(l1);
		l2=new Label("Model No.");
		l2.setBounds(100,60,100,20);
		add(l2);
		l3=new Label("Company");
		l3.setBounds(100,100,100,20);
		add(l3);
		l4=new Label("Amount");
		l4.setBounds(100,140,100,20);
		add(l4);
		l5=new Label("IMEI No.");
		l5.setBounds(100,180,100,20);
		add(l5);
		l10= new Label("Quantity");
		l10.setBounds(100,220,100,20);
		add(l10);
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
        l6= new Label("Color");
        l6.setBounds(100,270,100,20);
        add(l6);
        c1= new Checkbox("Black");
        c1.setBounds(200,290,60,15);
         add(c1);
        c2= new Checkbox("Gold");
        c2.setBounds(290,290,60,15);
        add(c2);
        c3= new Checkbox("Silver");
        c3.setBounds(380,290,60,15);
        add(c3);
        l7= new Label("Features");
        l7.setBounds(100,320,100,20);
        add(l7);
        c4= new Checkbox("Dual Sim");
        c4.setBounds(200,340,120,15);
         add(c4);
        c5= new Checkbox("4g-lte");
        c5.setBounds(340,340,120,15);
        add(c5);
        c6= new Checkbox("Dual Camera");
        c6.setBounds(200,380,120,15);
        add(c6);
        c7= new Checkbox("FingerPrint Scanner");
        c7.setBounds(340,380,180,15);
        add(c7);
        b1= new Button("Submit");
        b1.setBounds(100,450,80,20);
        add(b1);
        b2= new Button("Cancel");
        b2.setBounds(220,450,80,20);
        add(b2);
        b1.addActionListener(this);
		//setBounds(0,0,530,530);
		//setVisible(true);

	}
public void actionPerformed(ActionEvent ae){
	Object ob=ae.getSource();
if(ob==b1){
	try{System.out.print("IN try");
	   int id =Integer.parseInt(t1.getText());
	   String model= t2.getText();
	   String comp=t3.getText();
	   int amt=Integer.parseInt(t4.getText());
	   String color="";
	   String imei=t5.getText();
	   int quant=Integer.parseInt(t6.getText());
       String dualcam,dualsim,fourg,fps;
if(c1.getState()){
		color="Black";
	}
else if(c2.getState()){
		color="Gold";
	}
else if(c3.getState()){
		color="Silver";
	}
if(c4.getState()){
    	dualsim="yes";
    }
    else
    {
    	dualsim="no";
    }
if(c5.getState()){
    	fourg="yes";
    }
    else
    {
    	fourg="no";
    }
if(c6.getState()){
    	dualcam="yes";
    }
    else
    {
    	dualcam="no";
    }
if(c7.getState()){
    	fps="yes";
    }
    else
    {
    	fps="no";
    }
  
   st.execute("insert into mobile(MobileId,ModelNo,CompanyName,Amount,IMEINO,Quantity,Color,DualSim,Fourg,DualCam,FpScan) values("+id+",'"+model+"','"+comp+"',"+amt+",'"+imei+"',"+quant+",'"+color+"','"+dualsim+"','"+fourg+"','"+dualcam+"','"+fps+"')");
      JOptionPane.showMessageDialog(null,"saved","",0);
	t1.setText("");
      t2.setText("");
      t3.setText("");
      t4.setText("");
      t5.setText("");
      t6.setText("");
      c1.setState(false);
      c2.setState(false);
      c3.setState(false);
      c4.setState(false);
      c5.setState(false);
      c6.setState(false);
      c7.setState(false);
    }
 catch(Exception e){
 	JOptionPane.showMessageDialog(null,e,"",0);
      }	
    }
  }
}