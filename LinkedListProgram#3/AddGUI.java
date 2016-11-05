/*Name: Taha Rangwala
 * Date: November 2, 2016
 * Purpose: The purpose of this dialog box class is to allow the user to add values to the program
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//AddGUI class header
public class AddGUI extends GBDialog{

	//Declaring window objects
	private JLabel firstNameLabel, lastNameLabel, yearLabel, GPALabel;
	private JTextField firstNameField, lastNameField;
	private IntegerField yearField;
	private DoubleField GPAField;
	private JButton Add;
	
	/*Purpose: This is the constructor method of the dialog box class
	 * param F This is the JFrame settings needed for the super class
	 */
	public AddGUI(JFrame F){
		super(F);
		setSize(500,200);
		setTitle("Add A Value");
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
		firstNameLabel = addLabel("First Name",1,1,1,1);
		firstNameField = addTextField("",1,2,1,1);
		lastNameLabel = addLabel("Last Name",1,3,1,1);
		lastNameField = addTextField("",1,4,1,1);
		yearLabel = addLabel("Graduation Year",2,1,1,1);
		yearField = addIntegerField(0,2,2,1,1);
		yearField.setText("");
		GPALabel = addLabel("GPA",2,3,1,1);
		GPAField = addDoubleField(0,2,4,1,1);
		GPAField.setText("");
		Add = addButton("Add",3,2,1,1);
	}
	
	/*Purpose: The purpose of this method is to perform certain tasks according to which button the user clicks
	 * @param buttonObj This is the button object which allows the program to tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		
		if(buttonObj == Add){
			try{
				Student.checkStudentInputs(firstNameField.getText(),lastNameField.getText(),yearField.getNumber(),GPAField.getNumber());
				GUI.List.Add(new Student(firstNameField.getText(),lastNameField.getText(),yearField.getNumber(),GPAField.getNumber()));
				setVisible(false);
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
