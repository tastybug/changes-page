package com.tastybug.portablechangelog.model;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Optional;

public class Entry {

    private Optional<Locale> locale;

    private String description;

    private LinkedList<Link> links;

    public Entry(Optional<Locale> locale, String description) {
        this.locale = locale;
        this.description = description;
    }

    public Optional<Locale> getLocale() {
        return locale;
    }

    public String getDescription() {
        return description;
    }

    public LinkedList<Link> getLinks() {
        return links;
    }

}
