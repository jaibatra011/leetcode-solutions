class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans=0;
        int i=0,j=tokens.length-1;
        Arrays.sort(tokens);
        while(i<=j){
            if(power<tokens[i]){
                if(ans==0)
                    break;
                else if(i!=j){
                    power+=tokens[j--];
                    ans--;
                }
                else{
                    j--;
                }
            }
            else{
                power-=tokens[i++];
                ans++;
            }
            //System.out.println(power);
        }
        return ans;
    }
}