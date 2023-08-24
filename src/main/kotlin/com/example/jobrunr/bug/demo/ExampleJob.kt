package com.example.jobrunr.bug.demo

import org.jobrunr.jobs.annotations.Job
import org.springframework.stereotype.Component

@Component
class ExampleJob {
  /*
   * Per https://www.jobrunr.io/en/documentation/background-methods/passing-arguments/
   * The arguments of the background job should be simple as they would be serialized into json
   * and got deserialized to original objects. Primitive types and primary keys are recommended.
   * */
  @Job(name = "Do something fun", retries = 3)
  fun doSomethingFun(funId: Long, anotherFunId: Long) {
    print("having fun with $funId, $anotherFunId")
  }
}
