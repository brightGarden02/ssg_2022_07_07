package package1;

public class WiseSaying {

    int id;
    String content;
    String author;

    public WiseSaying(int id, String content, String author) {

        this.id = id;
        this.content = content;
        this.author = author;
    }

    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String toJson() {
        return """
                {
                    "id": %d,
                    "content": "%s",
                    "author": "%s"
                }
                """.stripIndent().formatted(id, content, author);
    }

}
