package package1;

import org.json.simple.JSONObject;

import java.io.*;
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
            int idNum = 0;
            if(cmd.contains("삭제") && cmd.contains("=")){

                String[] arr = cmd.split("=");
                idNum = Integer.parseInt(arr[1]);
                cmd = "삭제";
            }

            switch (cmd) {
                case "등록":
                    registerWiseSayings();
                    break;
                case "목록":
                    seeList();
                    break;
                case "삭제":
                    if(idNum != 0){
                        deleteList(idNum);
                    }
                    break;
                case "수정":
                    modifyList();
                    break;
                case "종료":
                    break outer;
            }

        }


    }

    private void modifyList() {


    }

    private void deleteList(int idNum) throws IOException {

        if(wiseSayingList.size() < idNum){
            System.out.println(idNum + "번 명언은 존재하지 않습니다..");
            return;
        }

        if(wiseSayingList.get(idNum-1).getIdx() == idNum){
            wiseSayingList.remove(idNum-1);
            System.out.println(idNum + "번 명언이 삭제되었습니다.");
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

        wiseSayingList.add(new WiseSaying(idx, author, content));

        System.out.printf("%d번 명언이 등록되었습니다.\n", idx);

        idx++;
    }


}
