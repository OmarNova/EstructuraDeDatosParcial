package ListaCircularDoble;

import java.util.Iterator;

import static java.lang.System.*;


public class DoubleCircularList implements ListInterface, Iterable<ListNodeDouble> {

    private ListNodeDouble inode;
    private int size;

    public ListNodeDouble head;
    public ListNodeDouble tail;

    /**
     * List
     */
    public DoubleCircularList() {
        clear();
    }

    /*
    ok
     */
    public DoubleCircularList(Object object) {
        add(object);
    }

    /*
    ok
     */
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
    public ListNodeDouble search(Object object) {
        Iterator<ListNodeDouble> i = this.iterator();
        ListNodeDouble inode;
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
    public boolean insert(ListNodeDouble node, Object object) {
        try {
            if (node.next == head) {
                add(object);
            } else {
                this.size++;
                ListNodeDouble newNode = new ListNodeDouble(object,node.next,node);
                newNode.next.previous = newNode;
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
                ListNodeDouble node = this.search(ob);
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
                head = new ListNodeDouble(object);
                tail = head;
                tail.next = head;
                head.previous = tail;
               
            } else {
                head =new ListNodeDouble(object,head,tail);
                head.next.previous = head;
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
                head = new ListNodeDouble(object);
                tail = head;
                tail.next = head;
                head.previous = tail;
            } else {
                tail.next = new ListNodeDouble(object, head,tail);
                tail = tail.next;
                head.previous = tail;
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
    public boolean remove(ListNodeDouble node) {
        return remove(node.getObject());
    }

    /*
    ok
     */
    @Override
    public boolean remove(Object object) {
        try{
            if(object != null){
                boolean eliminado = false;
                ListNodeDouble node = head;
                int s = 0;
                while(eliminado == false && s < size){
                    if(node.getObject() == object){
                        this.size--;
                        eliminado = true;
                        if(node.previous == tail){
                            head = head.next;
                            head.previous = tail;
                            tail.next = head;
                            
                        }else if(node == tail){
                            node.previous.next = node.next;
                            head.previous = node.previous;
                        }else{
                            node.previous.next = node.next;
                        }
                    }
                    s++;
                    node = node.next;
                }
                return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean contains(Object object) {
        return search(object) != null;
    }


    @Override
    public Object[] toArray() {
        if(isEmpty()){
            return new Object[0];
        }else{
            ListNodeDouble a = head;
            Object[] o = new Object[size];
            for(int i = 0; i < size; i++){
                o[i] = a.getObject();
                a = a.next;
            }
            return o;
        }
        
    }

    @Override
    public Object[] toArray(Object[] object) {
        if(isEmpty()){
            return new Object[0];
        }else{
            return toArray();
        }
    }

    @Override
    public Object getBeforeTo() {
        try{
            return head.previous.getObject();
        }catch(Exception e){
            return null;
        }
    }

    /*
    ok
     */
    @Override
    public ListNodeDouble getBeforeTo(ListNodeDouble node) { 
        try{return node.previous;}catch(Exception e){return null;}
    }

    @Override
    public Object getNextTo() {
        return head.next.getObject();
    }

    @Override
    public Object getNextTo(ListNodeDouble node) {
        try{return node.next;}catch(Exception e){return null;}
    }

    @Override
    public DoubleCircularList subList(ListNodeDouble from, ListNodeDouble to) {
        DoubleCircularList listSub = new DoubleCircularList();
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

    @Override
    public DoubleCircularList sortList() {
        try{
            Double[] a = new Double[size];
            ListNodeDouble t = head;
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
            DoubleCircularList b = new DoubleCircularList();
            for (int i = 0; i < a.length; i++) {
                b.add(a[i]);   
            }
            return b;
        }catch(NumberFormatException n){
            String[] a = new String[size];
            ListNodeDouble t = head;
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
            DoubleCircularList b = new DoubleCircularList();
            for (int i = 0; i < a.length; i++) {
                b.add(a[i]);
            }
            return b;
        }
    }

    @Override
    public Iterator<ListNodeDouble> iterator() {
        inode = head;
        return new Iterator<ListNodeDouble>() {
            @Override
            public boolean hasNext() {
                return inode.next != null;
            }

            @Override
            public ListNodeDouble next() {
                if (inode != null) {
                    ListNodeDouble tmp = inode;
                    inode = inode.next;
                    return tmp;
                } else {
                    return null;
                }
            }
        };
    }

    public void rec(ListNodeDouble node) {
        if (node.next != null) {
            rec(node.next);
            // <- ;) ->
        }
        out.println(node.toString());
    }
    @Override
    public String toString(){
        String a = head.previous.getObject().toString() + " <-> ";
        ListNodeDouble node = head;
        int s =0;
        while(s < size){
            s++;
            a += node.getObject() + " <-> ";
            node = node.next;
        }
        a += tail.next.getObject().toString();
        return a;
    }

}
