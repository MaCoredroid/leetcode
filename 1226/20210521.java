class DiningPhilosophers {
    private Semaphore semaphore=new Semaphore(2,true);

    private int[] pos=new int[5];

    private ReentrantReadWriteLock reentrantReadWriteLock=new ReentrantReadWriteLock();

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        while(true){
            semaphore.acquire();
            reentrantReadWriteLock.writeLock().lock();
            pos[philosopher]=1;
            reentrantReadWriteLock.writeLock().unlock();
            reentrantReadWriteLock.readLock().lock();
            boolean flag=pos[(philosopher+1)%5]==1||pos[(philosopher+4)%5]==1;
            reentrantReadWriteLock.readLock().unlock();
            if(flag){
                reentrantReadWriteLock.writeLock().lock();
                pos[philosopher]=0;
                reentrantReadWriteLock.writeLock().unlock();
                semaphore.release();
                continue;
            }
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            reentrantReadWriteLock.writeLock().lock();
            pos[philosopher]=0;
            reentrantReadWriteLock.writeLock().unlock();
            semaphore.release();
            break;
        }
    }
}