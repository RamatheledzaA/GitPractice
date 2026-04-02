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
class Stack {
    private Node head ;
    private int size;
    public Stack(){
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
            return '' ;
        }
        char poppped = head.value;
        head = head.next;
        size--;
        return popped;
    }
    //
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
