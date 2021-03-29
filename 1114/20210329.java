class Foo {
    int ticket=0;
    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(ticket!=0){

        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        ticket++;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(ticket!=1){

        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        ticket++;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(ticket!=2){

        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        ticket++;
    }
}