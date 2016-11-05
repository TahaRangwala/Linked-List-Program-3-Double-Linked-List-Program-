/*Name: Taha Rangwala
 * Date: November 2, 2016
 * Purpose: The purpose of this dialog box class is to allow the user to edit values in the program
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//EditGUI class header
public class EditGUI extends GBDialog{
	
	//Declaring private instance variables
	private DoubleListNode <Student> Current;//current double list node that is being changed
	private JLabel firstNameLabel, lastNameLabel, yearLabel, GPALabel;
	private JTextField firstNameField, lastNameField;
	private IntegerField yearField;
	private DoubleField GPAField;
	private JButton Edit;
	
	/*Purpose: This is the constructor method of the dialog box class
	 * param F This is the JFrame settings needed for the super class
	 * param Current This is the current double list node
	 */
	public EditGUI(JFrame F, DoubleListNode <Student> Current){
		super(F);
		this.Current = Current;
		setSize(500,200);
		setTitle("Edit A Value");
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
		firstNameLabel = addLabel("First Name",1,1,1,1);
		firstNameField = addTextField(Current.getValue().getFirstName(),1,2,1,1);
		lastNameLabel = addLabel("Last Name",1,3,1,1);
		lastNameField = addTextField(Current.getValue().getLastName(),1,4,1,1);
		yearLabel = addLabel("Graduation Year",2,1,1,1);
		yearField = addIntegerField(Current.getValue().getYear(),2,2,1,1);
		GPALabel = addLabel("GPA",2,3,1,1);
		GPAField = addDoubleField(Current.getValue().getGPA(),2,4,1,1);
		Edit = addButton("Edit",3,2,1,1);
	}
	
	/*Purpose: The purpose of this method is to perform certain tasks according to which button the user clicks
	 * @param buttonObj This is the button object which allows the program to tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		
		if(buttonObj == Edit){
			try{
				GUI.List.Edit(new Student(firstNameField.getText(),lastNameField.getText(),yearField.getNumber(),GPAField.getNumber()));
				setVisible(false);
			}
			catch(Exception E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
