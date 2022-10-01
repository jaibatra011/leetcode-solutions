class Solution {
    public int numDecodings(String s) {
        // DYNAMIC PROGRAMMING, getting TLE using recursion
        int[] ans=new int[s.length()];
        for(int i=s.length()-1;i>=0;i--){
            //Base case
            if(s.charAt(i)=='0') //if ith place has zero, no combination possible
                ans[i]=0;
            
            else if(i==s.length()-1) // if string length==1
                ans[i]=1;
            
            else if(i==s.length()-2){ //if string length==2
                if(Integer.parseInt(s.substring(i))>0 && Integer.parseInt(s.substring(i))<27 && s.charAt(i+1)!='0') // no zeroes and in range, therefore 2
                    ans[i]=2;
                else if(Integer.parseInt(s.substring(i))>0 && Integer.parseInt(s.substring(i))<27) // with zeroes but in range, therefore 1, like 10 and 20
                    ans[i]=1;
                else if(s.charAt(i+1)=='0') // not in range with zeroes, no possible ans
                    ans[i]=0;
                else // not in range without zeroes, therefore 1 ans possible
                    ans[i]=1;
            }
            
            //Calculating using future values
            // if in range, we can consider single digit and both together
            else if(Integer.parseInt(s.substring(i,i+2))<27)
                ans[i]=ans[i+1]+ans[i+2];
            else // if not in range, we can consider single digit only
                ans[i]=ans[i+1];
        }
        
        //Returning first value
        return ans[0];
    }
}