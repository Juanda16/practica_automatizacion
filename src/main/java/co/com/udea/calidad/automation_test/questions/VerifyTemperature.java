package co.com.udea.calidad.automation_test.questions;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import org.hamcrest.Matchers;

import net.serenitybdd.screenplay.Actor;

public class VerifyTemperature implements net.serenitybdd.screenplay.Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
            seeThatResponse("The temperature should be greater than 0",
                response -> response.statusCode(200)
                    .body("current.temp_c", Matchers.greaterThan(0.0))
            )
        );
        return true;
    }

    public static VerifyTemperature isDisplayed() {
        return new VerifyTemperature();
    }
}
