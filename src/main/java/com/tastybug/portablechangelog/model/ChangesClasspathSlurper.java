package com.tastybug.portablechangelog.model;

import com.tastybug.portablechangelog.model.ChangelogRepository;

class ChangesClasspathSlurper implements ChangelogRepository {


    @Override
    public Changes getChangesByVersion(String version) {
        return null;
    }

    @Override
    public Changes getChangesRecursive(String latestVersion, String notAfter) {
        return null;
    }
}
