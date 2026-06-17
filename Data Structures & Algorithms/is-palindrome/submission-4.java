class Solution {
    public boolean isPalindrome(String s) {
        String filteredString = s.replaceAll("[^A-Za-z0-9]","").toUpperCase();
        int l = 0, r = filteredString.length() - 1;
        while (l < r) if (filteredString.charAt(l++) != filteredString.charAt(r--)) return false;

        return true;
    }
}
