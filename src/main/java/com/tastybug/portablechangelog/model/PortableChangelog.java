package com.tastybug.portablechangelog.model;

import static com.tastybug.portablechangelog.util.Checker.ensureNotEmpty;

public class PortableChangelog {

    ChangelogRepository changelogRepository;

    public PortableChangelog() {
        this(new ChangesClasspathSlurper());
    }

    public PortableChangelog(ChangelogRepository changelogRepository) {
        this.changelogRepository = changelogRepository;
    }

    public Changes getChangesForVersion(String version) {
        ensureNotEmpty(version, "No version given.");

        return changelogRepository.getChangesByVersion(version);
    }
}
