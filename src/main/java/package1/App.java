package package1;

import java.util.Scanner;

public class App {

    public void run(){

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);

        outer:
        while(true){
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "종료":
                    break outer;
            }

        }

        sc.close();

    }



}
