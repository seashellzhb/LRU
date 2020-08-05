import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, Node> map = new HashMap<>();
    private DoublyLinkedList cache = new DoublyLinkedList();

    public Map<Integer, Node> getMap() {
        return map;
    }

    public DoublyLinkedList getCache() {
        return cache;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    private int maxCapacity;

    public LRUCache(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String get(int key) {
        if (!map.containsKey(key)) {
            return null;
        }
        // 调整到双向链表尾部，代表是最近访问
        adjustAsRecent(key);

        return map.get(key).val;
    }

    public void put(int key, String val) {
        // 首先检查key 是不是已经存在， 如果存在则更新不会涉及到超出容量需要eviction
        if(map.containsKey(key)) {
            // 删除旧的数据
            deleteByKey(key);
            // 添加为最近使用元素
            addAsRecent(key, val);
        }

        // 超出最大容量，先删除最久未访问的节点 （头节点）
        if (maxCapacity == cache.getSize()) {
            removeLeastRecent();
        }

        // 添加为最近使用元素
        addAsRecent(key, val);
    }

    public void printCache() {

    }

    //-------------------

    private void adjustAsRecent(int key) {
        Node node = map.get(key);
        // 先删除该节点
        cache.removeNode(node);
        // 挪到改节点到双向两边尾部， 表示最近被访问
        cache.addNodeLast(node);

    }

    private void deleteByKey(int key) {
        Node node = map.get(key);
        cache.removeNode(node);
        map.remove(key);
    }

    private void addAsRecent(int key, String val) {
        Node node = new Node(key, val);
        map.put(key, node);
        cache.addNodeLast(node);
    }

    private void removeLeastRecent() {
        Node node = cache.removeFirst();
        map.remove(node.key);
    }






}
