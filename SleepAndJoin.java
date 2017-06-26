

/*This class helps in understanding the concepts of methods like Join, Sleep, Wait
 * We are Running Two Threads processThread1 and process2Thread 
 * We have used two different methods of creating threads one by implementing Runnable and other extending Thread Class
 * 
 * Sleep() and yield() are Static Thread Class methods
 * join() is Instance Thread Class method
 * uncomment
 */

public class SleepAndJoin {

	
	public  String sharedString="I am a Shared String";
	
	class RunProcess1 implements Runnable{
		
		
		
		public void run() {
			
			for(int i=0; i <5; i++)
			{
				try {
					Thread.sleep(2000);
					System.out.println("RunProcess1 =>"+i);
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 synchronized(sharedString)
			 {
				 try {
					 
					 System.out.println("RunProcess1 is reading the String "+ sharedString); 
					 sharedString.wait();
					 System.out.println("RunProcess1 waken up form waiting state and completing");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			 }
			
		}
		
	}
	

	
	class RunProcess2 extends Thread{
		
		public void run(){
			
			for(int i=0; i <5; i++)
			{
				try {
					Thread.sleep(2000);
					System.out.println("RunProcess2 =>"+i);
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
			 synchronized(sharedString)
			 {
				 System.out.println("RunProcess2 is reading the String "+ sharedString); 
				 sharedString.notify();
				 System.out.println("RunProcess2 is about to complete");
				 
			 }
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		SleepAndJoin sleepandjoin=new SleepAndJoin();
		RunProcess1 process1=sleepandjoin.new RunProcess1();
		Thread process1Thread=new Thread(process1);
		
		RunProcess2 process2Thread=sleepandjoin.new RunProcess2();
		
		process1Thread.start();
		//process1Thread.join();   //The thread on which join is called completes the execution and then the calling thread moves ahead
								// In this case main Thread called join on process1Thread so first process1Thread is completed and then other.
		process2Thread.start();
		
		
	}
	
	
}
