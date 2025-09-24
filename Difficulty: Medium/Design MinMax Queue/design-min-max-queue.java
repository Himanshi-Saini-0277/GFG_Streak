class SpecialQueue {
    Queue<Integer> q;
    Deque<Integer> minQ;
    Deque<Integer> maxQ;
    
    public SpecialQueue() {
        q = new LinkedList<>();
        minQ = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public void enqueue(int x) {
        q.offer(x);
        
        while(!minQ.isEmpty() && minQ.peekLast()>x) minQ.pollLast();
        
        minQ.offerLast(x);
        
        while(!maxQ.isEmpty() && maxQ.peekLast()<x) maxQ.pollLast();
        
        maxQ.offerLast(x);
    }

    public void dequeue() {
        if(q.isEmpty()) return;
        
        int rem = q.poll();
        
        if(!minQ.isEmpty() && minQ.peekFirst()==rem)  minQ.pollFirst();
        
        if(!maxQ.isEmpty() && maxQ.peekFirst()==rem)  maxQ.pollFirst();
    }

    public int getFront() {
        if(q.isEmpty()) return -1;
        return q.peek();
    }

    public int getMin() {
        if(minQ.isEmpty())  return -1;
        return minQ.peekFirst();
    }

    public int getMax() {
        if(maxQ.isEmpty())  return -1;
        return maxQ.peekFirst();
    }
}