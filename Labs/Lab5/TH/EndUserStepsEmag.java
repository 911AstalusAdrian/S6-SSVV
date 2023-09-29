package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.DictionaryPage;
import org.example.pages.DictionaryPageEmag;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserStepsEmag {

    DictionaryPageEmag dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_products(String productName) {
       List<String> products = dictionaryPage.getProducts(productName);
       assert products.size() > 0;
    }

    @Step
    public void filter_products(String filter) {
        assert dictionaryPage.filter_results(filter);
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}
