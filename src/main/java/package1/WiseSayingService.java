package package1;

import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }


    public void dumpToJson() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();

        String json = "[" + wiseSayings
                .stream()
                .map(wiseSaying -> wiseSaying.toJson())
                .collect(Collectors.joining(",")) + "]";

        Util.file.saveToFile("%s/data.json".formatted(App.getBaseDir()), json);
    }

    public WiseSaying findById(int paramId) {
        return wiseSayingRepository.findById(paramId);

    }

    public boolean modify(int paramId, String newContent, String newAuthor) {
        return wiseSayingRepository.modify(paramId, newContent, newAuthor);
    }


    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.add(content, author);
    }

    public boolean remove(int paramId) {
        return wiseSayingRepository.remove(paramId);
    }
}
