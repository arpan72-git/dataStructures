public class CountLeafNodesBinaryTree {
    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,5,6,7,8,9,-1,-1,-1,-1,-1,-1};
        System.out.println(countLeafNodes(array, array.length -1, 1));
    }

    public static int countLeafNodes(int[] array, int n, int i){
        if (i > n || array[i] == -1) return 0;

        int x = countLeafNodes(array, n,2*i);
        int y = countLeafNodes(array, n,2*i +1);
        if (x==0 && y==0)
            return x + y +1;
        else return x+y;
    }
}
