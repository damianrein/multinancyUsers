package com.multinancyUsers.config;

public class TenantContext {

	private static ThreadLocal<String> currentTenant = new ThreadLocal<>();
	
	public static void setCurrentTenant(String tenant) {
		currentTenant.set(tenant);
	}
}
