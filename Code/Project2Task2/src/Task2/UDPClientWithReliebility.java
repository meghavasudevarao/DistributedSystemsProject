package Task2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPClientWithReliebility {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		 System.out.print("Enter the equation in the format:");
         System.out.println("'operand1 operator operand2'");
         String inp = sc.nextLine();

        	int res=0;
    		for (int i=0;i<=100;i++)
    		{
    			res= res+(add(0,i));
            
    		}
    		 System.out.println("Result is: " +res);
    	}
        	
        	
        	
        	
        	
	
	
	public static int add (int x,int y)
	{
		
		DatagramSocket ds= null ;
        byte buf[] = null;
        String ans="0";
		try {
			 ds = new DatagramSocket();
			 
		        InetAddress ip = InetAddress.getLocalHost();
			
	            buf = new byte[65535];
	            	String inp=Integer.toString(x)+	Integer.toString(y);            // convert the String input into the byte array.
	           buf = inp.getBytes();
	 
	            // Step 2:Create the datagramPacket for sending the data.
	            DatagramPacket DpSend =
	                      new DatagramPacket(buf, buf.length, ip, 1234);
	 
	            // invoke the send call to actually send the data.
	            ds.send(DpSend);
	 
	 while(true)
	 {
		 ds.setSoTimeout(2000);
         ds.send(DpSend);
	            buf = new byte[65535];
	            DatagramPacket DpReceive =
	                                 new DatagramPacket(buf, buf.length);
	         
	          
	            ds.receive(DpReceive);
	 
	           
	                               ans=  new String(buf,0,buf.length);
	 }
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(ds != null) ds.close();}
		
		
		
		
		
		
		
		
		return Integer.parseInt(ans.trim());
	}
}
