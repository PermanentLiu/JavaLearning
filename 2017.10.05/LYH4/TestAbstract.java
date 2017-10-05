
import java.io.*;

public class TestAbstract 
{  
    public static void main(String args[]) throws IOException 
	{  
        File dir = new File("D:/java");  
        File file1 = new File(dir, "fileTest001.txt");  
        File file2 = new File(dir, "fileTest002.java");   
        
        if (!dir.exists())  
            dir.mkdir();  
        if (!file1.exists())  
            file1.createNewFile();  
        if (!file2.exists())  
            file2.createNewFile();  
            
        System.out.println("file1's AbsolutePath=  " + file1.getAbsolutePath());  
        System.out.println("file2's AbsolutePath=  " + file2.getAbsolutePath());  
        
        System.out.println("file1 Canread=" + file1.canRead());  
        System.out.println("file1's len= " + file1.length());  
        
        String[] fileList = dir.list(); 
        System.out.println("there are " + fileList.length + " file(s) in D:/java");  
    }  

}
