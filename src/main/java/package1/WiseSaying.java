package package1;

public class WiseSaying {

    private int idx;
    private String author;
    private String content;

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

    public WiseSaying(int idx, String author, String content) {

        this.idx = idx;
        this.author = author;
        this.content = content;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "idx=" + idx +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
