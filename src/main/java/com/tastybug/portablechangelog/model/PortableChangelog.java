package com.tastybug.portablechangelog.model;

import static com.tastybug.portablechangelog.util.Checker.ensureNotEmpty;

public class PortableChangelog {

    ChangelogRepository changelogRepository;

    public PortableChangelog() {
        this(new ClasspathSlurper());
    }

    public PortableChangelog(ChangelogRepository changelogRepository) {
        this.changelogRepository = changelogRepository;
    }

    public Changelog getChangelogForVersion(String version) {
        ensureNotEmpty(version, "No version given.");

        return changelogRepository.getChangelogForVersion(version);
    }
}
