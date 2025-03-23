public class StringStack {
    int size;
    char[] stack;
    int top;

    public StringStack(int size) {
        stack = new char[size];
        this.size = size;
        int top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(char value) {
        if (!isFull()) {
            stack[++top] = value;
        } else {
            throw new StackOverFlow();
        }
    }

    public char pop() {
        if (isEmpty()) throw new StackUnderFlow();
        else {
            return stack[top--];
        }
    }

    public char peek() {
        if (isEmpty()) throw new StackUnderFlow();
        else {
            return stack[top];
        }
    }

    public void infixToPostFix(String input) {

        //Converting String to String array to exclude Spaces
        String[] tempArray = input.split(" ");
        //Converting String to String Builder to append (req for conversion to char Array)
        StringBuilder tempString = new StringBuilder();
        //Appending stringArray data to stringBuilder
        for (String temp : tempArray) {
            tempString.append(temp);
        }
        //Converting StringBuilder to String
        String combinedString = tempString.toString();
        //converting string to char Array
        char[] infix = combinedString.toCharArray();

        StringBuilder finalExpression = new StringBuilder();
        for (char in : infix) {
            if (isOpeningBracket(in)) {
                push(in);
            } else if (isOperator(in)) {
                if (!isEmpty() && hasHigherPriority(in)) {
                    finalExpression.append(pop());
                }
                push(in);
            } else if (isClosingBracket(in)) {
                if (!isEmpty()) {
                    while (!isOpeningBracket(peek()) && !isEmpty()) {
                        finalExpression.append(pop());
                    }
                    pop();
                } else {
                    throw new UnBalancedExpression();
                }
            } else {
                finalExpression.append(in);
            }
        }
        while (!isEmpty()) {
            finalExpression.append(pop());
        }

        String finalString = finalExpression.toString();

        System.out.println(finalString);
    }

    public boolean isOperator(char input) {
        return switch (input) {
            case '*', '-', '/', '+' -> true;
            default -> false;
        };
    }

    public boolean isOpeningBracket(char op) {
        return op == '(' || op == '{' || op == '[';
    }

    public boolean isClosingBracket(char op) {
        return op == ')' || op == '}' || op == ']';
    }

    public boolean hasHigherPriority(char op) {
        if (isEmpty() || isOpeningBracket(op))
            return false;

        int priorityOfOp = calculatePriority(op);
        int priorityOfTop = calculatePriority(peek());

        return priorityOfTop >= priorityOfOp;
    }

    public boolean balancedParenthesis(char[] input) {
        for (char in : input) {
           if (isOpeningBracket(in)) {
                push(in);
            } else if (isClosingBracket(in)) {
                char topChar = peek();
                    if(isEmpty()|| !compareParenthesis(in,topChar))
                        return false;
                    else pop();
                }
        }
        return isEmpty();
    }

    public boolean compareParenthesis(char in, char top){
        return (in==')' && top =='(' || in == '}' && top == '{' || in == ']' && top == '[');
    }

    public int calculatePriority(char op) {
        return switch (op) {
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> 0;
        };
    }
}
