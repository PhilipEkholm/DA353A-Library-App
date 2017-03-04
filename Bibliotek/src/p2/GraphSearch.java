package p2;
import java.util.*;

public class GraphSearch {

    /*************************** DEPTH FIRST TRAVERSAL **********************
     * Traverserar grafen genom sökning på djupet. Noderna returneras
     * som en Iterator-implementering
     * @param graph grafen som traverseras
     * @param from nod i vilken travereringen startar
     * @return noderna som besökts
     */
    public static <V> Iterator<V> traversalDF(Graph<V> graph, V start) {
        LinkedList<Edge<V>> stack = new LinkedList<Edge<V>>();
        LinkedHashSet<V> visited = new LinkedHashSet<V>();
        Edge<V> edge;

        visited.add(start);
        stack.addAll(graph.getAdjacentList(start));
        while( !stack.isEmpty() ) {
            edge = stack.removeLast();
            if(!visited.contains(edge.getTo())) {
                visited.add(edge.getTo());
                stack.addAll(graph.getAdjacentList(edge.getTo()));
            }
        }
        return visited.iterator();
    }
    /*************************** DEPTH FIRST SEARCH *************************
     * Sökning av väg från <code>from</code> till <code>to</code> sker på djupet.
     * Den först funna vägen returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return En väg från <code>from</code> till <code>to</code>. Går det inte 
     * att komma till <code>to</code> returneras en tom lista.
     */
    public static <V> ArrayList<Edge<V>> depthFirstSearch(Graph<V> graph, V from, V to) {
        LinkedList<Edge<V>> stack = new LinkedList<Edge<V>>();
        HashMap<V,Edge<V>> visited = new HashMap<V,Edge<V>>();
        boolean arrived = from.equals(to);
        Edge<V> edge;

        visited.put(from,null);
        stack.addAll(graph.getAdjacentList(from));
        while( !stack.isEmpty() && !arrived ) {
            edge = stack.removeLast();
            if(!visited.containsKey(edge.getTo())) {
                visited.put(edge.getTo(),edge);
                stack.addAll(graph.getAdjacentList(edge.getTo()));
                arrived = to.equals(edge.getTo());
            }
        }
        return getPath(from, to, visited);
    }


    /*************************** BREADTH FIRST TRAVERSAL **********************
     * 
     */
    public static <V> Iterator<V> traversalBF(Graph<V> graph, V start) {
        LinkedList<Edge<V>> queue = new LinkedList<Edge<V>>();
        LinkedHashSet<V> visited = new LinkedHashSet<V>();
        Edge<V> edge;

        visited.add(start);
        queue.addAll(graph.getAdjacentList(start));
        while( !queue.isEmpty() ) {
            edge = queue.removeFirst();
            if(!visited.contains(edge.getTo())) {
                visited.add(edge.getTo());
                queue.addAll(graph.getAdjacentList(edge.getTo()));
            }
        }
        return visited.iterator();
    }
    /*************************** BREADTH FIRST SEARCH *************************
     * Sökning av väg från <code>from</code> till <code>to</code> sker på bredden.
     * Den först funna vägen returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return En väg från <code>from</code> till <code>to</code>. Går det inte 
     * att komma till <code>to</code> returneras en tom lista.
     */
    public static <V> ArrayList<Edge<V>> breadthFirstSearch(Graph<V> graph, V from, V to) {
        LinkedList<Edge<V>> queue = new LinkedList<Edge<V>>();
        HashMap<V,Edge<V>> visited = new HashMap<V,Edge<V>>();
        boolean arrived = from.equals(to);
        Edge<V> edge;

        visited.put(from,null);
        queue.addAll(graph.getAdjacentList(from));
        while( !queue.isEmpty() && !arrived ) {
            edge = queue.removeFirst();
            if(!visited.containsKey(edge.getTo())) {
                visited.put(edge.getTo(),edge);
                queue.addAll(graph.getAdjacentList(edge.getTo()));
                arrived = to.equals(edge.getTo());
            }
        }
        return getPath(from, to, visited);
    }

    /**
     * Sökning av väg från <code>from</code> till <code>to</code> sker på bredden.
     * Vägen med lägst vikt returneras.<br>
     * Om <code>from</code> ej finns i grafen kastas NullPoinerException.
     * @param from Nod där sökningen startar
     * @param to Nod där sökningen slutar
     * @return Vägen med lägst vikt som leder från <code>from</code> till 
     * <code>to</code>. Går det inte att komma till <code>to</code> returneras 
     * en tom lista.
     */
    public static <V> ArrayList<Edge<V>> dijkstraSearch(Graph<V> graph, V from, V to) {
        Candidate<V> candidate;
        PriorityQueue<Candidate<V>> queue = new PriorityQueue<Candidate<V>>();
        HashMap<V,Edge<V>> visited = new HashMap<V,Edge<V>>();
        boolean arrived = from.equals(to);
        ArrayList<Edge<V>> adjacentList = graph.getAdjacentList(from);

        visited.put(from,null);
        for(Edge<V> edge : adjacentList)
            queue.add(new Candidate<V>(edge,edge.getWeight()));
        while( !queue.isEmpty() && !arrived ) {
            candidate = queue.remove();
            if(!visited.containsKey(candidate.edge.getTo())) {
                visited.put(candidate.edge.getTo(),candidate.edge);
                adjacentList = graph.getAdjacentList(candidate.edge.getTo());
                for(Edge<V> edge : adjacentList)
                    queue.add(new Candidate<V>(edge,candidate.totalWeight + edge.getWeight()));
                arrived = to.equals(candidate.edge.getTo());
            }
        }
        return getPath(from, to, visited);
    }

    // Klass som används i DijkstraSearch
    private static class Candidate<V> implements Comparable<Candidate<V>> {
        private Edge<V> edge;
        private int totalWeight;

        public Candidate(Edge<V> edge, int totalWeight) {
            this.edge = edge;
            this.totalWeight = totalWeight;
        }

        public int compareTo(Candidate<V> cand) {
            return totalWeight - cand.totalWeight;
        }

    }

    private static <V> ArrayList<Edge<V>> getPath(V from, V to, HashMap<V,Edge<V>> visited) {
        ArrayList<Edge<V>> path = new ArrayList<Edge<V>>();
        Edge<V>  edge = visited.get(to);
        while( edge != null ) {
            path.add(0,edge);
            edge = visited.get(edge.getFrom());
        }
        return path;
    }

}


