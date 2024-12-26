package com.ms.example.config;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.binding.soap.JaxWsSoapBindingConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ms.example.service.DocService;
import com.ms.example.service.WsService;

public class Server {
  
  private static final Logger log = LoggerFactory.getLogger(Server.class);
  
  protected Server() throws Exception {
    log.info("Initiating...");
    DocService service = new DocService();
    JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean(); 
    svrFactory.setServiceClass(WsService.class); 
    svrFactory.setAddress("http://localhost:9000/doc"); 
    svrFactory.setServiceBean(service);
    //enable sending file as multipart attachment
    ((JaxWsSoapBindingConfiguration)svrFactory.getBindingConfig()).setMtomEnabled(true);
    svrFactory.create();
  }

  public static void main(String[] args) throws Exception {
    new Server();
    log.info("Server ready...");

    //Thread.sleep(5 * 60 * 1000);
    //System.out.println("Server exiting");
    //System.exit(0);
  }
}
