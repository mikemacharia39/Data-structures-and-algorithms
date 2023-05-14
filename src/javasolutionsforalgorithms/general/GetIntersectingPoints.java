package javasolutionsforalgorithms.general;


public class GetIntersectingPoints {

    /**
     *  To find the point of intersection between two lines given by their endpoints, we can use the following steps:
     *  Convert the input strings to integers representing the coordinates of the endpoints.
     *  Calculate the slopes and y-intercepts of the two lines.
     *  Check if the two lines are parallel. If they are, there is no point of intersection and we return null.
     *  Calculate the x-coordinate of the point of intersection using the equation of the line.
     *  This is the value of x where the two lines intersect.
     *  Calculate the y-coordinate of the point of intersection using the value of x calculated
     *  in step 4 and the equation of one of the lines.
     *
     * Also refer to the link:
     * <a href="https://stackoverflow.com/questions/31506740/java-find-intersection-of-two-lines#:~:text=To%20find%20the%20intersection%20point%20of%20the%20x-axis,replace%20x%20for%20its%20value%20%28b2-b1%29%20%2F%20%28m1-m2%29">...</a>.
     *
     * @param point1 4 points of the first line
     * @param point2 4 points of the second line
     * @return the point of intersection between the two lines
     */
    public static String[] getIntersection(String[] point1, String[] point2) {
        int x1 = Integer.parseInt(point1[0]);
        int y1 = Integer.parseInt(point1[1]);
        int x2 = Integer.parseInt(point1[2]);
        int y2 = Integer.parseInt(point1[3]);

        int x3 = Integer.parseInt(point2[0]);
        int y3 = Integer.parseInt(point2[1]);
        int x4 = Integer.parseInt(point2[2]);
        int y4 = Integer.parseInt(point2[3]);

        // Calculate slopes and y-intercepts
        // using y = mx + c
        // where m is the slope and c is the y-intercept
        // m = (y2 - y1) / (x2 - x1), explain why? because y2 = mx2 + c, y1 = mx1 + c, so y2 - y1 = m(x2 - x1)
        // c = y1 - mx1, explain why? because y1 = mx1 + c, so c = y1 - mx1
        double slope1 = (y2 - y1) / (double)(x2 - x1);
        double slope2 = (y4 - y3) / (double)(x4 - x3);
        double yintercept1 = y1 - slope1 * x1;
        double yintercept2 = y3 - slope2 * x3;

        // Check if lines are parallel
        if (slope1 == slope2) {
            return null;
        }

        // Calculate x-coordinate of intersection point
        // x = (c2 - c1) / (m1 - m2)
        double xintersect = (yintercept2 - yintercept1) / (slope1 - slope2);

        // Calculate y-coordinate of intersection point
        // y = mx + c
        double yintersect = slope1 * xintersect + yintercept1;

        return new String[] { String.format("%.2f", xintersect), String.format("%.2f", yintersect) };
    }

    public static void main(String[] args) {
        String[] point1 = { "2", "3", "0", "-3" };
        String[] point2 = { "1", "4", "3", "0" };

        String[] result = GetIntersectingPoints.getIntersection(point1, point2);
        if (result == null) {
            System.out.println("Lines do not intersect");
        } else {
            System.out.println("x: " + result[0] + ", y: " + result[1]);
        }
    }

}
