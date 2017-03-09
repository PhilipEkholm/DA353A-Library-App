package p2;
import java.lang.reflect.Constructor;
import java.util.Iterator;

import javax.swing.JOptionPane;

import collections.List;
import collections.Map;
import collections.Queue;
import collections.SearchTree;
import collections.ArrayList;

public class TestP2 {
    
    private static void test(boolean condition, String... message ) {
        if (condition && message.length>0)
            System.out.println(message[0]);
        else if (message.length > 1)
            System.out.println(message[1]);
    }
    
    private static <T> boolean member(T elem, List<T> list) {
        return list.indexOf(elem)>=0;
    }
    
    private static <T> boolean remove(T elem, T[] arr) {
        for(int i=0; i<arr.length; i++)
            if(elem.equals(arr[i])) {
                arr[i]=null;
                return true;
            }
        return false;
    }
    
    public static <T> void testQueue(String queueType, T[]... array) throws Exception {
        System.out.println(queueType);
        Class cls = Class.forName(queueType);
        Constructor constructor;
        Queue<T> queue;
        try {
            constructor = cls.getConstructor(new Class[] {});
            queue = (Queue<T>)constructor.newInstance(new Object[]{});
        } catch(Exception e) {
            constructor = cls.getConstructor(new Class[] {int.class});
            queue = (Queue<T>)constructor.newInstance(new Object[]{20});
        }
        for(T item : array[0]) {
            queue.enqueue(item);
        }
        test((queue.size()==array[0].length),"queue-size: pass","queue-size: fail");
        int i=0;
        T item, previousItem = null;
        boolean ascending = true, descending = true;
        while(!queue.isEmpty() && i<array[0].length) {
            if(array.length==1)
                test(queue.dequeue().equals(array[0][i]),"queue-dequeue: pass","queue-dequeue: fail");
            else { // PriorityQueue
                item = queue.dequeue();
                if(i>=1) {
                    ascending = ascending && ((Comparable<T>)previousItem).compareTo(item)<=0;
                    descending = descending && ((Comparable<T>)previousItem).compareTo(item)>=0;
                }
                previousItem = item;
            }
            i++;
        }
        test(ascending || descending, "PriorityQueue: pass", "PriorityQueue: fail");
        test(queue.isEmpty() && i==array[0].length,"queue-enqueue/dequeue: pass","queue-enqueue/dequeue: fail");
    }
    
    public static <K,V> void testSearchTree(String searchTreeType, K[] keys, V[] values) throws Exception {
        System.out.println(searchTreeType);
        Class cls = Class.forName(searchTreeType);
        Constructor constructor = cls.getConstructor(new Class[] {});
        SearchTree<K,V> tree = (SearchTree<K,V>)constructor.newInstance(new Object[]{});
        V[] tempValues = values.clone();

        test(tree.size()==0,"tree-size==0: pass", "tree-size==0: fail");
        for(int i=0; i<keys.length; i++) {
            tree.put(keys[i],values[i]);
        }
        test(tree.size()==keys.length,"tree-size/put: pass", "tree-size/put: fail, " + tree.size() + "!=" + keys.length);        
        
        for(int i=0; i<keys.length; i++) {
            test(tree.contains(keys[i]),"tree-contains: pass", "tree-contains: fail");
            if(tree.contains(keys[i])) {
            	test(tree.get(keys[i]).equals(values[i]),"tree-get: pass", "tree-get: fail");
            }
        }
        
        List<K> treeKeys = tree.keys();
        boolean ok = true;
        for(K key : keys) {
            ok = ok && member(key,treeKeys);
        }
        test(ok,"tree-keys: pass","tree-keys: fail");
        
        Iterator<V> iter = tree.iterator();
        int i=0;
        ok = true;
        while(iter.hasNext()) {
            V value = iter.next();
            ok = ok && remove(value,tempValues);
            i++;
        }
        test(ok,"tree-iterator: values pass","tree-iterator: felaktigt value/values");        
        test(values.length==i,"tree-iterator: antal values pass","tree-iterator: Fel antal values i iterator");
        
        List<V> treeValues = tree.values();
        ok = true;
        for(V value : values) {
            ok = ok && member(value,treeValues);
        }
        test(ok,"tree-values: pass","tree-values: fail");
        
        ok = true;
        for(i=0; i<keys.length; i++) {
        	ok = ok && tree.remove(keys[i])!=null && tree.get(keys[i])==null;
        }
        test(ok,"tree-remove: pass","tree-remove: fail");
    }

    public static <K,V> void testMap(String mapType, K[] keys, V[] values) throws Exception {
        System.out.println(mapType);
        Class cls = Class.forName(mapType);
        Constructor constructor;
        Map<K,V> map;
        try {
            constructor = cls.getConstructor(new Class[] {});
            map = (Map<K,V>)constructor.newInstance(new Object[]{});
        } catch(Exception e) {
            constructor = cls.getConstructor(new Class[] {int.class});
            map = (Map<K,V>)constructor.newInstance(new Object[]{20});
        }
        test(map.isEmpty(),"tree-isEmpty: pass", "tree-isEmpty: fail");
        for(int i=0; i<keys.length; i++) {
            map.put(keys[i],values[i]);
        }
        test(map.size()==keys.length,"map-size/put: pass", "map-size/put: fail, " + map.size() + "!=" + keys.length);        
        
        for(int i=0; i<keys.length; i++) {
            test(map.containsKey(keys[i]),"map-containsKey: pass", "map-containsKey: fail");
            if(map.containsKey(keys[i])) {
            	test(map.get(keys[i]).equals(values[i]),"map-get: pass", "map-get: fail");
            }
        }
        
        K[] tempKeys = keys.clone();
        Iterator<K> mapKeys = map.keys();
        boolean ok = true;
        int i=0;
        while(mapKeys.hasNext()) {
            K key = mapKeys.next();
            ok = ok && remove(key,tempKeys);
            i++;
        }
        test(ok,"map-keys: pass","map-keys: fail");        
        test(keys.length==i,"map-keys: Korrekt antal nycklar","map-keys: Fel antal nycklar");
        
        Iterator<V> mapValues = map.values();
        V[] tempValues = values.clone();
        ok = true;
        i=0;
        while(mapValues.hasNext()) {
            V value = mapValues.next();
            ok = ok && remove(value,tempValues);
            i++;
        }
        test(ok,"map-values: pass","map-values: fail");
        test(values.length==i,"map-values: Korrekt antal values","map-values: Fel antal values");
        
        ok = true;
        for(i=0; i<keys.length; i++) {
        	ok = ok && map.remove(keys[i])!=null && map.get(keys[i])==null;
        }        
        test(ok,"map-remove: pass","map-remove: fail");
    }

    public static void main(String[] args) {
        String menu = "Test av:\n\n"
                + "1.  LinkedQueue\n" + "2.  ArrayQueue\n"
                + "3.  PriorityQueue\n"
                + "4.  BinarySearchTree\n" + "5.  AVLTree\n"
                + "6.  HashtableOH\n"
                + "0.  Avsluta programmet\n\n" + "Ange ditt val";
        int choice = -1;
        while (choice != 0) {
            try {
                switch (choice) {
                case 1:
                    testQueue("collections.LinkedQueue", new Integer[]{2,4,6,8,1,3,5,7});
                    break;
                case 2:
                    testQueue("collections.ArrayQueue", new Integer[]{2,4,6,8,1,3,5,7});
                    break;
                case 3:
                    testQueue("collections.PriorityQueue", new Integer[]{2,4,6,8,1,3,5,7}, new Integer[]{1,2,3,4,5,6,7,8});
                    break;
                case 4:
                    testSearchTree("collections.BinarySearchTree", new Integer[]{1,5,6,2,3,4}, 
                            new String[]{"one","five","six","two","tree","four"});
                    break;
                case 5:
                    testSearchTree("collections.AVLTree", new Integer[]{1,5,6,2,3,4}, 
                            new String[]{"one","five","six","two","tree","four"});
                    break;
                case 6:
                    testMap("collections.HashtableOH", new Integer[]{1,5,6,2,3,4}, 
                            new String[]{"one","five","six","two","tree","four"});
                    break;
                }
                choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (Exception e) {
                System.out.println(e);
                choice = -1;
            }
        }
    }

}
