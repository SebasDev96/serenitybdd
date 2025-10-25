package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.By;


public class AddTransactionStepDefinitions {

    @Given("{actor} is logged into the application")
    public void isLoggedIntoApplication(Actor actor) {

        actor.attemptsTo(
                Open.url("http://127.0.0.1:5500/login.html"),
                Enter.theValue("user").into(By.id("username")),
                Enter.theValue("pass").into(By.id("password")),
                Click.on(By.xpath("//button[contains(text(),'Iniciar sesión')]"))

        );

    }

    @When("{actor} enters the required information for the new transaction")
    public void entersTheRequiredInformationForTheNewTransaction(Actor actor) {
        actor.attemptsTo(
                Click.on("//button[contains(.,'Añadir transacción')]"),
                Enter.theValue("12-12-2025").into("//input[@type='date']"),
                Enter.theValue("700").into(By.id("amount")),
                Enter.theValue("testing description").into(By.id("description")),
                Click.on(By.xpath("//button[contains(.,'Guardar')]"))
        );

    }

    @Then("{actor} should see a new transaction in the transaction list with correct details")
    public void shouldSeeANewTransaction(Actor actor) {
        actor.attemptsTo(

                Ensure.that(By.xpath("//tbody[@id='transactions-list']"))
                        .text().contains("testing description")


        );


    }

}
