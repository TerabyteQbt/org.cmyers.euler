package org.cmyers.practice.lru_cache;

class Main {
    public static final void main(String[] args) {
        System.out.println("Practice lru_cache");
        LruCache<String, String> cache = new LruCache<>();
        // default max size = 10
        cache.set("a", "aval");
        assertNotNull(cache.get("a"));
        cache.set("b", "bval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        cache.set("c", "cval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        cache.set("d", "dval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        cache.set("e", "eval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        cache.set("f", "fval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        assertNotNull(cache.get("f"));
        cache.set("g", "gval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        assertNotNull(cache.get("f"));
        assertNotNull(cache.get("g"));
        cache.set("h", "hval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        assertNotNull(cache.get("f"));
        assertNotNull(cache.get("g"));
        assertNotNull(cache.get("h"));
        cache.set("i", "ival");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        assertNotNull(cache.get("f"));
        assertNotNull(cache.get("g"));
        assertNotNull(cache.get("h"));
        assertNotNull(cache.get("i"));
        cache.set("j", "jval");
        assertNotNull(cache.get("a"));
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        assertNotNull(cache.get("f"));
        assertNotNull(cache.get("g"));
        assertNotNull(cache.get("h"));
        assertNotNull(cache.get("i"));
        assertNotNull(cache.get("j"));
        cache.set("k", "kval");
        assertNotNull(cache.get("b"));
        assertNotNull(cache.get("c"));
        assertNotNull(cache.get("d"));
        assertNotNull(cache.get("e"));
        assertNotNull(cache.get("f"));
        assertNotNull(cache.get("g"));
        assertNotNull(cache.get("h"));
        assertNotNull(cache.get("i"));
        assertNotNull(cache.get("j"));
        assertNotNull(cache.get("k"));
        assertNull(cache.get("a"));
    }

    private static final void assertNotNull(Object n) {
        if(n == null) {
            throw new AssertionError("Object was null");
        }
    }
    private static final void assertNull(Object n) {
        if(n != null) {
            throw new AssertionError("Object was not null");
        }
    }
}

