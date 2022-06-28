package io.github.learningmaven.it;


import com.soebes.itf.jupiter.extension.MavenGoal;
import com.soebes.itf.jupiter.extension.MavenJupiterExtension;
import com.soebes.itf.jupiter.extension.MavenTest;
import com.soebes.itf.jupiter.maven.MavenExecutionResult;

import static com.soebes.itf.extension.assertj.MavenITAssertions.assertThat;

@MavenJupiterExtension
@MavenGoal("${project.groupId}:${project.artifactId}:${project.version}:ensure-neo4j")
public class PluginIT {

    @MavenTest
    void a_project_without_neo4j(MavenExecutionResult result) {
        assertThat(result).isFailure()
                .out().error().anyMatch(line -> line.contains("No trace of Neo4j in the dependency tree... Unacceptable!"));
    }

    @MavenTest
    void a_project_with_neo4j(MavenExecutionResult result) {
        assertThat(result).isSuccessful();
    }
}
