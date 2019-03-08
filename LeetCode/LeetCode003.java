/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/


/*
思路：关键词：不重复 子串长度
所以定义两个for循环，内外两个游标，这样就可以找出所有子串（比如abcd，就有6个子串；abcde，10个）
定义一个变量，存储每个子串的长度，如果长度大于之前的子串，就更新长度
PS：判断是否是子串（即判断是否重复），使用set（无序，不重复）来判断
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;//存放已知最长的子串的长度
        int length = s.length();
	
		//找出所有子串
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j <= length; j++){
                if (hasResult(s, i, j)){//判断这个子串是否有重复元素，参数为原字符串，首，尾
                    result = Math.max(result, j - i);//比较，如果新子串长度大于旧子串，更新
                }
            }
        }
        return result;//比较完所有子串，返回结果
    }
    
    private boolean hasResult(String s, int start, int end){//传进来想要判断是否满足条件的子串
        Set<Character> set = new HashSet<>();//利用set的不重复性
        
        for (int i = start; i < end; i++){//i为传进来的子串中，从首到尾之中的任意一个字符的游标
            Character temp = s.charAt(i);//temp为游标i所指向的字符
            
            if (set.contains(temp)){//检查set中当前temp是否有重复
                return false;//有的话，则当前子串不符合规定，返回，终止父方法中当前循环，并开启下一次循环
            }
            set.add(temp);//如果没有的话，把当前temp添加进set中
        }
        return true;//如果整个子串都没有重复的字符，则返回true，父方法中计算此子串的长度，并与result中的长度进行比较
    }
}