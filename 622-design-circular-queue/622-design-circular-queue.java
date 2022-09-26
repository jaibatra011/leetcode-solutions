class MyCircularQueue {
    
    private int start,end;
    private int[] q;
    
    public MyCircularQueue(int k) {
        q=new int[k];
        start=end=-1;
    }
    
    public boolean enQueue(int value) {
        if(isEmpty()){ //if empty, set start to 0, end will automatically set to 0 in next if
            start=0;
        }
        if(!isFull()){
            if(end==q.length-1)
                end=-1;
            q[++end]=value;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        System.out.println("Dequeue");
        if(!isEmpty()){
            if(start==end) //only 1 element, therefore it becomes empty
                start=end=-1;
            else{ // move start forward 1 place
                if(start==q.length-1)
                    start=-1;
                start++;
            }
            return true;
        }
        return false;
    }
    
    public int Front() {
        if(!isEmpty())
            return q[start];
        return -1;
    }
    
    public int Rear() {
        if(!isEmpty())
            return q[end];
        return -1;
    }
    
    public boolean isEmpty() {
        if(start==-1 && end==-1)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if((start==0 && end==q.length-1) || (start-end==1 && end!=-1))
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */