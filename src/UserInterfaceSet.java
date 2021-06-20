
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joey Smeets and Ruth Wenzel
 * @version 20.06.2021
 */

public class UserInterfaceSet implements ActionListener{

    private JTextField inputA;
    private JTextField inputB;
    private JTextField result;

    private CalcEngineSet calcSet;
    private boolean showingAuthor;
    private JFrame frame;
    private JLabel status;
    
    // constructor
	public UserInterfaceSet(CalcEngineSet engine) {
		calcSet = engine;
		makeFrame();
		frame.setVisible(true);
	}
	
	/**
	 * Creates the interface and adds the buttons and text fields.
	 */
	protected void makeFrame() {
		frame = new JFrame(calcSet.getTitle());

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
	        addButton(buttonPanel, "Union");
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
	
    /**
     * Takes care of the commands with the according method call. 
     * @param event (button pressed in this case).
     * @throws EmptySetException - if a command was called while 
     * 		the required sets are not filled, this exception is thrown.
     */
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
        
        if(command.equals("Union")) {
        	addTextFieldsToSets();
			try {
				result.setText(calcSet.union().toString());
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
        }
        if(command.equals("Subtraction")) {
        	addTextFieldsToSets();
        	try {
				result.setText(calcSet.subtraction().toString());
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
        }
        if(command.equals("Intersection")) {
        	addTextFieldsToSets();
        	try { 
				result.setText(calcSet.intersection().toString());
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
        }
        if(command.equals("Clear All")) {
        	addTextFieldsToSets();
        	try {
				calcSet.clearAll();
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
        }
        if(command.equals("Size set A")) {
        	addTextFieldsToSets();
			try {
				calcSet.GetSizeSetA();
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
        }
        if(command.equals("Size set B")) {
        	addTextFieldsToSets();
			try {
				calcSet.GetSizeSetB();
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
//            try {
//            	calcSet.setB = calcSet.parseStringToSet(inputB.getText());
//				result.setText(calcSet.sizeOfSet(calcSet.setB));
//			} catch (EmptySetException e) {
//				e.printStackTrace();
//			}
        }
        if(command.equals("Clear A")) { 
        	addTextFieldsToSets();
        	try {
				calcSet.clearA();
			} catch (EmptySetException e) {
				e.printStackTrace();
			}
        }
        if(command.equals("Clear B")) {
        	addTextFieldsToSets();
            try {
				calcSet.clearB();
			} catch (EmptySetException e) { 
				e.printStackTrace();
			}
        }
        redisplay();
	}
	
    /**
     * Adds the values in the text boxes and adds them to the corresponding sets.
     */
    public void addTextFieldsToSets() {
    	calcSet.setA = calcSet.parseStringToSet(inputA.getText());
    	calcSet.setB = calcSet.parseStringToSet(inputB.getText());
    }
    
	/**
	 * Redisplays the text fields as a string and removes the square brackets.
	 */
	public void redisplay() {
		inputA.setText(calcSet.setA.toString().replace("[","").replace("]","").replace(" ",""));
        inputB.setText(calcSet.setB.toString().replace("[","").replace("]","").replace(" ",""));
        result.setText(calcSet.setResult.toString().replace("[","").replace("]","").replace(" ",""));
	}
}