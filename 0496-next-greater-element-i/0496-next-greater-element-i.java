class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> h = new HashMap<>();
        Stack<Integer> s = new Stack();
        for(int i=nums2.length-1;i>=0;i--){
            if(s.isEmpty())
                h.put(nums2[i],-1);
            else if(s.peek()>nums2[i])
                h.put(nums2[i],s.peek());
            else{
                while(!s.isEmpty() && s.peek()<=nums2[i])
                    s.pop();
                if(s.isEmpty())
                    h.put(nums2[i],-1);
                else
                    h.put(nums2[i],s.peek());
            }
            s.push(nums2[i]);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i]=h.get(nums1[i]);
        }
        return ans;
    }
}