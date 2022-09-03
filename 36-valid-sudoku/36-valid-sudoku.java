class Solution {
    public boolean isValidSudoku(char[][] board) {
        //checking rows
        for(int i=0;i<9;i++){
            int[] count = new int[9];
            for(int j=0;j<9;j++){
                if(board[i][j]!='.')
                    count[board[i][j]-'1']++;
            }
            for(int j=0;j<9;j++){
                if(count[j]>1)
                    return false;
            }
        }
        //checking columns
        for(int i=0;i<9;i++){
            int[] count = new int[9];
            for(int j=0;j<9;j++){
                if(board[j][i]!='.')
                    count[board[j][i]-'1']++;
            }
            for(int j=0;j<9;j++){
                if(count[j]>1)
                    return false;
            }
        }
        //checking 3x3 sub boxes
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int[] count = new int[9];
                for(int k=3*i;k<3*(i+1);k++){
                    for(int l=3*j;l<3*(j+1);l++){
                        if(board[k][l]!='.')
                            count[board[k][l]-'1']++;
                    }
                }
                for(int k=0;k<9;k++){
                    if(count[k]>1)
                        return false;
                }
            }
        }
        return true;
    }
}