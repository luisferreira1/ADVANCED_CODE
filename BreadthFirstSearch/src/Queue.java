
public class Queue {
	int rear = 0;
	int front = 0;
	int size = 0;
	int queue[];
	public Queue(int size)
	{
		this.size = size;
		queue = new int[size];
	}
	
	public boolean isFull()
	{
		if (rear == front -1)
		{
			return true;
		}
		else if (front == 0 && rear == size -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isEmpty()
	{
		return rear == front; 
	}
	
	public void enqueue(int value)
	{
		if (isFull())
		{
			System.out.println("ERROR! QUEUE FULL!!");
			return;
		}
		
		queue[rear] = value;
		rear++;
		if (rear == size)
		{
			rear = 0;
		}
	}
	
	public int dequeue()
	{
		if (isEmpty())
		{
			System.out.println("ERROR! QUEUE EMPTY!!");
			return 0;
		}
		
		int value = queue[front];
		front++;
		if (front == size)
		{
			front = 0;
		}
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {3,2,5,1,2,5,7,8,89,109};
		Queue queue = new Queue(11);
		for (int i = 0; i < array.length; i++)
		{
			queue.enqueue(array[i]);
		}
		while(!queue.isEmpty())
		{
			System.out.print(queue.dequeue() + " ");
		}
	}

}
