// DeQueue.java
// This class creates a double ended queue
// Written by Matthew Abell and Matthew McPartlab
//2018-10-22
////////////////////////////////////////////////////////////////
class DeQueue{
	private int maxSize;
	public long[] queArray;
	private int front;
	private int rear;
	private int nItems;
//--------------------------------------------------------------
	public DeQueue(int s){ // constructor
		maxSize = s;
		queArray = new long[maxSize];
		front = 0; //the front is the right side of the dequeue
		rear = -1; //the rear is the left side of the dequeue
		nItems = 0;
		}
//--------------------------------------------------------------
	public void insertRight(long j){ // put item right side of the dequeue
		if(rear == maxSize-1) // deal with wraparound
			rear = -1;
		queArray[++rear] = j; // increment rear and insert
		nItems++; // one more item
	}
//--------------------------------------------------------------
	public void insertLeft(long j){ // put item left side of the dequeue
		if(front == 0) // deal with wraparound
			front = maxSize;
		queArray[--front] = j; // decrement front and insert
		nItems++; // one more item
	}
//--------------------------------------------------------------
	public long removeLeft(){ // take item from left side of the dequeue
		long temp = queArray[front++]; // get value and incr front
		if(front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}
//--------------------------------------------------------------
	public long removeRight(){ // take item from the right side of the dequeue
		long temp = queArray[rear--]; // get value and decr rear
		if(rear == -1) // deal with wraparound
			front = maxSize;
		nItems--; // one less item
		return temp;
	}
//--------------------------------------------------------------
	public long peekLeft(){ // peek at lesft most value of dequeue
		return queArray[front];
	}
//--------------------------------------------------------------
	public long peekRight(){ // peek at the right most value of the dequeue
		return queArray[rear];
	}
//--------------------------------------------------------------
	public boolean isEmpty(){ // true if dequeue is empty
		return (nItems==0);
	}
//--------------------------------------------------------------
	public boolean isFull(){ // true if dequeue is full
		return (nItems==maxSize);
	}
//--------------------------------------------------------------
	public int size(){ // number of items in dequeue
		return nItems;
	}

	public void display(){ //displays dequeue
        if (isEmpty()){
        	System.out.println(" ");
        }
        else if(rear == -1){   //if insertRight has not been used
        	rear = 0;
        	int i = front;
			while (i != rear){
				System.out.print(queArray[i] + " ");
				i++;
				if (i == maxSize){
					i = 0;
				}
			}
        }
        else{
	        int i = front;
			while (i != rear){
				System.out.print(queArray[i] + " ");
				i++;
				if (i == maxSize){
					i = 0;
				}
			}
			System.out.println(queArray[rear]);
		}
	}
//--------------------------------------------------------------
} // end class Queue
