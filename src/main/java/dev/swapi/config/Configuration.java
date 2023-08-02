package dev.swapi.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configuration.properties"})
public interface Configuration extends Config {

    @Config.Key("api.url")
    String apiUrl();
}
