class Solution {
    public boolean binarySearch(int[] matrix, int target){
        int l=0, u=matrix.length-1;
        while(u>l){
            int mid=l+(u-l)/2;
            if(matrix[mid]==target)
                return true;
            if(matrix[mid]>target)
                u=mid;
            if(matrix[mid]<target)
                l=mid+1;
        }
        if(u==l)
            return matrix[l+(u-l)/2]==target;
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0,u=matrix.length-1;
        while(u>l){
            int mid=l+(u-l)/2;
            if(matrix[mid][0]==target || matrix[mid+1][0]==target)
                return true;
            if(matrix[mid][0]<target && matrix[mid+1][0]>target)
                return binarySearch(matrix[mid],target);
            if(matrix[mid][0]<target)
                l=mid+1;
            if(matrix[mid][0]>target)
                u=mid;
        }
        return binarySearch(matrix[matrix.length-1],target);
    }
}