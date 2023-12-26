package com.example.project;

/**
 * @author yyh
 * @date 2023-12-26
 */
public abstract class AbstractEquation extends IEqualtion {
    @Override
    public char getOperator() {
        return operator;
    }
    @Override
    public short getOperand1() {
        return operand1;
    }
    @Override
    public short getOperand2() {
        return operand2;
    }

    @Override
    public void setOperand1(short operand1) {
        this.operand1 = operand1;
    }
    @Override
    public void setOperand2(short operand2) {
        this.operand2 = operand2;
    }
    @Override
    public void setOperator(char operator) {
        this.operator = operator;
    }
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public AbstractEquation(short operand1, short operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }
    public AbstractEquation() {
    }
}
