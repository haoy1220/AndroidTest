package com.hao.androidtest.leetcode.kotlin

import java.util.ArrayList

class Solution {
    //下一个排序
    //特征：交换
    fun nextPermutation(nums: IntArray): Unit {
        var i = nums.size - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            var j = nums.size - 1;

            while (nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private fun reverse(nums: IntArray, i: Int) {
        var left = i;
        var right = nums.size - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //在排序数组中查找元素的第一个和最后一个位置
    //特征：有序、定位
    //解决方法：二分搜索
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val leftIndex = binarySearch(nums, target, true);
        val rightIndex = binarySearch(nums, target, false) - 1;
        if (leftIndex <= rightIndex && rightIndex < nums.size && nums[leftIndex] == target && nums[rightIndex] == target) {
            return intArrayOf(leftIndex, rightIndex);
        }
        return intArrayOf(-1, -1);
    }

    private fun binarySearch(nums: IntArray, target: Int, lower: Boolean): Int {
        var left = 0;
        var right = nums.size - 1;
        var ans = nums.size;
        while (left <= right) {
            val mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    //组合求和
    //特征：有序、可重用、全部可能
    //解决方法：搜索回溯、深度遍历
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val ans: MutableList<List<Int>> = ArrayList()
        val combine: MutableList<Int> = ArrayList()
        dfs(candidates, target, ans, combine, 0)
        return ans
    }

    private fun dfs(
        candidates: IntArray,
        target: Int,
        ans: MutableList<List<Int>>,
        combine: MutableList<Int>,
        idx: Int
    ) {
        if (idx == candidates.size) {
            return
        }
        if (target == 0) {
            ans.add(ArrayList(combine))
            return
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1)
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx])
            dfs(candidates, target - candidates[idx], ans, combine, idx)
            combine.removeAt(combine.size - 1)
        }
    }

    //旋转图像
    fun rotate(matrix: Array<IntArray>): Unit {

    }
}