class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans=0, i=0,j=tokens.length-1;
        Arrays.sort(tokens);
        while(i<=j){
            if(power<tokens[i]){ //face down
                if(ans==0) // cant face down if ans=0, hence break
                    break;
                else if(i!=j){ 
                    //no need to face down if i=j, there is no scope of increasing ans further
                    power+=tokens[j--];
                    ans--;
                }
                else{ // hence if i=j, we just need to get out of loop
                    j--;
                }
            }
            else{ // face up
                power-=tokens[i++];
                ans++;
            }
        }
        return ans;
    }
}