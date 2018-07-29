package rover

import org.scalatest.{FlatSpec, Matchers}
import AutoPilot._

class AutoPilotSpec extends FlatSpec with Matchers {

  val position = GridCoordinates(0,0)
  val gridlimits = Gridlimits(6,6)

  def setUpObstacleMap = ObstacleMap(gridlimits)

  def setUpRover(pos: GridCoordinates = position) = Rover(pos, North, gridlimits)
  val roverAtOrigin = setUpRover()

  "findShortestPath" should "find the direct path between two points where the shortest path doesn't touch the boundaies." ignore  {
    val destination = GridCoordinates(0,1)
    findShortestPath(setUpRover())(destination) shouldBe List(MoveForward)
  }

  it should "find the direct path between two points at the other horizontal ends ." in {
    val destination = GridCoordinates(6,0)
    findShortestPath(roverAtOrigin)(destination) shouldBe List(RotateAntiClockWise, MoveForward)
  }

  it should "find the direct path between two points at the other vertical ends." in {
    val destination = GridCoordinates(0,6)
    findShortestPath(roverAtOrigin)(destination).length shouldBe 3
  }

  it should "find the direct path between two generic points where the shortest path does touch the boundaries." in {
    val destination = GridCoordinates(6,2)
    findShortestPath(setUpRover(GridCoordinates(0,1)))(destination).length shouldBe 5
  }

  "findShortestUninterruptedPath" should "find the shortest path with no obstacles in the cases above" in {
    ??? //duplicate above
  }

  it should "find the shortest path with one obstacle" in {

    val obstacles = setUpObstacleMap
    obstacles.markAsObstacle(???)
    val destination = ???
    findShortestUninterruptedPath(roverAtOrigin)(obstacles)(destination).map(_.length) shouldBe Some(???)

  }

  it should "find the shortest path with a few obstacle" in {

    val obstacleMap = setUpObstacleMap

    val obstacles: List[GridCoordinates] = ???
    obstacles.foreach(obstacleMap.markAsObstacle)

    val destination = ???
    findShortestUninterruptedPath(roverAtOrigin)(obstacleMap)(destination).map(_.length) shouldBe Some(???)
  }

  it should "gracefully give up if the destination is " +
    "completely blocked off by obstacles" in {

    val obstacleMap = setUpObstacleMap

    val obstacles: List[GridCoordinates] = ???
    obstacles.foreach(obstacleMap.markAsObstacle)

    val destination = ???
    findShortestUninterruptedPath(roverAtOrigin)(obstacleMap)(destination).map(_.length) shouldBe None

  }

}
