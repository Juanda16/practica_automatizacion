package co.com.udea.calidad.automation_test.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

public class VerifyStatusCode implements Question<Boolean> {

    private final int expectedStatusCode;

    public VerifyStatusCode(int expectedStatusCode) {
        this.expectedStatusCode = expectedStatusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
            ResponseConsequence.seeThatResponse("The status code should be " + expectedStatusCode,
                response -> response.statusCode(expectedStatusCode)
            )
        );
        return true;
    }

    public static VerifyStatusCode is(int statusCode) {
        return new VerifyStatusCode(statusCode);
    }
}