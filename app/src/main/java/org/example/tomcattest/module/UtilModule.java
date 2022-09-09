package org.example.tomcattest.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.example.tomcattest.util.JsonUtil;

@Provider
public class UtilModule extends AbstractModule {

    @Provides
    @Singleton
    public JsonUtil providesJsonUtil() {
        return new JsonUtil(new ObjectMapper());
    }

}
