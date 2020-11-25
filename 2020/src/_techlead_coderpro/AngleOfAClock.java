package _techlead_coderpro;

public class AngleOfAClock {
    public static void main(String[] args) {
        System.out.println(calcAngle(3, 15));
        System.out.println(calcAngle(3, 00));
    }

    public static double calcAngle(int h, int m) {
        double h_angle = (360 / (12 * 60.0)) * (h * 60) + m;
        double m_angle = 360 / 60.0 * m;
        double angle = Math.abs(h_angle - m_angle);
        return Math.min(angle, 360 - angle);
    }
}
