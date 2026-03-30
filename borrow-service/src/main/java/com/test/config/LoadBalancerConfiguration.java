package com.test.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

// 随机负载均衡策略配置
public class LoadBalancerConfiguration {

	@Bean
	public ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(
			Environment environment,
			LoadBalancerClientFactory loadBalancerClientFactory) {
		String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
		// 修正：正确获取 ObjectProvider
		ObjectProvider<ServiceInstanceListSupplier> provider =
				loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class);
		return new RandomLoadBalancer(provider, name);
	}
}