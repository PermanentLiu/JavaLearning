
import java.io.*;

public class FileStreamTest{

   public static void main(String args[]){

	   try{
	      byte bWrite [] = {10,20,30,40,50};
	      OutputStream os = new FileOutputStream("test.txt");
	      for(int x = 0; x < bWrite.length ; x++){
	         os.write( bWrite[x] ); // writes the bytes
	      }
	      os.close();
	
	      InputStream is = new FileInputStream("test.txt");
	      int size = is.available();
	
	      for(int i = 0; i< size; i++){
	         System.out.print((char)is.read() + "  ");
	      }
	      is.close();
	   } catch(IOException e){
	      System.out.print("IOException");
	   }    
   }
}
版权声明 
上一节 
下一节 
 
 

笔记
您还没有添加过笔记，也可以选中教程内容来添加 
 
