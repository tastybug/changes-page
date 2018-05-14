package com.tastybug.portablechangelog.model;

public interface ChangelogRepository {

    Changes getChangesByVersion(String version);

    Changes getChangesRecursive(String latestVersion, String notAfter);
}
