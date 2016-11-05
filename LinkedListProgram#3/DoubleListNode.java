/*Name: Taha Rangwala
 * Date: November 2, 2016
 * Purpose: The purpose of this class is to hold all of the information for every single
 * double list node that is in the program.
 */

import java.io.Serializable;//allows for files

//DoubleListNode class header
public class DoubleListNode<T extends Comparable <T>> implements Serializable{

	//Declaring private instance varaibles
	private T value;//generic type value

	private DoubleListNode<T> next;//next value after current

	private DoubleListNode<T> previous;//previous value before current

	//Purpose: This is the constructor method to initialize the private instance variables
	public DoubleListNode() {
		value = null;
		next = null;
		previous = null;
	}

	/*Purpose: This is the constructor method to initialize the private instance variables
	 * @param initValue This is the current value of the node
	 * @param initNext This is the next node after the current node
	 * @param initPrevious This is the previous node before the current node
	 */
	public DoubleListNode(T initValue, DoubleListNode<T> initNext, DoubleListNode<T> initPrevious) {

		value = initValue;

		next = initNext;

		previous = initPrevious;

	}

	/*Purpose: This returns the value of the node
	 * @return This is the generic type of the node
	 */
	public T getValue() {
		return value;
	}

	/*Purpose: This returns the next node
	 * @return This is the next double list node
	 */
	public DoubleListNode<T> getNext() {
		return next;
	}

	/*Purpose: This returns the previous node
	 * @return This is teh previous double list node
	 */
	public DoubleListNode<T> getPrevious() {
		return previous;
	}

	/*Purpose: This methods sets the value of double list node
	 * @param newValue This is the new value being set
	 */
	public void setValue(T newValue) {
		value = newValue;
	}

	/*Purpose: This methods sets the next value of double list node
	 * @param newValue This is the new value being set
	 */
	public void setNext(DoubleListNode<T> newNext) {
		next = newNext;
	}

	/*Purpose: This methods sets the previous value of double list node
	 * @param newValue This is the new value being set
	 */
	public void setPrevious(DoubleListNode<T> newPrevious) {
		previous = newPrevious;
	}

}