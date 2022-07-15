package package1;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
//    public List<WiseSaying> wiseSayings;
//    public int wiseSayingLastId;

    private WiseSayingTable wiseSayingTable;
    WiseSayingRepository() {
//        wiseSayings = new ArrayList<>();
//        wiseSayingLastId = 0;
        wiseSayingTable = new WiseSayingTable(App.getBaseDir());
    }

    public WiseSaying findById(int paramId) {

//        for(WiseSaying wiseSaying : wiseSayings){
//            if(wiseSaying.id == paramId){
//                return wiseSaying;
//            }
//        }
//
//        return null;

        return wiseSayingTable.findById(paramId);
    }


    public List<WiseSaying> findAll() {

        return wiseSayingTable.findAll();
    }

    public WiseSaying add(String content, String author) {

//        int id = ++wiseSayingLastId;
//        WiseSaying wiseSaying = new WiseSaying(id, content, author);
//        wiseSayings.add(wiseSaying);

        // store file

//        return wiseSaying;
        return wiseSayingTable.save(content, author);
    }


    public boolean remove(int paramId) {

//        WiseSaying foundWiseSaying = findById(paramId);
//        wiseSayings.remove(foundWiseSaying);
//        wiseSayingLastId--;

        // delete file

        return wiseSayingTable.removeById(paramId);
    }

    public boolean modify(int paramId, String content, String author){

//        WiseSaying foundWiseSaying = findById(paramId);
//        foundWiseSaying.content = content;
//        foundWiseSaying.author = author;


        // modify file
        return wiseSayingTable.save(paramId, content, author);
    }
}
