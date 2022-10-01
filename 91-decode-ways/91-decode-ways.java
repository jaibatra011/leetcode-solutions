class Solution {
    public int numDecodings(String s) {
        int[] ans=new int[s.length()];
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0')
                ans[i]=0;
            else if(i==s.length()-1)
                ans[i]=1;
            else if(i==s.length()-2 && s.charAt(i)!='0'){
                if(Integer.parseInt(s.substring(i))>0 && Integer.parseInt(s.substring(i))<27 && s.charAt(i+1)!='0')
                    ans[i]=2;
                else if(Integer.parseInt(s.substring(i))>0 && Integer.parseInt(s.substring(i))<27)
                    ans[i]=1;
                else if(s.charAt(i+1)=='0')
                    ans[i]=0;
                else
                    ans[i]=1;
            }
            else if(Integer.parseInt(s.substring(i,i+2))<27)
                ans[i]=ans[i+1]+ans[i+2];
            else
                ans[i]=ans[i+1];
        }
        return ans[0];
    }
}