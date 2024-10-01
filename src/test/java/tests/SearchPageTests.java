package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.SearchPage;

@DisplayName("Страница поиска по ЖК")
public class SearchPageTests extends TestBase {

    SearchPage searchPage =new SearchPage();

    @DisplayName("Соответствие выдачи по ЖК")
    @ValueSource(strings = {
            "Цветной город",
            "Янила Драйв"
    })
    @Tag("SMOKE")
    @ParameterizedTest(name = "По ЖК {0}")
    void successfulComplexSearchTest(String SearchComplex) {
        searchPage
                .openSearchPage()
                .activateInputField()
                .setValueOnInputField(SearchComplex)
                .clickOnObjectInSuggest()
                .checkSuccsessfulSearchByComplex(SearchComplex);
    }

    @Disabled ("TRR-9999")
    @DisplayName("Соответствие выдачи по метро")
    @ValueSource(strings = {
            "Озерки",
            "Василеостровская"
    })
    @Tag("REGRESS")
    @ParameterizedTest(name =  "По метро {0}")
    void successfulComplexSearchForSubwayTest(String SearchSubway){
        searchPage
                .openSearchPage()
                .activateInputField()
                .setValueOnInputField(SearchSubway)
                .clickOnObjectInSuggest()
                .checkSuccsessfulSearchByMetro(SearchSubway);
    }
}
