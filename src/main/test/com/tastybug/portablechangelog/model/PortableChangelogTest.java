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
    void getChangesForVersion_returns_Changes_for_a_given_version_from_repository() {
        Changes expectedChanges = mock(Changes.class);
        String aVersion = "1.5";
        when(changelogRepository.getChangesByVersion(aVersion)).thenReturn(expectedChanges);

        Changes changes = portableChangelog.getChangesForVersion(aVersion);

        assertThat(changes).isEqualTo(expectedChanges);
    }

    @Test
    void getChangesForVersion_throws_IllegalArgumentException_if_null_version_info_is_provided() {
        try {
            portableChangelog.getChangesForVersion(null);
            fail("Expected exception.");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class).withFailMessage("No version given.");
        }
    }

    @Test
    void getChangesForVersion_throws_IllegalArgumentException_if_empty_version_info_is_provided() {
        try {
            portableChangelog.getChangesForVersion("");
            fail("Expected exception.");
        } catch (Exception e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class).withFailMessage("No version given.");
        }
    }
}