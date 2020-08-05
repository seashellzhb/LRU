import org.junit.Test;

public class LRUTest {

    @Test
    public void testLru() {

        LRUCache lruCache = new LRUCache(3);

        lruCache.put(1, "val1");
        lruCache.put(2, "val2");
        lruCache.put(3, "val3");

        lruCache.getCache().printDllNodes();

        // 读取2， 2应该到链表尾部
       String val_2 = lruCache.get(2);
       System.out.printf("Read value for key 2 is %s %n", val_2);
       lruCache.getCache().printDllNodes();

        /**
         * cache 达到最大容量时，添加新元素
         * 最久未访问（链表头节点指向的数据）被剔除
         * 新元素被加到链表尾部
         * */
        // 添加4， 4应该被加到尾部
        lruCache.put(4, "val4");
        System.out.println("After add 4");
        lruCache.getCache().printDllNodes();

    }

}
