class AnimalShelf {
    Queue<int[]> queueCat;
    Queue<int[]> queueDog;
    int time;
    public AnimalShelf() {
        queueCat=new LinkedList<>();
        queueDog=new LinkedList<>();
        time=0;
    }
    
    public void enqueue(int[] animal) {
        if(animal[1]==0){
            queueCat.offer(new int[]{animal[0],time++});
        }else{
            queueDog.offer(new int[]{animal[0],time++});
        }
    }
    
    public int[] dequeueAny() {
        int[] cat=queueCat.isEmpty()?new int[]{-1,20000001}:queueCat.peek();
        int[] dog=queueDog.isEmpty()?new int[]{-1,20000001}:queueDog.peek();
        if(cat[0]==-1&&dog[0]==-1){
            return new int[]{-1,-1};
        }
        if(cat[1]<dog[1]){
            queueCat.poll();
            return new int[]{cat[0],0};
        }else{
            queueDog.poll();
            return new int[]{dog[0],1};
        }
    }
    
    public int[] dequeueDog() {
        int[] dog=queueDog.isEmpty()?new int[]{-1,-1}:queueDog.peek();
        if(dog[1]==-1){
            return new int[]{-1,-1};
        }
        queueDog.poll();
        return new int[]{dog[0],1};
        
    }
    
    public int[] dequeueCat() {
        int[] cat=queueCat.isEmpty()?new int[]{-1,-1}:queueCat.peek();
        if(cat[1]==-1){
            return new int[]{-1,-1};
        }
        queueCat.poll();
        return new int[]{cat[0],0};
        
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */