package com.tastybug.portablechangelog.model;

import com.tastybug.portablechangelog.util.Checker;

import java.util.List;
import java.util.Locale;

import static java.util.stream.Collectors.toList;

public class Changelog {

    private String versionString;

    private List<Entry> entries;

    public Changelog(String versionString, List<Entry> entries) {
        Checker.ensureNotEmpty(versionString, "Null/empty versionString given.");
        this.versionString = versionString;
        this.entries = entries;
    }

    public List<Entry> getEntryByLocale(Locale expectedLocale) {
        return entries
                .stream()
                .filter(item -> !item.getLocale().isPresent()
                        || hasMatchingLocale(item, expectedLocale))
                .collect(toList());
    }

    private boolean hasMatchingLocale(Entry entry, Locale compareAgainst) {
        return compareAgainst.equals(entry.getLocale().orElse(null));
    }
}
