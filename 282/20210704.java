class Solution {
    List<String> answer=new ArrayList<>();
    public String digits;
    public long target;
    public List<String> addOperators(String num, int target) {
        if (num.length() == 0) {
            return new ArrayList<String>();
        }

        this.target = target;
        this.digits = num;
        this.answer = new ArrayList<String>();
        this.recurse(0, 0, 0, 0, new ArrayList<String>());
        return this.answer;
    }
    
    public void recurse( int index, long previousOperand, long currentOperand, long value, ArrayList<String> ops){
        String nums=this.digits;
        if (index == nums.length()) {
             if (value == this.target && currentOperand == 0) {
                StringBuilder sb = new StringBuilder();
                ops.subList(1, ops.size()).forEach(v -> sb.append(v));
                this.answer.add(sb.toString());
             }
             return;
        }
        currentOperand = currentOperand * 10 + Character.getNumericValue(nums.charAt(index));
        String current_val_rep = Long.toString(currentOperand);
        int length = nums.length();
        if (currentOperand > 0) {
          // NO OP recursion
            recurse(index + 1, previousOperand, currentOperand, value, ops);
        }
        ops.add("+");
        ops.add(current_val_rep);
        recurse(index + 1, currentOperand, 0, value + currentOperand, ops);
        ops.remove(ops.size() - 1);
        ops.remove(ops.size() - 1);
        if (ops.size() > 0) {

      // SUBTRACTION
          ops.add("-");
          ops.add(current_val_rep);
          recurse(index + 1, -currentOperand, 0, value - currentOperand, ops);
          ops.remove(ops.size() - 1);
          ops.remove(ops.size() - 1);

          // MULTIPLICATION
          ops.add("*");
          ops.add(current_val_rep);
          recurse(
              index + 1,
              currentOperand * previousOperand,
              0,
              value - previousOperand + (currentOperand * previousOperand),
              ops);
          ops.remove(ops.size() - 1);
          ops.remove(ops.size() - 1);
        }

        
    }
}