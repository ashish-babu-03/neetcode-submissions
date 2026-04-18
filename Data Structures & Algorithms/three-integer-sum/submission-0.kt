class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        var p = 0
        var q = nums.size -1
        nums.sort()
        val resultList = mutableListOf<List<Int>>()
        for(i in nums.indices) {
            
            
                p = i+1
                q = nums.size-1
            val num = nums[i] * -1
            if (i >0 && nums[i] == nums[i-1]) continue
            while (p<q) {
                if (nums[p] + nums[q] < num) {
                    p++
                } else if(nums[p]+ nums[q] > num) {
                    q--
                } else {
                    
                        resultList.add(listOf(nums[i],nums[p],nums[q]))
                    p++
                    q--
                    while (p < q && nums[p]==nums[p-1]) p++
                    while (p < q && nums[q]==nums[q+1]) q--
                }
            }
        }
        return resultList
    } 
    
}
