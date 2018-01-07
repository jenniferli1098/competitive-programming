package codebook;

public class UnionFind {
    static class Union {
        int[] parent;

        public Union(int N) {
            this.parent = new int[N];

            for (int i = 0; i < this.parent.length; i++) {
                this.parent[i] = i;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            if (this.parent[x] == x) {
                return x;
            } else {
                this.parent[x] = find(this.parent[x]);
                return this.parent[x];
            }
        }

        public void unite(int x, int y) {
            this.parent[find(x)] = find(y);
        }

        public void debug() {
            for (int i = 0; i < this.parent.length; i++) {
                System.out.println("Index => " + i + " Parent => " + this.parent[i]);
            }
        }
    }
}
