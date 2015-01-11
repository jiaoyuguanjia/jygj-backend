package com.system.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

	private static ScheduledThreadPool instance = null;
	private static ScheduledExecutorService pool;
	
	private ScheduledThreadPool(){}

	public static synchronized ScheduledThreadPool getInstance() {
		if (instance == null) {
			instance = new ScheduledThreadPool();
		}
		return instance;
	}

	public synchronized void addToPool(Runnable run, int delaySeconds) {
		if (pool == null || pool.isShutdown()) {
			pool = Executors.newScheduledThreadPool(1);
		}
		pool.scheduleWithFixedDelay(run, 0, delaySeconds, TimeUnit.SECONDS);
	}
}