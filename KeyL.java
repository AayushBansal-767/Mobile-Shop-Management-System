import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class KeyL implements KeyListener{
	Frame f;
	Label l;
	//TextField t;
	KeyL(){
		f= new Frame("KeyListener");
		f.setLayout(null);
		Font f1= new Font("TimesNewRoman",Font.BOLD,250);
		f.setFont(f1);
		l= new Label("");
		l.setBounds(300,300,200,200);
		f.add(l);
	//	t= new TextField();
	//	t.setBounds(100,50,200,30);
	//	f.add(t);
	//	t.addTextListener(this);
		//t.setEnabled(false);
		f.setSize(800,800);
		f.setVisible(true);
		f.addKeyListener(this);
	}
public void keyTyped(KeyEvent ke){
	char c;
	String s= Character.toString(c=ke.getKeyChar());
	l.setText(s);
	}	
public void keyPressed(KeyEvent ke){
	System.out.println("pressed");
}
public void keyReleased(KeyEvent ke){
	System.out.println("release");
}
/*public void textValueChanged(TextEvent te){
	String c=" ";
	c=t.getText();
	l.setText(c);
	t.setText("");

}*/
public static void main(String z[]){
	KeyL a= new KeyL();
}
}