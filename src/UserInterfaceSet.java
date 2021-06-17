
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserInterfaceSet<E> extends UserInterface {

	JTextField displaySet2;
	private JTextField displayResult;
	CalcEngineSet<E> calcSet;

	public UserInterfaceSet(CalcEngineSet<E> engine) {
		super(engine);
		calcSet = new CalcEngineSet<E>();
	}

	@Override
	protected void makeFrame() {
	    {
	        frame = new JFrame(calc.getTitle());
	        
	        JPanel contentPane = (JPanel)frame.getContentPane();
	        contentPane.setLayout(new BorderLayout(8, 8));
	        contentPane.setBorder(new EmptyBorder( 10, 10, 10, 10));

	        display = new JTextField();
	        contentPane.add(display, BorderLayout.NORTH);

	        JPanel buttonPanel = new JPanel(new GridLayout(4, 6));
	            addButton(buttonPanel, "7");
	            addButton(buttonPanel, "8");
	            addButton(buttonPanel, "9");
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "+");
	            addButton(buttonPanel, "del");
	            
	            addButton(buttonPanel, "4");
	            addButton(buttonPanel, "5");
	            addButton(buttonPanel, "6");
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "-");
	            addButton(buttonPanel, "?");
	            
	            addButton(buttonPanel, "1");
	            addButton(buttonPanel, "2");
	            addButton(buttonPanel, "3");
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "*");
	            addButton(buttonPanel, "mod");
	            
	            addButton(buttonPanel, "0");
	            buttonPanel.add(new JLabel(" "));
	            buttonPanel.add(new JLabel(" "));
	            buttonPanel.add(new JLabel(" "));
	            addButton(buttonPanel, "/");
	            addButton(buttonPanel, "=");
	            
	        contentPane.add(buttonPanel, BorderLayout.CENTER);

	        status = new JLabel(calc.getAuthor());
	        contentPane.add(status, BorderLayout.SOUTH);

	        frame.pack();
	    }
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		{
	     String command = event.getActionCommand();

	        if(command.equals("0") ||
	           command.equals("1") ||
	           command.equals("2") ||
	           command.equals("3") ||
	           command.equals("4") ||
	           command.equals("5") ||
	           command.equals("6") ||
	           command.equals("7") ||
	           command.equals("8") ||
	           command.equals("9")) {
	            int number = Integer.parseInt(command);
	            calc.numberPressed(number);
	        }
	        else if(command.equals("+")) {
	            calc.plus();
	        }
	        else if(command.equals("-")) {
	            calc.minus();
	        }
	        else if(command.equals("*")) {
	            calc.multiply();
	        }
	        else if(command.equals("/")) {
	            calc.divide();
	        }
	        else if(command.equals("mod")) {
	            calc.modulo();
	        }
	        else if(command.equals("=")) {
	            calc.equals();
	        }
	        else if(command.equals("del")) {
	            calc.clear();
	        }
	        else if(command.equals("?")) {
	            showInfo();
	        }
	        // else unknown command.

	        redisplay();
	    }
	}
	
	@Override
	protected void redisplay() {
		display.setText("" + calc.getDisplayValue());
	}

}
