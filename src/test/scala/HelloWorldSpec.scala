import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.mutable.Stack

class HelloWorldSpec extends Spec with ShouldMatchers {

  describe("HelloWorld") {
    val hello = new HelloWorld()
    it("should say hello") {
      assert(hello.hello() === "Hello World")
    }
  }
}
