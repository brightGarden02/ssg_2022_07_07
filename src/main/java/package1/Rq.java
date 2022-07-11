package package1;

public class Rq {

    String url;

    public Rq(String url) {
        this.url = url;
    }

    public int getIntParam(String paramName, int defaultValue) {

        String[] urlBits = url.split("\\?", 2);
        urlBits = urlBits[1].split("&");

        for(String urlBit : urlBits) {

            String[] paramNameAndValue = urlBit.split("=", 2);
            String paramName_ = paramNameAndValue[0];
            String paramValue = paramNameAndValue[1];

            if(paramName.equals(paramName_)) {
                return Integer.parseInt(paramValue);
            }
        }

        return defaultValue;

    }

    public String getPath() {
        String[] urlBits = url.split("\\?", 2);

        return urlBits[0];
    }


}
