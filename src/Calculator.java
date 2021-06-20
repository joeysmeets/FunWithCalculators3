
/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 * 
 * @author Alex and n-c0de-r
 * @version 27.05.2021
 * 
 * @author Joey Smeets and Ruth Wenzel
 * @version 18.06.2021
 */
public class Calculator
{
    private CalcEngineSet engine;
    private UserInterfaceSet gui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator() {
        engine = new CalcEngineSet();
        gui = new UserInterfaceSet(engine);
    } 

//    /**
//     * In case the window was closed, show it again.
//     */
//    public void show()
//    {
//        gui.setVisible(true);
//    }
    
    public static void main(String[] args) {
    	Calculator c = new Calculator();
    }
}