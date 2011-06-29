package katabowling

import scala.collection.mutable.ListBuffer

class BowlingCalculator {

  def calculateScore(rolls: String): Int = {
    // convert the string to a list of Int scores for each roll
    val rollPoints = convertRollsToInts(rolls);
    // calculate the score for each frame
    val frameScores = calculateFrames(rollPoints)
    // sum the score fo the first 10 frames
    frameScores.slice(0, 10).sum
  }

  def convertRollsToInts(rolls: String): List[Int] = {
    rolls.toList.foldLeft(ListBuffer[Int]()) { (res, roll) =>
      roll match {
	// the score for a strike is 10
	case 'X' => res += 10
	// the score for a miss is 0
	case '-' => res += 0
	// the score for a spare is 10 - the previous roll
	case '/' => res += (10 - res.last)
	// the score for a normal roll is the number of pins
	case c   => res += c.toString.toInt
      }
    }.toList
  }

  def calculateFrames(rolls: List[Int]): List[Int] = {
    rolls match {
      case Nil => Nil
      // is this a strike?
      case 10 :: _ =>
	// the frame score is the sum of the roll in this frame
	// and the next 2 rolls
	rolls.slice(0, 3).sum :: calculateFrames(rolls.drop(1))
      // is this a spare?
      case r1 :: r2 :: _ if r1 + r2 == 10 =>
	// the frame score is the sum of the 2 rolls in this frame
	// and the next roll
	rolls.slice(0, 3).sum :: calculateFrames(rolls.drop(2))
      // this is a normal roll!
      case _ =>
	// the frame score is the sum of the 2 rolls in this frame
	rolls.slice(0, 2).sum :: calculateFrames(rolls.drop(2))
    }
  }  
}

object BowlingCalculator extends BowlingCalculator {}
