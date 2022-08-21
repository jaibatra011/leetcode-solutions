class Solution {
    public int lengthOfLastWord(String s) {
        int ans=0,i=s.length()-1;
        if(s.charAt(i)==' '){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            while(i>=0 && s.charAt(i)!=' '){
                i--;
                ans++;
            }
        }
        else{
            while(i>=0 && s.charAt(i)!=' '){
                i--;
                ans++;
            }
        }
        return ans;
        //String[] arr = s.split(" ");
        //return arr[arr.length-1].length();
    }
}