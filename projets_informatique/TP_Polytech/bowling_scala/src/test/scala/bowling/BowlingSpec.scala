package bowling

import org.scalatest.FunSuite
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

class BowlingSpec extends FunSuite with GeneratorDrivenPropertyChecks {

    val allRollsWith0 = List.fill(10)((0,0))
    val allRollsWith1 = List.fill(10)((1,1))
    val simpleSpareRolls = (5,5) :: List.fill(9)((1,1))
    val simpleStrikeRolls = (10,0) :: List.fill(9)((1,1))
    var allStrikeRolls = List.fill(12)((10,0))
    val spareAtTheEndRolls = List((1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (5,5), (3,0))
    val spareAndStrikeAtTheEndRolls = List((1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (5,5), (10,0))
    val strikeAtTheEndRolls = List((1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (1,1), (10,0), (3,3))

    val pinDownValue = Gen.choose(1,9)

    test("roll(): roll something should add the roll to the rolls list.") {
        val game = new Bowling(List((3,5)))
        assert(game.rolls.length == 1)
        assert(game.rolls(0)._1 == 3)
        assert(game.rolls(0)._2 == 5)
    }

    test("score(): All rolls with 0 pin down should give a score of 0.") {
        val game = new Bowling(allRollsWith0)
        assert(game.score() == 0)
    }

    test("score(): All rolls with 1 pin down should give a score of 20.") {
        val game = new Bowling(allRollsWith1)
        assert(game.score() == 20)
    }

    test("score(): All rolls with 1 pin down and 1 spare should give 29.") {
        val game = new Bowling(simpleSpareRolls)
        assert(game.score() == 29)
    }

    test("score(): All rolls with 1 pin down and 1 strike should give 30.") {
        val game = new Bowling(simpleStrikeRolls)
        assert(game.score() == 30)
    }

    test("score(): All rolls with strikes should give 300.") {
        val game = new Bowling(allStrikeRolls)
        assert(game.score() == 300)
    }

    test("score(): All rolls with 1 except spare at the end and 3 should give 31.") {
        val game = new Bowling(spareAtTheEndRolls)
        assert(game.score() == 31)
    }

    test("score(): All rolls with 1 except 1 spare and 1 strike at the end should give 38.") {
        val game = new Bowling(spareAndStrikeAtTheEndRolls)
        assert(game.score() == 38)
    }

    test("score(): All rolls with 1 except 1 strike and 2 3 pin down at the end should give 34.") {
        val game = new Bowling(strikeAtTheEndRolls)
        assert(game.score() == 34)
    }

    test("score(): random values") {
      /*  var randomRolls = List.fill(10)((pinsRoll1,pinsRoll2))
        val game = new Bowling(randomRolls)
        */
    }    
}
