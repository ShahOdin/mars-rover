package rover

case class GridCoordinates(x: Int, y: Int)

case class Gridlimits(maxX: Int, maxY: Int)

object GridCoordinates {

  implicit class GridVectorOps(offsetVector: GridCoordinates) {

    def traverse(limits: Gridlimits)
                (vector: DifferenceVector): GridCoordinates = {
      import util._

      GridCoordinates(
        positiveModulo(offsetVector.x + vector.x, limits.maxX + 1),
        positiveModulo(offsetVector.y + vector.y, limits.maxY + 1)
      )
    }

    def findShortestVectorTo(gridlimits: Gridlimits)
                            (otherOffsetVector: GridCoordinates): DifferenceVector = ???
  }

}

case class ObstacleMap(limits: Gridlimits) {

  import util._

  private var data: Seq[Seq[Boolean]] = Seq.fill(limits.maxX + 1, limits.maxY + 1)(true)

  def markAsObstacle(position: GridCoordinates): Unit = {
    data.get2DElementAt(position.x)(position.y).map(_ => true)
  }

  def isObstructed(position: GridCoordinates): Boolean = {
    data.get2DElementAt(position.x)(position.y).contains(true)
  }
}
