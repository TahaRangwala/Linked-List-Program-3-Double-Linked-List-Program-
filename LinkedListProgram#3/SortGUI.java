/*Name: Taha Rangwala
 * Date: November 2, 2016
 * Purpose: The purpose of this dialog box class is to allow the user to choose the sort type at the beginning of the program
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//SortGUI class header
public class SortGUI extends GBDialog{

	//Declaring window objects
		private JButton sortName, sortGPA;
		
	/*Purpose: This is the constructor method of the dialog box class
	 * param F This is the JFrame settings needed for the super class
	 */
	public SortGUI(JFrame F) {
		super(F);
		sortName = addButton("Sort By Last Name",1,1,1,1);
		sortGPA = addButton("Sort By GPA",2,1,1,1);
		setTitle("Choose Sort Type");
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
	/*Purpose: The purpose of this method is to perform certain tasks according to which button the user clicks
	 * @param buttonObj This is the button object which allows the program to tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		
		if(buttonObj == sortName){
			Student.sortName = true;
			setVisible(false);
		}
		else{
			Student.sortName = false;
			setVisible(false);
		}
	}
	
}
