package org.klea.test.project.web.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class RestApp extends ResourceConfig {

    public RestApp() {
        packages("org.klea.test.project.web.rest");
    }
}
