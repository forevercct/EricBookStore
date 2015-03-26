package uitox.eric.bookstore.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class BookstoreWebApplicationInitializer implements
		WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext
				.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
				"dispacther", new DispatcherServlet(appContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
		System.out.println("Reading WebApplicationInitializer");
	}
}
