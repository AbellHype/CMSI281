// Queue.java
// This class creates a queue
// Written by Matthew Abell and Matthew McPartlab
//2018-10-22
////////////////////////////////////////////////////////////////
class Queue{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;
//--------------------------------------------------------------
    public Queue(int s){ // constructor
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
        }
//--------------------------------------------------------------
    public void insert(long j){ // put item at rear of queue
        if(rear == maxSize-1) // deal with wraparound
            rear = -1;
        queArray[++rear] = j; // increment rear and insert
        nItems++; // one more item
    }
//--------------------------------------------------------------
    public long remove(){ // take item from front of queue
        long temp = queArray[front++]; // get value and incr front
        if(front == maxSize) // deal with wraparound
            front = 0;
        nItems--; // one less item
        return temp;
    }
//--------------------------------------------------------------
    public long peekFront(){ // peek at front of queue
        return queArray[front];
    }
//--------------------------------------------------------------
    public boolean isEmpty(){ // true if queue is empty
        return (nItems==0);
    }
//--------------------------------------------------------------
    public boolean isFull(){ // true if queue is full
        return (nItems==maxSize);
    }
//--------------------------------------------------------------
    public int size(){ // number of items in queue
        return nItems;
    }

    public void display(){ //displays queue from front to rear
        System.out.print("Front of Queue: ");
        if (isEmpty()){
            System.out.println(" ");
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
