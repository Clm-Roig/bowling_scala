import scala.util.Random
import scala.annotation.tailrec

case class GameState(
    nbFlip: Int,
    nbSuccess: Int
)

object FlipCoin extends App {
    val state = GameState(0, 0)
    val r = new Random
    mainLoop(state, r)

    def flip(): Char = {
        if(r.nextInt(2) == 0) 'H' else 'T'
    }

    def printState(gs: GameState): Unit = {
        println(s"#Flips: ${gs.nbFlip} | #Correct: ${gs.nbSuccess}")
    }

    def printGameOver(gs: GameState): Unit = {
        println("\n==== GAME OVER ====")
        printState(gs)
    }

    def printAskHOrT(): Unit = {
        println("=======")
        println("Heads or Tails? Type H, T or Q to quit.")
    }

    @tailrec
    def mainLoop(state: GameState, r: Any): Unit = {
        var charTyped = 'a'

        printAskHOrT()
        charTyped = scala.io.StdIn.readChar()
        if(charTyped != 'Q') {
            val result = flip()
            val newNumFlips = state.nbFlip + 1
            var success = 0
            if(result == charTyped) success = 1
            val newState = state.copy(nbFlip = newNumFlips, nbSuccess = state.nbSuccess + success)
            println(s"Result: $result")
            printState(newState)
            mainLoop(newState, r)
        } else {
            printGameOver(state)
        }
    }
}
