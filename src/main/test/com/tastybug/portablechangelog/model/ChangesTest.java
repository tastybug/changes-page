package com.tastybug.portablechangelog.model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChangesTest {


    @Test
    void constructor_throws_NPE_on_null_or_empty_version_string() {
        assertThrows(IllegalArgumentException.class, () -> new Changes(null, Collections.emptyList()));
        assertThrows(IllegalArgumentException.class, () -> new Changes("", Collections.emptyList()));
    }

    @Test
    void can_create_Changes_without_any_ChangeItems() {
        new Changes("1.0", Collections.emptyList());
    }

    @Test
    void getItemsByLocale_returns_only_items_with_matching_locale() {
        ChangeItem expectedChangeItem = aChangeItem(Locale.CANADA, "bla");
        ChangeItem toBeFilteredChangeItem = aChangeItem(Locale.US, "blubb");
        Changes changes = aChanges(expectedChangeItem, toBeFilteredChangeItem);

        List<ChangeItem> changeItems = changes.getItemsByLocale(Locale.CANADA);

        assertThat(changeItems).containsExactly(expectedChangeItem);
    }

    @Test
    void getItemsByLocale_returns_empty_list_if_no_matching_locale_item_is_found() {
        ChangeItem expectedChangeItem = aChangeItem(Locale.CANADA, "bla");
        ChangeItem toBeFilteredChangeItem = aChangeItem(Locale.US, "blubb");
        Changes changes = aChanges(expectedChangeItem, toBeFilteredChangeItem);

        List<ChangeItem> changeItems = changes.getItemsByLocale(Locale.GERMAN);

        assertThat(changeItems).isEmpty();
    }


    @Test
    void getItemsByLocale_returns_fallback_items_if_no_() {
        ChangeItem expectedChangeItem = aChangeItem(Locale.CANADA, "bla");
        ChangeItem toBeFilteredChangeItem = aChangeItem(Locale.US, "blubb");
        Changes changes = aChanges(expectedChangeItem, toBeFilteredChangeItem);

        List<ChangeItem> changeItems = changes.getItemsByLocale(Locale.GERMAN);

        assertThat(changeItems).isEmpty();
    }


    private Changes aChanges(ChangeItem... changeItems) {
        return new Changes("1.2.3", Arrays.asList(changeItems));
    }

    private ChangeItem aChangeItem(Locale locale, String description) {
        return new ChangeItem(Optional.ofNullable(locale), description);
    }

}