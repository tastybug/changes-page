package com.tastybug.portablechangelog.model;

import java.util.LinkedList;
import java.util.Locale;
import java.util.Optional;

public class ChangeItem {

    private Optional<Locale> locale;

    private String description;

    private LinkedList<ExternalLink> links;

    public ChangeItem(Optional<Locale> locale, String description) {
        this.locale = locale;
        this.description = description;
    }

    public Optional<Locale> getLocale() {
        return locale;
    }

    public String getDescription() {
        return description;
    }

    public LinkedList<ExternalLink> getLinks() {
        return links;
    }

}
