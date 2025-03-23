public class Stack {
    public int maxSize;
    public int[] arr;
    public int top;

    public Stack(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        top = -1;
    }

    public void push(int data){
        if(!isFull()){
            arr[++top] = data;
        } else{
            System.out.println("Stack Full");
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("ERROR: Stack is Empty");
            return -9999;
        } else{
            return arr[top--];
        }
    }

    public void printStack(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return;
        }
        System.out.println(" ");
        for(int i=top; i>=0; i--){
            System.out.print(arr[i] +"   ");
        }
    }

    public int topOfStack(){
        if(top!=-1)
            return arr[top];
        else {
            System.out.println("ERROR: Stack is Empty");
            return -999;
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize-1;
    }

//    public void infixToPostfix(String input){
//        StringBuilder postfix = new StringBuilder();
//
//        arr = new int[input.length()];
//
//        String[] infix = input.split(" ");
//
//        for(String in: infix){
//            if(isOpeningBracket(in)){
//                push(Integer.parseInt(in));
//            }
//            else if(isOperator(in)){
//                if(!isEmpty() && hasHigherPriority(in)){
//                    postfix.append(pop());
//                }
//                push(Integer.parseInt(in));
//            } else if(isClosingBracket(in) && !isEmpty()){
//                while (!isOpeningBracket(String.valueOf(topOfStack()))){
//                    postfix.append(pop());
//                }
//                pop();
//            } else if(isClosingBracket(in) && isEmpty()) {
//                System.out.println("Error in expression");
//                return;
//            } else {
//                push(Integer.parseInt(in));
//            }
//        }
//
//        while(!isEmpty()){
//            postfix.append(pop());
//        }
//
//    }


    public int getPriority(String operator){

        return switch (operator){
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    public boolean hasHigherPriority(String in){
        int topOperator = getPriority(String.valueOf(topOfStack()));
            return topOfStack() <= Integer.parseInt(in);

    }

    public boolean isOpeningBracket(String input){
        return input.equals("(") || input.equals("{") || input.equals("[");
    }

    public boolean isClosingBracket(String input){
        return input.equals(")") || input.equals("}") || input.equals("]");
    }
    public void postfixEvaluation(String notation){
        String[] array = notation.split(" ");

        for(String arr: array){
            if(isOperator(arr)){
                if(!isEmpty()){
                    int op2 = pop();
                    int op1 = pop();
                    int res = calculate(arr,op1,op2);
                    if(res!=-111){
                        push(res);
                    }
                } else{
                    System.out.println("There is an error with your expression");
                }
            } else {
                push(Integer.parseInt(arr));
            }
        }
        printStack();
    }

    public void checkPriority(String input){

    }

    public boolean isOperator(String element){
        return element.equals("+") || element.equals("-") || element.equals("/") || element.equals("*");
    }



    public int calculate(String operand, int op1, int op2){

        return switch (operand) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> {
                System.out.println("Invalid operand");
                yield -111;
            }
        };
    }
}
