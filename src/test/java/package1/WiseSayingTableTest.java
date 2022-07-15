package package1;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WiseSayingTableTest {

    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {

        WiseSayingTable wiseSayingTable = new WiseSayingTable("test_data");

        WiseSaying wiseSaying = new WiseSaying(1, "나에게 불가능이란 없다", "나폴레옹");

//        wiseSayingTable.save(wiseSaying);

        assertTrue(new File("test_data/wise_saying/1.json").exists());
    }



}
