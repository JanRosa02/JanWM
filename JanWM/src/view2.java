import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class view2 implements ActionListener
{
JFrame fr;
JRadioButton rb1,rb2,rb3,rb4;
JButton b1,b2;
JLabel lb1,lb2;
ButtonGroup bg;
String ques[]={"Was dient nicht zur Verhütung??","capitol of italy"};
String op1[]={"A: Pille","peris"};
String op2[]={"B: Kondom","Delhi"};
String op3[]={"C: Coitus interruptus","Rome"};
String op4[]={"D: Glücksspirale","bern"};
String ans[]={"C: Coitus interruptus","Rome"};
int cn;
view2()
{
fr =new JFrame();
fr.setLayout(null);
fr.setSize(600,600);
Container c=fr.getContentPane();
c.setBackground(Color.GRAY);

lb1=new JLabel(ques[0]);
lb1.setBounds(280,20,300,30);
lb1.setSize(800, 120);
fr.add(lb1);
lb1.setFont(new Font("chiller",Font.BOLD,30));

rb1=new JRadioButton(op1[0]);
rb1.setBounds(100,200,100,30);
rb1.setSize(200, 60);
fr.add(rb1);

rb2=new JRadioButton(op2[0]);
rb2.setBounds(700,200,100,30);
rb2.setSize(200, 60);
fr.add(rb2);
rb3=new JRadioButton(op3[0]);
rb3.setBounds(100,280,100,30);
rb3.setSize(200, 60);
fr.add(rb3);
rb4=new JRadioButton(op4[0]);
rb4.setBounds(700,280,100,30);
rb4.setSize(200, 60);
fr.add(rb4);
bg =new ButtonGroup();
bg.add(rb1);
bg.add(rb2);
bg.add(rb3);
bg.add(rb4);
rb1.addActionListener(this);
rb2.addActionListener(this);
rb3.addActionListener(this);
rb4.addActionListener(this);

b1=new JButton("Next");
b1.setBounds(100,400,100,30);
fr.add(b1);

b2=new JButton("zurück zum Login");
b2.setBounds(250,400,100,30);
fr.add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
fr.setVisible(true);
fr.setSize(1000,800);
fr.setResizable(false);

}

	
public static void main(String s[])
{
new view2 ();

}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1)
{

String en="";
if(rb1.isSelected())
en=rb1.getText();
if(rb2.isSelected())
en=rb2.getText();
if(rb3.isSelected())
en=rb3.getText();
if(rb4.isSelected())
en=rb4.getText();
if(en.equals(ans[cn]))
JOptionPane.showMessageDialog(null,"Right Answer");
else
JOptionPane.showMessageDialog(null,"Wrong Answer");
}
if (e.getSource()==b2)
{
cn++;
lb1.setText(ques[cn]);
rb1.setText(op1[cn]);
rb2.setText(op2[cn]);
rb3.setText(op3[cn]);
rb4.setText(op4[cn]);
}

	
}

public void setVisible(boolean b) {
	
}
}