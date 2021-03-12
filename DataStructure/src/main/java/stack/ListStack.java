package stack;

public class ListStack implements StackInterface{
    
    private int size;
    private ListNode top;
    
    public ListStack() {
        top = null;
	size = 0;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.top = null;
    }
    /*
      ok
    */

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /*
      ok
    */

    @Override
    public Object peek() {
        if(!isEmpty()){
            return this.top.getObject();
        }else{
        return null;
        }
    }
    /*
      ok
    */

    @Override
    public Object pop() { 
        Object a = top.getObject();
        top = top.next;
        this.size--;
        return a;
    }
    /*
      ok
    */
    
    @Override
    public boolean push(Object object) { 
        try{
            ListNode nuevo = new ListNode(object);
            nuevo.next = this.top;
            this.top = nuevo;
            this.size++;
            return true;
        } catch(Exception e){
            return false;
        } 
    }
    /*
      ok
    */
    
    @Override
    public int size() {
        return this.size;
    }
    /*
      ok
    */

    @Override
    public boolean search(Object object) {
        ListNode a = top;
        while(a != null){
            if(a.getObject()  == object){
                return true;
            }
            a = a.next;
        }
        return false; 
    }

    @Override
    public void sort() {
        try{
            Double[] a = new Double[size];
            ListNode t = top;
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
            ListStack b = new ListStack();
            for (int i = 0; i > a.length; i++) {
                b.push(a[i]);   
            }
            top = b.top;
        }catch(NumberFormatException n){
            String[] a = new String[size];
            ListNode t = top;
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
            ListStack b = new ListStack();
            for (int i = 0; i < a.length; i++) {
                b.push(a[i]);
            }
            top = b.top;
        }
    }

    @Override
    public void reverse() {
        ListStack a = new ListStack();
        ListNode b = top;
        while (b != null){
            a.push(b.getObject());
            b = b.next;
        }
        top = a.top;
        a = null;
    }  
    /*
     ok
    */
    
    @Override
    public String toString(){
        return top.toString();
    }
    /*
     ok
    */



}
