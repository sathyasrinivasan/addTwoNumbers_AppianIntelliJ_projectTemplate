package org.appiansc.plugins.addNumbers.connectedSystem;

import com.appian.connectedsystems.simplified.sdk.SimpleIntegrationTemplate;
import com.appian.connectedsystems.simplified.sdk.configuration.SimpleConfiguration;
import com.appian.connectedsystems.templateframework.sdk.ExecutionContext;
import com.appian.connectedsystems.templateframework.sdk.IntegrationResponse;
import com.appian.connectedsystems.templateframework.sdk.TemplateId;
import com.appian.connectedsystems.templateframework.sdk.configuration.PropertyPath;
import com.appian.connectedsystems.templateframework.sdk.diagnostics.IntegrationDesignerDiagnostic;
import com.appian.connectedsystems.templateframework.sdk.metadata.IntegrationTemplateRequestPolicy;
import com.appian.connectedsystems.templateframework.sdk.metadata.IntegrationTemplateType;

import java.util.HashMap;
import java.util.Map;

import static org.appiansc.plugins.addNumbers.connectedSystem.HelloWorldConnectedSystemTemplate.CS_PROP_KEY;
@TemplateId(name="HelloWorldIntegrationTemplate")
@IntegrationTemplateType(IntegrationTemplateRequestPolicy.READ)
public class HelloWorldIntegrationTemplate  extends SimpleIntegrationTemplate {

    public static final String INTEGRATION_PROP_KEY="intProp";

    @Override
    protected SimpleConfiguration getConfiguration(
            SimpleConfiguration integrationConfiguration,
            SimpleConfiguration connectedSystemConfiguration,
            PropertyPath updatedProperty,
            ExecutionContext executionContext) {

        return integrationConfiguration.setProperties(
                textProperty(INTEGRATION_PROP_KEY).label("Text Property Intg")
                        .isRequired(true)
                        .description("This will be concatinated with the connected system text property on exec -INTG")
                        .build()
        );

    }

    @Override
    protected IntegrationResponse execute(
            SimpleConfiguration integrationConfiguration,
            SimpleConfiguration connectedSystemConfiguration,
            ExecutionContext executionContext) {

        Map<String, Object> requestDiagonstic = new HashMap<>();
        String csValue = connectedSystemConfiguration.getValue(CS_PROP_KEY);
        requestDiagonstic.put("csValue", csValue);

        String integrationValue = integrationConfiguration.getValue(INTEGRATION_PROP_KEY);
        requestDiagonstic.put("integrationValue", integrationValue);

        Map<String, Object> result = new HashMap<>();

        final long start = System.currentTimeMillis();
        result.put("Hello", "World");
        result.put("concat", csValue + integrationValue);
        final long end = System.currentTimeMillis();

        final long executionTime = end - start;
        final IntegrationDesignerDiagnostic diagnostic = IntegrationDesignerDiagnostic.builder()
                                                                .addExecutionTimeDiagnostic(executionTime)
                                                                .addRequestDiagnostic(requestDiagonstic)
                                                                .build();

        return IntegrationResponse.forSuccess(result).withDiagnostic(diagnostic).build();

    }
}
