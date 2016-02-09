package leetcode;

import java.util.Arrays;

/**
 * Created by yufeijiang on 2/9/16.
 */
public class RectangleAreaSolution {


    /*
    THERE ARE SOME REDUNDANCY IN MY CODE, THIS ONE IS BETTER.
    THE QUESTION HAVE SAID THAT LEFT-BOTTOM AND RIGHT-TOP. USE THIS INFORMATION.
    	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int areaOfRectA = (C-A) * (D-B);
		int areaOfRectB = (G-E) * (H-F);

		int left = Math.max(A, E);
		int right = Math.min(G, C);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);

		//If overlap
		int overlap = 0;
		if(right > left && top > bottom)
			overlap = (right - left) * (top - bottom);

		return areaOfRectA + areaOfRectB - overlap;
	}


     */


    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rectOneX=Math.abs(C-A);
        int rectOneY=Math.abs(D-B);
        int rectOneArea=rectOneX*rectOneY;
        int rectTwoX=Math.abs(G-E);
        int rectTwoY=Math.abs(H-F);
        int rectTwoArea=rectTwoX*rectTwoY;

        int oneYMax=Math.max(B,D);
        int oneYMin=Math.min(B,D);
        int twoYMax=Math.max(F,H);
        int twoYMin=Math.min(F,H);

        int oneXMax=Math.max(A,C);
        int oneXMin=Math.min(A,C);
        int twoXMax=Math.max(G,E);
        int twoXMin=Math.min(G,E);

        if(oneYMax<twoYMin || oneYMin>twoYMax || oneXMax<twoXMin || oneXMin>twoXMax){
            return rectOneArea+rectTwoArea;
        }

        int[] xArray={A,C,E,G};
        int[] yArray={B,D,F,H};
        Arrays.sort(xArray);
        Arrays.sort(yArray);
        int overlapArea=(xArray[2]-xArray[1])*(yArray[2]-yArray[1]);
        return rectOneArea+rectTwoArea-overlapArea;


    }


}
