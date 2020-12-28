import java.lang.Math;
public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        int squareLegA = legA * legA;
        int squareLegB = legB * legB;
        int squareLegC = squareLegA + squareLegB;
        double legC = Math.sqrt(squareLegC);
        return legC;
    }
}
