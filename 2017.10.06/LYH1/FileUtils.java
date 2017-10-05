import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


public class FileUtils {
    
    /**
     * 写入文件
     * @param filePath 文件的绝对地址
     * @param data 需要写入文件的字符串
     * @param append 是否采用追加模式，如果为false，则覆盖原文件，如果为true，则在文件末尾追加
     * @throws IOException
     */
    public static void writeStringToFile(String filePath, String data, boolean append) throws IOException {
        // your code here
    	File file = new File(filePath);
    	FileWriter fileWriter = new FileWriter(file, append);

    	
    	try
    	{
    		fileWriter.write(data);
    	}
    	catch(IOException e)
    	{
    		e.getStackTrace();
    	}
    	finally
    	{
			fileWriter.close();
		}
    }
    
    /**
     * 读取文件
     * @param filePath 文件的绝对路径
     * @return 文件的内容
     * @throws IOException
     */
    public static String readStringFromFile(String filePath) throws IOException {
        // your code here
    	FileReader fileReader = new FileReader(filePath);
    	
    	StringBuilder stringBuilder = new StringBuilder();
    	
    	int temp;
    	
    	try
    	{
    		while ((temp = fileReader.read()) != -1)
    		{
    			stringBuilder.append((char) temp);
    		}
    	}
    	catch (Exception e) 
    	{
			// TODO: handle exception
    		e.getStackTrace();
		}
    	finally
    	{
    		fileReader.close();
    	}
    	
    	
    	
    	
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) throws IOException {
        String filePath = "/apps/test";
        writeStringToFile(filePath, "write String to test file\n", false);
        writeStringToFile(filePath, "append\n", true);
        writeStringToFile(filePath, "append\n", true);
        writeStringToFile(filePath, "append\n", true);
        System.out.println(readStringFromFile(filePath));
    }

} 