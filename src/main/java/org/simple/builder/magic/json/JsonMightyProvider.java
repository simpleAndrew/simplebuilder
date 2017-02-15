package org.simple.builder.magic.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.simple.builder.magic.AllMightyProviderAsItShouldBe;
import org.simple.builder.model.meta.Army;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

@Component
public class JsonMightyProvider implements AllMightyProviderAsItShouldBe, ResourceLoaderAware {

    private ObjectMapper parser;

    private final String metaLocation = "data";

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    void loadArmiesInMemory() throws IOException {
        //no need to do it. it's easier to organize same catalog in DB (say, Postges with JSON support)
        //just go for direct reading of USSR only lists so far just to implement JSON parsing)
        Enumeration<URL> resources = resourceLoader.getClassLoader().getResources(metaLocation);

    }

    public Army getArmy(String id) {

        Army army = new Army();
        army.setMetaId(id);

        return army;
    }
}
