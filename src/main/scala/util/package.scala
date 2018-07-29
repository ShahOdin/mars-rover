import rover.CyclicIndex

package object util {

  def positiveModulo(dividend: Int, divisor: Int): Int = {
    {
      val modulo = dividend % divisor
      modulo match {
        case i if i < 0 => modulo + divisor
        case _ => modulo
      }
    }
  }

  implicit class seqOps[A](seq: Seq[A]) {
    //todo: give this a better name
    def getElementAt(index: CyclicIndex): Option[A] = seq match {
      case Nil =>
        None
      case _ =>
        val moduloIndex = positiveModulo(index, seq.length)
        Some(seq(moduloIndex))
    }
  }

  implicit class seqSeqOps[A](seq: Seq[Seq[A]]) {
    //todo: give this a better name
    def get2DElementAt(row: CyclicIndex)(col: CyclicIndex): Option[A] = seq match {
      case Nil =>
        None
      case _ =>
        val rowModulo = positiveModulo(row, seq.length)
        val rowSeq = seq(rowModulo)

        val colModulo = positiveModulo(col, rowSeq.length)
        Some(rowSeq(colModulo))
    }
  }

}
