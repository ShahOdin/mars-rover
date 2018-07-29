package rover

import org.scalatest.{FlatSpec, Matchers}

class GridVectorOpsSpec extends FlatSpec with Matchers {

  val limits = Gridlimits(4,4)
  val position = GridCoordinates(1,1)

  "GridVectorOps" should "behave as normal within the limit region" in {
    position.traverse(limits)(GridCoordinates(1,1)) shouldBe GridCoordinates(2,2)
  }

  it should "behave as expected if the new location is less than minimum x/y" in {
    position.traverse(limits)(GridCoordinates(-5,-5)) shouldBe GridCoordinates(1,1)
  }

  it should "behave as expected if the new location is bigger than maximum x/y" in {
    position.traverse(limits)(GridCoordinates(5,5)) shouldBe GridCoordinates(1,1)
  }

}
