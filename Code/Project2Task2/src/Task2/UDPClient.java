package Task2;

import java.net.*;
import java.util.Scanner;
import java.io.*;
public class UDPClient{
    public static void main(String args[]){ 
    	
		// args give message contents and destination hostname
    	Scanner sc = new Scanner(System.in);
    	 
        // Step 1:Create the socket object for carrying
        // the data
    	DatagramSocket ds= null ;
        byte buf[] = null;
		
		try {
			 ds = new DatagramSocket();
			 
		        InetAddress ip = InetAddress.getLocalHost();
			 System.out.print("Enter the equation in the format:");
	            System.out.println("'operand1 operator operand2'");
	            String inp = sc.nextLine();
	            buf = new byte[65535];
	 
	            // convert the String input into the byte array.
	            buf = inp.getBytes();
	 
	            // Step 2:Create the datagramPacket for sending the data.
	            DatagramPacket DpSend =
	                      new DatagramPacket(buf, buf.length, ip, 1234);
	 
	            // invoke the send call to actually send the data.
	            ds.send(DpSend);
	 
	 
	            buf = new byte[65535];
	            DatagramPacket DpReceive =
	                                 new DatagramPacket(buf, buf.length);
	            ds.receive(DpReceive);
	 
	            System.out.println("Answer = " +
	                                new String(buf,0,buf.length));	
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(ds != null) ds.close();}
	}		      	
}