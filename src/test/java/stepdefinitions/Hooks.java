package stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.annotations.Steps;

public class Hooks {

    @Steps
    SauceDemoStepDefinitions sauceSteps;

    @Before("@saucedemo")
    public void abrirPaginaAntes() {
        sauceSteps.abrirPagina();
    }
}