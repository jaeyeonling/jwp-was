package webserver.http.request;

import webserver.http.HttpMethod;

public class RequestLine {

    private static final String SEPARATOR = " ";
    private static final int INDEX_OF_REQUEST_METHOD = 0;
    private static final int INDEX_OF_REQUEST_URL = 1;

    private final HttpMethod method;
    private final RequestURL url;

    private RequestLine(final HttpMethod method,
                        final RequestURL url) {
        this.method = method;
        this.url = url;
    }

    public static RequestLine parse(final String rawRequestLine) {
        final String[] splitRequestLine = rawRequestLine.split(SEPARATOR);
        final HttpMethod httpMethod = HttpMethod.of(splitRequestLine[INDEX_OF_REQUEST_METHOD]);
        final RequestURL requestURL = RequestURL.of(splitRequestLine[INDEX_OF_REQUEST_URL]);

        return new RequestLine(httpMethod, requestURL);
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return url.getPath();
    }

    boolean matchMethod(final HttpMethod other) {
        return method == other;
    }

    public String getParameter(final String key) {
        return url.getParameter(key);
    }

    RequestQuery getParameters() {
        return url.getParameters();
    }

    @Override
    public String toString() {
        return "RequestLine{" +
                "method=" + method +
                ", url=" + url +
                '}';
    }
}
