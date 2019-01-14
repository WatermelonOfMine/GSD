package com.chaoxing.gsd.service;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: longrui
 * @text: 2018/4/19 18:09
 */
public class ESIndexFactory {
	
	// 集群名,默认值elasticsearch
	@Value("${es_cluster_name}")
	
	private static String ES_CLUSTER_NAME;
	
	// ES集群中某个节点
	@Value("${es_hostname}")
	private static String ES_HOSTNAME;
	
	// 连接端口号
	@Value("${es_tcp_port}")
	private static int ES_TCP_PORT;

	// TransportClient对象，用于连接ES集群
	private static volatile TransportClient client;

	// 单例模式，只初始化一次
	@SuppressWarnings("resource")
	public static TransportClient getClientInstance() {
		if (client == null) {
			synchronized (ESIndexFactory.class) {
				if (client == null) {
					try {
						Settings settings = Settings.builder().put("cluster.name", "ES_220").build();
						client = new PreBuiltTransportClient(settings).addTransportAddress(
								new InetSocketTransportAddress(InetAddress.getByName("120.92.71.220"), 9300));
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return client;
	}
}