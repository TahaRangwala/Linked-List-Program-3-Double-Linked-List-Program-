/*Name: Taha Rangwala
 * Date: November 2, 2016
 * Purpose: This class allows the user to add, delete, and edit data the the user inputs. This class uses information
 * from all of the other classes, and then relays it all back to the main gui.
 */

import java.io.Serializable;//allows for files

//DoubleLinkedList class header
public class DoubleLinkedList<T extends Comparable<T>> implements Serializable {

	//Declaring private instance variables
	private DoubleListNode<T> Head;//Head value of doublelistnode
	private DoubleListNode<T> Current;//Current value of doublelistnode

	/*Purpose: This is the constructor method that initializes the instance variables
	 */
	public DoubleLinkedList() {
		Head = null;
		Current = null;
	}

	/*Purpose: This returns the current value that the program is currently on
	 */
	public DoubleListNode getCurrent() {
		if (Current == null)
			throw new IllegalArgumentException("There Is Nothing In The Program!");
		return Current;
	}

	/*Purpose: This changes the way the data is sorted when the user inputs things
	 */
	public void changeSort() {
		if (Student.sortName)
			Student.sortName = false;
		else
			Student.sortName = true;
		if(Head != null)
			reAdd();
		Current = Head;
	}

	/*Purpose: This readds the values the user inputted before when they change the type of sort
	 */
	public void reAdd() {
		DoubleListNode<T> Temp = Head;
		Head = null;
		while (Temp != null) {
			Add(Temp.getValue());
			Temp = Temp.getNext();
		}
	}

	/*Purpose: This adds a new value to the double linked list
	 * @param Value This is the value that the user is adding to the program
	 */
	public void Add(T Value) {
		if(Head == null){
			Head = new DoubleListNode(Value,null,null);
			Current = Head;
		}
		else{
			DoubleListNode <T> Temp = Head;
			if(Temp.getValue().compareTo(Value) > 0){
				Head = new DoubleListNode(Value,Temp,null);
				Temp.setPrevious(Head);
				Current = Head;
			}
			else{
				while(Temp.getNext() != null){
					if(Temp.getValue().compareTo(Value) > 0){
						Current = new DoubleListNode(Value,Temp,Temp.getPrevious());
						Temp.getPrevious().setNext(Current);
						Temp.setPrevious(Current);
						return;
					}
					Temp = Temp.getNext();
				}
				if(Temp.getValue().compareTo(Value) > 0){
					Current = new DoubleListNode(Value,Temp,Temp.getPrevious());
					Temp.getPrevious().setNext(Current);
					Temp.setPrevious(Current);
				}
				else{
					Temp.setNext(new DoubleListNode(Value,null,Temp));
					Current = Temp.getNext();
				}
			}
		}
	}

	/*Purpose: This deletes a value to the double linked list that the program is currently on
	 */
	public void Delete(){
		if(Head == null){
			throw new IllegalArgumentException("No Students Have Been Inputted");
		}
		else if(!hasPrevious() && !hasNext()){
			Head = null;
			Current = null;
		}
		else if(!hasPrevious()){
			Head = Head.getNext();
			Head.setPrevious(null);
			Current = Head;
		}
		else if(!hasNext()){
			Current = Current.getPrevious();
			Current.setNext(null);
		}
		else{
			Current.getPrevious().setNext(Current.getNext());
			Current.getNext().setPrevious(Current.getPrevious());
			Current = Current.getPrevious();
		}
	}

	/*Purpose: This allows the user to edit the value that the progam is currently on
	 */
	public void Edit(T Value) {
		Delete();
		Add(Value);
	}

	/*Purpose: This returns a boolean value if there is a value before the current value
	 * @return This returns a boolean value of whether or not their is a previous value
	 */
	public boolean hasPrevious(){
		return Current.getPrevious() != null;
	}

	/*Purpose: This returns a boolean value if there is a value after the current value
	 * @return This returns a boolean value of whether or not their is a next value
	 */
	public boolean hasNext() {
		return Current.getNext() != null;
	}

	/*Purpose: This method returns the previous value of the current value and changes the value of the current value
	 * @return This returns a string value of the previous value
	 */
	public String Previous() {
		Current = Current.getPrevious();
		return Current.getValue().toString();
	}

	/*Purpose: This method returns the next value of the current value and changes the value of the current value
	 * @return This returns a string value of the next value
	 */
	public String Next() {
		Current = Current.getNext();
		return Current.getValue().toString();
	}

}
