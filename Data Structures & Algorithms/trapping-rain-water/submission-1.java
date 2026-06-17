class Solution {
    public int trap(int[] height) {
        int water = 0, n = height.length, l=0, r= n-1, maxL = 0, maxR = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                maxL = Math.max(maxL, height[l]);
                water += maxL - height[l];
                l++;
            } else {
                maxR = Math.max(maxR, height[r]);
                water += maxR - height[r];
                r--;
            }
        }
        return water;
    }
}
