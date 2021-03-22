import java.util.LinkedList;

/**
 * 深度优先搜索
 *
 * @since 2021-03-22
 */
public class GrapDfs {
    // 顶点的个数
    private int v;

    // 邻接表
    private LinkedList<Integer>[] adj;

    // 标记顶点是否被访问
    private boolean[] visited;

    // 记录一个顶点的前一个顶点
    private Integer[] pre;

    // 标记是否已经找到
    private boolean found = false;

    public GrapDfs(int v) {
        this.v = v;
        adj = new LinkedList[v];
        visited = new boolean[v];
        pre = new Integer[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
            pre[i] = -1;
        }
    }

    public void add(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    public void dfs(int start, int end) {
        // 已经找到路径
        if (found) {
            return;
        }
        if (start == end) {
            print(pre, end);
            System.out.println(end);
            found = true;
            return;
        }

        visited[start] = true;
        int size = adj[start].size();
        for (int i = 0; i < size; i++) {
            Integer next = adj[start].get(i);
            if (!visited[next]) {
                pre[next] = start;
                dfs(next, end);
            }
        }
    }

    private void print(Integer[] pre, Integer end) {
        if (pre[end] == -1) {
            return;
        }
        int p = pre[end];
        print(pre, p);
        System.out.print(p);
    }

    public static void main(String[] args) {
        GrapDfs grap = new GrapDfs(9);
        grap.add(1, 2);
        grap.add(1, 4);
        grap.add(2, 3);
        grap.add(2, 5);
        grap.add(3, 6);
        grap.add(4, 5);
        grap.add(5, 6);
        grap.add(5, 7);
        grap.add(6, 8);
        grap.add(7, 8);
        grap.dfs(1, 7);
    }
}
