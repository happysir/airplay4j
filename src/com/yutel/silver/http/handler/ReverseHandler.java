package com.yutel.silver.http.handler;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.yutel.silver.http.HttpWrap;

public class ReverseHandler implements HttpHandler {

	public void handle(HttpWrap hw) throws IOException {
		Map<String, String> headers = hw.getRequestHeads();
		for (Map.Entry<String, String> item : headers.entrySet()) {
			System.out.println("name=" + item.getKey() + ",value=" + item.getValue());
		}
		response(hw);
	}

	private void response(HttpWrap hw) throws IOException {
		System.out.println("response");
		hw.getResponseHeads().put("Date", new Date().toString());
		hw.getResponseHeads().put("Upgrade", "PTTH/1.0");
		hw.getResponseHeads().put("Connection", "Upgrade");
		hw.sendResponseHeaders(101, 0);
	}
}
