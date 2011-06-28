package katabowling

import org.specs2.mutable._

class BowlingCalculatorSpecs2 extends Specification {

  "The bowling score" should {

    val calc = BowlingCalculator

    "for the rolls '--------------------' (all misses) be '0'" in {
      calc.calculateScore("--" * 10) mustEqual(0)
    }

    "for the rolls '9-9-9-9-9-9-9-9-9-9-' be '90'" in {
      calc.calculateScore("9-" * 10) mustEqual(90)
    }

    "for the rolls '5/5/5/5/5/5/5/5/5/5/5' be '150'" in {
      calc.calculateScore("5/" * 10 + "5") mustEqual(150)
    }

    "for the rolls 'XXXXXXXXXXXX' (all strikes) be '300'" in {
      calc.calculateScore("X" * 12) mustEqual(300)
    }

    "for the rolls '----------------X1-' be '12'" in {
      calc.calculateScore("--" *  8 + "X1-") mustEqual(12)
    }

    "for the rolls '5/' be '10'" in {
      calc.calculateScore("5/") mustEqual(10)
    }

    "for the rolls '5-' be '5'" in {
      calc.calculateScore("5-") mustEqual(5)
    }

    "for the rolls '-5' be '5'" in {
      calc.calculateScore("-5") mustEqual(5)
    }

    "for the rolls '44' be '8'" in {
      calc.calculateScore("44") mustEqual(8)
    }
 
  }
}
