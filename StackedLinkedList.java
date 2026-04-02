// ramatheledza Adzisani 4484298
class Node{
    char value ;
    Node next ;
    Node ( char value ){
        this.value = value ;
        this.next = null;
    }
}

// create a stack class
class Stack1 {
    private Node head ;
    private int size;
    public Stack1(int i){
        this.head = null;
        this.size = 0;

    }
    // create the push method that insert a new node into the stack
    public void push(char value){
        Node newNode = new Node (value);
        if(head != null){
            newNode .next= head;
        }
        head = newNode;
        size++;
    }
    // create a pop method that detetes or remoe a node from stack and return the top element
    public char pop(){
        if( isEmpty ()){
            return 0;
        }
        char popped = head.value;
        head = head.next;
        size--;
        return popped;
    }
    //create a peek method that returns the top value
    public char peek(){
        if( isEmpty ()){
            return 0 ;
        }
        return head.value;
    }

    // create the isEmpty method
    public boolean isEmpty(){
        return size == 0 ;
    }
    // create a size method
    public int size(){
        return size;
    }
}

public class StackedLinkedList {
    public static void main( String [] args){

        Stack myStack = new Stack(10);
        myStack.push('a');
        myStack.push('d');
        myStack.push('p');
        myStack.push('m');
        myStack.push('k');

        System.out.print("Stacks:  ") ;
        System.out.println();
        System.out.println("Pop :" + myStack.pop());
        System.out.println("Peek :" + myStack.peek());
        System.out.println("isEmpty :" + myStack.isEmpty());
        System.out.println("Size :" + myStack.size());
    }
}
