package com.example.jobrunr.bug.demo

import org.jobrunr.storage.InMemoryStorageProvider
import org.jobrunr.storage.StorageProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {
  @Bean
  fun defaultStorageProvider(): StorageProvider = InMemoryStorageProvider()
}
