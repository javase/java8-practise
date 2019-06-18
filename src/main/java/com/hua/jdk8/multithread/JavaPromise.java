package com.hua.jdk8.multithread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class JavaPromise {
	public static void main(String[] args) throws Throwable, ExecutionException {

		ExecutorService executor = new ThreadPoolExecutor(5, 200,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(1024));

		System.out.println("执行前，我先打印一下");

		//jdk1.8之前的实现方式
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				System.out.println("task started!");
				try {
					int delay = 3;
					//模拟耗时操作
					for (int i = 0; i < delay; i++) {
						System.out.println(i + 1);
						Thread.sleep(1 * 1000);
					}
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				return "task finished!";
			}
		}, executor);


		System.out.println("main thread is running");
		System.out.println(future.get());

		//采用lambada的实现方式
		future.thenAccept(e -> System.out.println("lambada " + e + " ok"));
	}
}