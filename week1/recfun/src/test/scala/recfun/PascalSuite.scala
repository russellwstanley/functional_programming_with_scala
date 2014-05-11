package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal

  test("pacal: col=0,row=0"){
    assert(pascal(0,0) == 1)
  }

  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }

  test("pascal: col=2,row=4") {
    assert(pascal(2,4) === 7)
  }

  test("pascal: col=5,row=4") {
    assert(pascal(5,4) === 1)
  }

  test("check illegal argument exception...c < 0"){
    intercept[IllegalArgumentException]{
      pascal(-1,3)
    }
  }

  test("check illegal argument exception...r too high"){
    intercept[IllegalArgumentException]{
      pascal(3,1)
    }
  }

  test("check illegal argument exception...r 0 c 1"){
    intercept[IllegalArgumentException]{
      pascal(1,0)
    }
  }

  test("check illegal argument exception...r<0"){
    intercept[IllegalArgumentException]{
      pascal(0,-1)
    }
  }
}
