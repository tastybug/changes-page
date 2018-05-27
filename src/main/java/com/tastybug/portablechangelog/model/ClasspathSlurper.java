package com.tastybug.portablechangelog.model;

class ClasspathSlurper implements ChangelogRepository {


    @Override
    public Changelog getChangelogForVersion(String version) {
        return null;
    }

    @Override
    public Changelog getChangesRecursive(String latestVersion, String notAfter) {
        return null;
    }
}
