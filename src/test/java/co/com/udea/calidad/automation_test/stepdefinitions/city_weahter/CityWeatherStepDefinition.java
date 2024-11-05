package co.com.udea.calidad.automation_test.stepdefinitions.city_weahter;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import co.com.udea.calidad.automation_test.tasks.ConnectTo;
import co.com.udea.calidad.automation_test.tasks.ConsumerThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class CityWeatherStepDefinition {
        Actor user = Actor.named("user");

    @Before
    public void config(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("the user is on the weather page")
    public void theUserIsOnTheWeatherPage() {
        user.attemptsTo(ConnectTo.theService());
    }

    @When("the user enters a city")
    public void theUserEntersTheCity(
    ) {
        user.attemptsTo(ConsumerThe.service(
          "Medellin"
        ));
    }

    @When("the user enters {string}")
    public void theUserEntersTheCity(String city) {
        user.attemptsTo(ConsumerThe.service(city));
    }

    @Then("the user should see the temperature")
    public void theUserShouldSeeTheWeatherInformation() {
        //Questions
        user.should(seeThatResponse(response->response.statusCode(200)
        .body("current.temp_c", Matchers.greaterThan(((Number) 0).floatValue()))
       
));
}

    @Given("the user make a request to the weather API")
    public void the_user_make_a_request_to_the_weather_API() {
    }

    @Then("the user should see the status code 200")
    public void the_user_should_see_the_status_code() {
        user.should(seeThatResponse(response->response.statusCode(200)));
    }
}

  