package stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.GoogleSteps;

public class GoogleStepDefinitions {

    @Steps
    GoogleSteps googleSteps;

    @Dado("que el usuario abre la página de Google")
    public void queElUsuarioAbreLaPaginaDeGoogle() {
        googleSteps.abrirGoogle();
    }

    @Dado("que el usuario está en la página de DuckDuckGo")
    public void queElUsuarioEstáEnLaPáginaDeDuckDuckGo() {
        googleSteps.abrirGoogle();
    }

    @Cuando("busca el término {string}")
    public void buscaElTérmino(String term) {
        googleSteps.searchesFor(term);
    }

    @Entonces("debería ver resultados relacionados con {string}")
    public void deberíaVerResultadosRelacionadosCon(String term) {
        googleSteps.shouldSeeResultsFor(term);
    }
}
