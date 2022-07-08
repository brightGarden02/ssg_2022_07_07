package package1;

import java.io.*;
import java.util.*;

public class App {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<WiseSaying> wiseSayingList = new ArrayList<>();
    int idx = 0;
    String cmd;
    int idNum = 0;
    public void run() throws IOException {

        System.out.println("== 명언 SSG ==");

        outer:
        while(true){
            System.out.print("명령) ");
            cmd = br.readLine();

            if(cmd.contains("삭제") || cmd.contains("수정")){
                cmd = splitDeleteOrModifyInformation(cmd);
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
                    if(idNum != 0){
                        modifyList(idNum);
                    }
                    break;
                case "종료":
                    break outer;
            }

        }


    }


    private String splitDeleteOrModifyInformation(String cmd) {

        String[] deleteOrModify = cmd.split("\\?");

        if(cmd.contains("=")){

            String[] arr = cmd.split("=");
            idNum = Integer.parseInt(arr[1]);
            cmd = deleteOrModify[0];
            return cmd;
        }
        else{
            return deleteOrModify[0];
        }

    }

    private void modifyList(int idNum) throws IOException {

        for(int i = 0; i < wiseSayingList.size(); i++){

            if(wiseSayingList.get(i).getIdx() == idNum){

                System.out.print("새 명언을 입력해주세요: ");
                String newContent = br.readLine();

                System.out.println(idNum + "번 명언을 수정합니다.");
                System.out.println("기존 명언 : " + wiseSayingList.get(i).getContent());

                wiseSayingList.get(i).setContent(newContent);

                System.out.println("새 명언 : " + wiseSayingList.get(i).getContent());
                System.out.println(idNum + "번 명언이 수정되었습니다.");
                return;
            }
        }

        System.out.println(idNum + "번 명언은 존재하지 않습니다.");


    }

    private void deleteList(int idNum) throws IOException {

        for(int i = 0; i < wiseSayingList.size(); i++){

            if(wiseSayingList.get(i).getIdx() == idNum){
                wiseSayingList.remove(i);
                System.out.println(idNum + "번 명언이 삭제되었습니다.");
                idx--;
                return;
            }
        }

        System.out.println(idNum + "번 명언은 존재하지 않습니다..");

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
        idx++;

        wiseSayingList.add(new WiseSaying(idx, author, content));

        System.out.printf("%d번 명언이 등록되었습니다.\n", idx);

    }


}
