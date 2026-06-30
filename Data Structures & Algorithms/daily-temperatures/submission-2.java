class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = 0;i<n ;i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prevTempDay = stack.pop();
                result[prevTempDay] = i - prevTempDay;
            }
            stack.push(i);
        }

        return result;
    }
}
