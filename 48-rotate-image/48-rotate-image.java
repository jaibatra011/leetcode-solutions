class Solution {
    public void transpose(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<=i;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
    }
    public void reflect(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length/2;j++){
                int temp=mat[i][j];
                mat[i][j]=mat[i][mat[0].length-j-1];
                mat[i][mat[0].length-j-1]=temp;
            }
        }
    }
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
}