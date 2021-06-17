

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterfaceSet implements ActionListener{

    private JTextField inputA;
    private JTextField inputB;
    private JTextField result;

    private CalcEngineSet calcSet;
    private JButton union, subtraction, intersection, clearAll, sizeA, sizeB, clearA, clearB;
    private boolean showingAuthor;
    private JFrame frame;
    private JLabel status;

    
	public UserInterfaceSet(CalcEngineSet engine) {
		calcSet = engine;
		makeFrame();
		frame.setVisible(true);
	}
	
	protected void makeFrame() {
		frame = new JFrame(calcSet.getTitle());
//        frame.setMinimumSize(new Dimension(250, 200));

        JPanel contentPane = (JPanel) frame.getContentPane();
	        contentPane.setLayout(new BorderLayout(2, 2));
	        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));        
        
        JPanel textPanel = new JPanel(new GridLayout(2, 1));
	        inputA = new JTextField();
	        textPanel.add(inputA);
	        inputB = new JTextField();
	        textPanel.add(inputB);
	        contentPane.add(textPanel, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4));
	        JButton union = new JButton("Union");
	        buttonPanel.add(union);
	        addButton(buttonPanel, "Subtraction");
	        addButton(buttonPanel, "Intersection");
	        addButton(buttonPanel, "Clear All");
	        
	        addButton(buttonPanel, "Size set A");
	        addButton(buttonPanel, "Size set B");
	        addButton(buttonPanel, "Clear A");        
	        addButton(buttonPanel, "Clear B");
	        contentPane.add(buttonPanel);
       
        result = new JTextField();
        contentPane.add(result, BorderLayout.SOUTH);
        
        status = new JLabel(calcSet.getAuthor());
        
        frame.pack();
	}
	
	/**
     * Add a button to the button panel.
     * @param panel The panel to receive the button.
     * @param buttonText The text for the button.
     */
    protected void addButton(Container panel, String buttonText)
    {
        JButton button = new JButton(buttonText);
        button.addActionListener(this);
        panel.add(button);
    }
	
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
        
        if(command.equals("Union")) {
            try {
				result.setText(calcSet.union().toString());
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        if(command.equals("Subtraction")) {
            try {
				result.setText(calcSet.subtraction().toString());
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(command.equals("Intersection")) {
            try {
				result.setText(calcSet.intersection().toString());
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(command.equals("Union")) {
            try {
				calcSet.clearAll();
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(command.equals("Size set A")) {
            try {
				result.setText(calcSet.sizeOfSet(calcSet.setA));
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(command.equals("Size set B")) {
            try {
				result.setText(calcSet.sizeOfSet(calcSet.setB));
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        if(command.equals("Clear A")) {
            try {
				calcSet.clearA();
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
        }
        if(command.equals("Clear B")) {
            try {
				calcSet.clearB();
			} catch (EmptySetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
        }

        redisplay();
    }
	
	public void redisplay() {
		inputA.setText("" + calcSet.setA);
        inputB.setText("" + calcSet.setB);
        result.setText("" + calcSet.setResult);
	}
	
	/**
     * Toggle the info display in the calculator's status area between the
     * author and version information.
     */
    protected void showInfo()
    {
        if(showingAuthor)
            status.setText(calcSet.getVersion());
        else
            status.setText(calcSet.getAuthor());

        showingAuthor = !showingAuthor;
    }
}
