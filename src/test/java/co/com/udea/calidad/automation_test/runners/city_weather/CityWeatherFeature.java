package co.com.udea.calidad.automation_test.runners.city_weather;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/city_weather_feature/city_weather.feature",
        glue = "co.com.udea.calidad.automation_test.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CityWeatherFeature {}