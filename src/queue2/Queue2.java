/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package queue2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Queue2 {

      record Ticket(String name, int urgency, int arrival) {}
    public static void main(String[] args) {
        Scanner scannerLojinEstano = new Scanner(System.in);
        PriorityQueue<Ticket> queue = new PriorityQueue<>(
                Comparator.comparingInt(Ticket::urgency)
                          .thenComparingInt(Ticket::arrival)
        );

        System.out.println("Enter tickets (lower urgency number = served first).");
        System.out.println("Type 'done' to finish.");

        int arrival = 1;
        while (true) {
            System.out.print("\nTicket word: ");
            String name = scannerLojinEstano.nextLine().trim();

            if (name.equalsIgnoreCase("done")) {
                break;
            }
            if (name.isEmpty()) {
                System.out.println("Ticket word can't be empty. Try again.");
                continue;
            }

            System.out.print("Urgency (number): ");
            String urgencyInput = scannerLojinEstano.nextLine().trim();

            int urgency;
            try {
                urgency = Integer.parseInt(urgencyInput);
            } catch (NumberFormatException e) {
                System.out.println("Urgency must be a whole number. Try again.");
                continue;
            }

            queue.offer(new Ticket(name, urgency, arrival++));
        }

        System.out.println("\n=== Poll Order ===");
        while (!queue.isEmpty()) {
            Ticket t = queue.poll();
            System.out.print(t.name() + ", ");
        }

        scannerLojinEstano.close();
    }

}
