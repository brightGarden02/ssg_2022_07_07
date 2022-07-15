package package1;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WiseSayingTable {

    private String baseDir;

    public WiseSayingTable(String baseDir) {
        this.baseDir = baseDir;
    }

    public void save(WiseSaying wiseSaying) {

        Util.file.mkdir("%s/wise_saying".formatted(baseDir));
        String body = wiseSaying.toJson();

        Util.file.saveToFile("%s/wise_saying/%d.json".formatted(baseDir, wiseSaying.id), body);
    }

    public void save(String content, String author) {
        int id = getLastId() + 1;

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        save(wiseSaying);

        saveLastId(id);
    }

    private void saveLastId(int id) {
        Util.file.saveToFile("%s/wise_saying/last_id.txt".formatted(baseDir), id + "");
    }

    public int getLastId() {

        String lastId = Util.file.readFromFile("%s/wise_saying/last_id.txt".formatted(baseDir), "");

        if(lastId.isEmpty()){
            return 0;
        }

        return Integer.parseInt(lastId);
    }

    public WiseSaying findById(int id) {
        String path = "%s/wise_saying/%d.json".formatted(baseDir, id);

        if(new File(path).exists() == false){
            return null;
        }

        Map<String, Object> map = Util.json.jsonToMapFromFile(path);

        if(map == null){
            return null;
        }

        return new WiseSaying((int) map.get("id"), (String) map.get("content"), (String) map.get("author"));

    }

    public List<WiseSaying> findAll() {
        List<Integer> fileIds = getFileIds();

        return fileIds
                .stream()
                .map(id -> findById(id))
                .collect(Collectors.toList());
    }

    private List<Integer> getFileIds() {

        String path = "%s/wise_saying".formatted(baseDir);
        List<String> fileNames = Util.file.getFileNamesFromDir(path);

        return fileNames
                .stream()
                .filter(fileName -> !fileName.equals("last_id.txt"))
                .map(fileName -> fileName.replace(".json", ""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public void removeById(int id){
        String path = "%s/wise_saying/%d.json".formatted(baseDir, id);

        new File(path).delete();
    }


}
