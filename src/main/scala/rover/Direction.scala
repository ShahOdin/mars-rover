package rover

sealed trait Direction

case object North extends Direction
case object East extends Direction
case object South extends Direction
case object West extends Direction

object Direction {

  private val directions = List(North, East, South, West)

  private def directionIndex(direction: Direction): CyclicIndex = {
    directions.indexOf(direction)
  }

  private def getDirectionByIndex(index: CyclicIndex): Direction = {
    import util._
    directions.getElementAt(index).get
  }

  implicit class DirectionOps(direction: Direction) {
    def rotateClockWise: Direction = {
      val index = directionIndex(direction)
      getDirectionByIndex(index + 1)
    }

    def rotateAntiClockWise: Direction = {
      val index = directionIndex(direction)
      getDirectionByIndex(index - 1)
    }
  }

}

