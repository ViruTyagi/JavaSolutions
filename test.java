import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
public class test
{   
static class FastReader 	
{		
BufferedReader br; 		
StringTokenizer st; 		
public FastReader() 		
{ 			
br = new BufferedReader(new	InputStreamReader(System.in)); 		
} 		
String next() 		
{ 			
while (st == null || !st.hasMoreElements()) 			
{ 				
try				
{ 					
st = new StringTokenizer(br.readLine()); 				
} 				
catch (IOException e) 				
{ 					
e.printStackTrace(); 				
} 			
} 			
return st.nextToken(); 		
} 
		
int nextInt() 		
{ 			
return Integer.parseInt(next()); 		
} 
		
long nextLong() 		
{ 			
return Long.parseLong(next()); 		
} 
		
double nextDouble() 		
{ 			
return Double.parseDouble(next()); 		
		 } 
		
		String nextLine() 		
		 { 			
String str = ""; 			
			 try			
			{ 				
				 str = br.readLine(); 			
			 } 			
			 catch (IOException e) 			
			 { 				
				 e.printStackTrace(); 			
			 } 			
			 return str; 		
		 } 	
	 }
 
	
	
	 public static void main(String[] args){
		 FastReader scan=new FastReader();
			int t = scan.nextInt();
			while(t-- > 0){
				int n = scan.nextInt();
				int no = 0 ;
				if(n%4 == 0)no = n/4;
				else no = n/4 + 1;
				while(n-- - no > 0)System.out.print("9");
				while(no-- >0)System.out.print("8");
				System.out.println("");
			}
		}
	} 

