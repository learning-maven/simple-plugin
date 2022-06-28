package io.github.learningmaven;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

import static org.apache.maven.plugins.annotations.LifecyclePhase.COMPILE;

/**
 * This plugin makes sure a Neo4j dependency is included in the dependency tree.
 * How would a project succeed otherwise?
 */
@Mojo(name = "ensure-neo4j", defaultPhase = COMPILE)
public class YNoUseNeo4jMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        @SuppressWarnings("unchecked")
        List<Dependency> dependencies = project.getDependencies();
        if (dependencies.stream()
                .noneMatch(dep -> dep.getArtifactId().contains("neo4j"))) {
            throw new MojoExecutionException("No trace of Neo4j in the dependency tree... Unacceptable!");
        }
    }
}
