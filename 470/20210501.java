/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while(true){
            int num=(rand7()-1)*7+rand7();
            if(num<=40){
                return 1+(num-1)%10;
            }
            num=(num-1-40)*7+rand7();
            if(num<=60){
                return 1+(num-1)%10;
            }
            num=(num-1-60)*7+rand7();
            if(num<=20){
                return 1+(num-1)%10;
            }
        }      
    }
}