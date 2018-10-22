class DeQueueTester{
	public DeQueueTester(){
		;
	}

	public static void main(String [] args){
		DeQueue Test = new DeQueue(10);
		Test.insertLeft(1);
		Test.insertRight(2);
		Test.insertLeft(3);
		Test.insertRight(4);
		Test.insertLeft(8);
		Test.insertLeft(5);
		Test.display();
		long x = Test.removeLeft();
		long y = Test.removeLeft();
		long z = Test.removeRight();
		Test.display();
	}
}
