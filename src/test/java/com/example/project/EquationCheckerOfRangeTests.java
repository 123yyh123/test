package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author yyh
 * @date 2023-12-06
 */
public class EquationCheckerOfRangeTests {
    private EquationCheckerOfRange equationCheckerOfRange;

    public static Stream<Arguments> equationProvider() {
        return Stream.of(
                Arguments.of(new SimpleTriplet(1, 2, true)),
                Arguments.of(new SimpleTriplet(3, 4, true)),
                Arguments.of(new SimpleTriplet(5, 6, true)),
                Arguments.of(new SimpleTriplet(74, 82, false)),
                Arguments.of(new SimpleTriplet(9, 10, true))
        );
    }

    public static Stream<Arguments> equationProvider2() {
        return Stream.of(
                Arguments.of(new SimpleTriplet(1, 2, false)),
                Arguments.of(new SimpleTriplet(3, 4, false)),
                Arguments.of(new SimpleTriplet(45, 6, true)),
                Arguments.of(new SimpleTriplet(34, 23, true)),
                Arguments.of(new SimpleTriplet(9, 10, false))
        );
    }

    @BeforeEach
    void setUp() {
        equationCheckerOfRange = new EquationCheckerOfRange(0, 100);
    }

    @Test
    @DisplayName("A basic assert")
    void useCodedValue() {
        AddEquation addEquation = AddEquation.AddEquationBuilder.build((short) 1, (short) 1);
        assertTrue(equationCheckerOfRange.check(addEquation), "1 and 1 should be in range");
    }

    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "0, 1, '-',false",
            "4, 2,'-',true"
    })
    void useCsvSource(int first, int second, char operator, boolean expectedResult) {
        SubEquation subEquation = SubEquation.SubEquationBuilder.build((short) first, (short) second);
        assertEquals(expectedResult,
                equationCheckerOfRange.check(subEquation),
                () -> first + " " + operator + " " + second + " should be " + expectedResult);
    }

    @ParameterizedTest(name = "using CsvSource")
    @CsvSource({
            "46, 87, '+',false",
            "34, 23,'+',true"
    })
    void useCsvSource2(int first, int second, char operator, boolean expectedResult) {
        AddEquation addEquation = AddEquation.AddEquationBuilder.build((short) first, (short) second);
        assertEquals(expectedResult,
                equationCheckerOfRange.check(addEquation),
                () -> first + " " + operator + " " + second + " should be " + expectedResult);
    }

    @RepeatedTest(value = 5, name = "using RepeatedTest")
    void useRepeatedTest() {
        assertEquals(true,
                equationCheckerOfRange.check(AddEquation.AddEquationBuilder.build((short) 34, (short) 43)),
                "34 and 43 and 77 should be in range");
    }

    @ParameterizedTest(name = "using MethodSource")
    @MethodSource("equationProvider")
    void useMethodSource(SimpleTriplet triplet) {
        assertEquals(triplet.result,
                equationCheckerOfRange.check(AddEquation.AddEquationBuilder.build((short) triplet.op1, (short) triplet.op2)),
                "should equal");
    }

    @ParameterizedTest(name = "using MethodSource")
    @MethodSource("equationProvider2")
    void useMethodSource2(SimpleTriplet triplet) {
        assertEquals(triplet.result,
                equationCheckerOfRange.check(SubEquation.SubEquationBuilder.build((short) triplet.op1, (short) triplet.op2)),
                "should equal");
    }

    public static class SimpleTriplet {
        public int op1;
        public int op2;
        public boolean result;

        public SimpleTriplet(int op1, int op2, boolean result) {
            this.op1 = op1;
            this.op2 = op2;
            this.result = result;
        }
    }

}
