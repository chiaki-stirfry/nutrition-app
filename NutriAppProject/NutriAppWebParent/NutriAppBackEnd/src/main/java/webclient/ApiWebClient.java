package webclient;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.core.publisher.Mono;
import reactor.netty.tcp.TcpClient;

@Component
public class ApiWebClient {

//	 private static final Logger logger = LoggerFactory.getLogger(ApiWebClient.class);
//
//	    public ClientResponse createClient(ClientRequest request) {
//
//	        // tcp client timeout
//	        TcpClient tcpClient = TcpClient.create()
//	                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
//	                .doOnConnected(connection ->
//	                        connection.addHandlerLast(new ReadTimeoutHandler(3))
//	                                .addHandlerLast(new WriteTimeoutHandler(3)));
//
//	        WebClient webClient = WebClient.builder()
//	                .baseUrl("http://localhost:8899")
//	                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//	                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//	                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))  // timeout
//	                .build();
//
//	        ClientResponse response = webClient.post()
//	                .uri("/accounts")
//	                .body(Mono.just(request), ClientRequest.class)
//	                .retrieve()
//
//	                // handle status
//	                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
//	                    logger.error("Error endpoint with status code {}", clientResponse.statusCode());
//	                    throw new ApiWebClientException("HTTP Status 500 error");  // throw custom exception
//	                })
//
//	                .bodyToMono(ClientResponse.class)
//	                .block();
//
//	        return response;
//	    }
//
//	    public ClientResponse createClientWithDuration(ClientRequest request) {
//
//	        WebClient webClient = WebClient.builder()
//	                .baseUrl("http://localhost:8899")
//	                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//	                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//	                .build();
//
//	        ClientResponse response = webClient.post()
//	                .uri("/accounts")
//	                .body(Mono.just(request), ClientRequest.class)
//	                .retrieve()
//
//	                // handle status
//	                .onStatus(HttpStatus::is5xxServerError, clientResponse -> {
//	                    logger.error("Error endpoint with status code {}", clientResponse.statusCode());
//	                    throw new ApiWebClientException("HTTP Status 500 error");  // throw custom exception
//	                })
//
//	                .bodyToMono(ClientResponse.class)
//	                .timeout(Duration.ofSeconds(3))  // timeout
//	                .block();
//
//	        return response;
//	    }

	}