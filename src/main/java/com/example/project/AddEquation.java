package com.example.project;

/**
 * @author yyh
 * @date 2023-12-26
 */
public class AddEquation extends AbstractEquation {
    private AddEquation(short i1, short i2) {
        super(i1, i2, '+');
    }
    public AddEquation() {
    }
    @Override
    public int calculate() {
        return getOperand1()+getOperand2();
    }
    public static class AddEquationBuilder{
        public static AddEquation build(short operand1,short operand2){
            return new AddEquation(operand1, operand2);
        }
    }
}
