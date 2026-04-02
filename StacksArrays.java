// ramatheledza adzisani 4484298
class Stack {
    static char[] stack;
    static int top;
    static int capacity;
    public Stack( int capacity ){
        this.capacity = capacity ;
        this.top =  -1 ;
        this.stack = new char[capacity];
    }
    // create a push method ( used to insert an new element to a stack
    public static void push (char element){
        if ( top == capacity -1){
            System.out.println("stack is full") ;
            return;
        }
        stack[++top] = element;
    }

    // create  a pop method ( used to removed and element and return the top element from stack
    public char pop(){
        if ( isEmpty()){
            System.out.println("stack is full") ;
            return 0;
        }
        return stack[top--];

    }

    // create a peek method ( used to return the top elememt from the stack)
    public char peek(){
        if ( isEmpty()){
            System.out.println("stack is full") ;
            return 0;
        }
        return stack[top];
    }

    // create isEmpty method to check if the stack is empty or not
    public boolean isEmpty(){
        return top == -1 ;
    }

    // create the size method ( check the number of element in a stack
    public  int size(){
        return top + 1 ;
    }

    // creacte a method that displays the output
    public static void printStack(){
        for( int i = 0 ; i <= top ; i++){
            System.out.println(stack[i]);
        }
    }
}

public class StacksArrays {
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
