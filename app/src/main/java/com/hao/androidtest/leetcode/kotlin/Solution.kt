package com.hao.androidtest.leetcode.kotlin

class Solution {
    //下一个排序
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

    //在排序数组中查找元素的第一个和最后一个位置
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var leftIndex = binarySearch(nums, target, true);
        var rightIndex = binarySearch(nums, target, false) - 1;
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
}