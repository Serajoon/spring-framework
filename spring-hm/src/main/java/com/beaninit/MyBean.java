package com.beaninit;

import lombok.Data;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

@Data
public class MyBean implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
    }
}
