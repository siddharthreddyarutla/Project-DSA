package Impl.hashMap;

import utils.GenericUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * | Method        | Average Case | Worst Case |
 * | ------------- | ------------ | ---------- |
 * | put()         | O(1)         | O(n)       |
 * | get()         | O(1)         | O(n)       |
 * | remove()      | O(1)         | O(n)       |
 * | containsKey() | O(1)         | O(n)       |
 * | keySet()      | O(n)         | O(n)       |
 * | values()      | O(n)         | O(n)       |
 * | size()        | O(1)         | O(1)       |
 * | isEmpty()     | O(1)         | O(1)       |
 * | rehash()      | O(n)         | O(n)       |
 */

public class HashMapImpl {
    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        System.out.println(hashMap.isEmpty());

        System.out.println(hashMap.get("hyb"));

        hashMap.put("hyb", 50);
        hashMap.put("Chennai", 100);
        hashMap.put("Bnglr", 200);

        System.out.println(hashMap.size());

        System.out.println(hashMap.get("Chennai"));
        System.out.println(hashMap.get("Bnglr"));

        System.out.println(hashMap.keySet());

        System.out.println(hashMap.containsKey("pune"));

        System.out.println(hashMap.remove("Chennai"));

        System.out.println(hashMap.values());

        System.out.println(hashMap.size());
    }

    public static class HashMap<K, V> {

        public class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // nodes
        private int N; // Size of the buckets
        int K; // Lambda value

        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.K = 2;
            this.buckets = new LinkedList[N];

            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {

            GenericUtils.Pair<Integer, Integer> pair = getBucketAndDataIndex(key);

            int bucketIndex = pair.first;

            int dataIndex = pair.second;

            if (dataIndex == -1) {
                buckets[bucketIndex].add(new Node(key, value));
                n++;
            } else {
                buckets[bucketIndex].get(dataIndex).value = value;
            }

            int lambda = n / N;

            if (lambda > K) {
                rehash();
            }
        }

        public V get(K key) {

            GenericUtils.Pair<Integer, Integer> pair = getBucketAndDataIndex(key);

            int bucketIndex = pair.first;

            int dataIndex = pair.second;

            if (dataIndex == -1) {
                return null;
            } else {
                return buckets[bucketIndex].get(dataIndex).value;
            }
        }

        public boolean containsKey(K key) {

            GenericUtils.Pair<Integer, Integer> pair = getBucketAndDataIndex(key);

            int bucketIndex = pair.first;

            int dataIndex = pair.second;

            if (dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {

            GenericUtils.Pair<Integer, Integer> pair = getBucketAndDataIndex(key);

            int bucketIndex = pair.first;

            int dataIndex = pair.second;

            if (dataIndex == -1) {
                return null;
            } else {
                Node node = buckets[bucketIndex].get(dataIndex);
                buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
        }

        public Set<K> keySet() {

            Set<K> keySet = new HashSet<>();

            for (int bucketIndex = 0; bucketIndex < N; bucketIndex++) {
                for (int dataIndex = 0; dataIndex < buckets[bucketIndex].size(); dataIndex++) {
                    keySet.add(buckets[bucketIndex].get(dataIndex).key);
                }
            }

            return keySet;
        }

        public Set<V> values() {

            Set<V> values = new HashSet<>();

            for (int bucketIndex = 0; bucketIndex < N; bucketIndex++) {
                for (int dataIndex = 0; dataIndex < buckets[bucketIndex].size(); dataIndex++) {
                    values.add(buckets[bucketIndex].get(dataIndex).value);
                }
            }

            return values;
        }

        public int size() {
            return n;
        }

        private void rehash() {

            LinkedList<Node> oldBucket[] = buckets;

            buckets = new LinkedList[N * 2];

            for (int bucketIndex = 0; bucketIndex < oldBucket.length; bucketIndex++) {
                LinkedList<Node> ll = oldBucket[bucketIndex];

                for (int dataIndex = 0; dataIndex < ll.size(); dataIndex++) {
                    Node node = ll.get(dataIndex);
                    put(node.key, node.value);
                }
            }
        }

        private boolean isEmpty() {
            return n == 0;
        }

        public GenericUtils.Pair<Integer, Integer> getBucketAndDataIndex(K key) {
            int bucketIndex = hashFunction(key);
            int dataIndex = getDataIndex(bucketIndex, key);

            return new GenericUtils.Pair<>(bucketIndex, dataIndex);
        }

        private int getDataIndex(int bucketIndex, K key) {

            LinkedList<Node> linkedList = buckets[bucketIndex];

            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i).key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        private int hashFunction(K key) {
            int hash = key.hashCode();
            return Math.abs(hash) % N;
        }
    }
}
