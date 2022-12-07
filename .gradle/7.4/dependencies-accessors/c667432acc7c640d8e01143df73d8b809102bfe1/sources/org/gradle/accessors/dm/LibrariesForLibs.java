package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final CommonsLibraryAccessors laccForCommonsLibraryAccessors = new CommonsLibraryAccessors(owner);
    private final GroovyLibraryAccessors laccForGroovyLibraryAccessors = new GroovyLibraryAccessors(owner);
    private final HttpLibraryAccessors laccForHttpLibraryAccessors = new HttpLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

    /**
     * Returns the group of libraries at commons
     */
    public CommonsLibraryAccessors getCommons() { return laccForCommonsLibraryAccessors; }

    /**
     * Returns the group of libraries at groovy
     */
    public GroovyLibraryAccessors getGroovy() { return laccForGroovyLibraryAccessors; }

    /**
     * Returns the group of libraries at http
     */
    public HttpLibraryAccessors getHttp() { return laccForHttpLibraryAccessors; }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class CommonsLibraryAccessors extends SubDependencyFactory {

        public CommonsLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for lang3 (org.apache.commons:commons-lang3)
             */
            public Provider<MinimalExternalModuleDependency> getLang3() { return create("commons.lang3"); }

    }

    public static class GroovyLibraryAccessors extends SubDependencyFactory {

        public GroovyLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for core (org.codehaus.groovy:groovy)
             */
            public Provider<MinimalExternalModuleDependency> getCore() { return create("groovy.core"); }

            /**
             * Creates a dependency provider for json (org.codehaus.groovy:groovy-json)
             */
            public Provider<MinimalExternalModuleDependency> getJson() { return create("groovy.json"); }

            /**
             * Creates a dependency provider for nio (org.codehaus.groovy:groovy-nio)
             */
            public Provider<MinimalExternalModuleDependency> getNio() { return create("groovy.nio"); }

    }

    public static class HttpLibraryAccessors extends SubDependencyFactory {

        public HttpLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for validation (io.micronaut:micronaut-http-validation)
             */
            public Provider<MinimalExternalModuleDependency> getValidation() { return create("http.validation"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Creates a plugin provider for micronaut to the plugin id 'io.micronaut.application'
             * This plugin was declared in settings file 'settings.gradle'
             */
            public Provider<PluginDependency> getMicronaut() { return createPlugin("micronaut"); }

            /**
             * Creates a plugin provider for openapi to the plugin id 'org.openapi.generator'
             * This plugin was declared in settings file 'settings.gradle'
             */
            public Provider<PluginDependency> getOpenapi() { return createPlugin("openapi"); }

            /**
             * Creates a plugin provider for shadow to the plugin id 'com.github.johnrengelman.shadow'
             * This plugin was declared in settings file 'settings.gradle'
             */
            public Provider<PluginDependency> getShadow() { return createPlugin("shadow"); }

            /**
             * Creates a plugin provider for spotless to the plugin id 'com.diffplug.spotless'
             * This plugin was declared in settings file 'settings.gradle'
             */
            public Provider<PluginDependency> getSpotless() { return createPlugin("spotless"); }

    }

}
