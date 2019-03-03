import spock.lang.Specification
import tdd.example.CalculateTest

import java.math.RoundingMode

class TestSpock extends Specification{
    def "계산"(){
        given:
        RoundingMode 소수점버림 = RoundingMode.DOWN;

        when:
        def calculate = CalculateTest.calculate(10000L, 0.1f, 소수점버림)

        then:
        calculate == 10L
    }

    def "where 사용하기"(){
        given:
        RoundingMode 소수점버림 = RoundingMode.DOWN;

        expect:
        CalculateTest.calculate(amount, rate, 소수점버림) == result

        where:
        amount | rate | result
        10000L | 0.1f | 10L
        2799L | 0.2f | 5L
    }
}