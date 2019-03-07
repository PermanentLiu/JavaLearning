
/*
给定一个整数数组 nums 和一个目标值 target
请你在该数组中找出和为目标值的那 两个 整数
并返回他们的数组下标。

你可以假设每种输入只会对应一个答案
但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
*/

/*
思路：因为要从数组中查找两个数
用遍历的方法，需要遍历两次
所以定义i，j。进行两次for循环
又已知i + j = target；即j = target - i；
所以嵌套for循环，在最内层添加一个if条件，满足上式，即可确定i，j
注意：因为不能重复利用元素，所以j要在i的基础上往后找
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int[] {i, j};
                }
            }
        }
        throw new RuntimeException("no result");//考虑不存在的情况
        // return new int[] {0};
    }
}