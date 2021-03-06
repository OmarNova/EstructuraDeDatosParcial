package ListaSimple;


import java.util.Iterator;
import static java.lang.System.*;


public class List implements ListInterface, Iterable<ListNode> {
    private ListNode inode;
    private int size;

    public ListNode head;
    public ListNode tail;

    /**
     * List
     */
    public List() {
        clear();
    }

    /*
    ok
     */
    public List(Object object) {
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
        ListNode inode;
        while ((inode = i.next()) != null) {
            if (inode.getObject().toString().equals(object.toString())) {
                return inode;
            }
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
            if (node.next == null) {
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
            } else {
                head = new ListNode(object, head);
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
            } else {
                tail.next = new ListNode(object);
                tail = tail.next;
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
            ListNode t = null;
            boolean eliminado = false;
            while(a != null && eliminado == false){
                if( a.getObject() == object){
		    this.size--;
                    if(t == null){
                        head = a.next;
                        a.next = null;
                    }else{
                    t.next = a.next;
                    a.next = null;
                    eliminado = true;
                    }
                }
                t = a;
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
            if(isEmpty()){
                return new Object[0];
            }else{
                return toArray();
            }
        } catch(Exception e){
            return null;
        }
    }
    /*
    ok
    */

    @Override
    public Object getBeforeTo() {
        return null;
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
        return head.next.getObject();
    }
    /*
    ok
     */

    @Override
    public Object getNextTo(ListNode node) {
        return node.next.getObject();
    }
    /*
    ok
     */
    
    @Override
    public List subList(ListNode from, ListNode to) {
        List listSub = new List();
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
    public List sortList() {
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
            List b = new List();
            for (int i = 0; i < a.length; i++) {
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
            List b = new List();
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
}
