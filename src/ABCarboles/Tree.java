/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ABCarboles;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author AULA6
 */
public class Tree {

    private Nodo root;

    public Tree() {
        root = null;
    }

    public void add(int d) {
        Nodo n = new Nodo(d);
        if (root == null) {
            root = n;
        } else {
            Nodo aux = root, p = null;
            while (aux != null) {
                p = aux;
                if (n.data > aux.data) {
                    aux = aux.right;
                } else if (n.data < aux.data) {
                    aux = aux.left;

                } else {
                    return;
                }

            }
            if (n.data > p.data) {
                p.right = n;
            } else {
                p.left = n;
            }

        }
    }

    
  
    public void rdraw() {
        JFrame frame = new JFrame() {
            public void paint(Graphics g) {
                rdraw(root, 10, 40, g);
            }
        };
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class Info {

        int x1, x2;
    }

    private Info rdraw(Nodo r, int x, int y, Graphics g) {
        Info i = new Info();
        i.x1 = x;
        i.x2 = 0;
        if (r == null) {
            return i;
        }
        Info j1, j2;

        j1 = rdraw(r.left, x, y + 50, g);
        x = j1.x1;

        g.drawOval(x, y, 30, 30);
        g.drawString("" + r.data, x + 10, y + 20);
        i.x2 = x;

        j2 = rdraw(r.right, x + 30, y + 50, g);
        x = j2.x1;
        i.x1 = x;

        if (j1.x2 > 0) {
            g.drawLine(i.x2 + 5, y + 25, j1.x2 + 15, y + 50);
        }
        if (j2.x2 > 0) {
            g.drawLine(i.x2 + 25, y + 25, j2.x2 + 15, y + 50);
        }

        return i;

    }


    public int rnearlefast() {
        return rnearlefast(root);

    }

    private int rnearlefast(Nodo r) {
         if (r == null) {
            return 0;
        }
        if (r.left == null && r.right == null) 
            System.out.print("la hoja mas cercana es " + r.data);
         else 
            rnearlefast(r.left);

        
    return 0;
    }



     public void printLevel(int nivel, int l) {
        printLevel(root, nivel, l);
    }

    private void printLevel(Nodo r, int nivel, int l) {
        if (r == null) {
            return;
        }
        if (nivel == l) {
             System.out.println("NIVEL:(" + nivel + ") = " + r.data);
        }
        printLevel(r.left, nivel + 1, l);
        printLevel(r.right, nivel + 1, l);

    }
 

    public boolean exist(int d) {
        Nodo aux = root;
        while (aux != null) {
            if (d == aux.data) {
                return true;
            } else if (d > aux.data) {
                aux = aux.right;
            } else {
                aux = aux.left;
            }
        }
        return false;
    }


    public boolean isComplete() {
        return isComplete(root);
    }

    private boolean isComplete(Nodo r) {
        if (r == null) {
            return true;
        }
        if ((r.left == null && r.right != null) || (r.left != null && r.right == null)) {
            return false;
        }
        return isComplete(r.left) && isComplete(r.right);
    }


    public void printKidsOf(int d) {
        Nodo aux = root;
        while (aux != null) {
            if (d == aux.data) {
                if (aux.left != null && aux.right != null) {
                    System.out.print(" " + aux.left.data);
                }
                System.out.print(" " + aux.right.data);
            }
            if (d > aux.data) {
                aux = aux.right;
            } else {
                aux = aux.left;

            }

        }
    }


    public void printFatherOf(int d) {
        Nodo aux = root;
        while (aux != null) {

            if (aux.left != null && d == aux.left.data) {
                System.out.print(" " + aux.data);
            }

            if (aux.right != null && d == aux.right.data) {
                System.out.print(" " + aux.data);
            }

            if (d > aux.data) {
                aux = aux.right;
            } else {
                aux = aux.left;
            }

        }
    }


    public void prune() {
        prune(root);

    }

    private void prune(Nodo r) {
        if (r == null) {
            return;
        }
        if (r.left == null && r.right != null) {
            r.right = null;
        }
        if (r.left != null && r.right == null) {
            r.left = null;
        } else {
            prune(r.left);
        }
            prune(r.right);

    }
}