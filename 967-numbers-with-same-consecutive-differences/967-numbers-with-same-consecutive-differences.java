class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans=new ArrayList<>();
        int j=1;
        Queue<Integer> q=new LinkedList<>();
        while(j<10){// varying first place
            int num=j, numOfDigits=1;
            q.add(num);
            while(numOfDigits<n){// to get the numbers of fixed length
                int size=q.size();
                for(int i=0;i<size;i++){//take all the numbers from queue
                    num=q.poll();
                    int unit=num%10; //find unit place digit
                    unit-=k; //subtract the difference(k)
                    int newNum1=0;
                    if(unit>=0){
                        newNum1=(num*10)+unit;
                        q.add(newNum1); //add new number
                    }
                    unit=num%10;
                    unit+=k; //add the difference
                    if(unit<10){
                        int newNum2=(num*10)+unit;
                        if(newNum2!=newNum1)
                            q.add(newNum2); // add the new number
                    }
                }
                numOfDigits++;
            }
            // empty the queue, queue will have all the ans number starting with j
            while(!q.isEmpty()){ 
                ans.add(q.poll());
            }
            j++;
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}