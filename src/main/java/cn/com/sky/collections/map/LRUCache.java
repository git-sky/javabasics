package cn.com.sky.collections.map;

import java.util.HashMap;

/**
 *
 */
public class LRUCache<K, V> {

    //缓存大小
    private final int MAX_CACHE_SIZE;
    //头指针
    private Entry<K, V> first;
    //尾指针
    private Entry<K, V> last;

    private HashMap<K, Entry<K, V>> hashMap;

    public LRUCache(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<K, Entry<K, V>>();
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry<K, V>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        hashMap.put(key, entry);
    }

    public V get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null)
            return null;
        moveToFirst(entry);
        return entry.value;
    }

    public void remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            if (entry.pre != null)
                entry.pre.next = entry.next;
            if (entry.next != null)
                entry.next.pre = entry.pre;
            if (entry == first)
                first = entry.next;
            if (entry == last)
                last = entry.pre;
        }
        hashMap.remove(key);
    }

    private void moveToFirst(Entry<K, V> entry) {
        if (entry == first)
            return;
        if (entry.pre != null)
            entry.pre.next = entry.next;
        if (entry.next != null)
            entry.next.pre = entry.pre;
        if (entry == last)
            last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null)
                first = null;
            else
                last.next = null;
        }
    }

    private Entry<K, V> getEntry(K key) {
        return hashMap.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry<K, V> entry = first;
        while (entry != null) {
            sb.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }

    class Entry<K, V> {
        //前驱
        public Entry<K, V> pre;
        //后驱
        public Entry<K, V> next;
        public K key;
        public V value;
    }
}