package qyu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Description(desc="fuck you", author="qyu")
@Retention(RetentionPolicy.RUNTIME)
public @interface Fuck {
	String value();
}
