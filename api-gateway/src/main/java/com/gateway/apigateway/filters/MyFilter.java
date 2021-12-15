package com.gateway.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class MyFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("Pre Processing Logic Goes here >>> " + exchange.getRequest());
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			log.info("Post Processing Logic Goes Here >>> " + exchange.getResponse());
		}));
	}


}