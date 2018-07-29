package util

import org.scalatest.{FlatSpec, Matchers}

class SeqOpsSepc extends FlatSpec with Matchers {

  val seq1D = List(1,2,4,78)
  val seq2D = Seq(Seq(1,2,3),Seq(20,60),Seq(100))
  val emptySeq = Seq.empty

  "getElement" should "return same result as the ordinary get function for a valid index" in {
    seq1D.getElementAt(3) shouldBe Some(78)
  }

  it should "return same result as the ordinary get function for zero index" in {
    seq1D.getElementAt(0) shouldBe Some(1)
  }

  it should "return the correct result for negative index" in {
    seq1D.getElementAt(-1) shouldBe Some(78)
  }

  it should "return None for an empty sequence" in {
    emptySeq.getElementAt(3) shouldBe None
  }

  "2D-getElement" should "return None for an empty sequence" in {
    emptySeq.get2DElementAt(3)(6) shouldBe None
  }

  it should "return same result as the ordinary get function for a valid index" in {
    seq2D.get2DElementAt(0)(0) shouldBe Some(1)
  }

  it should "return the corret value for indices over the max amount" in {
    seq2D.get2DElementAt(4)(4) shouldBe Some(20)
  }

  it should "return the corret value for indices lower than the min amount" in {
    seq2D.get2DElementAt(-4)(-4) shouldBe Some(100)
  }

}
