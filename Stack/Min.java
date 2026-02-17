import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> min;
public MinStack()
{
    st=new Stack<>();
    min=new Stack<>();
}
public void push(int val)
{
    st.push(val);
    if(min.isEmpty() || min.peek()>=val)
    {
        min.push(val);
    }
}
public void pop()
{
    if (st.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
    if(st.peek().equals(min.peek()))
    {
        min.pop();
    }
        st.pop();

}
public int top()
{
    if (st.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

    return st.peek();
}
public int getmin()
{
    if (min.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
    return min.peek();
}
}
public class Min {

    public static void main(String[] args) {

        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(3);
        ms.push(7);
        ms.push(2);

        System.out.println("Top: " + ms.top());      // 2
        System.out.println("Min: " + ms.getmin());   // 2

        ms.pop();

        System.out.println("Top: " + ms.top());      // 7
        System.out.println("Min: " + ms.getmin());   // 3
    }
}