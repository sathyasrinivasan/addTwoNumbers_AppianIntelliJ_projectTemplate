package org.appiansc.plugins.addNumbers.expressions;

import com.appiancorp.ps.plugins.typetransformer.AppianObject;
import com.appiancorp.ps.plugins.typetransformer.AppianTypeFactory;
import org.appiansc.plugins.addNumbers.SathyaPluginCategory;
import com.appiancorp.suiteapi.content.ContentService;
import com.appiancorp.suiteapi.expression.annotations.Function;
import com.appiancorp.suiteapi.expression.annotations.Parameter;
import com.appiancorp.suiteapi.type.AppianType;
import com.appiancorp.suiteapi.type.TypeService;
import org.apache.log4j.Logger;


@SathyaPluginCategory
public class AddTwoNumbersExpressionFunction {
    private static final Logger LOG = Logger.getLogger(AddTwoNumbersExpressionFunction.class);

    @Function
    public Integer addTwoNumbersExpressionFunction(
            TypeService typeService,           // injected dependency
            ContentService contentService,     // injected dependency
            @Parameter Integer num1,
            @Parameter Integer  num2
    ) {
        LOG.debug("exampleExpressionFunction was called; create a dictionary and return it");

//        if (optionalListOfStrings != null)
//            LOG.info("optionalListOfStrings was " + optionalListOfStrings.length + " items");

        AppianTypeFactory typeFactory = AppianTypeFactory.newInstance(typeService);
        AppianObject dictionary = (AppianObject) typeFactory.createElement(AppianType.DICTIONARY);

//        dictionary.put("someDateTime", typeFactory.createDateTime(someDateTime));
//        dictionary.put("someDocumentId", typeFactory.createLong(someDocument));

        return num1+num2;
    }
}