package com.example.project;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author yyh
 * @date 2023-12-26
 */
public abstract class IEqualtion implements Serializable {
    // 两个操作数（short）、操作符（char）
    protected short operand1;
    protected short operand2;
    protected char operator;
    public abstract int calculate();
    public abstract void setOperand1(short operand1);
    public abstract void setOperand2(short operand2);
    public abstract void setOperator(char operator);
    public abstract short getOperand1();
    public abstract short getOperand2();
    public abstract char getOperator();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IEqualtion that = (IEqualtion) o;
        return operand1 == that.operand1 && operand2 == that.operand2 && operator == that.operator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operator);
    }

}
