package com.ms.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.activation.DataHandler;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

@WebService(endpointInterface = "com.ms.example.service.DocService")
public class DocService implements WsService {
  private static final String DOC_LOCATION = "test.pdf";

  @Override
  public DocResponse getDocument(String name) {
    File file = Paths.get(DOC_LOCATION).toFile();

    DocResponse res = new DocResponse(file.getName(), file.length());
    try {
      res.setData(DocService.class.getClassLoader().getResourceAsStream(DOC_LOCATION).readAllBytes());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return res;
  }

  @XmlMimeType("application/octet-stream")
  private DataHandler imageData;

  public DataHandler getImageData() {
    return imageData;
  }

  public void setImageData(DataHandler imageData) { 
    this.imageData = imageData; 
  }
}
