import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;



/**
 * This program is to display the Producer and Consumer Problem
 * 
 */
public class ProducerConsumer {
	

//     List buffer=Collections.synchronizedList(new LinkedList());
    static List  buffer=new LinkedList();
	int capacity=4;
	
	public static void main(String[] args) throws Exception
	{
		
		ProducerConsumer process=new ProducerConsumer();
		Producer produce=process.new Producer();
		Consumer consume=process.new Consumer();
		
		Thread t1=new Thread(produce);
		Thread t2=new Thread(consume);
		
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
	
	
	
class Producer implements Runnable {
 
  
	@Override
	public void run(){
		// TODO Auto-generated method stub
		synchronized(buffer){
			System.out.println("Producer is running");
			System.out.println("Producer is going to waiting state");
			
			try {
				
				
				
			while(true)	{while (buffer.size() < capacity) {
					
						System.out.println("I am Producing data");
						Random rand=new Random();
						int data=rand.nextInt(10)+1;
						buffer.add(data);
					}
					if (buffer.size() == capacity) {
						System.out.println("Buffer Full, I am going to Wait");
						buffer.notify();
						Thread.sleep(4000);
						buffer.wait();
					
					}
					
			}	
				} catch (Exception e) {

				}

			}
		}

}	

class Consumer extends Thread{
	
	public void run(){
		synchronized(buffer) {
			System.out.println("Consumer started Running.......");
			try{
					while (true) {
						while (buffer.size() > 0) {
							System.out.println("I am Consuming...");
							buffer.remove(0);
						}
						if (buffer.size() == 0) {
							System.out.println("Whoaa!! ...There is nothing. I have to ask producer");
							buffer.notify();
							Thread.sleep(4000);
							buffer.wait();
						
						}
							
						
					}
				} catch (Exception e) {

				}
			
		}
	}	
}

}

