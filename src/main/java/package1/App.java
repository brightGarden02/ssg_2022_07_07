package package1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int idx = 1;

    public void run() throws IOException {

        System.out.println("== 명언 SSG ==");

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


    }

    private void seeList() {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------------");
        for(int i = wiseSayingList.size()-1; i >= 0 ; i--){
            System.out.println(wiseSayingList.get(i).getIdx() + " / " +
                    wiseSayingList.get(i).getAuthor() + " / " +
                    wiseSayingList.get(i).getContent());
        }

    }

    private void registerWiseSayings() throws IOException {


        System.out.print("명언: ");
        String content = br.readLine();

        System.out.print("작가: ");
        String author = br.readLine();

        wiseSayingList.add(new WiseSaying(idx, content, author));
        System.out.printf("%d번 명언이 등록되었습니다.\n", idx);

        idx++;
    }


}
