class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos=nums1.length-1; //position to put new element
        // going backwards so that we dont have to shift next elements forward by 1 place
        int i=m-1,j=n-1;
        for(;i>=0 && j>=0;){
            if(nums1[i]>nums2[j]){
                nums1[pos--]=nums1[i--];
            }
            else
                nums1[pos--]=nums2[j--];
        }
        for(;j>=0 && pos>=0;){
            nums1[pos--]=nums2[j--];
        }
    }
}