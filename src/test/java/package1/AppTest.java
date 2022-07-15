package package1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void 명언을_삭제할_수_있다() {

        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다
                나폴레옹
                삭제?id=1
                목록
                삭제?id=1
                종료
                """);

        System.out.println(rs);

        assertTrue(rs.contains("1번 명언이 등록되었습니다"));
        assertTrue(rs.contains("2번 명언이 등록되었습니다"));

        assertTrue(rs.contains("1번 명언이 삭제되었습니다"));

        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("--------------------------"));

        assertTrue(rs.contains("2 / 나폴레옹 / 나에게 불가능이란 없다"));

        assertTrue(rs.contains("1번 명언은 존재하지 않습니다"));

    }


    @Test
    public void 등록_후_목록에서_확인할_수_있어야_한다() {

        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다
                나폴레옹
                목록
                종료
                """);


        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("--------------------------"));

        assertTrue(rs.contains("2 / 나폴레옹 / 나에게 불가능이란 없다"));
        assertTrue(rs.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라"));

    }


    @Test
    public void 등록을_하면_생성된_명언의_번호가_출력되어야_한다() {

        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다
                나폴레옹
                종료
                """);


        assertTrue(rs.contains("1번 명언이 등록되었습니다"));
        assertTrue(rs.contains("2번 명언이 등록되었습니다"));

    }



    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {

        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                종료
                """);


        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));

    }


    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료()  {

        String rs = AppTestRunner.run("종료");


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
