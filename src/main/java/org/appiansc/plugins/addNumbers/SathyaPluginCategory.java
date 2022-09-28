package org.appiansc.plugins.addNumbers;

import com.appiancorp.suiteapi.expression.annotations.Category;

import java.lang.annotation.*;

@Category("sathyaPluginCategory")
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface SathyaPluginCategory {

}
