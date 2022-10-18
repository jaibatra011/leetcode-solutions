class Solution {
    public int longestPalindrome(String s) {
        int ans=0;
        boolean singleValueTaken=false;
        int[] freq = new int[58];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'A']++;
        }
        for(int i=0;i<freq.length;i++){
            ans+=freq[i]/2*2;
            if(freq[i]%2==1)
                singleValueTaken=true;
        }
        if(singleValueTaken)
            ans++;
        return ans;
    }
}