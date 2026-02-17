import java.util.*;
//Approach 1 (Single Queue)
class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);

        int size = q.size();

        // Rotate previous elements
        for (int i = 0; i < size - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

//Approach 2 (Two Queues)
class MyStack1 {

    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int topElement = q1.poll();  // last element

        // swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public int top() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int topElement = q1.peek();
        q2.add(q1.poll());

        // swap again
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
public class StackQueue{
public static void main(String[] args) {

        MyStack st = new MyStack();

        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st.top());  // 3
        System.out.println(st.pop());  // 3
        System.out.println(st.empty());  // 2
    }
}