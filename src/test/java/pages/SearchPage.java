package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {

    private SelenideElement
            searchInput = $(".field.field_lg.px-3"),
            activeSearchInput = $(".text-field__element:nth-child(1)"),
            suggestDropdown = $(".dropdown-item"),
            searchResultsBlock = $(".page_results__row.row"),
            subwayOnComplexCard = $(".subway"),
            builderOnComplexCard = $(".obj-card-body__item");


    public SearchPage openSearchPage(){
        open("/objects/list");

        return this;
    }


    public SearchPage activateInputField(){
        searchInput.click();

        return this;
    }

    public SearchPage setValueOnInputField(String value){
        activeSearchInput.setValue(value);

        return this;
    }

    public SearchPage clickOnObjectInSuggest(){
        suggestDropdown.click();

        return this;
    }

    public SearchPage checkSuccsessfulSearchByComplex(String value){
        searchResultsBlock.shouldHave(text(value));

        return this;
    }

    public SearchPage checkSuccsessfulSearchByMetro(String value){
        sleep(5000); //иначе не успеет прогрузится
        subwayOnComplexCard.shouldHave(text(value));

        return this;
    }

    public SearchPage checkSuccsessfulSearchByBuilder(String value){
        sleep(5000); //иначе не успеет прогрузится
        builderOnComplexCard.shouldHave(text(value));

        return this;
    }
}
