package co.com.udea.calidad.automation_test.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class ConsumerThe implements Task {
    private EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
    private String apiKey;
    private String city;

    public ConsumerThe(String city) {
        this.city = city;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
 
            apiKey = environmentVariables.getProperty("webdriver.base.apiKey");
            String resource = "/current.json?key=" + apiKey + "&q=" + city;
    
            actor.attemptsTo(
                Get.resource(resource)
            );
        }

    public static ConsumerThe service(String city){
        return Tasks.instrumented(ConsumerThe.class, city);
    }
}


//@Override
// public <T extends Actor> void performAs(T actor) {
    
//     apiKey = environmentVariables.getProperty("webdriver.base.apiKey");
//       String Getof = "/current.json?key="+apiKey;
//       actor.attemptsTo(
//               Get.resource(Getof).with(
//                 request -> request
//                     .header("Content-Type","application/json")
                    
//                     .param("q", city)
//                     .param("aqi", "no")
//                     .relaxedHTTPSValidation()
//                     .formParam("Grant_type","Typer_value")
//               )
//       );
// }
// public static ConsumerThe service(String city){
//     return Tasks.instrumented(ConsumerThe.class, city);
// }
// }
