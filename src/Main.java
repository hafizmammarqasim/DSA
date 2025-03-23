//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

//    public static Stack nextGreaterElement(Stack stack){
//        Stack finalStack = new Stack(stack.maxSize);
//        int[] tempStack = new int[stack.maxSize];
//        int counter=0;
//        boolean status;
//        int temp;
//
//       while (!stack.isEmpty())
//           tempStack[counter++] = stack.pop();
//        while (!stack.isEmpty()){
//            tempStack = stack;
//            status = false;
//            tempStack.pop();
//            while (!tempStack.isEmpty()){
//                temp = tempStack.pop();
//                if(stack.topOfStack() < temp) {
//                    finalStack.push(temp);
//                    status = true;
//                    break;
//                }
//            }
//            if(!status){
//                stack.pop();
//                finalStack.push(-1);
//            }
//        }
//        return finalStack;
//
//    }

    public static void main(String[] args) {

        Stack stack = new Stack(10);

        stack.printStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        stack.push(100);

        stack.printStack();

//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.pop();
//        stack.printStack();

        stack.push(100);
        stack.push(200);

        stack.printStack();

        Stack stack2 = new Stack(20);

        stack2.postfixEvaluation("2 3 + 8 8 + *");

        Stack stack3 = new Stack(10);
        stack3.postfixEvaluation("2 3 * 5 4 * + 9 -");


//        Stack nextGreaterElement = nextGreaterElement(stack);
//        nextGreaterElement.printStack();

        }
}
