object AlphabetSoup extends App {
  val source = scala.io.Source.fromFile("alphabet_soup.txt")
  val groups = source.getLines.drop(1).grouped(1)

  groups.zipWithIndex foreach { e =>
    val p = e._1.mkString
    val list = List(p.count(_ == 'H'), p.count(_ == 'A'), p.count(_ == 'C') / 2, p.count(_ == 'K'), p.count(_ == 'E'), p.count(_ == 'R'), p.count(_ == 'U'), p.count(_ == 'P'))
    val solution = list.min
    println("Case #" + (e._2 + 1) + ": " + solution)
  }
  source.close()
}