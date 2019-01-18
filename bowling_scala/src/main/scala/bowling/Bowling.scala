package bowling

case class Bowling(rolls: List[(Int,Int)] = Nil) {
    // CONST
    val NUMBER_OF_PINS = 10
    // =================
  
    def roll(pins:(Int, Int)): Bowling = {
        Bowling(this.rolls :+ (pins))
    }

    def multipleRolls(pins: List[(Int,Int)]): Bowling = {
        def multipleRollsRec(pins: List[(Int,Int)], bowling: Bowling): Bowling = {
            if(pins.length == 0) bowling
            else {
                val newBowling = roll(pins.head)
                multipleRollsRec(pins.tail, newBowling)
            }
        }

        multipleRollsRec(pins, this)
    }

    def computeScore(rolls: List[(Int,Int)],frameNb: Int): Int = {
        if(rolls == Nil) { 
            0
        }
        else {
            val remainingRolls = rolls.tail
            val roll1 = rolls.head._1
            var roll2 = rolls.head._2
            var frameScore = 0
            // Strike
            if(roll1 == 10) {
                if(! remainingRolls.isEmpty && frameNb != 10) {
                    frameScore = 10 + remainingRolls.head._1

                    if(remainingRolls.head._2 == 0) {
                        if(! remainingRolls.tail.isEmpty)
                            frameScore += remainingRolls.tail.head._1
                    }
                    
                    else frameScore += remainingRolls.head._2
                }
                else frameScore = 10

            // Spare
            } else if (roll1 + roll2 == 10) {
                if(! remainingRolls.isEmpty && frameNb != 10)
                    frameScore = 10 + remainingRolls.head._1
                else 
                    frameScore = 10

            // Default
            } else {
                frameScore = roll1 + roll2
            }

            frameScore + computeScore(remainingRolls, if(frameNb+1 <= 10) frameNb +1 else 10)
        }
    }

    def score(): Int = {
        this.computeScore(this.rolls, 1)
    }

}
