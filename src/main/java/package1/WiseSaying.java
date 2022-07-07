package package1;

public class WiseSaying {

    private int idx;
    private String content;
    private String author;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public WiseSaying(int idx, String content, String author) {

        this.idx = idx;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "idx=" + idx +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
