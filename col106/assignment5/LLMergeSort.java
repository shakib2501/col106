package col106.assignment5;

import java.util.Comparator;

/*
Implementation of MergeSort Algorithm :
    1. you get linked list of size <=1 you just return the list as it is already sorted
    2. Find mid node using findSplit method(Don't forget to add mid element to globalList before returning it)
    3. Create two LinkedList lt (with head = head and tail = mid) and rt (with head = mid.next and tail = tail)
    4. Now recursively MergSort lt and rt Linked lists(Maintain this order)
    5. Now merge these two lists that we got from recursive calls using given crieteria for ordering
    6. Return merged Linked list
*/

public class LLMergeSort <T extends Comparator>  {

  LinkedList<T>  globalList = new LinkedList<T>();

  //CALL THIS METHOD AFTER EVERY CALL OF findSplit and DO NOT MODIFY THIS METHOD
  public void adjustGlobalPointer(T node){
      globalList.add(node);
  }

  // Utility function to get the middle of the linked list
  public Node<T> findSplit(LinkedList<T>  lst) {
    //find middle node of LL :
    Node<T> middle = lst.getHead();
    //Enter your code here
    Node<T> pointer1 = lst.getHead();
    Node<T> pointer2 = lst.getHead();
    if (lst.getHead() != null) {
      while(pointer1 != null && pointer1.next != null) {
        pointer1 = pointer1.next.next;
        pointer2 = pointer2.next;
      }
      middle = pointer2;
    }

    //!!!!!*****DO NOT REMOVE THIS METHOD CALL (change the argument apprpriately)*****!!!!!
    adjustGlobalPointer(middle.getData()); //Add object of ItemNode after finding mid in each call
    return middle;
  }


  public LinkedList<T>  MergeSort(LinkedList<T>  lst) {
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
    Node<T> middle = findsplit(lst);
    if (lst.getHead() == null || lst.getHead().next == null) {
        return lst;
    }
    LinkedList<T> first_half = new LinkedList<>();
    LinkedList<T> second_half = new LinkedList<>();
    //creating new LinkedLists
    boolean flag = true;
    Node<T> current = lst.getHead();
    while(current != null) {
        if(flag == true) {
            first_half.add(current.getData());
            if (current == middle)
                flag = false;
        }
        else {
            second_half.add(current.getData());
        }
        current = current.next;
    }

    //Now we created two Linkedlist
    first_half = MergeSort(first_half);
    second_half = MergeSort(second_half);

    //Merging two LinkedLists


    return SortedList(first_half, second_half);
  }

  private LinkedList<T> SortedList(LinkedList<T> lst1, LinkedList lst2) {
    // if (lst1 == null) {
    //     return lst2;
    // }
    // else if (lst2 == null) {
    //     return lst1;
    // }
    LinkedList<T> resultList = new LinkedList<>();
    Node<T> current1 = lst1.getHead();
    Node<T> current2 = lst2.getHead();
    while (current1 != null && current2 != null) {
        if (current1.getData() <= current2.getData()) {
            resultList.add(current1.getData());
            current1 = current1.next;
        }
        else{
            resultList.add(current2.getData());
            current2 = current2.next;
        }
    }
    while (current1 == null && current2 != null) {
        resultList.add(current2.getData());
        current2 = current2.next;
    }
    while (current2 == null && current1 != null) {
        resultList.add(current2.getData());
        current2 = current2.next;
    }
    return resultList;
  }

  //DO NOT CALL OR MODIFY THESE METHODS IN YOUR CALL THIS IS FOR USE IN DRIVER CODE
  public LinkedList<T> getGlobalList() {
    return this.globalList;
  }

  public void clearGlobalList(){
    globalList  = new LinkedList<>();
  }

}
