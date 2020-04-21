import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
class Mobile implements ActionListener{
	Frame f;
	MenuBar mb;
	Menu m1,m2,m3,m4,m5;
	MenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15;
	JLabel l1,l2;
	JLabel l3,l4,l5,l6,l7;
	ImageIcon img1,img2,img3,img4;
	JDesktopPane dp;
	Connection con;
    Statement st;
    ResultSet rs;
	{
		try{
		    Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobileshop","root","");
			st=con.createStatement();
			//JOptionPane.showMessageDialog(null,"Connected","",1);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e,"",0);
		}
	}
	Mobile(){
	 f= new Frame("Mobile Info");
	f.setLayout(null);
	Font f2= new Font("TimesNewRoman",Font.PLAIN,12);
	l7 = new JLabel("");
	l7.setBounds(620,721,150,20);
	f.add(l7);
	DateTimeFormatter dtf=   DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	l7.setText(dtf.format(now));
	l7.setFont(f2);
	m1= new Menu("Mobile");
	m2= new Menu("Coustmer");
	m3= new Menu("Login");
	m4= new Menu("View");
	m5 = new Menu("Extra");
	mi1=new MenuItem("New Mobile");
	m1.add(mi1);
	mi2=new MenuItem("Modify Mobile");
	m1.add(mi2);
	mi14= new MenuItem("Sales");
	m1.add(mi14);
	mi15= new MenuItem("Stocks");
	m1.add(mi15);
	mi3=new MenuItem("New Coustmer");
	m2.add(mi3);
	mi4=new MenuItem("Modify Coustmer");
	m2.add(mi4);
	mi5=new MenuItem("Delete");
	m2.add(mi5); 
	mi6=new MenuItem("Logout");
	m3.add(mi6);
	mi7=new MenuItem("Change PASSWORD");
	m3.add(mi7);
	mi8=new MenuItem("MonthWise");
	m4.add(mi8); 
	mi9=new MenuItem("ItemWise");
	m4.add(mi9);
	mi11=new MenuItem("Calculator");
	m5.add(mi11);
	mi12=new MenuItem("Color Changer");
	m5.add(mi12);
	l1= new JLabel("www.mobileshop.com");
	l1.setBounds(30,700,200,20);
	f.add(l1);
	l2= new JLabel("Mobile Shop SGNR Branch");
	l2.setBounds(600,700,200,20);
	f.add(l2);
    l3= new JLabel();
	l3.setBounds(0,120,100,210);
	img1=  new ImageIcon("fn.png");
	l3.setIcon(img1);
	f.add(l3);
	l5= new JLabel();
	l5.setBounds(0,350,100,210);
	img3=  new ImageIcon("fn.png");
	l5.setIcon(img1);
	f.add(l5);
	l4= new JLabel();
	l4.setBounds(700,120,100,210);
	img2=  new ImageIcon("fn.png");
	l4.setIcon(img2);
	f.add(l4);
	l6= new JLabel();
	l6.setBounds(700,350,100,210);
	img4=  new ImageIcon("fn.png");
	l6.setIcon(img4);
	f.add(l6);
	mi1.addActionListener(this);
	mi2.addActionListener(this);
	mi3.addActionListener(this);
	mi4.addActionListener(this);
	mi5.addActionListener(this);
	mi6.addActionListener(this);
	mi7.addActionListener(this);
	mi14.addActionListener(this);
	mi15.addActionListener(this);
	mi8.addActionListener(this);
	mi9.addActionListener(this);
	mi12.addActionListener(this);
	mi11.addActionListener(this);
		mb =new MenuBar();
		f.setMenuBar(mb);
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		dp= new JDesktopPane();
		dp.setBounds(100,100,600,600);
		dp.setBackground(Color.darkGray);
		dp.setLayout(null);
		f.add(dp);
		f.setSize(800,800);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		Object ob=ae.getSource();
	if(ob==mi1){//for newMobile
		    JInternalFrame jif= new JInternalFrame("New Mobile",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
		    Menu1 m= new Menu1();
		   // nm.setLayout(null);
		    m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
		}
	if(ob==mi2){//for Modify
		JInternalFrame jif= new JInternalFrame("Modify Mobile",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
		   Menu2 m=new Menu2(); 
		   // nm.setLayout(null);
			m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
		}
if(ob==mi3){//for Modify
				JInternalFrame jif= new JInternalFrame("New Coustmer",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
		   Menu3 m=new Menu3(); 
		   // nm.setLayout(null);
			m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
		}
if(ob==mi4){//for Modify
		JInternalFrame jif= new JInternalFrame("Modify Coustmer",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
		   Menu4 m=new Menu4(); 
		   // nm.setLayout(null);
			m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
		}
if(ob==mi5){
	JInternalFrame jif= new JInternalFrame("Modify Coustmer",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
			//jif.setVisible(true);
		   Menu5 m=new Menu5(); 
		   // nm.setLayout(null);
			m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
	}
if(ob==mi6){
int yy=JOptionPane.showConfirmDialog(null,"do you wanna logout","",0);
if(yy==0){
	Login l= new Login();
	f.setVisible(false);
  }
}
if(ob==mi7){
	JInternalFrame jif= new JInternalFrame("Change Password",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
		//	jif.setVisible(true);
		    Menu7 m= new Menu7(); 
		   // nm.setLayout(null);
			m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
	
         }
     if(ob==mi14){
         	JInternalFrame jif= new JInternalFrame("Sales",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
		//	jif.setVisible(true);
		  MenuSale m= new MenuSale(); 
		   // nm.setLayout(null);
			m.setBounds(0,0,530,530);
			m.setVisible(true);
			jif.add(m);	
			dp.add(jif);
	
         }
     if(ob==mi15){
         	String h[]={"MobileId","ModelNo","CompanyName","Quantity"};
   	     	String d[][]= new String[50][4];
   	     	int r=0;
         	JInternalFrame jif= new JInternalFrame("Sales",true,true,true,true);
			jif.setLayout(null);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
				try{
   		rs=st.executeQuery("Select * from mobile");
   		
     	while(rs.next()){
   			d[r][0]=rs.getString("MobileId");
   			d[r][1]=rs.getString("ModelNo");
   			d[r][2]=rs.getString("CompanyName");
   			d[r][3]=rs.getString("Quantity");   			
   			r++;
   		}

   		}
        catch(Exception e){
      	JOptionPane.showMessageDialog(null,e,"",0);
         }
          JTable tb=new JTable(d,h);
   		JScrollPane sp= new JScrollPane(tb);
   		sp.setBounds(100,300,500,300);
   		f.add(sp);
   		     sp.setBounds(0,0,530,530);
   	         jif.add(sp);	
		    dp.add(jif);
   		  }
   if(ob==mi8){ 
   	        String[] choices = { "1", "2", "3", "4", "5", "6","7","8","9","10","11","12" };
   		  	int m= Integer.parseInt((String)JOptionPane.showInputDialog(null, "Choose now...","Select Month",JOptionPane.QUESTION_MESSAGE,null,choices,choices[0]));
   		  //	int m= Integer.parseInt(JOptionPane.showInputDialog(null,"enter month","",2));

   		  	String h[]={"MobileId","Model","Coustmerid","amount"};
   	     	String d[][]= new String[50][4];
   	     	int r=0;
         	JInternalFrame jif= new JInternalFrame("MonthWise",true,true,true,true);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
			jif.setVisible(true);
				try{
   		rs=st.executeQuery("Select * from sale where month="+m+" ");
   		
     	while(rs.next()){
   			d[r][0]=rs.getString("MobileId");
   			d[r][1]=rs.getString("Model");
   			d[r][2]=rs.getString("Coustmerid");
   			d[r][3]=rs.getString("amount");   			
   			r++;
   		}

   		}
        catch(Exception e){
      	JOptionPane.showMessageDialog(null,e,"",0);
         }
          JTable tb=new JTable(d,h);
   		JScrollPane sp= new JScrollPane(tb);
   		sp.setBounds(100,300,500,300);
   		f.add(sp);
   		     sp.setBounds(0,0,530,530);
   	         jif.add(sp);	
		    dp.add(jif);
   		     }
   	 if(ob==mi9){
   	 	    String[] choices = { "1", "2", "3", "4", "5", "6","7","8","9","10" };
   		  	int m= Integer.parseInt((String)JOptionPane.showInputDialog(null, "Choose now...","The Choice of a Lifetime",JOptionPane.QUESTION_MESSAGE,null,choices,choices[1]));

   		  	String h[]={"Month","Model","Coustmerid","amount"};
   	     	String d[][]= new String[50][4];
   	     	int r=0;
         	JInternalFrame jif= new JInternalFrame("ItemWise",true,true,true,true);
			if(jif.isVisible()){
			}
			else{
				try{
				jif.setMaximum(true);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,e,"",0);
			}
		}
			jif.setBounds(20,20,560,560);
			//jif.setSize(200,200);
			jif.setVisible(true);
			jif.setVisible(true);
				try{
   		rs=st.executeQuery("Select * from sale where MobileId="+m+" ");
   		
     	while(rs.next()){
   			d[r][0]=rs.getString("month");
   			d[r][1]=rs.getString("Model");
   			d[r][2]=rs.getString("Coustmerid");
   			d[r][3]=rs.getString("amount");   			
   			r++;
   		}

   		}
        catch(Exception e){
      	JOptionPane.showMessageDialog(null,e,"",0);
         }
          JTable tb=new JTable(d,h);
   		JScrollPane sp= new JScrollPane(tb);
   		sp.setBounds(100,300,500,300);
   		f.add(sp);
   		     sp.setBounds(0,0,530,530);
   	         jif.add(sp);	
		    dp.add(jif);
   		     }
   if(ob==mi12){
   	Color intialcolor= Color.lightGray;
   	Color color = JColorChooser.showDialog(dp,"Select a Color",intialcolor);
   	f.setBackground(color);
   	         }
    if(ob==mi11){
            }
   		  }
   	  }
