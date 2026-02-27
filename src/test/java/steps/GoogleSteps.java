package steps;

import net.serenitybdd.annotations.Step;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleSteps {

    GooglePage googlePage;

    @Step
    public void abrirGoogle() {
        googlePage.open();
    }

    @Step("Ingresar término de búsqueda: {0}")
    public void searchesFor(String term) {
        googlePage.enterSearchTerm(term);
    }

    @Step("Validar resultados")
    public void shouldSeeResultsFor(String term) {
        assertThat(googlePage.getTitle(), containsString(term));
    }
}
