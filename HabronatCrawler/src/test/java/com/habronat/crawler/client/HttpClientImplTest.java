package com.habronat.crawler.client;

import com.habronat.crawler.client.apache.ApacheHttpClientFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class HttpClientImplTest {

    private HttpClient httpClient;
    private ApacheHttpClientFactory apacheHttpClientFactory;

    private org.apache.http.client.HttpClient apacheClient;
    private ArgumentCaptor<HttpUriRequest> httpRequestCaptor;

    @Before
    public void setUp() {
        apacheHttpClientFactory = mock(ApacheHttpClientFactory.class);
        httpClient = new HttpClientImpl(apacheHttpClientFactory);

        apacheClient = mock(org.apache.http.client.HttpClient.class);
        doReturn(apacheClient).when(apacheHttpClientFactory).get();

        httpRequestCaptor = ArgumentCaptor.forClass(HttpUriRequest.class);
    }

    @Test
    public void get() throws IOException {
        doReturn(createHttpResponse("page content 1")).when(apacheClient).execute(any(HttpGet.class));

        Response response = httpClient.get("http://url1.com");

        assertThat(response.getContent(), equalTo("page content 1"));
        verify(apacheClient, times(1)).execute(httpRequestCaptor.capture());

        HttpUriRequest request = httpRequestCaptor.getValue();
        assertThat(request.getURI().toString(), equalTo("http://url1.com"));
        assertThat(request.getMethod(), equalTo("GET"));
    }

    @Test
    public void post() throws IOException {
        doReturn(createHttpResponse("page content 1")).when(apacheClient).execute(any(HttpGet.class));

        Response response = httpClient.post("http://url1.com");

        assertThat(response.getContent(), equalTo("page content 1"));
        verify(apacheClient, times(1)).execute(httpRequestCaptor.capture());

        HttpUriRequest request = httpRequestCaptor.getValue();
        assertThat(request.getURI().toString(), equalTo("http://url1.com"));
        assertThat(request.getMethod(), equalTo("POST"));
    }

    private HttpResponse createHttpResponse(String content) throws IOException {
        InputStream is = new ByteArrayInputStream(content.getBytes());

        HttpEntity httpEntity = mock(HttpEntity.class);
        doReturn(is).when(httpEntity).getContent();

        HttpResponse httpResponse = mock(HttpResponse.class);
        doReturn(httpEntity).when(httpResponse).getEntity();

        return httpResponse;
    }

}