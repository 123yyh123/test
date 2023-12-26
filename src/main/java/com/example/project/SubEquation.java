package com.example.project;

/**
 * @author yyh
 * @date 2023-12-26
 */
public class SubEquation extends AbstractEquation {
    private SubEquation(short i1, short i2) {
        super(i1, i2, '-');
    }

    @Override
    public int calculate() {
        return getOperand1()-getOperand2();
    }
    public static class SubEquationBuilder{
        public static SubEquation build(short operand1,short operand2){
            return new SubEquation(operand1, operand2);
        }
    }
}
