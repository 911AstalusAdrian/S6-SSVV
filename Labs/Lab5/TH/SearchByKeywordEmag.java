package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.EndUserStepsEmag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/EmagTestData.csv")
public class SearchByKeywordEmag {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public EndUserStepsEmag anna;

    public String name;

    public String filter;

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public void setWebdriver(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    @Issue("#EMAG-1")
    @Test
    public void searchEmagByKeywordTestDDT() {
        anna.is_the_home_page();
        anna.looks_for(getName());
        if (getFilter().isEmpty()) {
            anna.should_see_products(getName());
        } else {
            anna.filter_products(getFilter());
        }
    }
//    public void searching_by_keyword_iphone_14_should_display_the_corresponding_article() {
//        anna.is_the_home_page();
//        anna.looks_for("iphone 14");
//        anna.should_see_products("iphone 14");
//    }
//
//    @Test
//    public void searching_by_keyword_iphone_15_should_display_the_corresponding_article() {
//        anna.is_the_home_page();
//        anna.looks_for("iphone 15");
//        anna.should_see_products("iphone 15");
//    }
//
//    @Test
//    public void searching_by_keyword_iphone_14_and_filter_256_GB_should_display_results() {
//        anna.is_the_home_page();
//        anna.looks_for("iphone 14");
//        anna.filter_products("256 GB");
//    }
//
//    @Test
//    public void searching_by_keyword_iphone_14_and_filter_2_TB_should_display_results() {
//        anna.is_the_home_page();
//        anna.looks_for("iphone 14");
//        anna.filter_products("2 TB");
//    }

//    @Pending
//    @Test
//    public void searching_by_ambiguious_keyword_should_display_the_disambiguation_page() {
//    }
}
