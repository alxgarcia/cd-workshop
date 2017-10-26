package greetings

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{Matchers, WordSpec}

class GreetingServerSpec extends WordSpec with Matchers with ScalatestRouteTest {
  val routes: Route = GreetingRoutes.route

  "The service" should {
    "returns a default greeting" in {
      Get("/greet") ~> routes ~> check {
        responseAs[String] shouldEqual "Hi dude!!"
      }
    }
  }
}
