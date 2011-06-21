import org.specs2.mutable._

class HelloWorldSpecs2 extends Specification {

  private val hwString = new HelloWorld().hello

  "The 'Hello World' string" should {
    "contain 11 characters" in {
      hwString must have size(11)
    }
    "start with 'Hello'" in {
      hwString must startWith("Hello")
    }
    "end with 'World'" in {
      hwString must endWith("World")
    }
  }
}

