package co.com.udea.calidad.automation_test.questions;

import net.serenitybdd.screenplay.Actor;

public class Question implements net.serenitybdd.screenplay.Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {

        return true;
    }

    public static Question validacion(){
        return new Question();
    }
}