package greetings

import java.util.concurrent.TimeUnit

import akka.http.scaladsl.server.{HttpApp, Route}

object GreetingServer extends HttpApp with GreetingService {
  val startTime: Long = System.currentTimeMillis()
  def uptime(): Long = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)
  override protected def routes: Route =
    get {
      pathSingleSlash{
       complete {
         s"System up and running for ${uptime()} seconds"
       }
      } ~
      path("greet") {
        complete {
          greet
        }
      }
    }
}

trait GreetingService {
  val greet: String = ???
}
