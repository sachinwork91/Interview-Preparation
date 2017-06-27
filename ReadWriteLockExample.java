import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {

	private final ReadWriteLock readwritelock=new ReentrantReadWriteLock();
	private final Lock readLock=readwritelock.readLock();
	private final Lock writeLock=readwritelock.writeLock();
	String[] mylists={"Hello","!","This","is ","read","Write","lock","Example"};
	
	
	public void read(){
		System.out.println("Starting Reading");
		readLock.lock();
		Thread t=Thread.currentThread();
		for(String str : mylists)
		{
			System.out.println("Thread "+t.getName()+ " is reading "+" List =>" +str);
			try{Thread.sleep(2000);
			}catch(Exception e){}
			
		
		}
		readLock.unlock();
	}
	
	public void write(){
		
		System.out.println("Starting to Write in a list");
		writeLock.lock();
		Thread t=Thread.currentThread();
		for(int i=0; i<mylists.length;i++)
		{
			mylists[i]="Writing =>"+i;
		System.out.println("Thread "+t.getName() + " Writing.... "+i);
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		}
		writeLock.unlock();
	}
	
	class FileReadingThread extends Thread{
		
		String str="";
		public void run()
		{Thread.currentThread().setName(str);
			read();
			
		}
		FileReadingThread(String str)
		{
			this.str=str;	
		}
	}
	
	class FileWritingThread extends Thread{
		
		String str="";
		public void run(){
			Thread.currentThread().setName(str);
			write();
			
		}
		FileWritingThread(String str)
		{
			this.str=str;
		}
		
	}
	
	
	public static void main(String[] args){
		ReadWriteLockExample readWriteLockExample=new ReadWriteLockExample();
		FileReadingThread fileReadThread1=readWriteLockExample.new FileReadingThread("Read 1");
		FileReadingThread fileReadThread2=readWriteLockExample.new FileReadingThread("Read 2");
		FileReadingThread fileReadThread3=readWriteLockExample.new FileReadingThread("Read 3");
		FileWritingThread fileWriteThread1=readWriteLockExample.new FileWritingThread("Writer");
		fileReadThread1.start();
		fileWriteThread1.start();
		fileReadThread2.start();
		fileReadThread3.start();
		
	}
}
