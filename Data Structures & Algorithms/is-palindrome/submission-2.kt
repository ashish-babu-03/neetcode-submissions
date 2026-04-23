class Solution {
    fun isPalindrome(s: String): Boolean {
        val filteredString = s.filter { it.isLetterOrDigit() }.lowercase()
        var l = 0
        var r = filteredString.length -1
        while (l <= r) {
            if (filteredString[l] != filteredString[r]) return false
            l++
            r--
        }
        
        return true

    }
}
