package pl.kowalecki.soaplab1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kowalecki.soaplab1wsdl.RegisterCallResponse;
import pl.kowalecki.soaplab1wsdl.ResultsResponse;


@SpringBootApplication
public class Soaplab1Application {

    @Bean
    CommandLineRunner lookup(WebClient webClient){
        return args -> {
            String student = "Piotr";
            if (args.length > 0) {
                student = args[0];
            }
            RegisterCallResponse registerCallResponse = webClient.registerCallResponse(student);
            System.out.println(registerCallResponse.getExercise().getName());
            System.out.println(registerCallResponse.getExercise().getNote());
            ResultsResponse resultsResponse = webClient.getResult(student);
            System.out.println(resultsResponse.getEntry());
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Soaplab1Application.class, args);


    }
}
