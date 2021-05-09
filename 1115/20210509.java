class FooBar {
    private int n;
    volatile boolean flag = true;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n;) {
            if(flag){
                printFoo.run();
                i++;
                flag=!flag;
            }else{
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n;) {
            if(!flag){
                printBar.run();
                i++;
                flag=!flag;
            }else{
                Thread.yield();
            }
        }
    }
}