class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int len = gas.length;
        if (totalCost > totalGas) return -1;
        int totalTank = 0;
        int currentTank = 0;
        int start = 0;
        for (int i = 0;i < len;i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                start = i+1;
                currentTank = 0;
            }
        }
        return totalTank < 0 ? -1 : start;
    }
}
