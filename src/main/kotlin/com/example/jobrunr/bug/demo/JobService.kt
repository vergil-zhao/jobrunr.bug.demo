package com.example.jobrunr.bug.demo

import org.jobrunr.configuration.JobRunr
import org.jobrunr.scheduling.JobScheduler
import org.jobrunr.storage.InMemoryStorageProvider
import org.springframework.stereotype.Service

@Service
class JobService(
  val exampleJob: ExampleJob,
) {
  val jobScheduler: JobScheduler = JobRunr
    .configure()
    .useStorageProvider(InMemoryStorageProvider())
    .useBackgroundJobServer()
    .useDashboard()
    .initialize()
    .jobScheduler

  fun enqueueNormalJob(jobPayload: JobPayload) {
    val anotherFunId = jobPayload.anotherFunId
    jobScheduler.enqueue {
      exampleJob.doSomethingFun(jobPayload.funId, anotherFunId)
    }
  }

  fun enqueueBugJob(jobPayload: JobPayload) {
    val funId = jobPayload.funId
    val anotherFunId = jobPayload.anotherFunId
    jobScheduler.enqueue {
      exampleJob.doSomethingFun(funId, anotherFunId)
    }
  }
}
