class Solution {
    public boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<2)
            return "";
        for(int i=0;i<palindrome.length();i++){
            String ans="";
            if(palindrome.charAt(i)!='a'){
                ans = palindrome.substring(0,i)+'a'+palindrome.substring(i+1,palindrome.length());
                if(!isPalindrome(ans))
                    return ans;
            }
        }
        return palindrome.substring(0,palindrome.length()-1)+'b';
    }
}