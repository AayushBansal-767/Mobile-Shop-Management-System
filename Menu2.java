import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class Menu2 extends Panel implements ActionListener{
	Button b1,b2,b3,b4;
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
        //    JOptionPane.showMessageDialog(null,"Connected","",0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e,"",0);
        }
    }
	Menu2(){
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
        b3= new Button("Find");
        b3.setBounds(340,450,80,20);
        add(b3);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
		//setBounds(0,0,530,530);
		//setVisible(true);

	}
public void actionPerformed(ActionEvent ae){
    Object ob=ae.getSource();

    if(ob==b3){
 //if(b3.getLabel().equals("Find")){

        int a=Integer.parseInt(t1.getText());
    try{
        rs=st.executeQuery("select * from mobile where MobileId="+a+" ");
        if(rs.next()){
            t2.setText(rs.getString("ModelNo"));
            t3.setText(rs.getString("CompanyName"));
            t4.setText(rs.getString("Amount"));
            t5.setText(rs.getString("IMEINO"));
            t6.setText(rs.getString("Quantity"));
            String c=rs.getString("Color");
            if(c.equals("Black")){
                c1.setState(true);
               }
               else {
                if(c.equals("Gold")){
                    c2.setState(true);
                }
                else{
                    if(c.equals("Silver")){
                        c3.setState(true);
                     }
                   }
               }
            String dualsim=rs.getString("DualSim");
            String dualcam=rs.getString("DualCam");
            String fourg=rs.getString("Fourg");
            String fps=rs.getString("FpScan");

           if(dualsim.equals("yes")){
              c4.setState(true);
           }
           else{
             c4.setState(false);
            }
            if(fourg.equals("yes")){
                   c5.setState(true);
            }
            else{
                 c5.setState(false);
            }
            if(dualcam.equals("yes")){
                  c6.setState(true);
           }
            else {
                c6.setState(false);
           }
            if(fps.equals("yes")){

            c7.setState(true);
            }
          else {
           c7.setState(false);
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
       int id =Integer.parseInt(t1.getText());
       String model= t2.getText();
       String comp=t3.getText();
       int amt=Integer.parseInt(t4.getText());
       int quant=Integer.parseInt(t6.getText());
       String color="";
       String imei=t5.getText();
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
    else{
        dualsim="no";
    }
  if(c5.getState()){
        fourg="yes";
    }
    else{
        fourg="no";
    }
  if(c6.getState()){
        dualcam="yes";
    }
    else{
        dualcam="no";
    }
   if(c7.getState()){
        fps="yes";
    }
    else{
        fps="no";
    }
   st.executeUpdate("Update mobile set ModelNo='"+model+"',CompanyName='"+comp+"',Amount="+amt+",IMEINO='"+imei+"',Quantity="+quant+",Color='"+color+"',DualSim ='"+dualsim+"',Fourg='"+fourg+"',DualCam='"+dualcam+"',FpScan='"+fps+"' where MobileId = "+id+" ");
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