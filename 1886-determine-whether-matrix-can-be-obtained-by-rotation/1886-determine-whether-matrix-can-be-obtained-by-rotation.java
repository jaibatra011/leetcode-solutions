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
    public boolean compare(int[][] mat, int[][] target){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]!=target[i][j])
                    return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        //Intuition rotate 3 times and compare with target
        int i = 0; 
        boolean ans = compare(mat,target);
        while(!ans && i<3){
            rotate(mat);
            ans=compare(mat,target);
            i++;
        }
        return ans;
        
        //Intuition (without actually rotating) fails 4 test cases out of 113 
        //fails [[0,0],[1,1]] [[0,1],[1,0]]
        // rotation is possible iff row sum and column sum of target are among row sum, column sum, reverse of row sum and column sum
        
        /*if(mat.length!=target.length || mat[0].length!=target[0].length)
            return false;
        String rowsSum="", rowsSumReverse="", columnsSum="", columnsSumReverse="";
        String targetRowsSum="", targetColumnsSum="";
        int sum=0, targetSum=0;
        for(int i=0;i<mat.length;i++){// iterating over rows to calculate rows Sum
            sum=0;
            targetSum=0;
            for(int j=0;j<mat[0].length;j++){
                sum+=mat[i][j];
                targetSum+=target[i][j];
            }
            rowsSum+=Integer.toString(sum);
            targetRowsSum+=Integer.toString(targetSum);
            rowsSumReverse=Integer.toString(sum)+rowsSumReverse;
        }
        for(int j=0;j<mat[0].length;j++){ //iterating over coluns to calculate columns Sum
            sum=0;
            targetSum=0;
            for(int i=0;i<mat.length;i++){
                sum+=mat[i][j];
                targetSum+=target[i][j];
            }
            columnsSum+=Integer.toString(sum);
            targetColumnsSum+=Integer.toString(targetSum);
            columnsSumReverse=Integer.toString(sum)+columnsSumReverse;
        }
        Map<String,Integer> h = new HashMap<>();
        h.put(rowsSum,1);
        h.put(rowsSumReverse,1);
        h.put(columnsSum,1);
        h.put(columnsSumReverse,1);
        return h.containsKey(targetRowsSum) && h.containsKey(targetColumnsSum);
        */
    }
}