class Solution {
    public int reverse(int x) {
        long ans=0;
        boolean negative=false;
        if(x<0){
            negative=true;
            x=-x;
        }
        while(x>0){
            ans=(ans*10)+(x%10);
            x/=10;
        }
        ans=negative?-ans:ans;
        return ans>=-Math.pow(2,31) && ans<=(Math.pow(2,31)-1)?(int)ans:0;
    }
}