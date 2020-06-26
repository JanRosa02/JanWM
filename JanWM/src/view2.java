package testu;

import java.awt.event.*;
import java.beans.Visibility;
import java.awt.*;

import javax.swing.*;



public class view2 implements ActionListener{

	
	//Hier werden die Fragen definiert
	protected String[] questions = 	{

								"Wie lautet die Hauptstadt von Frankreich?",

								"Welches Dateiformat öffnet man typischerweise mit dem Acrobat Reader?",

								"In welchem Land liegt Ilanz ?",

								"Was ist das wervollste Material?",
								
								"In welcher Sportart ist Eric Ramires ein Profi"
								
							};
	
	//Hier werden die Antwort möglichkeiten definiert
	protected String[][] options = 	{

								{"A: Bern","B: Helsinki","C: Madrid","D: Paris"},

								{"A: PDF","B: BAT","C: EXE","D: ARF"},

								{"A: Schweiz","B: Italien","C: Österreich","D: Deutschland"},

								{"A: Gold","B: Diamant ","C: Palladium","D: Californium 252"},
								
								{"A: Tennis","B: Badminton ","C: Fussball","D: Basketball"}

							};
	//Hier werden die richtige Antworten definiert
	char[] answers = 		{

								'D',

								'B',

								'A',

								'D',
								
								'C'

							};
	char guess;

	char answer;

	int index;

	
	//Variable richtige antworten
	int right_gues =0;

	int total_questions = questions.length;

	//Variable resultat
	int result;

	//Es wird definiert wie lange man zeit hat 
	int seconds=15;

	
	
	//Frame "frame" wird hier definiert
	JFrame frame = new JFrame();
	
	
	//Textfelder
	JTextField textfield = new JTextField();
	
	JTextField number_right = new JTextField();

	JTextField prozent = new JTextField();

	JTextArea textarea = new JTextArea();
	

	//A
	
	JButton buttonA = new JButton();
	JLabel antwort_labelA = new JLabel();
	
	//B
	
	JButton buttonB = new JButton();
	JLabel antwort_labelB = new JLabel();
	
	//C
	
	JButton buttonC = new JButton();
	JLabel antwort_labelC = new JLabel();
	
	//D
	
	JButton buttonD = new JButton();
	JLabel antwort_labelD = new JLabel();
		
	//Jokers
	
	JButton buttonj1 = new JButton();
	JButton buttonj2 = new JButton();
	
	//ExtraButtons
	
	JButton buttonback = new JButton();
	

	//Timer
	JLabel time_label = new JLabel();

	JLabel seconds_left = new JLabel();
	
	Timer timer = new Timer(1000, new ActionListener() {

		

		@Override
		//Der Timer wird hier "eingestellt" 
		public void actionPerformed(ActionEvent e) {

			seconds--;

			seconds_left.setText(String.valueOf(seconds));

			if(seconds<=0) {

				displayAnswer();

			}

			}

		});

	
	
	public view2() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(1200,850);

		frame.getContentPane().setBackground(new Color(50,50,50));

		frame.setLayout(null);

		frame.setResizable(false);

		
		//Frage x von x wird hier definiert
		textfield.setBounds(320,0,500,50);

		textfield.setBackground(Color.BLUE);

		textfield.setForeground(Color.WHITE);

		textfield.setFont(new Font("Verdana",Font.PLAIN,30));

		textfield.setBorder(BorderFactory.createBevelBorder(1));

		textfield.setHorizontalAlignment(JTextField.CENTER);

		textfield.setEditable(false);

		
		//In diesem Area, werden die Fragen eingebettet
		textarea.setBounds(0,50,1200,120);

		textarea.setLineWrap(true);

		textarea.setWrapStyleWord(true);

		textarea.setBackground(new Color(25,25,25));

		textarea.setForeground(Color.WHITE);

		textarea.setFont(new Font("Verdana",Font.PLAIN,27));

		textarea.setBorder(BorderFactory.createBevelBorder(1));

		textarea.setEditable(false);

		
		//Button A wird hier definiert
		buttonA.setBounds(150,300,100,100);

		buttonA.setFont(new Font("Verdana",Font.PLAIN,35));

		buttonA.setFocusable(false);

		buttonA.addActionListener(this);

		buttonA.setText("A");

		
		//Button B wird hier definiert
		buttonB.setBounds(150,500,100,100);

		buttonB.setFont(new Font("Verdana",Font.PLAIN,35));

		buttonB.setFocusable(false);

		buttonB.addActionListener(this);

		buttonB.setText("B");

		
		//Button C wird hier definiert
		buttonC.setBounds(600,300,100,100);

		buttonC.setFont(new Font("Verdana",Font.PLAIN,35));

		buttonC.setFocusable(false);

		buttonC.addActionListener(this);

		buttonC.setText("C");

		
		//Button D wird hier definiert
		buttonD.setBounds(600,500,100,100);

		buttonD.setFont(new Font("Verdana",Font.PLAIN,35));

		buttonD.setFocusable(false);

		buttonD.addActionListener(this);

		buttonD.setText("D");
		

        //Joker Skip
		buttonj1.setBounds(100, 700, 200, 50);
		
		buttonj1.setFont(new Font("Verdana",Font.PLAIN,15));
		
		buttonj1.setFocusable(false);
		
		buttonj1.addActionListener(this);
		
		buttonj1.setText("Joker: Richtige Antwort");
		
		buttonj1.setForeground(Color.ORANGE);
		
	
		//Joker 50/50
		buttonj2.setBounds(600, 700, 200, 50);
		
		buttonj2.setFont(new Font("Verdana",Font.PLAIN,15));
		
		buttonj2.setFocusable(false);
		
		buttonj2.addActionListener(this);

		buttonj2.setText("Joker: Neue Frage");
		
		buttonj2.setForeground(Color.ORANGE);
		
		//Zurück zum Login Button
	    buttonback.setBounds(420, 400, 300, 50);
		
		buttonback.setFont(new Font("Verdana",Font.PLAIN,15));
		
		buttonback.setFocusable(false);
		
		buttonback.addActionListener(this);
		
		buttonback.setText("Zurück zum Login");
		
		buttonback.setVisible(false);
		
		
		//Label für die Antworten werden definiert
		antwort_labelA.setBounds(275,300,500,100);

		antwort_labelA.setBackground(new Color(50,50,50));

		antwort_labelA.setForeground(Color.WHITE);

		antwort_labelA.setFont(new Font("Verdana",Font.PLAIN,25));

		
		//Label für die Antworten werden definiert
		antwort_labelB.setBounds(275,500,500,100);

		antwort_labelB.setBackground(new Color(50,50,50));

		antwort_labelB.setForeground(Color.WHITE);

		antwort_labelB.setFont(new Font("Verdana",Font.PLAIN,25));

		
		//Label für die Antworten werden definiert
		antwort_labelC.setBounds(725,300,500,100);

		antwort_labelC.setBackground(new Color(50,50,50));

		antwort_labelC.setForeground(Color.WHITE);

		antwort_labelC.setFont(new Font("Verdana",Font.PLAIN,25));

		
		//Label für die Antworten werden definiert
		antwort_labelD.setBounds(725,500,500,100);

		antwort_labelD.setBackground(new Color(50,50,50));

		antwort_labelD.setForeground(Color.WHITE);

		antwort_labelD.setFont(new Font("Verdana",Font.PLAIN,25));

		
		//Timer
		seconds_left.setBounds(1000,166,200,850);

		seconds_left.setBackground(new Color(25,25,25));

		seconds_left.setForeground(Color.BLUE);

		seconds_left.setFont(new Font("Verdana",Font.PLAIN,80));

		seconds_left.setBorder(BorderFactory.createBevelBorder(1));

		seconds_left.setOpaque(true);

		seconds_left.setHorizontalAlignment(JTextField.CENTER);

		seconds_left.setText(String.valueOf(seconds));

		

		time_label.setBounds(1000,120,200,50);

		time_label.setBackground(new Color(50,50,50));

		time_label.setForeground(Color.RED);

		time_label.setFont(new Font("Verdana",Font.PLAIN,15));

		time_label.setHorizontalAlignment(JTextField.CENTER);

		time_label.setText("Dein Timer");

		
		//End Resultat des Spielers
		number_right.setBounds(0,600,1200,100);

		number_right.setBackground(new Color(25,25,25));

		number_right.setForeground(Color.GREEN);

		number_right.setFont(new Font("Verdana",Font.PLAIN,30));

		number_right.setBorder(BorderFactory.createBevelBorder(1));

		number_right.setHorizontalAlignment(JTextField.CENTER);

		number_right.setEditable(false);

		

		prozent.setBounds(320,200,500,50);

		prozent.setBackground(new Color(25,25,25));

		prozent.setForeground(Color.GREEN);

		prozent.setFont(new Font("Verdana",Font.PLAIN,30));

		prozent.setBorder(BorderFactory.createBevelBorder(1));

		prozent.setHorizontalAlignment(JTextField.CENTER);

		prozent.setEditable(false);

		
		
		//Hier werden die Labels, Buttons &  Textfield implementiert
		frame.add(time_label);

		frame.add(seconds_left);

		frame.add(antwort_labelA);

		frame.add(antwort_labelB);

		frame.add(antwort_labelC);

		frame.add(antwort_labelD);

		frame.add(buttonA);

		frame.add(buttonB);

		frame.add(buttonC);

		frame.add(buttonD);
		
		frame.add(buttonj1);
		
		frame.add(buttonj2);

		frame.add(buttonback);
		
		frame.add(textarea);

		frame.add(textfield);

		frame.setVisible(true);

		

		nextQuestion();

	}

	public void nextQuestion() {

		

		if(index>=total_questions) {

			results();

		}

		else {

			textfield.setText("Frage nummer: "+(index+1) + " von " + total_questions);

			textarea.setText(questions[index]);

			antwort_labelA.setText(options[index][0]);

			antwort_labelB.setText(options[index][1]);

			antwort_labelC.setText(options[index][2]);

			antwort_labelD.setText(options[index][3]);

			timer.start();

		}

	}

	@Override

	public void actionPerformed(ActionEvent e) {

		

			buttonA.setEnabled(false);

			buttonB.setEnabled(false);

			buttonC.setEnabled(false);

			buttonD.setEnabled(false);

			
			if(e.getSource()==buttonj2) {
			
				right_gues--;
				
	}

			if(e.getSource()==buttonback) {
				login loginframe = new login();
				loginframe.setVisible(true);
				frame.setVisible(false);
			}
			
			if(e.getSource()==buttonj1) {
			
				//Wenn der Joker eingesetzt wird, zählt es als richtige antwort, Der Button kann nicht mehr benutzt werden & es wird ein Dialog angezeigt, welcher die Nutzung des Jokers bestätigt
				right_gues++;
				buttonj1.setVisible(false);
				JOptionPane.showMessageDialog(null,"Du hast erfolgreich einen Joker eingelöst");
			
				
			}

			if(e.getSource()==buttonA) {

				answer= 'A';

				if(answer == answers[index]) {

					//Wenn A richtig ist, wird +1 bei den richtigen Antworten angegeben
					right_gues++;

				}

			}

			if(e.getSource()==buttonB) {

				answer= 'B';

				if(answer == answers[index]) {
					
					//Wenn B richtig ist, wird +1 bei den richtigen Antworten angegeben
					right_gues++;

				}

			}

			if(e.getSource()==buttonC) {

				answer= 'C';

				if(answer == answers[index]) {
					
					//Wenn C richtig ist, wird +1 bei den richtigen Antworten angegeben
					right_gues++;

				}

			}

			if(e.getSource()==buttonD) {

				answer= 'D';

				if(answer == answers[index]) {
					
					//Wenn D richtig ist, wird +1 bei den richtigen Antworten angegeben
					right_gues++;

				}

			}

			displayAnswer();

	}

	public void displayAnswer() {

		
		
		//Hier wird definiert, was passier, wenn der Timer abläuft
		timer.stop();

		
		//Die Buttons sind nicht mehr benutzbar bis der Timer wieder startet
		buttonA.setEnabled(false);

		buttonB.setEnabled(false);

		buttonC.setEnabled(false);

		buttonD.setEnabled(false);

		

		if(answers[index] != 'A')

			antwort_labelA.setForeground(Color.RED);

		if(answers[index] != 'B')

			antwort_labelB.setForeground(Color.RED);

		if(answers[index] != 'C')

			antwort_labelC.setForeground(Color.RED);

		if(answers[index] != 'D')

			antwort_labelD.setForeground(Color.RED);

		

		Timer pause = new Timer(2000, new ActionListener() {

			

			@Override

			public void actionPerformed(ActionEvent e) {

				

				antwort_labelA.setForeground(Color.WHITE);

				antwort_labelB.setForeground(Color.WHITE);
				antwort_labelC.setForeground(Color.WHITE);

				antwort_labelD.setForeground(Color.WHITE);
				

				answer = ' ';

				seconds=15;

				seconds_left.setText(String.valueOf(seconds));

				buttonA.setEnabled(true);

				buttonB.setEnabled(true);

				buttonC.setEnabled(true);

				buttonD.setEnabled(true);

				index++;

				nextQuestion();

			}

		});

		pause.setRepeats(false);

		pause.start();

	}

	public void results(){

		

		buttonA.setEnabled(false);

		buttonB.setEnabled(false);

		buttonC.setEnabled(false);

		buttonD.setEnabled(false);

		

		result = (int)((right_gues/(double)total_questions)*100);

		

		textfield.setText("Dein Resultat!");

		textarea.setText("");
		
		seconds_left.setVisible(false);
		
		time_label.setVisible(false);
	
		antwort_labelA.setText("");
		
		antwort_labelB.setText("");

		antwort_labelC.setText("");

		antwort_labelD.setText("");
		
	    buttonj1.setVisible(false);
	    
	    buttonj2.setVisible(false);
		
		buttonA.setVisible(false);
		
		buttonB.setVisible(false);
		
		buttonC.setVisible(false);
		
		buttonD.setVisible(false);
		
		buttonback.setVisible(true);

		

		number_right.setText("Du hast "+right_gues+" von "+total_questions+" Fragen richtig beantwortet");

		prozent.setText("Du hast " + result+"%" + " erreicht");

		

		frame.add(number_right);

		frame.add(prozent);

		

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
