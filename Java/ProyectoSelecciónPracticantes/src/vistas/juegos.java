package vistas;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class juegos {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(rand.nextInt(10) + 1);
        }
        showList(list);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hideList(list);

        Scanner scanner = new Scanner(System.in);
        for (int element : list) {
            System.out.print("Introduzca el siguiente número: ");
            int answer = scanner.nextInt();
            if (answer != element) {
                System.out.println("Perdiste!!!");
                return;
            }
        }
        System.out.println("¡Ganaste!");
    }

    public static void showList(ArrayList<Integer> list) {
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void hideList(ArrayList<Integer> list) {
        for (int element : list) {
            System.out.print("* ");
        }
        System.out.println();
    
}
}




