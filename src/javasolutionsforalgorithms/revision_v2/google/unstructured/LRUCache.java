package javasolutionsforalgorithms.revision_v2.google.unstructured;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">...</a>
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    private final int capacity;
    public final Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;

        // Create a LinkedHashMap with initial capacity, load factor 0.75, and access order enabled
        // access order true means order by the last accessed, while false means order by insertion
        this.cache = new LinkedHashMap<Integer, Integer>(this.capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return cache.size() > capacity;
            }
        };
    }

    int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }

    void put(int key, int value) {
        this.cache.put(key, value);
    }
}
