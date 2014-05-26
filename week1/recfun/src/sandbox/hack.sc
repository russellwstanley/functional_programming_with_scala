def increasingSubsequences(in : List[Int]): List[List[Int]] = in match {
  case Nil => List[List[Int]]()
  case head :: Nil =>  increasingSubsequences(in.tail) :+ List(head)
  case head :: tail => {
    val inc = increasingSubsequences(tail)
    if(head < inc.last.last) inc.updated(inc.length -1,inc.last :+ head)
    else inc :+ List(head)
  }
}

def longestIncreasingSubsequence2(in : List[Int]):List[Int]={
  val (working,longest) = in.foldLeft((List(),List()))((data,x) => data match {
    case (working,longest) => {
      if(working.isEmpty) (working::x, longest)
      if()
    }

  })
  longest
}



def longestIncreasingSubsequence(in : List[Int]):List[Int]={
  in.foldLeft(List[List[Int]]())((incSequences,x) => {
    if(incSequences.isEmpty || x <= incSequences.head.last) List(x) :: incSequences
    else (incSequences.head :+ x) :: incSequences.tail
  }).maxBy(incSequence => incSequence.length)
}
val in = List(-1,2,3,0,1,2,3,4,5,2)
longestIncreasingSubsequence(in)


def threeElementSubsetsSumTo0(in : List[Int]) : Boolean = {
  def threeElementSubsets(subSet : List[Int],in : List[Int]) : Boolean = {
    println(subSet)
    if (in.isEmpty) subSet.length == 3 && subSet.sum == 0
    else if (subSet.length == 3 && subSet.sum == 0) true
    else if (subSet.length == 3) threeElementSubsets(List(),in)
    else threeElementSubsets(in.head :: subSet,in.tail)
  }
  threeElementSubsets(List(),in)
  }
//def threeElementSubsetsSumTo0(in : List[Int]) : Boolean = {
// for(i <- 0 to in.length - 3){
//   for(j <- i+1 to in.length -2) {
//     for(k <- j+1 to in.length -1) {
//       if(in(i)+in(j)+in(k) == 0) return true
//     }
//   }
// }
//  false
//}
val set = List(1,3,5,-2,0,-1)
threeElementSubsetsSumTo0(set)






}