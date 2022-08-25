package pl.luckit.ing.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.net.URI;

@Slf4j
public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {

    private static final String REST_TEMPLATE_ERROR_MESSAGE = "Error appeared when called URL: {}, HttpMethod: {}";

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
                || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(URI url, HttpMethod method, ClientHttpResponse response) throws IOException {
        log.warn(REST_TEMPLATE_ERROR_MESSAGE, url, method);
        this.handleError(response);
    }
}