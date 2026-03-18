package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import java.net.URISyntaxException;

public class RegistrationStepDefinitions {
    @Given("{actor} wants to sign up in the application")
    //camel case convention
    public void wantsToSignUpInTheApplication(Actor actor) throws URISyntaxException {

        String expectedName = "Sebastian";
        String expectedLastname = "Engativa";
        String expectedAge = "29";
        String expectedEmail = "coco@gmail.com";
        String expectedCountry = "Colombia";


        actor.attemptsTo(
                Open.url("http://127.0.0.1:5501/register.html"),
                Enter.theValue(expectedName).into("//input[@id='name']"),
                Enter.theValue(expectedLastname).into("//input[@id='last-name']"),
                Enter.theValue(expectedAge).into("//input[@id='age']"),
                SelectFromOptions.byVisibleText(expectedCountry).from("//select[@id='country']"),
                Click.on("//input[@id='sex-m']"),
                Enter.theValue(expectedEmail).into("//input[@type='email']"),
                Click.on("//input[@id='monday']"),
                Upload.theClasspathResource("pictures/img.jpg")
                        .to(Target.the("picture fied").locatedBy("//input[@id='picture']")),
                Click.on("//button[@id='save-btn']"),
                Switch.toWindowTitled("Summary"),
                Ensure.that(Target.the("Name element")
                        .locatedBy("//strong[contains(text(), 'Nombre')]/parent::p")).text()
                        .containsIgnoringCase(expectedName),

                Ensure.that(Target.the("Last name element")
                                .locatedBy("//strong[contains(text(), 'Apellido')]/parent::p")).text()
                        .containsIgnoringCase(expectedLastname)



        );
    }
}
