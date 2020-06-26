package testu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.Position;

import testu.view2;

public class login extends JFrame implements ActionListener {

  JFrame loginframe = new JFrame();
	
	JPanel textpanel;
    JPanel logpanel;
    JPanel northpanel;
    JPanel westpanel;
    JPanel eastpanel;
    
    JTextField mailtext;
    
    JLabel maillabel, passwordlabel;
    JLabel willfield, westlabel, eastlabel;
    
    JButton submit, fontplus;
    
    JPasswordField passwordtext;
  

    login() {
    	setLayout(new BorderLayout(40, 40));
    	textpanel = new JPanel(new GridLayout(4, 1, 2, 2));
    	logpanel = new JPanel(new BorderLayout());
    	northpanel = new JPanel(new BorderLayout());
    	westpanel = new JPanel(new BorderLayout( 10, 10));
    	eastpanel = new JPanel(new BorderLayout(10, 10));
    	
    	logpanel.setBackground(Color.GRAY);
    	northpanel.setBackground(Color.WHITE);
    	
    	//Hier wurden die definierten Labels/Buttons/TextFields erstellt
        maillabel = new JLabel();
        mailtext = new JTextField();
        passwordtext = new JPasswordField();
        willfield = new JLabel();
        westlabel = new JLabel();
        eastlabel = new JLabel();
        passwordlabel = new JLabel();
        JLabel jimages = new JLabel("");
        submit = new JButton("ANMELDEN");
        fontplus = new JButton("+");
        
        //Die Texte wurden hinzugef¸gt
        maillabel.setText("Mail :");
        passwordlabel.setText("Password :");
        
        //Das Label wurde zum Panel (northpanel) hinzugef¸gt
        northpanel.add(jimages, BorderLayout.CENTER);
        
        //Ein Label wurde zum Westpanel hinzugef¸gt
        westpanel.add(westlabel, BorderLayout.WEST);
        
        eastpanel.add(eastlabel, BorderLayout.EAST);
        
        textpanel.add(maillabel, BorderLayout.SOUTH);
        textpanel.add(mailtext, BorderLayout.SOUTH);
        textpanel.add(passwordlabel, BorderLayout.SOUTH);
        textpanel.add(passwordtext, BorderLayout.SOUTH);

        
        logpanel.add(submit, BorderLayout.EAST);
        logpanel.add(fontplus, BorderLayout.WEST);
        logpanel.add(willfield, BorderLayout.CENTER);
  
        
        willfield.setFont(new Font("Thamona", Font.PLAIN, 14));
        
       willfield.setForeground(Color.RED);
        
    
       
       jimages.setIcon(new ImageIcon("jimages/jimages.png"));
       
       
        
        
       
        add(textpanel, BorderLayout.CENTER);
        add(logpanel, BorderLayout.SOUTH);
        add(northpanel, BorderLayout.NORTH);
        add(westpanel, BorderLayout.WEST);
        add(eastpanel, BorderLayout.EAST);
        
        setTitle("Quiz-Login");
        setSize(500, 400);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fontplus.addActionListener(this);
        submit.addActionListener(this);
    }

    public static void main(String[] args) {
        new start();
    }

  
    public void actionPerformed(ActionEvent e) {
        
    	String userName = mailtext.getText();
        String password = passwordtext.getText();
    	
        if (userName.trim().equals("jan.rosamilia@gmx.ch") && password.trim().equals("corona")) {
        	  view2 frame = new view2();
              frame.setVisible(true);
              setVisible(false);
              
            
        }  {
        	mailtext.setText("");
        	passwordtext.setText("");
        	willfield.setText("Ein Konto mir der Mail: " + userName + " wurde nicht gefunden");
            
        }
        if(e.getSource() == fontplus) {
        	maillabel.setFont(new Font("Thamona", Font.PLAIN, 20));
       	 passwordlabel.setFont(new Font("Thamona", Font.PLAIN, 20));
       	 willfield.setVisible(false);
        }
        	
    	}

		
	}

