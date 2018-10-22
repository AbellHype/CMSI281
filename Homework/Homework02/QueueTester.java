class QueueTester{
	public QueueTester(){
		;
	}

	public static void main(String [] args){
		Queue Test = new Queue(5);
		Test.display();
		Test.insert(5);
		Test.insert(4);
		Test.insert(3);
		Test.insert(2);
		Test.insert(1);
		System.out.println(Test.remove());
		Test.insert(0);
		Test.display();
	}
}
