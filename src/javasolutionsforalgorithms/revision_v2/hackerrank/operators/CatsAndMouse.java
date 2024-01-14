package javasolutionsforalgorithms.revision_v2.hackerrank.operators;

/**
 * Two cats and a mouse are at various positions on a line. You will be given their starting positions.
 * Your task is to determine which cat will reach the mouse first,
 * assuming the mouse does not move and the cats travel at equal speed.
 * If the cats arrive at the same time, the mouse will be allowed to move and it will escape while they fight.
 *
 * You are given  queries in the form of x, y, and z representing the respective positions for cats x and y, and for mouse y.
 * Complete the function  to return the appropriate answer to each query, which will be printed on a new line.
 *
 * If cat x catches the mouse first, print Cat A.
 * If cat y catches the mouse first, print Cat B.
 * If both cats reach the mouse at the same time, print Mouse C as the two cats fight and mouse escapes.
 *
 */
public class CatsAndMouse {

    static String catAndMouse(int x, int y, int z) {
        int catAMouseDistance = Math.abs(z-x);
        int catBMouseDistance = Math.abs(z-y);

        if (catAMouseDistance < catBMouseDistance) {
            return "Cat A";
        } else if (catAMouseDistance > catBMouseDistance) {
            return "Cat B";
        }

        return "Mouse C";
    }
}
