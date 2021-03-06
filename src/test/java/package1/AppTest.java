package package1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {


    @Test
    public void 문자열을_파일에_저장() {

//        Util.file.mkdir("test_data");
//        Util.file.saveToFile("test_data/1.txt", "안녕");

        Util.file.mkdir(App.getBaseDir());
        Util.file.saveToFile(App.getBaseDir() + "/1.txt", "안녕");

//        String body = Util.file.readFromFile("test_data/1.txt", "");
        String body = Util.file.readFromFile(App.getBaseDir() + "/1.txt", "");

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
