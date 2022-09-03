class Solution {
    public boolean isPalindromeHelper(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
    public boolean isPalindrome(String s) {
        String str="";
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)-'a'<26 && s.charAt(i)-'a'>=0) || 
               (s.charAt(i)-'0'<10 && s.charAt(i)-'0'>=0))
                str+=Character.toString(s.charAt(i));
            if(s.charAt(i)-'A'<26 && s.charAt(i)-'A'>=0)
                str+=Character.toString(s.charAt(i)+32);
        }
        return isPalindromeHelper(str);
    }
}