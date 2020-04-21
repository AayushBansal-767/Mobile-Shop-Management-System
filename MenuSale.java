import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
class MenuSale extends Panel implements ActionListener{
	Button b1,b2,b3;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	TextField t1,t2,t3,t4,t5,t6,t8,t7,t10;
	Checkbox c1,c2,c3,c4,c5,c6,c7;
	Connection con;
    Statement st;
    ResultSet rs;
    int tq,a,amount;
    Choice  dd, mm, yy;
    int day,mon,yr;
    String modl="";
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
	MenuSale(){

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
		l7= new Label("Quantity");
		l7.setBounds(100,320,60,20);
        add(l7);
        l8= new Label("Total");
		l8.setBounds(300,320,60,20);
        add(l8);
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
        t7= new TextField();
        t7.setBounds(170,320,100,20);
        add(t7);
        t8= new TextField();
        t8.setBounds(370,320,100,20);
        add(t8);
        l6= new Label("Color");
        l6.setBounds(100,260,100,20);
        add(l6);
        c1= new Checkbox("Black");
        c1.setBounds(200,280,60,15);
         add(c1);
        c2= new Checkbox("Gold");
        c2.setBounds(290,280,60,15);
        add(c2);
        c3= new Checkbox("Silver");
        c3.setBounds(380,280,60,15);
        add(c3);
        b1= new Button("Submit");
        b1.setBounds(100,420,80,20);
        add(b1);
        b2= new Button("Cancel");
        b2.setBounds(220,420,80,20);
        add(b2);
        b3 = new Button("Find");
        b3.setBounds(340,420,80,20);
        add(b3);
        l9= new Label("Date Of Purchase");
        l9.setBounds(100,220,120,20);
        add(l9);
        l10= new Label("Coustmer Id");
        l10.setBounds(100,360,100,20);
        add(l10);
        t10= new TextField();
        t10.setBounds(210,360,100,20);
        add(t10);

    dd = new Choice();
    mm = new Choice();
    yy = new Choice();

    for(int i = 1; i<=31; i++)
    {
        if(i>=1 && i <= 9)
        dd.addItem("0" + i);
        else if(i>=10 && i<=31)
        dd.addItem("" + i);
    }
    for(int i = 1; i<=12; i++)
    {
        if(i>=1 && i <= 9)
        mm.addItem("0" + i);
        else if(i>=10 && i<=12)
        mm.addItem("" + i);
    }   
    for(int i = 1960; i<=2018; i++)
        yy.addItem("" + i);
    dd.setBounds(230,220,60,15);
    add(dd);
    mm.setBounds(300,220,60,15);
    add(mm);
    yy.setBounds(370,220,60,15);
    add(yy);
       b3.addActionListener(this);
       b1.addActionListener(this);
		//setBounds(0,0,530,530);
		//setVisible(true);

	}
	public void actionPerformed(ActionEvent ae){
		Object ob=ae.getSource();
		a= Integer.parseInt(t1.getText());
		//int tq;
		if(ob==b3){
		 a= Integer.parseInt(t1.getText());
			String c="";
			int n= Integer.parseInt(t7.getText());
			if(c1.getState()){
             c="Black";
			}
			else if(c2.getState()){
					c="Gold";
				}
			else if(c3.getState()){
					c="Silver";
			}
			try{
        rs=st.executeQuery("select * from mobile where MobileId="+a+" and Color='"+c+"' and Quantity>="+n+" ");
        if(rs.next()){
        	modl =rs.getString("ModelNo");
        	amount= Integer.parseInt(rs.getString("Amount"));
            t2.setText(modl);
            t3.setText(rs.getString("CompanyName"));
            t4.setText(""+amount);
            t5.setText(rs.getString("IMEINO"));
            tq= Integer.parseInt(rs.getString("Quantity"));
            amount = Integer.parseInt(rs.getString("Amount"));
            int total= n*amount;
            t8.setText(""+total);

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
			int sold= Integer.parseInt(t7.getText());
			int remain=(tq)-(sold);
			day= Integer.parseInt(dd.getSelectedItem());
			mon= Integer.parseInt(mm.getSelectedItem());
			yr= Integer.parseInt(yy.getSelectedItem());
			int cid= Integer.parseInt(t10.getText());

			try{
				st.execute("insert into sale(day,month,year,MobileId,Model,Coustmerid,Amount) value ("+day+","+mon+","+yr+","+a+",'"+modl+"',"+cid+","+amount+")");
			 st.executeUpdate("Update mobile set Quantity="+remain+" where MobileId="+a+" ");
             JOptionPane.showMessageDialog(null,"saved","",0);
           t1.setText("");
           t2.setText("");
           t3.setText("");
           t4.setText("");
           t5.setText("");
          // t6.setText("");
           t8.setText("");
           t7.setText("");
           c1.setState(false);
     	   c2.setState(false);
      	   c3.setState(false);

		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"",0);
		   }
	   }
    }
}