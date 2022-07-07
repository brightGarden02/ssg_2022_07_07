package package1;

public class WiseSaying {

    private int idx;
    private String content;
    private String name;

    public WiseSaying(int idx, String content, String name) {

        this.idx = idx;
        this.content = content;
        this.name = name;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "idx=" + idx +
                ", content='" + content + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
