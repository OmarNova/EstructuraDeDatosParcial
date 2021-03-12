
import java.util.Scanner;
import ListaDoble.*;

public class Parcial {

     static class mapeado {
        public String valor; public int x,y;

        public mapeado(String valor, int x, int y) {
            this.valor = valor;
            this.x = x;
            this.y = y;
    }
    
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del mapa, en forma de N M: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        DoubleList mapa = new DoubleList();
        
        System.out.println("Ingrese el mapa: ");
        int mx=0,my=0,ex=0,ey =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) { 
                String a = sc.next();
                
                mapa.add(new mapeado(a,j,i));
                if(a.equals("m")){
                    mx = j;my = i;
                }else if(a.equals("e")){
                    ex = j;ey = i;
                }
            }  
        }
        

    }
    
    public static void MoverDerecha(DoubleList mapa, int mx, int my){
        int derecha = mx +1;
        if(!Obstaculo(mapa,derecha,my)){
            
        }
        
    }
   
    public static boolean Obstaculo(DoubleList mapa, int posX,int posY){
        
        boolean encontrado = true;
        while(encontrado){
            mapeado map = (mapeado) mapa.head.getObject();
           if(map.x == posX && map.y == posY ){
               encontrado = false;
           }
           mapa.head = mapa.head.next;
        }
        mapeado map = (mapeado) mapa.head.getObject();
        DoubleList mapa2 = new DoubleList(map.valor);
        System.out.println(map.valor);
    
        return mapa2.head.isEquals("1");
    }
    
}
