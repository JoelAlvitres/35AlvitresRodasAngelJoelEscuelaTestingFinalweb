package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;
import steps.SauceDemoSteps;

public class Hooks {

    @Steps
    SauceDemoSteps sauce;

    @Before("@SAUCEDEMO")
    public void abrirSauceDemoAntesDeCadaEscenario() {
        sauce.abrirSauceDemo();
    }
}