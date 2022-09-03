class Solution {
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex<0)
            return null;
        List<Integer> prev = new ArrayList<>();
        List<Integer> curr=prev;
        prev.add(1);
        for(int i=0;i<rowIndex;i++){
            curr=new ArrayList<>();
            curr.add(1);
            for(int j=0;j<prev.size()-1;j++){
                curr.add(prev.get(j)+prev.get(j+1));
            }
            curr.add(1);
            prev=curr;
        }
        return curr;
    }
}