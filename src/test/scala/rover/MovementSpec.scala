package rover

import org.scalatest.{FlatSpec, Matchers}
import rover.Movement._

class MovementSpec extends FlatSpec with Matchers {

  val position = GridCoordinates(1,2)
  val gridlimits = Gridlimits(5,5)

  def setUpRover(dir:Direction, pos: GridCoordinates = position) = Rover(pos, dir, gridlimits)

  "MovementOps" should "be able to move forward when rover is facing north within the limits" in {
    val rover = setUpRover(North)
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(1,3))
  }

  it should "appear on the other end when moving Northwards toward the grid's Y limit" in {
    val rover = setUpRover(North, GridCoordinates(3,5))
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(3,0))
  }

  it should "be able to move forward when rover is facing East within the limits" in {
    val rover = setUpRover(East)
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(2,2))
  }

  it should "appear on the other end when moving Eastwards toward the grid's Y limit" in {
    val rover = setUpRover(East, GridCoordinates(5,3))
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(0,3))
  }

  it should "be able to move forward when rover is facing South within the limits" in {
    val rover = setUpRover(South)
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(1,1))
  }

  it should "appear on the other end when moving Southwards toward the grid's negative Y region" in {
    val rover = setUpRover(South, GridCoordinates(5,0))
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(5,5))
  }

  it should "be able to move forward when rover is facing West within the limits" in {
    val rover = setUpRover(West)
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(0,2))
  }

  it should "appear on the other end when moving Westwards toward the grid's negative X region" in {
    val rover = setUpRover(West, GridCoordinates(0,3))
    rover.move(MoveForward) shouldBe rover.copy(position = GridCoordinates(5,3))
  }
  
  it should "rotate clockwise for all directions" in {
    setUpRover(North).move(RotateClockWise) shouldBe setUpRover(East)
    setUpRover(East).move(RotateClockWise) shouldBe setUpRover(South)
    setUpRover(South).move(RotateClockWise) shouldBe setUpRover(West)
    setUpRover(West).move(RotateClockWise) shouldBe setUpRover(North)
  }

  it should "rotate Anticlockwise for all directions" in {
    setUpRover(North).move(RotateAntiClockWise) shouldBe setUpRover(West)
    setUpRover(West).move(RotateAntiClockWise) shouldBe setUpRover(South)
    setUpRover(South).move(RotateAntiClockWise) shouldBe setUpRover(East)
    setUpRover(East).move(RotateAntiClockWise) shouldBe setUpRover(North)
  }

  it should "lead to the same position by different paths" in {

    val path1: Rover => Rover = transport(MoveForward) andThen transport(RotateClockWise) andThen transport(MoveForward)
    val path2: Rover => Rover = transport(RotateClockWise) andThen transport(MoveForward) andThen transport(RotateAntiClockWise) andThen transport(MoveForward)

    val rover = setUpRover(North)

    path1(rover).position shouldBe path2(rover).position

  }

}
