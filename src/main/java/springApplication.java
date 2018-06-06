import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.spring.intrface.Shape;

public class springApplication {

	public static void main(String[] args) {
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("spring-all.xml");
		context.registerShutdownHook();
		/*Shape shape= context.getBean("triangle",Shape.class);
		shape.draw();*/
		Shape shape= context.getBean("circle",Shape.class);
		shape.draw();
	}
}
