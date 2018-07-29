package rover

import org.scalatest.{FlatSpec, Matchers}

class DirectionOpsSpec extends FlatSpec with Matchers {

  "DirectionOps" should "handle clockwise rotations properly" in {
    North.rotateClockWise shouldBe East
    East.rotateClockWise shouldBe South
    South.rotateClockWise shouldBe West
    West.rotateClockWise shouldBe North
  }

  it should "handle anti-clockwise rotations properly" in {
    North.rotateAntiClockWise shouldBe West
    East.rotateAntiClockWise shouldBe North
    South.rotateAntiClockWise shouldBe East
    West.rotateAntiClockWise shouldBe South
  }

}
