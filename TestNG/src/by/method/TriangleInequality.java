package by.method;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleInequality {
    public boolean isTriangleExist(int first,int second,int third) {
        return first > 0 && second > 0 && third > 0 && !(first >= second + third || second >= first + third || third >= second + first);
    }

    //1
    @Test
    public void testOnNumbersThreeFourFiveReturnsTrue(){
        final boolean actual = this.isTriangleExist(3,4,5);
        final boolean expected = true;
        Assert.assertEquals(actual,expected);
    }

    //2
    @Test
    public void testWithSumOfTwoNumbersLessThenThirdReturnsFalse(){
        final boolean actual = this.isTriangleExist(3,3,7);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //3
    @Test
    public void testWithTwoFirstNegativeNumberReturnsFalse(){
        final boolean actual = this.isTriangleExist(-3,-4,5);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //4
    @Test
    public void testWithOneFirstNegativeNumberReturnsFalse(){
        final boolean actual = this.isTriangleExist(-3,4,5);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //5
    @Test
    public void testWithOnlyNegativeNumbersReturnsFalse(){
        final boolean actual = this.isTriangleExist(-3,-4,-5);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //6
    @Test
    public void testWithFirstZeroNumberReturnsFalse(){
        final boolean actual = this.isTriangleExist(0,4,5);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //7
    @Test
    public void testWithAllZerosReturnsFalse(){
        final boolean actual = this.isTriangleExist(0,0,0);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //8
    @Test
    public void testWithSumOfTwoEqualsThirdReturnsFalse(){
        final boolean actual = this.isTriangleExist(5,5,10);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

    //9
    @Test
    public void testWithAllSameNumbersThatNotZeroReturnsTrue(){
        final boolean actual = this.isTriangleExist(5,5,5);
        final boolean expected = true;
        Assert.assertEquals(actual,expected);
    }

    //10
    @Test
    public void testWithTwoZerosReturnsFalse(){
        final boolean actual = this.isTriangleExist(0,0,4);
        final boolean expected = false;
        Assert.assertEquals(actual,expected);
    }

}
