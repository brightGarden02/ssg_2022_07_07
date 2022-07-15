package package1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {


    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {

        Scanner sc = TestUtil.genScanner("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        //실행
        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);


        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));

    }


    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료()  {

        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        //실행
        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);


        System.out.println(rs);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));

    }

    @Test
    public void 문자열을_파일에_저장() {

        Util.file.mkdir("test_data");
        Util.file.saveToFile("test_data/1.txt", "안녕");

        String body = Util.file.readFromFile("test_data/1.txt");

        assertEquals("안녕", body);
    }


    @Test
    public void 출력을_모니터에_하지_않고_문자열로_얻기() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", rs);
    }


    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {

        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);

    }

    @Test
    public void Rq_getIntParam() {
        Rq rq = new Rq("삭제?id=1");

        int id = rq.getIntParam("id", 0);

        assertEquals(1, id);

    }


    @Test
    public void Rq_getIntParam_2() {

        Rq rq = new Rq("검색?id=10&no=1");

        int id = rq.getIntParam("id", 0);
        int no = rq.getIntParam("no", 0);

        assertEquals(10, id);
        assertEquals(1, no);

    }

    @Test
    public void Rq_getPath() {

        Rq rq = new Rq("삭제?id=1");

        String path = rq.getPath();

        assertEquals("삭제", path);

    }

}
