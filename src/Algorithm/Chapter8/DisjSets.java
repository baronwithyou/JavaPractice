package Algorithm.Chapter8;

public class DisjSets {

    private int []s;

    public DisjSets(int numElements)
    {
        s = new int[numElements];
//        保存每个节点的空节点
        for (int i = 0; i < s.length; i++)
            s[i] = -1;
    }

    public void union(int roo1, int root2)
    {
        s[root2] = roo1;
    }

    /**
     * 返回其节点的根节点
     * @param x
     * @return
     */
    public int find(int x)
    {
        if (s[x] < 0)
            return x;
        else
            return find(s[x]);
    }

    public static void main(String []args) {
        DisjSets djs = new DisjSets(8);
        djs.union(4, 5);
        djs.union(6, 7);
        djs.union(4, 6);
        System.out.println(djs.find(7));
    }
}
