package package1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {


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
