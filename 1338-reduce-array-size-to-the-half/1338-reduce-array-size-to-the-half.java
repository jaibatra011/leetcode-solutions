class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> h = new HashMap<>();
        int ans=0,sum=0;
        for(int i:arr){
            if(h.containsKey(i))
                h.put(i,h.get(i)+1);
            else
                h.put(i,1);
        }
        List<Map.Entry<Integer,Integer>> list= new ArrayList<>(h.entrySet());
        //Sort in desc order, that's why '-' in lambda exp
        Collections.sort(list,(l1,l2)->-(l1.getValue().compareTo(l2.getValue())));
        while(sum<arr.length/2){
            sum+=list.get(ans).getValue();
            ans++;
        }
        return ans;
    }
}