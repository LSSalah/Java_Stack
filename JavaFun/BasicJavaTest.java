public class BasicJavaTest {
    public static void main(String[] args) {
    BasicJava testNumber = new BasicJava();
    
    int[] testArr = {-9,-7,-5,-3,-1,0,1,3,5,7,9};
    
    testNumber.print1To255();

    testNumber.printOdd1To255();

    testNumber.printSum();

    testNumber.iterateArray(testArr);

    testNumber.findMax(testArr);

    testNumber.arrayOddNumbers();

    testNumber.greaterThanY(testArr, 3);

    testNumber.squareTheValues(testArr);

    testNumber.eliminateNegativeNumbers(testArr);

    testNumber.maxMinAvg(testArr);

    testNumber.shiftingValues(testArr);
    }
}