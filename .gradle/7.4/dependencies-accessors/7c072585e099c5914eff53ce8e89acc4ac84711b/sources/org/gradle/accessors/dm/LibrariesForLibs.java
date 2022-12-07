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
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(providers, config);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers) {
        super(config, providers);
    }

        /**
         * Creates a dependency provider for httpclient (io.micronaut:micronaut-http-client)
         */
        public Provider<MinimalExternalModuleDependency> getHttpclient() { return create("httpclient"); }

        /**
         * Creates a dependency provider for httpvalidation (io.micronaut:micronaut-http-validation)
         */
        public Provider<MinimalExternalModuleDependency> getHttpvalidation() { return create("httpvalidation"); }

        /**
         * Creates a dependency provider for jackson (io.micronaut:micronaut-jackson-databind)
         */
        public Provider<MinimalExternalModuleDependency> getJackson() { return create("jackson"); }

        /**
         * Creates a dependency provider for jakarta (jakarta.annotation:jakarta.annotation-api)
         */
        public Provider<MinimalExternalModuleDependency> getJakarta() { return create("jakarta"); }

        /**
         * Creates a dependency provider for jupiterjunit (org.junit.jupiter:junit-jupiter-params)
         */
        public Provider<MinimalExternalModuleDependency> getJupiterjunit() { return create("jupiterjunit"); }

        /**
         * Creates a dependency provider for logback (ch.qos.logback:logback-classic)
         */
        public Provider<MinimalExternalModuleDependency> getLogback() { return create("logback"); }

        /**
         * Creates a dependency provider for mockserver (org.mock-server:mockserver-junit-jupiter-no-dependencies)
         */
        public Provider<MinimalExternalModuleDependency> getMockserver() { return create("mockserver"); }

        /**
         * Creates a dependency provider for problemjson (io.micronaut.problem:micronaut-problem-json)
         */
        public Provider<MinimalExternalModuleDependency> getProblemjson() { return create("problemjson"); }

        /**
         * Creates a dependency provider for reactor (io.projectreactor:reactor-core)
         */
        public Provider<MinimalExternalModuleDependency> getReactor() { return create("reactor"); }

        /**
         * Creates a dependency provider for restassured (io.micronaut.test:micronaut-test-rest-assured)
         */
        public Provider<MinimalExternalModuleDependency> getRestassured() { return create("restassured"); }

        /**
         * Creates a dependency provider for serialization (io.micronaut.serde:micronaut-serde-processor)
         */
        public Provider<MinimalExternalModuleDependency> getSerialization() { return create("serialization"); }

        /**
         * Creates a dependency provider for validation (io.micronaut:micronaut-validation)
         */
        public Provider<MinimalExternalModuleDependency> getValidation() { return create("validation"); }

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

    public static class VersionAccessors extends VersionFactory  {

        private final MicronautVersionAccessors vaccForMicronautVersionAccessors = new MicronautVersionAccessors(providers, config);
        private final MironautVersionAccessors vaccForMironautVersionAccessors = new MironautVersionAccessors(providers, config);
        private final MockVersionAccessors vaccForMockVersionAccessors = new MockVersionAccessors(providers, config);
        private final RestVersionAccessors vaccForRestVersionAccessors = new RestVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: checkstyle (8.37)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getCheckstyle() { return getVersion("checkstyle"); }

            /**
             * Returns the version associated to this alias: groovy (3.0.5)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getGroovy() { return getVersion("groovy"); }

            /**
             * Returns the version associated to this alias: jakarta (2.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getJakarta() { return getVersion("jakarta"); }

            /**
             * Returns the version associated to this alias: jupiter (5.9.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getJupiter() { return getVersion("jupiter"); }

            /**
             * Returns the version associated to this alias: logback (1.1.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getLogback() { return getVersion("logback"); }

            /**
             * Returns the version associated to this alias: reactor (3.5.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getReactor() { return getVersion("reactor"); }

        /**
         * Returns the group of versions at versions.micronaut
         */
        public MicronautVersionAccessors getMicronaut() { return vaccForMicronautVersionAccessors; }

        /**
         * Returns the group of versions at versions.mironaut
         */
        public MironautVersionAccessors getMironaut() { return vaccForMironautVersionAccessors; }

        /**
         * Returns the group of versions at versions.mock
         */
        public MockVersionAccessors getMock() { return vaccForMockVersionAccessors; }

        /**
         * Returns the group of versions at versions.rest
         */
        public RestVersionAccessors getRest() { return vaccForRestVersionAccessors; }

    }

    public static class MicronautVersionAccessors extends VersionFactory  {

        public MicronautVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: micronaut.core (3.7.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getCore() { return getVersion("micronaut.core"); }

            /**
             * Returns the version associated to this alias: micronaut.problem (2.5.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getProblem() { return getVersion("micronaut.problem"); }

    }

    public static class MironautVersionAccessors extends VersionFactory  {

        public MironautVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: mironaut.serialize (1.3.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getSerialize() { return getVersion("mironaut.serialize"); }

    }

    public static class MockVersionAccessors extends VersionFactory  {

        public MockVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: mock.server (5.14.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getServer() { return getVersion("mock.server"); }

    }

    public static class RestVersionAccessors extends VersionFactory  {

        public RestVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: rest.assured (3.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             */
            public Provider<String> getAssured() { return getVersion("rest.assured"); }

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
