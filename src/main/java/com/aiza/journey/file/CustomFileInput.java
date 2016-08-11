package com.aiza.journey.file;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

public class CustomFileInput {
	private static final String TXT_TYPE = "text/plain";

	public static void main(String[] args) {
		String exampleString = "00OW               20121019                                                                                   \r\n" + 
				"0601OWA0d       20130101000000100000040000 0000000030000150   \r\n" + 
				"0601OWA0d       20130101000040100000005000 0000000030000071   \r\n" + 
				"0601OWA0d       20130101000045100000005000 0000000030000063   \r\n" + 
				"0601OWA0d       20130101000050100000005000 0000000030000057   \r\n" + 
				"99               OW00020486            ";
		InputStream inputStream = new ByteArrayInputStream(exampleString.getBytes(StandardCharsets.UTF_8));

		String finalURL = "http://localhost:8080/luz_compensation/api/qst-tariffs";
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

		String contentType = TXT_TYPE;
		String fileName = "demo";
		builder.addBinaryBody("file", inputStream, ContentType.create(contentType), fileName);

		HttpPost postRequest = new HttpPost(finalURL);
		postRequest.setEntity(builder.build());
		try {
			HttpResponse response = HttpClientBuilder.create().build().execute(postRequest);
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
