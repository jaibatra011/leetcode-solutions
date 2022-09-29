class Solution {
    public int findClosestElementIndex(int[] arr, int target){
        //BINARY SEARCH
        int i=0, r=arr.length, l=0;
        if(target<=arr[0])
            return 0;
        if(target>arr[arr.length-1])
            return arr.length-1;
        while(true){
            if(arr[i]>target && arr[i-1]<target)
                break;
            i=(r+l)/2;
            if(arr[i]>target){
                r=i;
            }
            else if(arr[i]<target){
                l=i+1;
            }
            else
                return i;
        }
        if(i>0)
            return Math.abs(arr[i]-target)>=Math.abs(arr[i-1]-target)?i-1:i;
        else
            return i;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index=findClosestElementIndex(arr,x);
        List<Integer> ans=new ArrayList<Integer>();
        ans.add(arr[index]);
        int left=1,right=1;
        while(left+right-1<k){
            //System.out.println((index)+" "+(index-left)+" "+(index+right));
            if(index-left>=0 && index+right<arr.length){
                 //System.out.println(Math.abs(arr[index-left]-x)+" "+Math.abs(arr[index+right]-x));
                if(Math.abs(arr[index-left]-x)<=Math.abs(arr[index+right]-x)){
                    ans.add(0,arr[index-left]);
                    //System.out.println(arr[index-left]);
                    left++;
                }
                else{
                    ans.add(arr[index+right]);
                    right++;
                }
            }
            else if(index-left<0){
                ans.add(arr[index+right]);
                right++;
            }
            else{
                ans.add(0,arr[index-left]);
                left++;
            }
        }
        return ans;
    }
}