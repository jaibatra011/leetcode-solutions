class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer,List<Integer>> h = new HashMap<>();
        // add nums to hashmap according to difference of indexes, as they'll be same for diagnol elements
        for(int i=0;i<mat.length;i++){ 
            for(int j=0;j<mat[0].length;j++){
                if(h.containsKey(j-i)){
                    h.get(j-i).add(mat[i][j]);
                }
                else{
                    h.put(j-i,new ArrayList<Integer>());
                    h.get(j-i).add(mat[i][j]);
                }
            }
        }
        //Sort all the lists in hashmap
        for(int i:h.keySet()){
            Collections.sort(h.get(i));
        }
        //remove first element from each list and put it in mat
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                mat[i][j]=h.get(j-i).remove(0);
            }
        }
        return mat;
    }
}
