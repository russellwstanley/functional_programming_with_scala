/**
 *
 * Created by russell on 11/05/14.
 */
//def countChange(history : Map[Int,Int], money : Int, coins : List[Int]) : Int= {
//
//  if(money==0) {
//    println("returning 1")
//    println(history)
//    1
//  }
//  else if(money <0) {
//    println("money < 0 returning 0")
//    0
//  }
//  else if (coins.isEmpty) {
//
//    println("coins empty returning 0")
//    0
//  }
//  else {
//    //println("recursing")
//    var count = 0
//    for(coin <- coins){
//      println("money: "+money)
//      //println("count: "+count)
//      println("coins: "+coin)
//      if(history.contains(coin)) count = count + countChange(history + (coin->(history(coin)+1)),money-coin,coins)
//      else count = count + countChange(history+(coin->1),money - coin,coins)
//    }
//    count
//  }
//}
//countChange(Map[Int,Int](),3,List(1,2))
def countChange(money: Int, coins: List[Int]): Int = {
  var changeSet = Set[Map[Int,Int]]()
  def countChangeRec(history : Map[Int,Int],remainingCash : Int){
    if(remainingCash == 0) changeSet += history
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
countChange(3,List(1,2))

