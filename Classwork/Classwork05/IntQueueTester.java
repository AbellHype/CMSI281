public class IntQueueTester{
	
	IntQueueTester(){
		;
	}

	public static void main(String args[]){
		IntQueue test = new IntQueue();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(4);
		test.push(5);
		System.out.println(test.peek());
		System.out.println(test.remove());
		System.out.println(test.peek());
		System.out.println(test.remove());
		System.out.println(test.peek());
	}	
}
