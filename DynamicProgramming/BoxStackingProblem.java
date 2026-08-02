package DynamicProgramming;

import java.util.Arrays;

public class BoxStackingProblem {
   /* Question:-
    Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [widthi, lengthi, heighti] (0-indexed).
     Choose a subset of cuboids and place them on each other.

    You can place cuboid i on cuboid j if widthi <= widthj and lengthi <= lengthj and heighti <= heightj.
     You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

    Return the maximum height of the stacked cuboids.



    Example 1:



    Input: cuboids = [[50,45,20],[95,37,53],[45,23,12]]
    Output: 190
    Explanation:
    Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
    Cuboid 0 is placed next with the 45x20 side facing down with height 50.
    Cuboid 2 is placed next with the 23x12 side facing down with height 45.
    The total height is 95 + 50 + 45 = 190..*/


    /*
    So lets make a approch,
    first we need to decide which box to choose, either we can sort the arrays (nlogn)
            or we need to iterate the arrays everytime  n*n

    then 2nd step is to choose or reject the box
    if choose we need to see which dimention
    so lets make all the boxes first by rotating first*/

    public static void main(String[] args) {
        int[][] cuboids = new int[][] {
                {50, 45, 20},
                {95, 37, 53},
                {45, 23, 12}
        };
        System.out.println(maxHeight(cuboids));
    }

    static int[][] makeAllBoxes(int[][] cuboids) {

        int n = cuboids.length;
        int[][] boxes = new int[n * 3][3];

        int x = 0;

        for (int i = 0; i < n; i++) {

            int h = cuboids[i][0];
            int l = cuboids[i][1];
            int w = cuboids[i][2];

            // Rotation 1: height = h
            boxes[x][0] = Math.max(l, w);  // length
            boxes[x][1] = Math.min(l, w);  // width
            boxes[x][2] = h;               // height

            // Rotation 2: height = l
            boxes[x + 1][0] = Math.max(h, w);
            boxes[x + 1][1] = Math.min(h, w);
            boxes[x + 1][2] = l;

            // Rotation 3: height = w
            boxes[x + 2][0] = Math.max(h, l);
            boxes[x + 2][1] = Math.min(h, l);
            boxes[x + 2][2] = w;

            x += 3;
        }

        return boxes;
    }

    static int [][] sortBoxes(int[][] boxes) {
        Arrays.sort(boxes, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // height desc
            } else {
                return Integer.compare(b[1], a[1]); // width desc
            }
        });
        return boxes;
    }

    public static int maxHeight(int[][] cuboids) {
        if(cuboids == null || cuboids.length == 0) return 0;
        int[][] boxes = makeAllBoxes(cuboids);
        boxes = sortBoxes(boxes);
        int i=0;

        int max = chooseBox(i,boxes, 0,boxes.length);
        return max;
    }

    private static int chooseBox(int i, int[][] cuboids, int height, int size) {
        if (size <= i) {
            return height;
        }
        if (i == 0) {
            return height+chooseBox(i+1,cuboids,height+cuboids[i][2],size);
        }
        if((cuboids[i][0]>cuboids[i-1][0]) && (cuboids[i][1]>cuboids[i-1][1])){
            return height+chooseBox(i+1,cuboids,height+cuboids[i][2],size);
        }
        else return height+chooseBox(i+1,cuboids,height,size);

    }


}
