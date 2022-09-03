class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[] arr = new int[mat.length*mat[0].length];
        int[][] ans = new int[r][c];
        int count=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                arr[count++]=mat[i][j];
            }
        }
        count=0;
        try{
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    ans[i][j]=arr[count++];
                }
            }
        }catch(Exception e){
            return mat;
        }
        if(count<arr.length)
            return mat;
        return ans;
    }
}