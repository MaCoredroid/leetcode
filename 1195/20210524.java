class FizzBuzz {
    private int n;
    Semaphore three=new Semaphore(0);
    Semaphore five=new Semaphore(0);
    Semaphore threefive=new Semaphore(0);
    Semaphore other=new Semaphore(0);
    int curr=1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true){
            three.acquire();
            if(curr>n){
                break;
            }
            printFizz.run();
            other.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true){
            five.acquire();
            if(curr>n){
                break;
            }
            printBuzz.run();
            other.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true){
            threefive.acquire();
            if(curr>n){
                break;
            }
            printFizzBuzz.run();
            other.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(curr<=n){
            if(curr%3==0&&curr%5==0){
                threefive.release();
            }else if(curr%3==0){
                three.release();
            }else if(curr%5==0){
                five.release();
            }else{
                printNumber.accept(curr);
                other.release();
            }
            other.acquire();
            curr++;
        }
        threefive.release();
        three.release();
        five.release();
    }
}