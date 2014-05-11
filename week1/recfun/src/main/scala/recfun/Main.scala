package recfun

import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * 0        1   0
   * 1      1 1 1   2
   * 2     1 2 2 1   3
   * 3    1 3 4 3 1
   * 4   1 4 7 7 4 1
   */


  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    require(c >= 0 && r >= 0)
    if (r == 0) require(c == 0)
    require(c <= r + 1)
    if (c == 0 || r <= 1 || c == r + 1) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def checkParens(chars: List[Char], count: Int): Boolean = {
      def newCount = chars.head match {
        case '(' => count + 1
        case ')' => count - 1
        case _ => count
      }
      if (count < 0) false
      else if (chars.isEmpty) count == 0
      else checkParens(chars.tail, newCount)
    }
    checkParens(chars, 0)
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    var changeSet = Set[Map[Int,Int]]()
    def countChangeRec(history : Map[Int,Int],remainingCash : Int){
      if(remainingCash == 0) {
        changeSet += history
      }
      else if (remainingCash > 0) {
        for(coin <- coins){
          if(!history.contains(coin)) countChangeRec(history + (coin -> 1), remainingCash - coin)
          else countChangeRec(history + (coin->(history(coin)+1)), remainingCash - coin)
        }
      }
    }
    countChangeRec(Map[Int,Int](),money)
    changeSet.size
  }
}
