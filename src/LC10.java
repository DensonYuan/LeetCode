public class LC10 {
    public static void main(String[] args) {
        int[] height = {1, 3, 4, 51, 2, 45, 23, 56, 24, 6, 21, 5, 3, 55, 62, 4, 77, 8, 4, 99, 4};
        System.out.println(new LC10().maxArea(height));
        System.out.println(new LC10().maxArea1(height));
    }

    public int maxArea(int[] height) {
        int ma = 0, i = 0, j = height.length - 1;
        int ca;
        while (i < j) {
            if (height[i] < height[j]) {
                ca = (j - i) * height[i];
                i++;
            } else {
                ca = (j - i) * height[j];
                j--;
            }
            if (ca > ma) ma = ca;
        }
        return ma;
    }

    // 超时,O(n^2)
    public int maxArea1(int[] height) {
        int ma = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int ca = (j - i) * Math.min(height[i], height[j]);
                if (ca > ma)
                    ma = ca;
            }
        }
        return ma;
    }
}