import java.io.PrintWriter;

public class AbstarctData {
	public static void main(String []args) throws Exception{
		PrintWriter outFile = new PrintWriter("Stacks&Queues.txt");
		  	int[] values = {15, 25, 35, 45, 55};
	        Stack<Integer> stack = new Stack<>();

	        System.out.println("Pushing values in order: 15, 25, 35, 45, 55");
	        outFile.println("Pushing values in order: 15, 25, 35, 45, 55");
	        for (int v : values) {
	            stack.push(v);
	            System.out.println("  push(" + v + ")  -> Position/Size = " + stack.size());
	            outFile.println("  push(" + v + ")  -> Position/Size = " + stack.size());
	        }
	        System.out.println("top of stack \npeek() -> " + stack.peek() );
	        System.out.println("isEmpty() -> " + stack.isEmpty());
	        outFile.println("top of stack \npeek() -> " + stack.peek());
	        outFile.println("isEmpty() -> " + stack.isEmpty());
	        outFile.println();
	        System.out.println("Popping all values:");
	        outFile.println("Popping all values:");
	        while (!stack.isEmpty()) {
	            int val = stack.pop();
	            System.out.println("  pop() -> " + val);
	            outFile.println("  pop() -> " + val);
	        }
	        try {
	            stack.peek();
	        } catch (IllegalStateException e) {
	            System.out.println("peek() -> " + e.getMessage());
	            outFile.println("peek() -> " + e.getMessage());
	        }
	        System.out.println("isEmpty() -> " + stack.isEmpty());
	        outFile.println("isEmpty() -> " + stack.isEmpty());
	        System.out.println("Result: The LAST value pushed (55) was the FIRST popped -> LIFO");
	        outFile.println("Result: The LAST value pushed (55) was the FIRST popped -> LIFO");
	        outFile.println();

	        Queue<Integer> queue = new Queue<>();

	        System.out.println("\nEnqueueing values in order: 15, 25, 35, 45, 55");
	        outFile.println("Enqueueing values in order: 15, 25, 35, 45, 55");
	        for (int v : values) {
	            queue.enqueue(v);
	            System.out.println("  enqueue(" + v + ")  -> Position/Size = " + queue.size());
	            outFile.println("  enqueue(" + v + ")  -> Position/Size = " + queue.size());
	        }
	        System.out.println("peek() -> " + queue.peek());
	        System.out.println("isEmpty() -> " + queue.isEmpty());
	        outFile.println("peek() -> " + queue.peek());
	        outFile.println("isEmpty() -> " + queue.isEmpty());
	        System.out.println("Dequeueing all values:");
	        outFile.println("Dequeueing all values:");
	        while (!queue.isEmpty()) {
	            int val = queue.dequeue();
	            System.out.println("  pop() -> " + val);
	            outFile.println("  pop() -> " + val);
	        }
	        System.out.println("isEmpty() -> " + queue.isEmpty());
	        outFile.println("isEmpty() -> " + queue.isEmpty());
	        System.out.println("Result: The FIRST value enqueued (15) was the FIRST dequeued -> FIFO");
	        outFile.println("Result: The FIRST value enqueued (15) was the FIRST dequeued -> FIFO");
	        
	        outFile.close();

	}
	
			
	public static class Stack<Type> {
		private Object[] elements;
		private int last;
		private static final int DEFAULT_CAPACITY = 10;

		public Stack() {
			elements = new Object[DEFAULT_CAPACITY];
			last = -1; 
		}

		public void push(Type item) {
			if (last == elements.length - 1) resize();
			elements[++last] = item;
		}
		

		public Type pop() {
			if (isEmpty()) throw new IllegalStateException("Stack is empty. Cannot pop.");
			Type item = (Type) elements[last];
			elements[last--] = null;
			return item;
		}

		public Type peek() {
			if (isEmpty()) throw new IllegalStateException("Stack is empty. Cannot peek.");
			return (Type) elements[last];
		}

		public boolean isEmpty() {
			return last == -1;
		}

		public int size() {
			return last + 1;
		}

		private void resize() {
			Object[] bigger = new Object[elements.length * 2];
			System.arraycopy(elements, 0, bigger, 0, elements.length);
			elements = bigger;
		}
	}
		    
	// Queue
	public static class Queue<Type> {
		private Object[] elements;
		private int front;   
		private int back;   
		private int size;   
		private static final int DEFAULT_CAPACITY = 10;
		        
		public Queue() {
			elements = new Object[DEFAULT_CAPACITY];
			front = 0;
			back = 0;
			size = 0;
		}
		
		       
		public void enqueue(Type item) {
			if (size == elements.length) resize();
			elements[back] = item;
			back = (back + 1) % elements.length;
			size++;
		}

		public Type dequeue() {
			if (isEmpty()) throw new IllegalStateException("Queue is empty. Cannot dequeue.");
			Type item = (Type) elements[front];
			elements[front] = null;
			front = (front + 1) % elements.length;
			size--;
			return item;
		}

		public Type peek() {
			if (isEmpty()) throw new IllegalStateException("Queue is empty. Cannot peek.");
			return (Type) elements[front];
		}

		public boolean isEmpty() {
			return size == 0;
		}
		
		public int size() {
			return size;
		}

		private void resize() {
			Object[] bigger = new Object[elements.length * 2];
			for (int i = 0; i < size; i++) {
				bigger[i] = elements[(front + i) % elements.length];
			}
			elements = bigger;
			front = 0;
			back = size;
		}
	}
}
