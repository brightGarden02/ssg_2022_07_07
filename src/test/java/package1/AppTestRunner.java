package package1;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {

    public static String run(String input) {

        Scanner sc = TestUtil.genScanner(input);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        //실행
        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
