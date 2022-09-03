class Solution {
    public boolean binarySearch(int[] matrix, int target){
        int l=0, u=matrix.length-1;
        while(u>l){
            int mid=l+(u-l)/2;
            if(matrix[mid]==target)
                return true;
            if(matrix[mid]>target)
                u=mid-1;
            if(matrix[mid]<target)
                l=mid+1;
        }
        if(u==l)
            return matrix[l+(u-l)/2]==target;
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length-1;i++){
            if(matrix[i][0]==target || matrix[i+1][0]==target)
                return true;
            if(matrix[i][0]<target && matrix[i+1][0]>target)
                return binarySearch(matrix[i],target);
        }
        return binarySearch(matrix[matrix.length-1],target);
    }
}