package AD.SW02.VerketteteListe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;

public class EinfachVerketteteListe {

    private static final Logger LOG = LogManager.getLogger(EinfachVerketteteListe.class);

    private int sizeCounter = 0;
    private final Node head;

    public EinfachVerketteteListe() {
        this.head = new Node("head");
    }

    public void addListElement(final Node node) {
        Node tempNode = head.getNextNode();
        head.setNextNode(node); //verkettet einzufügenden Node mit head
        node.setNextNode(tempNode); // hängt an den einzufügneden Node die Referenz auf den davor eingefügten Node
        sizeCounter++;
    }

    public void removeListElement(final Node node) throws NoSuchFieldException{
        Node toRemoveNode = find(node);
        Node previousNode = findReferenz(node);
        previousNode.setNextNode(toRemoveNode.getNextNode());
        sizeCounter--;
        toRemoveNode = null; //damit Node von GarbageCollector abgeräumt wird
    }

    public Node find(Node node) throws NoSuchFieldException {
        Node ausgabeNode = head.getNextNode();
        while (!ausgabeNode.equals(node)) {
            if (ausgabeNode.hasNext()) {
                ausgabeNode = ausgabeNode.getNextNode();
            } else {
                LOG.error("Das Ende der Liste wurde erreicht - Liste hat kein nächstes Element");
                throw new NoSuchFieldException("Kein entsprechendes Element gefunden");
            }
        }
        return ausgabeNode;
    }

    public Node findReferenz(Node node) throws NoSuchFieldException {
        int itterationCounter = 0;
        Node Referenz = head.getNextNode();
        while (!Referenz.equals(node)) {
            if (Referenz.hasNext()) {
                Referenz = Referenz.getNextNode();
                itterationCounter++;
            } else {
                LOG.error("Das Ende der Liste wurde erreicht - Liste hat kein nächstes Element");
                throw new NoSuchFieldException("Kein entsprechendes Element gefunden");
            }
        }
        Node ausgabeNode = head.getNextNode();
        for(int counter = itterationCounter; counter > itterationCounter-1; counter--){
            ausgabeNode = ausgabeNode.getNextNode();
        }
        return ausgabeNode;
    }

    public int size() {
        return getSizeCounter();
    }

    public int getSizeCounter() {
        return sizeCounter;
    }
}
