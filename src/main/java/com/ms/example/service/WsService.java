package com.ms.example.service;

import javax.jws.WebService;

@WebService
public interface WsService {
  public DocResponse getDocument(final String name);
}
