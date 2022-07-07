package package1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int idx = 1;

    Map<Integer, Map<String, String>> map = new HashMap<>();
    public void run() throws IOException {

        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);


        outer:
        while(true){
            System.out.print("명령) ");
            String cmd = br.readLine();

            switch (cmd) {
                case "등록":
                    registerWiseSayings();
                    break;
                case "목록":
                    seeList();
                    break;

                case "종료":
                    break outer;
            }

        }

        sc.close();

    }

    private void seeList() {

        System.out.println("번호 / 작가 / 명언");
        for(Integer key : map.keySet()){

            for(String key2 : map.get(key).keySet()){
                System.out.println(key + " / " + key2 + " / " + map.get(key).get(key2));
            }
        }

    }

    private void registerWiseSayings() throws IOException {

        System.out.print("명언: ");
        String wiseSaying = br.readLine();

        System.out.print("작가: ");
        String name = br.readLine();

        Map<String, String> nameAndWiseSaying = new HashMap<>();
        nameAndWiseSaying.put(name, wiseSaying);

        map.put(idx, nameAndWiseSaying);

        System.out.println(idx + "번 명언이 등록외었습니다.");
        idx++;
    }


}
