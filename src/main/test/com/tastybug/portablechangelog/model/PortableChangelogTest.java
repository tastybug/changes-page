package com.tastybug.portablechangelog.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PortableChangelogTest {

    private ChangelogRepository changelogRepository;
    private PortableChangelog portableChangelog;

    @BeforeEach
    void setUp() {
        changelogRepository = mock(ChangelogRepository.class);
        portableChangelog = new PortableChangelog(changelogRepository);
    }

    @Test
    void getChangelogForVersion_returns_Changes_for_a_given_version_from_repository() {
        Changelog expectedChangelog = mock(Changelog.class);
        String aVersion = "1.5";
        when(changelogRepository.getChangelogForVersion(aVersion)).thenReturn(expectedChangelog);

        Changelog changelog = portableChangelog.getChangelogForVersion(aVersion);

        assertThat(changelog).isEqualTo(expectedChangelog);
    }

    @Test
    void getChangelogForVersion_throws_IllegalArgumentException_if_null_version_info_is_provided() {
        try {
            portableChangelog.getChangelogForVersion(null);
            fail("Expected exception.");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class).withFailMessage("No version given.");
        }
    }

    @Test
    void getChangelogForVersion_throws_IllegalArgumentException_if_empty_version_info_is_provided() {
        try {
            portableChangelog.getChangelogForVersion("");
            fail("Expected exception.");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class).withFailMessage("No version given.");
        }
    }
}