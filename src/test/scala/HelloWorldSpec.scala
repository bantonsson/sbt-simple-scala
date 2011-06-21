import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class HelloWorldSpec extends FlatSpec with ShouldMatchers {

  private val hwString = new HelloWorld().hello

  "HelloWorld.hello" should "return the string 'Hello World'" in {
    hwString should equal ("Hello World")
  }
}
