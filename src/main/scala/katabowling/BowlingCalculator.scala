package katabowling

class BowlingCalculator {

  def calculateScore(rolls: String): Int = {
    innerScore(rolls.toList)
  }

  def innerScore(rolls: List[Char], pos: Int = 1, score: Int = 0): Int = {
    if (pos > 10) {
      return score
    }

    rolls match {
      case Nil => score
      case List('X', 'X')       => { score + 20 }
      case List('X', _*)        => { score + 10 + innerScore(rolls.slice(1, 3)) + innerScore(rolls.drop(1), pos + 1) }
      case List(n) if n.isDigit => { score + digitValueOf(n) }
      case List('-', '-', _*)   => { innerScore(rolls.drop(2), pos + 1, score) }
      case List(n, '/', _*) if n.isDigit => { innerScore(rolls.drop(2), pos + 1, score + 10 + innerScore(rolls.slice(2, 3))) }
      case List(n, '-', _*) if n.isDigit => { innerScore(rolls.drop(2), pos + 1, score + digitValueOf(n)) }
      case List('-', n, _*) if n.isDigit => { innerScore(rolls.drop(2), pos + 1, score + digitValueOf(n)) }
      case List(n1, n2, _*) if n1.isDigit && n2.isDigit => { innerScore(rolls.drop(2), pos + 1, score + digitValueOf(n1) + digitValueOf(n2)) }
      case _ => { debugPrint(rolls, pos, score); innerScore(rolls.tail, pos, score) }
    }
  }

  def debugPrint(rolls: List[Char], pos: Int, score: Int) = {
    println("Non matching '" +  rolls + "' @ " +  pos + " with score " + score)
  }

  def digitValueOf(c: Char): Int = {
    c - '0'
  }
}

object BowlingCalculator extends BowlingCalculator {}
