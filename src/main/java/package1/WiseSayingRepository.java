package package1;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    public List<WiseSaying> wiseSayings;
    public int wiseSayingLastId;

    WiseSayingRepository() {
        wiseSayings = new ArrayList<>();
        wiseSayingLastId = 0;
    }


    public WiseSaying findById(int paramId) {

        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.id == paramId){
                return wiseSaying;
            }
        }

        return null;
    }


    public List<WiseSaying> findAll() {

        return wiseSayings;
    }

    public WiseSaying write(String content, String author) {

        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);

        // store file

        return wiseSaying;
    }


    public void remove(int paramId) {

        WiseSaying foundWiseSaying = findById(paramId);
        wiseSayings.remove(foundWiseSaying);
        wiseSayingLastId--;

        // delete file

    }

    public void modify(int paramId, String content, String author){

        WiseSaying foundWiseSaying = findById(paramId);
        foundWiseSaying.content = content;
        foundWiseSaying.author = author;


        // modify file

    }
}
