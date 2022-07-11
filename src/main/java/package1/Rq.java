package package1;

public class Rq {

    String url;
    String path;
    String queryStr;

    public Rq(String url) {
        this.url = url;
        String[] urlBits = url.split("\\?", 2);
        this.path = urlBits[0];

        if(urlBits.length == 2){
            this.queryStr = urlBits[1];
        }

    }

    public int getIntParam(String inputParamName, int defaultValue) {

        if(queryStr == null){
            return defaultValue;
        }

        String[] bits = queryStr.split("&");

        for(String urlBit : bits) {

            String[] paramNameAndValue = urlBit.split("=", 2);
            String paramName = paramNameAndValue[0];
            String paramValue = paramNameAndValue[1];

            System.out.println("inputParamName: " + inputParamName +
                    ", paramName_: " + paramName + ", paramValue: " + paramValue
             );

            if(inputParamName.equals(paramName)) {
                return Integer.parseInt(paramValue);
            }
        }

        return defaultValue;

    }

    public String getPath() {

        return path;
    }


}
