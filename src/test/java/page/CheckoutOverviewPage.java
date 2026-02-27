package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends PageObject {

    @FindBy(css = ".title")
    private WebElementFacade pageTitle;

    @FindBy(id = "finish")
    private WebElementFacade finishButton;

    @FindBy(id = "cancel")
    private WebElementFacade cancelButton;

    @FindBy(css = ".summary_subtotal_label")
    private WebElementFacade subtotalLabel;

    @FindBy(css = ".summary_tax_label")
    private WebElementFacade taxLabel;

    @FindBy(css = ".summary_total_label")
    private WebElementFacade totalLabel;

    public boolean estaEnOverview() {
        return pageTitle.waitUntilVisible().getText().equals("Checkout: Overview");
    }

    public String obtenerSubtotal() { return subtotalLabel.getText(); }
    public String obtenerImpuesto() { return taxLabel.getText(); }
    public String obtenerTotal() { return totalLabel.getText(); }

    public void clickFinish() {
        finishButton.waitUntilClickable().click();
    }

    public void clickCancel() {
        cancelButton.waitUntilClickable().click();
    }
}