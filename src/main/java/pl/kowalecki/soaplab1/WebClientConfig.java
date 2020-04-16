package pl.kowalecki.soaplab1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
public class WebClientConfig {


    @Bean
    public Jaxb2Marshaller jaxb2Marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("pl.kowalecki.soaplab1wsdl");
        return jaxb2Marshaller;
    }
    @Bean
    public WebClient webClient(Jaxb2Marshaller jaxb2Marshaller){
        WebClient webClient = new WebClient();
        webClient.setDefaultUri("http://localhost:8088/mockApiPortSoap11");
        webClient.setMarshaller(jaxb2Marshaller);
        webClient.setUnmarshaller(jaxb2Marshaller);
        return webClient;
    }
}
