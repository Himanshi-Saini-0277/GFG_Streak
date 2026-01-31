class kQueues {

    public:
  
        vector<pair<int,int>> *base;
        vector<pair<int,int>> *q;
        int sz;
        
        kQueues(int n, int k) {
            q=new vector<pair<int,int>>(n,{-1,-1});
            base=new vector<pair<int,int>>(k,{-1,-1});
            sz=n;
        }
    
        int nextEmpty(){
            
            for(int i=0;i<sz;i++) if((*q)[i].first==-1) return i;
            return -1;
        }
        void enqueue(int x, int i) {
            int place=nextEmpty();
            if(place==-1) return;
            
            if((*base)[i].first==-1){
                (*q)[place].first=x;
                (*base)[i].first=place;
                (*base)[i].second=place;
                return ;
            }
            
            (*q)[(*base)[i].second].second=place;
            (*base)[i].second=place;
            (*q)[place].first=x;
            return ;
        }
    
        int dequeue(int i) {
            
            if((*base)[i].first==-1) return -1;
            int data;
            if((*base)[i].first==(*base)[i].second){
                
                data=(*q)[(*base)[i].first].first;
                (*q)[(*base)[i].first].first=-1;
                (*q)[(*base)[i].first].second=-1;
                
                (*base)[i].first=-1;
                (*base)[i].second=-1;
                
                return data;
            }
            
            data=(*q)[(*base)[i].first].first;
            (*q)[(*base)[i].first].first=-1;
            int ptr=(*q)[(*base)[i].first].second;
            (*q)[(*base)[i].first].second=-1;
            (*base)[i].first=ptr;
            
            return data;
        }
    
        bool isEmpty(int i) {
            if((*base)[i].first==-1) return true;
            return false;
        }
    
        bool isFull() {
            for(int i=0;i<sz;i++) if((*q)[i].first==-1)return false;
            return true;
        }
};