package com.tastybug.portablechangelog.model;

import com.tastybug.portablechangelog.util.Checker;

import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

public class Changes {

    private String versionString;

    private List<ChangeItem> changeItems;

    public Changes(String versionString, List<ChangeItem> changeItems) {
        Checker.ensureNotEmpty(versionString, "Null/empty versionString given.");
        this.versionString = versionString;
        this.changeItems = changeItems;
    }

    public List<ChangeItem> getItemsByLocale(Locale expectedLocale) {
        return changeItems
                .stream()
                .filter(item -> !item.getLocale().isPresent()
                        || hasMatchingLocale(item, expectedLocale))
                .collect(toList());
    }

    private boolean hasMatchingLocale(ChangeItem changeItem, Locale compareAgainst) {
        return compareAgainst.equals(changeItem.getLocale().orElse(null));
    }
}
