package package1;

import java.io.*;
import java.util.*;

public class App {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private List<WiseSaying> wiseSayingList = new ArrayList<>();
    private int idx = 0;
    private String cmd;
    public void run() throws IOException {

        System.out.println("== 명언 SSG ==");

        outer:
        while(true){

            System.out.print("명령) ");
            cmd = br.readLine();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    registerWiseSayings(rq);
                    break;
                case "목록":
                    seeList(rq);
                    break;
                case "삭제":
                    deleteList(rq);
                    break;
                case "수정":
                    modifyList(rq);
                    break;
                case "종료":
                    System.out.println("명언 SSG를 종료합니다.");
                    break outer;
            }
        }

    }

    private void modifyList(Rq rq) throws IOException {

        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }


        for(int i = 0; i < wiseSayingList.size(); i++){

            WiseSaying wiseSaying = wiseSayingList.get(i);

            if(wiseSaying.getIdx() == paramId){
                inputNewContentAndPrintContents(paramId, i, wiseSaying);
                return;
            }
        }

    }

    private void inputNewContentAndPrintContents(int paramId, int i, WiseSaying wiseSaying) throws IOException {

        System.out.print("새 명언을 입력해주세요: ");
        String newContent = br.readLine();

        System.out.println(paramId + "번 명언을 수정합니다.");
        System.out.println("기존 명언 : " + wiseSaying.getContent());

        wiseSayingList.get(i).setContent(newContent);

        System.out.println("새 명언 : " + wiseSaying.getContent());
        System.out.println(paramId + "번 명언이 수정되었습니다.");
    }

    private void deleteList(Rq rq) throws IOException {

        int paramId = rq.getIntParam("id", 0);

        if(paramId == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }

        WiseSaying foundWiseSaying = findById(paramId);


        if(foundWiseSaying == null){
            System.out.println(paramId + "번 명언은 존재하지 않습니다..");
            return;
        }

        wiseSayingList.remove(foundWiseSaying);

        System.out.println(paramId + "번 명언이 삭제되었습니다.");
        idx--;

    }

    private WiseSaying findById(int paramId) {

        for(int i = 0; i < wiseSayingList.size(); i++){

            WiseSaying wiseSaying = wiseSayingList.get(i);
            if(wiseSaying.getIdx() == paramId){
                return wiseSaying;
            }
        }

        return null;
    }


    private void seeList(Rq rq) {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------------");
        for(int i = wiseSayingList.size()-1; i >= 0 ; i--){

            WiseSaying wiseSaying = wiseSayingList.get(i);

            System.out.println(wiseSaying.getIdx() + " / " +
                    wiseSaying.getAuthor() + " / " +
                    wiseSaying.getContent());
        }

    }

    private void registerWiseSayings(Rq rq) throws IOException {

        System.out.print("명언: ");
        String content = br.readLine();

        System.out.print("작가: ");
        String author = br.readLine();

        int id = ++idx;
        WiseSaying wiseSaying = new WiseSaying(id, author, content);

        wiseSayingList.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);

    }


}
