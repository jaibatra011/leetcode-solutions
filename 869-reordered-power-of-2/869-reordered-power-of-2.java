class Solution {
    public boolean checkPowerOf2(int[] arr){
        if(arr[0]==0)
            return false;
        int n=0;
        for(int i:arr) // Converting int array to int
            n=(n*10)+i;
        return (n>0 && (n&(n-1))==0); // checking power of 2;
    }
    public boolean findPermutationAndCheckPowerOf2(int[] arr, int start){
        if(start==arr.length) //one permutation of all digits is complete
            return checkPowerOf2(arr);
        for(int i=start;i<arr.length;i++){
            swap(arr,start,i);//place ith digit at start
            //find permutations for rest of digits and check power of 2
            if(findPermutationAndCheckPowerOf2(arr,start+1))
                return true;
            swap(arr,start,i);//revert changes
        }
        return false;
    }
    public void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public boolean reorderedPowerOf2(int n) {
        List<Integer> l=new ArrayList<>(); 
        while(n!=0){ //converting int to int array
            l.add(n%10);
            n/=10;
        }
        return findPermutationAndCheckPowerOf2(l.stream().mapToInt(i->i).toArray(),0);
    }
}