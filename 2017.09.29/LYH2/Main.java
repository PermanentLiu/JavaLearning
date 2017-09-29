
public class Main
{
	public static void main(String args[]) {
        /**
         * 定义一个char类型的数组，命名为charArray，数组的初始化内容为“www.tianmaying.com"的所有字符
         * 以每行一个字符的方式打印出该字符数组
         */
        char[] charArray = new char[]{'w', 'w', 'w', '.', 't', 'i', 'a', 'n', 'm', 'a', 'y', 'i', 'n', 'g', '.', 'c', 'o', 'm'};
        
        for (int i = 0; i < charArray.length; i++)
        {
            System.out.println(charArray[i]);
        }
    }

}
