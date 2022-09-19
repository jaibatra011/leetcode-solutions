class Solution {
    public int trap(int[] height) {
        int start=0,ans=0;
        Map<Integer,Integer> h = new HashMap<>(); 
        //moving in right direction, from 0 to heights.length-1
        while(start<height.length){
            //since a wall is considered if it greater than 0, axis is not considered as wall
            while(start<height.length && height[start]==0)
                start++;
            
            //finding end wall, where it is equal or greater than start wall
            int end=start+1; // end is required outside for loop too, hence declared outside
            for(;end<height.length;end++){
                if(height[end]>=height[start]){
                    break;
                }
            }
            
            //compute how much water will get stored
            if(end<height.length){
                // add total water stored if there is no any other wall in between
                ans+=(end-start-1)*(Math.min(height[start],height[end]));
                
                // subtract the wall's length between start and end
                // becausse water can not be stored there
                for(int i=start+1;i<end;i++){
                    ans-=height[i];
                }
            }
            
            h.put(start,end); //putting start and end so that it doesn't get repeated
            start=end; // end is the new start
        }
        
        //moving in reverse direction, from heights.length-1 to 0
        //same algorithm as above, just in opposite direction
        start=height.length-1;
        while(start>=0){
            while(start>=0 && height[start]==0)
                start--;
            int end=start;
            for(end=start-1;end>=0;end--){
                if(height[end]>=height[start]){
                    break;
                }
            }
            if((!h.containsKey(end) || (h.containsKey(end) && h.get(end)!=start)) && end>=0){
                ans+=(start-end-1)*(Math.min(height[start],height[end]));
                for(int i=start-1;i>end;i--){
                    ans-=height[i];
                }
            }
            start=end;
        }
        return ans;
    }
}