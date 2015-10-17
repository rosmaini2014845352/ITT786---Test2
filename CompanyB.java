/* Test 2 - Q3 
 * Information needed for Company B:  MAC address + Thread
 */

/* Author : Rosmaini Dollah
* ID : 2014845352
* Github ID: rosmaini2014845352

*/
package companya;

import java.net.*;
import java.util.*;
import java.io.*;
import static java.lang.System.out;


//Runnable interface contains run() method
  class MyThread implements Runnable{
    String name;
    int time;
    Random r = new Random();
    
    public MyThread(String x){
        name = x;
        time = r.nextInt(999); //between 0-1 second
    }
    
    //this runs when we start thread
    @Override
    public void run(){
      
        try{
            System.out.printf("%s is sleeping for %d seconds\n", name, time);
            Thread.sleep(time); //how long do u want to sleep for?
            System.out.printf("%s is done\n", name);
        }catch(Exception e){}
    }
}
    
public class CompanyB {
   public static void main(String[] args) throws SocketException {
       
        System.out.println ("-----Sleeping Thread is running------");
        Thread t1 = new Thread(new MyThread("First thread"));
        Thread t2 = new Thread(new MyThread("Second thread"));
        Thread t3 = new Thread(new MyThread("Third thread"));
       
        t1.start();
        t2.start();
        t3.start();
    
       InetAddress CompanyA_ip;
        try {
					
            System.out.println ("A program to get an information from NIC such as MAC address and Thread");
            System.out.println ("-------------------------------------------------------------");
            CompanyA_ip = InetAddress.getLocalHost();
            System.out.println("Current IP address: " + CompanyA_ip.getHostAddress());
				
            NetworkInterface network = NetworkInterface.getByInetAddress(CompanyA_ip);
	
            byte[] mac = network.getHardwareAddress();
					
            System.out.print("Current MAC address: ");
					
            StringBuilder sb = new StringBuilder();
	
                for (int i = 0; i < mac.length; i++) {
		sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
		}
		System.out.println(sb.toString());
					
	} catch (UnknownHostException e) {
				
		e.printStackTrace();
				
		}
          catch (SocketException e){
					
		e.printStackTrace();
					
		}
			
	  
             
}

    

