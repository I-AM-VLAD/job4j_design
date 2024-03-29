package ru.job4j.ood.tdd;

import java.util.Scanner;

public class Fool {
    static class Answer {
        private int number;

        public Answer(int num) {
            this.number = num;
        }

        public String lable() {
            String result = String.valueOf(number);
            if (number % 3 == 0 && number % 5 == 0) {
                result = "FizzBuzz";
            } else if (number % 3 == 0) {
                result = "Fizz";
            } else if (number % 5 == 0) {
                result = "Buzz";
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var input = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(new Answer(startAt).lable());
            startAt++;
            if (!input.nextLine().equals(new Answer(startAt).lable())) {
                System.out.println("Ошибка");
                startAt = 0;
            }
            startAt++;
        }
    }
}
