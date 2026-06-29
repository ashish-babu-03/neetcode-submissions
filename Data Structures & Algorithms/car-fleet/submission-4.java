class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleetCount = 0, n = position.length;
        Integer[] indices = new Integer[n];
        for (int i = 0;i<n;i++) indices[i] = i;
        
        Arrays.sort(indices, (i, j) -> position[j] - position[i]);

        double prevTimeTaken = 0;
        for (int i: indices) {
            double currentTimeTaken = (double) (target - position[i])/speed[i];
            if (currentTimeTaken > prevTimeTaken) {
                fleetCount++;
                prevTimeTaken = currentTimeTaken;
            }
        }

        return fleetCount;
    }
}
