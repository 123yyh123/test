package com.example.project;

/**
 * @author yyh
 * @date 2023-12-26
 */
public class EquationCheckerOfRange implements EquationChecker {
    private final int min;
    private final int max;
    public EquationCheckerOfRange(int min, int max) {
        this.min = min;
        this.max = max;
    }
    /**
     * 检查算式是否符合要求
     * @param equation 算式
     * @return 是否符合要求
     */
    @Override
    public boolean check(IEqualtion equation) {
        if(equation.getOperand1()<min||equation.getOperand2()<min){
            return false;
        }
        if(equation.getOperand1()>max||equation.getOperand2()>max){
            return false;
        }
        if(equation.calculate()<min||equation.calculate()>max){
            return false;
        }
        return true;
    }
}
