package Task2;

import java.net.*;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.StringTokenizer;
import java.io.*;
public class UDPServerThatIgnoresYou{
    public static void main(String args[]){ 
    	DatagramSocket ds=null;
		try{
			
			ds = new DatagramSocket(1234);
	        byte[] buf = null;
	        DatagramPacket DpReceive = null;
	        DatagramPacket DpSend = null;
	        Random rnd= new Random();
 			while(true){
 				
 				buf = new byte[65535];
				 
 	            // create a DatgramPacket to receive the data.
 	            DpReceive = new DatagramPacket(buf, buf.length);
 	 
 	            // receive the data in byte buffer.
 	            ds.receive(DpReceive);
 	 
 	            String inp = new String(buf, 0, buf.length);
 	 
 	            //To remove extra spaces.
 	            inp=inp.trim();
 				
 				if(rnd.nextInt(10) < 7) {
 					System.out.println("Got request " +
 					new String(DpReceive.getData())+
 					" but ignoring it.");
 					continue;
 					}
 				else
 				
 				{
 					

 							
 				
 	            System.out.println("Equation Received:- " + inp);
 	           System.out.println("And making a reply");
 	            int result=ComputeResult(inp);
 	            
 	           System.out.println("Sending the result...");
 	            String res = Integer.toString(result);
 	 
 	            // Clear the buffer after every message.
 	            buf = res.getBytes();
 	 
 	            // get the port of client.
 	            int port = DpReceive.getPort();
 	 
 	            DpSend = new DatagramPacket(buf, buf.length,
 	                          InetAddress.getLocalHost(), port);
 	            ds.send(DpSend);
    		}
 				
 			}
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e) {System.out.println("IO: " + e.getMessage());
		}finally {if(ds != null) ds.close();}
    }
    
    public static int ComputeResult(String req) 
    {
    	
    	StringTokenizer st = new StringTokenizer(req);
    	 
        int a = Integer.parseInt(st.nextToken());
        String operation = st.nextToken();
        int b = Integer.parseInt(st.nextToken());	
    	
    	
    	
    			
    			int result;
    			
    			
    			switch (operation) {
    			
                case "+": result= add(a,b);
                         break;
                case "-": result=  sub(a,b);
                         break;
                case "X": result=  mul(a,b);
                         break;
                case "/": result=  div(a,b);
                         break;
                case "^": result=  pow(a,b);
                         break;
                default: result= -1;
                			break;

   }
    	
    	return result;
    	
    }
    
    public static int add(int a, int b)
    {
    	return a+b;
    }
    public static int sub(int a, int b)
    {
    	return a-b;
    }
    public static int mul(int a, int b)
    {
    	return a*b;
    }
    public static int div(int a, int b)
    {
    	return a/b;
    }
    public static int pow(int a, int b)
    {
    	return (int) Math.pow(a, b);
    			
    }
    
    
    
    
    
    
}