package rover

sealed trait MovementCommand

case object MoveForward extends MovementCommand

case object RotateClockWise extends MovementCommand

case object RotateAntiClockWise extends MovementCommand

object Movement {

  import Direction._

  implicit class RoverMovementOps(rover: Rover) {

    val move: MovementCommand => Rover = {
      case MoveForward =>
        moveForward(rover)
      case RotateClockWise =>
        rotateClockWise(rover)
      case RotateAntiClockWise =>
        rotateAntiClockWise(rover)
    }

  }

  private def rotateClockWise(rover: Rover): Rover = rover.copy(direction = rover.direction.rotateClockWise)

  private def rotateAntiClockWise(rover: Rover): Rover = rover.copy(direction = rover.direction.rotateAntiClockWise)

  private def moveForward(rover: Rover): Rover = rover.direction match {
    case North =>
      rover.copy(position = rover.position.traverse(rover.gridlimits)(GridCoordinates(0, 1)))
    case East =>
      rover.copy(position = rover.position.traverse(rover.gridlimits)(GridCoordinates(1, 0)))
    case South =>
      rover.copy(position = rover.position.traverse(rover.gridlimits)(GridCoordinates(0, -1)))
    case West =>
      rover.copy(position = rover.position.traverse(rover.gridlimits)(GridCoordinates(-1, 0)))
  }

  //todo: rename?
  def transport: MovementCommand => Rover => Rover = {
    case MoveForward =>
      moveForward
    case RotateClockWise =>
      rotateClockWise
    case RotateAntiClockWise =>
      rotateAntiClockWise
  }

}

