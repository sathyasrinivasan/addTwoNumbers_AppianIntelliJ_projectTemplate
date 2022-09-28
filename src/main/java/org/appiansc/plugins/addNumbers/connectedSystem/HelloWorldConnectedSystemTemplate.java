package org.appiansc.plugins.addNumbers.connectedSystem;

import com.appian.connectedsystems.simplified.sdk.SimpleConnectedSystemTemplate;
import com.appian.connectedsystems.simplified.sdk.configuration.SimpleConfiguration;
import com.appian.connectedsystems.templateframework.sdk.ExecutionContext;
import com.appian.connectedsystems.templateframework.sdk.TemplateId;
@TemplateId(name="HelloWorldConnectedSystemTemplate")
public class HelloWorldConnectedSystemTemplate extends SimpleConnectedSystemTemplate {

   public static final String CS_PROP_KEY = "csProp";

    @Override
    protected SimpleConfiguration getConfiguration( SimpleConfiguration simpleConfiguration, ExecutionContext executionContext){
        return simpleConfiguration.setProperties(
                textProperty(CS_PROP_KEY)
                        .label("Text Property label")
                        .description("This will be concatinated with the integration text property on execution")
                        .build()
        );
    }
}
