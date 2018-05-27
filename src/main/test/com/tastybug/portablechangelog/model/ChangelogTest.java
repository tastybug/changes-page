package com.tastybug.portablechangelog.model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChangelogTest {


    @Test
    void constructor_throws_NPE_on_null_or_empty_version_string() {
        assertThrows(IllegalArgumentException.class, () -> new Changelog(null, Collections.emptyList()));
        assertThrows(IllegalArgumentException.class, () -> new Changelog("", Collections.emptyList()));
    }

    @Test
    void can_create_Entries_without_any_ChangeItems() {
        new Changelog("1.0", Collections.emptyList());
    }

    @Test
    void getEntriesByLocale_returns_only_items_with_matching_locale() {
        Entry expectedEntry = anEntry(Locale.CANADA, "bla");
        Entry toBeFilteredChangeItem = anEntry(Locale.US, "blubb");
        Changelog changelog = aChangelog(expectedEntry, toBeFilteredChangeItem);

        List<Entry> entries = changelog.getEntryByLocale(Locale.CANADA);

        assertThat(entries).containsExactly(expectedEntry);
    }

    @Test
    void getEntriesByLocale_returns_empty_list_if_no_matching_locale_item_is_found() {
        Entry expectedEntry = anEntry(Locale.CANADA, "bla");
        Entry toBeFilteredEntry = anEntry(Locale.US, "blubb");
        Changelog changelog = aChangelog(expectedEntry, toBeFilteredEntry);

        List<Entry> entries = changelog.getEntryByLocale(Locale.GERMAN);

        assertThat(entries).isEmpty();
    }



    private Changelog aChangelog(Entry... entries) {
        return new Changelog("1.2.3", Arrays.asList(entries));
    }

    private Entry anEntry(Locale locale, String description) {
        return new Entry(Optional.ofNullable(locale), description);
    }

}