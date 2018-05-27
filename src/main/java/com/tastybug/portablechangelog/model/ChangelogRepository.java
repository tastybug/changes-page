package com.tastybug.portablechangelog.model;

public interface ChangelogRepository {

    Changelog getChangelogForVersion(String version);

    Changelog getChangesRecursive(String latestVersion, String notAfter);
}
