/**
 *
 * Created by russell on 11/05/14.
 */
def countChangeRec(money: Int, coins : List[Int],counter : Int):Int = {
  if(money - ) counter + countChangeRec(money-coins.head,coins,counter)
  else if (money - coins.head == 0) countChangeRec(money,coins.tail,counter+1)
  else counter + countChangeRec(money,coins.tail,counter)
}

countChangeRec(4,List(1,2),0)

