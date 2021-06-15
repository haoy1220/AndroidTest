package com.hao.androidtest.leetcode.kotlin

class Solution {
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
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}