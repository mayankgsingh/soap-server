package com.ms.example.service;

/**
 * POJO class for response
 */
public class DocResponse {
  private String name;
  private long size;
  private byte[] data;
  
  public DocResponse() {

  }
  
  public DocResponse(String name, long size) {
    super();
    this.name = name;
    this.size = size;
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public long getSize() {
    return size;
  }
  
  public void setSize(long size) {
    this.size = size;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
}
