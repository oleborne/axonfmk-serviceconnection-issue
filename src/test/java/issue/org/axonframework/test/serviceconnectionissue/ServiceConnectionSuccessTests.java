package issue.org.axonframework.test.serviceconnectionissue;

import io.axoniq.axonserver.grpc.admin.ContextOverview;
import org.axonframework.axonserver.connector.AxonServerConnectionManager;
import org.axonframework.test.server.AxonServerContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Testcontainers
@SpringBootTest
class ServiceConnectionSuccessTests {
	@Autowired
	private AxonServerConnectionManager axonServerConnectionManager;

	@Container
	@ServiceConnection
	static AxonServerContainer axonServerContainer = new AxonServerContainer("axoniq/axonserver:latest-dev");

	@Test
	void contextLoads() throws ExecutionException, InterruptedException {
		List<ContextOverview> allContexts = axonServerConnectionManager.getConnection().adminChannel().getAllContexts().get();
		assertThat(allContexts, hasSize(greaterThan(0)));
	}

}
