package batalla;

import batalla.clases.Block;
import batalla.clases.Estaticas;
import batalla.clases.Nave;

import java.util.Scanner;

/**
 * Created by Usuario1 on 19/08/2016.
 *
 * se deben crear 3 (tres) naves por cada usuario
 * el campo de batalla tiene N filas y N columnas
 * cada fila se identifica con números de 1 al  N
 * cada columna se identifica con letras mayúsculas o minúsculas
 *
 * cada nave se forma por dos celdas adyacentes o Block , en Horizontal o Vertical - en diagonal NO
 * cada celda (Block) se identifica por (letra, número)
 *
 *
 * Está previsto el ingreso erroneo del  del Primer Block solo si se encuentra fuera de la grilla,
 * por lo que volverá a pedir los datos. Para el segundo Block,  si se ingresa en diagonal
 * respecto del primero, o un block que no sea adyacente , o fuera de la grilla vuelve a pedir
 *los datos del mismo.
 *
 * Ejemplo de ingreso y salida de los datos.
 *
 * Ingrese dimensión de Grilla: 7
 *
    Ingrese datos de la Nave 1
        Primer Block
             Ingrese la columna: g
             Ingrese la fila: 1
        Segundo Block
             Ingrese la columna: g
             Ingrese la fila: 2

    Ingrese datos de la Nave 2
        Primer Block
             Ingrese la columna: b
             Ingrese la fila: 3
        Segundo Block
             Ingrese la columna: b
             Ingrese la fila: 4

     Ingrese datos de la Nave 3
        Primer Block
             Ingrese la columna: a
             Ingrese la fila: 7
        Segundo Block
             Ingrese la columna: b
             Ingrese la fila: 7


   Nave N. 1 :((g 1) (g 2))
   Nave N. 2 : ((b 3) (b 4))
   Nave N. 3 :((a 7) (b 7))

 *
 */
public class BatallaMain {

    public static void main(String[]args){

       Scanner sc=new Scanner(System.in);

        String a = null;
        int b=0;
        String c=null;
        int d=0;
        int y=0;
        int control=0;
        Nave[] naves = new Nave[3];


       System.out.print("Ingrese dimensión de Grilla: ");
       int dim=sc.nextInt();
        Block block1 = null;
        Block block2=null;

        while (y <3 ) {
            System.out.println("Ingrese datos de la Nave " + (y + 1));

            if (control==0) {
                System.out.println("\tPrimer Block"); // Ingreso coordenadas del primer Block de la nave.
                System.out.print("\t\tIngrese la columna: ");
                a = sc.next();
                System.out.print("\t\tIngrese la fila: ");
                b = sc.nextInt();

                boolean t = Estaticas.armaBlockUno(dim, a, b);

                if (t) {

                    block1 = new Block(a, b);
                }

                else {
                    System.out.println("\n         ATENCION!!  Ingresó datos fuera del rango.");
                    control = 0;
                    continue;
                }
            }

            System.out.println("\tSegundo Block"); // Ingreso coordenadas del segundo Block de la nave.
            System.out.print("\t\tIngrese la columna: ");
            c = sc.next();
            System.out.print("\t\tIngrese la fila: ");
            d = sc.nextInt();

                boolean t = Estaticas.armaBlockDos(dim, c, d, a, b);

                if (t) {

                    block2 = new Block(c, d);
                } else {
                    System.out.println("\n         ATENCION!!  Ingresó datos fuera del rango.");
                    control = 1;
                    continue;
                }

            Nave nave=new Nave(block1,block2);
            naves[y]=nave;
            y++;
            control=0;
        }
        System.out.println("\n");

        int i=0;
        for (Nave e:naves ) {
            i++;
            System.out.println(" Nave N. "+i+" :"+e);
        }

    }

}
