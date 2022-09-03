class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> h = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i:nums1){
            if(h.containsKey(i))
                h.put(i,h.get(i)+1);
            else
                h.put(i,1);
        }
        for(int i:nums2){
            if(h.containsKey(i) && h.get(i)>0){
                ans.add(i);
                h.put(i,h.get(i)-1);
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}
