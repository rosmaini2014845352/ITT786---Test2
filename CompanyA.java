/* Test 2 - Q1,Q2 & Q4
 * Information needed:  MAC address + IPv6 + Thread
 */

/* Author : Rosmaini Dollah
* ID : 2014845352
* Github ID: rosmaini2014845352

*/
package companya;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.io.*;
import java.util.Random;
/**
 *
 * @author  Rosmaini DOllah
 * ID : 2014845352
 * Test 2 -Thread
 */
public class CompanyA {

     public static void main(String[] args) {
      
	InetAddress CompanyA_ip;
        try {
					
            System.out.println ("A program to get an information from NIC such as MAC address, IPv6 and Thread ");
            System.out.println ("----------------------------------------------------------------------------");
            CompanyA_ip = InetAddress.getLocalHost();
            System.out.println("IPv4 address for Company A: " + CompanyA_ip.getHostAddress());
				
            NetworkInterface network = NetworkInterface.getByInetAddress(CompanyA_ip);
	
            //GetIPv6
	try
	    {
	       InetAddress inet = InetAddress.getByName("fe80::a5c5:31a9:aa10:8ce9%16");

	        boolean status = inet.isReachable(5000);
                System.out.println ("IPv6 Address for Company A:");
	        if (status)
	        {
	            System.out.println(inet.getCanonicalHostName() + " Host Reached\t" + java.net.Inet6Address.getByName("fe80::a5c5:31a9:aa10:8ce9%28").getHostAddress());
	        }
	        else
	        {
	           System.out.println(inet.getCanonicalHostName() + " Host Unreachable");
	        }

	    }
	 catch (UnknownHostException e)
	    {
	        System.err.println("Host does not exists");
	    }
	 catch (IOException e)
	    {
	       System.err.println("Error in reaching the Host");
	    }
	
            
            
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
        System.out.println ("-----Sleeping Thread is running------");
        Thread t1 = new Thread(new MyThread("First thread"));
        Thread t2 = new Thread(new MyThread("Second thread"));
        Thread t3 = new Thread(new MyThread("Third thread"));
       
        t1.start();
        t2.start();
        t3.start();
	
        
	
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
  }
       
    



