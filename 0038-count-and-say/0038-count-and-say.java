class Solution {
    public String countAndSayHelper(String n){
        String ans="";
        for(int i=0;i<n.length();i++){
            int count=1;
            while(i<n.length()-1 && n.charAt(i)==n.charAt(i+1)){
                count++;
                i++;
            }
            ans+=Integer.toString(count)+n.charAt(i);
        }
        return ans;
    }
    public String countAndSay(int n) {
        String[] dp=new String[n+1];
        dp[1]="1";
        for(int i=2;i<=n;i++){
            dp[i]=countAndSayHelper(dp[i-1]);
        }
        return dp[n];
    }
}