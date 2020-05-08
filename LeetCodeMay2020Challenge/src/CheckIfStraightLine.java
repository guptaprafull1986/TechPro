/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 * |
 * |
 * |             o(6,7)
 * |           o(5,6)
 * |         o(4,5)
 * |       o(3,4)
 * |     o(2,3)
 * |  o(1,2)
 * |_____________________________
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * |
 * |
 * |              o(7,7)
 * |            o(5,6)
 * |          o(4,5)
 * |        o(3,4)
 * |     o(2,2)
 * |  o(1,1)
 * |_____________________________
 * <p>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class CheckIfStraightLine {
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        float m = getSlope(coordinates, 1);

        for (int i = 2; i < coordinates.length; i++) {
            float mi = getSlope(coordinates, i);

            if (m != mi) {
                return false;
            }
        }

        return true;
    }

    float getSlope(int[][] coordinates, int i) {
        float dy = coordinates[i][1] - coordinates[i - 1][1];
        float dx = coordinates[i][0] - coordinates[i - 1][0];
        float m = dy / dx;
        return m;
    }
}
