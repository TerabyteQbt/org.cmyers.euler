package org.cmyers.practice.lru_cache;

import java.util.HashMap;

/**
 * very not thread safe.
 * Created by cmyers on 4/6/16.
 */
public class LruCache<K, V> {
    private static class Node<V> {
        public final V item;
        public Node<V> prev;
        public Node<V> next;

        public Node(V item) {
            this.item = item;
        }

        public Node(V item, Node<V> prev, Node<V> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

    }
    private static final int DEFAULT_MAX_SIZE = 10;

    // list of nodes in order of most recent access
    private Node<K> lruData;
    private Node<K> lruDataEnd;

    // map to find nodes in O(1)
    private final HashMap<K, Node<K>> nodes;
    // map of the key to the item
    private final HashMap<K, V> values;
    private int currentSize;

    private final int maxSize;

    public LruCache() {
        //System.currentTimeMillis();
        maxSize = DEFAULT_MAX_SIZE;
        nodes = new HashMap<>();
        values = new HashMap<>();
        lruData = null;
        lruDataEnd = null;
        currentSize = 0;
    }

    private void moveItemToFront(K key) {
        Node<K> thisNode = nodes.get(key);
        if(lruData.equals(thisNode)) {
            // item already first
            return;
        }
        // remove item from list
        if(lruDataEnd == thisNode) {
            // item is end of list
            lruDataEnd = lruDataEnd.prev;
        }
        Node<K> prevNode = thisNode.prev; // we know not null because it wasn't the first in the list
        Node<K> nextNode = thisNode.next;
        prevNode.next = nextNode;
        // next node could have been null if it was the end of the list
        if(nextNode != null) {
            nextNode.prev = prevNode;
        }

        // now insert as first
        thisNode.prev = null;
        thisNode.next = lruData;
        lruData.prev = thisNode;
        lruData = thisNode;
    }

    // get and set
    public V get(K key) {
        if(nodes.containsKey(key)) {
            moveItemToFront(key);
        }
        return values.get(key);
    }

    public void set(K key, V item) {
        if(values.containsKey(key)) {
            // update value
            values.put(key, item);
            moveItemToFront(key);
        }
        // item not present yet
        if(currentSize == maxSize) {
            removeLeastRecentlyUsed();
        }
        insertNewItem(key, item);
    }

    // item MUST not already exist in the relevant data structures
    private void insertNewItem(K key, V item) {
        values.put(key, item);
        lruData = new Node<>(key, null, lruData);
        if(lruDataEnd == null) {
            lruDataEnd = lruData;
        }
        nodes.put(key, lruData);
        currentSize++;
    }

    // TODO
    private void removeLeastRecentlyUsed() {
        K key = lruDataEnd.item;
        if(lruDataEnd == null) {
            return;
        }
        lruDataEnd = lruDataEnd.prev; // may be null if list has only 1 item
        nodes.remove(key);
        values.remove(key);
    }
}
