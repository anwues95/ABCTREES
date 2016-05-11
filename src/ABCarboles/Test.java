/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ABCarboles;


/**
 *
 * @author AULA6
 */  
public class Test {
    public static void main(String args[]){
      
        Tree s=new Tree();
        int vx[]={25,45,50,55,60,35,40,30,15,20,10,1,5};    
        for(int i=0;i<vx.length;i++){
            s.add(vx[i]);
        
    }
        //homework 10
       
        System.out.println();
        System.out.println(" los nodos del nivel 2 son ");
        s.printLevel(0, 2);
        System.out.println();
        
        int valor=45;
        if(s.exist(valor)){
           System.out.println("el numero " + valor + " si existe ");
        }else{
           System.out.println("el numero " + valor + " no existe "); 
        }

         if (s.isComplete()) {
           System.out.print("El ARBOL ESTA COMPLETO");
       } else {
           System.out.print("El ARBOL ESTA INCOMPLETO");
       }

         System.out.println();
         System.out.println("hijos de 35");
         s.printKidsOf(35);

        System.out.println();
         System.out.println("padre de 10");
         s.printFatherOf(10);
         s.rdraw();

       s.prune();

       System.out.println();
      s.rnearlefast();
       
       
    }
    }
