class Solution {
    public boolean containsDuplicate(int[] nums) {
        //we used HashMap instead of arrayList because the contains method of hashmap takes O(1) time complexity while arrayList takes O(n)
        Map<Integer,Integer> h = new HashMap<>();
        for(int i:nums){
            if(h.containsKey(i))
                return true;
            else
                h.put(i,1);
        }
        return false;
    }
}