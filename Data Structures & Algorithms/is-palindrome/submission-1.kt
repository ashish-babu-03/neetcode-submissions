class Solution {
    fun isPalindrome(s: String): Boolean {
        val charArray = s.toCharArray()
        var refinedString = ""
        for (i in charArray) {
            if ((i >='a' && i<='z') || (i>='A' && i <='Z') || (i>='0' && i<='9')) refinedString+=i
        }
        refinedString = refinedString.uppercase()
        var p1 = 0
        var p2 = refinedString.length - 1
        while (p1<p2){
            if (refinedString.get(p1) != refinedString.get(p2)) return false
            p1++
            p2--
        }
        return true
    }
}
