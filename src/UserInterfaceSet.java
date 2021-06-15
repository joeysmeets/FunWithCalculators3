

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class UserInterfaceSet extends UserInterface{
	
	JTextField displaySet2;
	private JTextField displayResult;
	CalcEngineSet<E> calcSet;
	
	public UserInterfaceSet(CalcEngineSet engine) {
		super(engine);
		calcSet = engine;
	}
	
	protected void makeFrame() {
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
	}
}
