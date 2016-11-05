/*Name: Taha Rangwala
 * Date: November 2, 2016
 * Purpose: The purpose of this class is to relay all of the information from the other classes back to this
 * class so that the user can see it. It allows the user to perform certain tasks and see certain outputs as well.
 */

import javax.swing.*;//allows for more window objects

import BreezySwing.*;//allows for more window objects

import java.awt.*;//allows for more colors

//GUI class header
public class GUI extends GBFrame{

	//Declaring private instance variables
	public static DoubleLinkedList List;//Double Linked List class object
	//Declaring window objects
	private JTextArea outputArea;
	private JButton Add, Previous, Next, Delete, Edit, Sort, deleteAll, saveAndExit;
	
	//Constructor method for initializing instance variables and window objects
	public GUI(){
		List = new DoubleLinkedList();//initializing the double linked list class object
		Add = addButton("Add",1,1,1,1);
		Delete = addButton("Delete",1,2,1,1);
		Sort = addButton("Change Sort",1,4,1,1);
		outputArea = addTextArea("",2,1,4,1);
		Previous = addButton("Previous",3,1,1,1);
		Next = addButton("Next",3,4,1,1);
		Edit = addButton("Edit",4,1,1,1);
		deleteAll = addButton("Delete All",4,2,1,1);
		saveAndExit = addButton("Save and Exit",4,4,1,1);
		Previous.setEnabled(false);
		Next.setEnabled(false);
		SortGUI sortGUI = new SortGUI(this);
		sortGUI.setVisible(true);
		//Checking for any existing files
		try{
			List = (DoubleLinkedList)FileInputOutput.getFile();
			outputArea.setText(List.getCurrent().getValue().toString());
		}
		catch(Exception E){
			List = new DoubleLinkedList();
			outputArea.setText("No Files Exist In The Double Linked List!");
		}
	}
	
	/*Purpose: The purpose of this method is to perform certain tasks according to which button the user clicks
	 * @param buttonObj This is the button object which allows the program to tell which button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Add){
			AddGUI addGUI = new AddGUI(this);
			addGUI.setVisible(true);
			outputArea.setText(List.getCurrent().getValue().toString());
			checkPrevious();
			checkNext();
		}
		else if(buttonObj == Previous){
			outputArea.setText(List.Previous());
			checkPrevious();
			checkNext();
		}
		else if(buttonObj == Next){
			outputArea.setText(List.Next());
			checkNext();
			checkPrevious();
		}
		else if(buttonObj == Delete){
			try{
				List.Delete();
				outputArea.setText(List.getCurrent().getValue().toString());
				checkPrevious();
				checkNext();
			}
			catch(Exception E){
				outputArea.setText(E.getLocalizedMessage());
			}
		}
		else if(buttonObj == Edit){
			try{
				EditGUI editGUI = new EditGUI(this,List.getCurrent());
				editGUI.setVisible(true);
				outputArea.setText(List.getCurrent().getValue().toString());
				checkPrevious();
				checkNext();
			}
			catch(Exception E){
				outputArea.setText(E.getLocalizedMessage());
			}
		}
		else if(buttonObj == Sort){
			try{
				List.changeSort();
				outputArea.setText(List.getCurrent().getValue().toString());
				checkPrevious();
				checkNext();
			}
			catch(Exception E){
				outputArea.setText(E.getLocalizedMessage());
			}
		}
		else if(buttonObj == deleteAll){
			FileInputOutput.Delete("Data.dat");
			outputArea.setText("All Data Has Been Cleared!");
			List = new DoubleLinkedList();
			checkPrevious();
			checkNext();
		}
		else{
			FileInputOutput.write(List);
			this.dispose();
		}
	}
	
	/*Purpose: The purpose of this method is to check if the previous button can be enabled
	 */
	private void checkPrevious(){
		if (!List.hasPrevious())
			Previous.setEnabled(false);
		else
			Previous.setEnabled(true);
	}
	
	/*Purpose: The purpose of this method is to check if the next button can be enabled
	 */
	private void checkNext(){
		if (!List.hasNext())
			Next.setEnabled(false);
		else
			Next.setEnabled(true);
	}
	
	//Main method to set up the GUI
	public static void main (String [] args){
		GUI theMainGUI = new GUI();//GUI object
		theMainGUI.setSize(500,500);//size of the GUI interface
		theMainGUI.setTitle("Taha's Double Linked List Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		//theMainGUI.setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
