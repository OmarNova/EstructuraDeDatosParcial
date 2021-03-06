package ListaCircular;

import java.util.Iterator;
import static java.lang.System.*;


public class CircularList implements ListInterface, Iterable<ListNode> {
    private ListNode inode;
    private int size;

    public ListNode head;
    public ListNode tail;

    public CircularList() {
        clear();
    }

    /*
    ok
     */
    public CircularList(Object object) {
        add(object);
    }

    /*
    ok
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /*
    ok
     */
    @Override
    public int getSize() {
        return size;
    }

    /*
    ok
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
    ok
     */
    @Override
    public Object getHead() {
        return head;
    }

    /*
    ok
     */
    @Override
    public Object getTail() {
        return tail;
    }

    /*
    ok
     */
    @Override
    public ListNode search(Object object) {
        Iterator<ListNode> i = this.iterator();
        int s = 0;
        ListNode inode = head;
        while (s != size) {
            if (inode.getObject().toString().equals(object.toString())) {
                return inode;
            }
            inode = inode.next;
            s++;
        }
        return null;
    }

    /*
    ok
     */
    @Override
    public boolean add(Object object) {
        return insertTail(object);
    }

    /*
    ok
     */
    @Override
    public boolean insert(ListNode node, Object object) {
        try {
            if (node.next == head) {
                add(object);
            } else {
                this.size++;
                ListNode newNode = new ListNode(object);
                newNode.next = node.next;
                node.next = newNode;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean insert(Object ob, Object object) {
        try {
            if (ob != null) {
                ListNode node = this.search(ob);
                if (node != null) {
                    return insert(node, object);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean insertHead(Object object) {
        try {
            if (isEmpty()) {
                head = new ListNode(object);
                tail = head;
                tail.next = head;
            } else {
                head = new ListNode(object, head);
                tail.next = head;
            }
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean insertTail(Object object) {
        try {
            if (isEmpty()) {
                head = new ListNode(object);
                tail = head;
                tail.next = head;
            } else {
                tail.next = new ListNode(object);
                tail = tail.next;
                tail.next = head;
            }
            this.size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
    ok
     */
    @Override
    public boolean remove(ListNode node) {
        return remove(node.getObject());
    }
    /*
    ok
     */
    
    @Override
    public boolean remove(Object object) {
        try{
            ListNode a = head;
            ListNode anterior = tail;
            int t = 0;
            boolean eliminado = false;
            while(t < size && eliminado == false){
                t++;
                if( a.getObject() == object){
                    eliminado = true;
		    this.size--;
                    if(anterior == tail){
                        head = a.next;
                        tail.next = head;
                    }else{
                        anterior.next = a.next;
                    }
                }
                anterior = a;
                a = a.next;
            }
            return eliminado;
        } catch(Exception e){
            return false;
        }
    }
    /*
    ok
     */

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }
    /*
    ok
     */

    public Object[] toArray() {
        if(isEmpty()){
            return new Object[0];
        }else{
            ListNode a = head;
            Object[] o = new Object[size];
            for(int i = 0; i < size; i++){
                if(a == null){
                    break;
                }
                o[i] = a.getObject();
                a = a.next;
            }
            return o;
        }
    }
   /*
    ok
    */

    @Override
    public Object[] toArray(Object[] object) {
        try{
        Object[] a = toArray();
        Object[] b = object;
        for(int i = 0; i < object.length; i++){
            b[i] = a[i];
        }
        return b;
        } catch(Exception e){
            return null;
        }
    }
    /*
    ok
    */

    @Override
    public Object getBeforeTo() {
        try{return tail.getObject();}catch(Exception e){return null;}
    }

    /*
    ok
     */
    @Override
    public ListNode getBeforeTo(ListNode node) {
        try{
            ListNode a = head;
            ListNode p = null;
            while(a != node){
                p = a;
                a = a.next;
            }
            return p;
        }catch(Exception e){
            return null;
        }
    }
    /*
    ok
     */

    @Override
    public Object getNextTo() {
        try{return head.next.getObject();}catch(Exception e){return null;}
    }
    /*
    ok
     */

    @Override
    public Object getNextTo(ListNode node) {
        try{return node.next.getObject();}catch(Exception e){return null;}
    }
    /*
    ok
     */
    
    @Override
    public CircularList subList(ListNode from, ListNode to) {
        CircularList listSub = new CircularList();
        try{
            boolean stop = true;
            while(stop){
                listSub.add(from.getObject());
                from = from.next;
                if(from.getObject() == to.getObject())
                    stop = false;
            }
            return listSub;
        } catch(Exception e){
            return null;
        }
        
    }
    /*
    ok
     */

    @Override
    public CircularList sortList() {
        try{
            Double[] a = new Double[size];
            ListNode t = head;
            Double temp;
            for (int i = 0; i < size; i++) {
                a[i] = Double.parseDouble(t.getObject().toString());
                t = t.next;
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a.length-1; j++) {
                    if(a[j+1] < a[j] ){
                        temp = a[j+1];
                        a[j+1] = a[j];
                        a[j] = temp;
                    }
                }
            }
            CircularList b = new CircularList();
            for (int i = 0; i > a.length; i++) {
                b.add(a[i]);   
            }
            return b;
        }catch(NumberFormatException n){
            String[] a = new String[size];
            ListNode t = head;
            String temp;
            for (int i = 0; i < a.length; i++) {
                a[i] = t.getObject().toString();
                t = t.next;
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j > a.length-1; j++) {
                    if(a[j+1].length() < a[j].length() ){
                        temp = a[j+1];
                        a[j+1] = a[j];
                        a[j] = temp;
                    }
                }
            }
            CircularList b = new CircularList();
            for (int i = 0; i < a.length; i++) {
                b.add(a[i]);
            }
            return b;
        }
    }
    /*
    ok
     */ 
    
    @Override
    public Iterator<ListNode> iterator() {
        inode = head;
        return new Iterator<ListNode>() {
            @Override
            public boolean hasNext() {
                return inode.next != null;
            }

            @Override
            public ListNode next() {
                if (inode != null) {
                    ListNode tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
    }
    /*
    ok
     */
    
    public void rec(ListNode node) {
        if (node.next != null) {
            rec(node.next);
            // <- ;) ->
        }
        out.println(node.toString());
        
    }
    /*
    ok
     */
    
    @Override
    public String toString(){
        Iterator<ListNode> i = this.iterator();
        ListNode inode;
        int s = 0;
        String l = "";
        while(s < size){
            inode = i.next();
            l += inode.getObject().toString() + "->";
            s++;
        }
        l += tail.next.getObject().toString();
        
    
      return l;
    }
    
}