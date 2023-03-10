import java.util.LinkedList;
import java.util.Queue;

public class StackQueue<T> {

    Queue<T> stack = new LinkedList<>();
    Queue<T> supportingStack = new LinkedList<>();

    public void push(T value){
        stack.add(value);
    }

    public T pop(){
        if(stack.isEmpty()){
            //throw exception
        }
        while(stack.size()>1){
            supportingStack.add(stack.poll());
        }
        T returnValue = stack.poll();
        //swapping queues finally
        while(!supportingStack.isEmpty()){
            stack.add(supportingStack.poll());
        }
        return returnValue;

    }

    public T peek(){
        if(stack.isEmpty()){
            //throw exception
        }
        while(stack.size()>1){
            supportingStack.add(stack.poll());
        }
        T returnValue = stack.peek();
        while(!supportingStack.isEmpty()){
            stack.add(supportingStack.poll());
        }
        return returnValue;

    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
