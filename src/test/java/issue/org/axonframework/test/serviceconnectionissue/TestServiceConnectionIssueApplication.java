package issue.org.axonframework.test.serviceconnectionissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestServiceConnectionIssueApplication {

	public static void main(String[] args) {
		SpringApplication.from(ServiceConnectionIssueApplication::main).with(TestServiceConnectionIssueApplication.class).run(args);
	}

}
