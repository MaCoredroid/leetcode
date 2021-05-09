class FooBar {
    private int n;
    public FooBar(int n) {
        this.n = n;
    }

    private BlockingQueue<Integer> bar=new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> foo=new LinkedBlockingQueue<>(1);


    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n;i++) {
            foo.put(1);
            printFoo.run();
            bar.put(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n;i++) {
            bar.take();
            printBar.run();
            foo.take();
        }
    }
}