package greetings

import java.util.concurrent.TimeUnit

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{HttpApp, Route}

object GreetingServer extends HttpApp {
  override def routes: Route = GreetingRoutes.route
}

object GreetingRoutes extends GreetingService {
  val route: Route =
    get {
      pathSingleSlash {
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
  val startTime: Long = System.currentTimeMillis()
  val greet: String = "Hi dude!!"

  def uptime(): Long = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)
}
