package package1;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingController(Scanner sc) {

        this.sc = sc;
        wiseSayingRepository = new WiseSayingRepository();
    }


    public void modify(Rq rq) {

        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 id가 없다면 작업 중지
        if(paramId == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }

        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);


        // 명언 객체를 찾지 못했으면 중지
        if(foundWiseSaying == null){
            System.out.println(paramId +  "번 명언은 존재하지 않습니다.");
            return;
        }


        System.out.println("기존 명언 : " + foundWiseSaying.content);
        System.out.print("새 명언을 입력해주세요: ");
        String newContent = sc.nextLine();

        System.out.println("기존 작가 : " + foundWiseSaying.author);
        System.out.print("새 작가를 입력해주세요: ");
        String newAuthor = sc.nextLine();

        wiseSayingRepository.modify(paramId, newContent, newAuthor);

        System.out.println(paramId + "번 명언이 수정되었습니다.");

    }



    public void list(Rq rq) {

        System.out.println("번호 / 작가 / 명언");
        System.out.println("--------------------------");

        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        for(int i = wiseSayings.size()-1; i >= 0 ; i--){

            WiseSaying wiseSaying_ = wiseSayings.get(i);

            System.out.println(wiseSaying_.id + " / " +
                    wiseSaying_.author + " / " +
                    wiseSaying_.content);
        }

    }

    public void write(Rq rq) {

        System.out.print("명언 : ");
        String content = sc.nextLine().trim();

        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = wiseSayingRepository.add(content, author);

        System.out.println(wiseSaying.id + "번 명언이 등록되었습니다.");

    }

    public void remove(Rq rq) {

        // URL에 입력된 id 얻기
        int paramId = rq.getIntParam("id", 0);

        // URL에 입력된 id가 없다면 작업 중지
        if(paramId == 0) {
            System.out.println("id를 입력해주세요");
            return;
        }


        // URL에 입력된 id에 해당하는 명언객체 찾기
        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);


        // 명언 객체를 찾지 못했으면 중지
        if(foundWiseSaying == null){
            System.out.println(paramId + "번 명언은 존재하지 않습니다..");
            return;
        }


        // 입력된 id에 해당하는 명언객체를 리스트에서 삭제
        wiseSayingRepository.remove(paramId);


        System.out.println(paramId + "번 명언이 삭제되었습니다.");

    }


}
