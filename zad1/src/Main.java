import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("podaj wartosc n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(n + " liczba ciagu to: " + fib(n));

    }

    public static long fib(int n){
        //macierz Q fibonacciego
        long[][] Q = new long[2][2];
        //macierz P pomocnicza
        long[][] P = new long[2][2];
        //macierz W wynik potegowania
        long[][] W = new long[2][2];

        // wyraz ciagu dla n=0 to 0 a dla n=1 to 1
        if(n<2) return n;

        //ustawiamy macierz Q
        Q[0][0] = 1;
        Q[0][1] = 1;
        Q[1][0] = 1;
        Q[1][1] = 0;
        wyswietl(Q,'Q');
        // ustawiamy macierz jednostkowa W
        W[0][0] = 1;
        W[0][1] = 0;
        W[1][0] = 0;
        W[1][1] = 1;
        wyswietl(W,'W');

        //zmniejszamy n o 1
        n--;
        int licznik=1;
        while(n>0)
        {
            System.out.println("wykonanie petli " + licznik++);
            System.out.println("===================================");
            if(n%2!=0){
                System.out.println("dla nieparzystego n=" + n +" mnozymy Q*W");
                wyswietl(Q,'Q');
                wyswietl(W,'W');
                // wykonujemy mnożenie P = W x Q
                P[0][0] = W[0][0]*Q[0][0] + W[0][1]*Q[1][0];
                P[0][1] = W[0][0]*Q[0][1] + W[0][1]*Q[1][1];
                P[1][0] = W[1][0]*Q[0][0] + W[1][1]*Q[1][0];
                P[1][1] = W[1][0]*Q[0][1] + W[1][1]*Q[1][1];
                wyswietl(P,'P');
                System.out.println("i zapisujemy do macierzy W");
                // wynik przenosimy: W = P
                W[0][0] = P[0][0];
                W[1][0] = P[1][0];
                W[0][1] = P[0][1];
                W[1][1] = P[1][1];


            }
            //dzielimy n na pol
            System.out.println("dzielimy n na pol");
            n/=2;
            if(n<=0) break;
            System.out.println("dla n=" + n + " potegujemy Q");
            wyswietl(Q,'Q');
            wyswietl(W,'W');
            // podnosimy Q do kwadratu:  P = Q x Q
            P[0][0] = Q[0][0]*Q[0][0] + Q[0][1]*Q[1][0];
            P[0][1] = Q[0][0]*Q[0][1] + Q[0][1]*Q[1][1];
            P[1][0] = Q[1][0]*Q[0][0] + Q[1][1]*Q[1][0];
            P[1][1] = Q[1][0]*Q[0][1] + Q[1][1]*Q[1][1];
            wyswietl(P,'P');
            System.out.println("i zapisujemy do macierzy Q");
            // wynik przenosimy: Q = P
            Q[0][0] = P[0][0];
            Q[1][0] = P[1][0];
            Q[0][1] = P[0][1];
            Q[1][1] = P[1][1];


        }
        return W[0][0];
    }

    public static void wyswietl(long[][] tab,char nazwa){
        System.out.println(nazwa);
        for(int i=0;i<tab.length;i++){
            for(int j=0;j<tab[i].length;j++){
                System.out.print(tab[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
