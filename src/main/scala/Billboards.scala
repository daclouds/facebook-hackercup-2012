object Billboards extends App {
	val source = scala.io.Source.fromFile("billboards.txt") 
	val groups = source.getLines.drop(1).grouped(1)
	groups.zipWithIndex foreach { e =>
		val solution = solve(e._1(0).split(" ").toList)
		println("Case #" + (e._2 + 1) + ": " + solution)
	}
	source.close()
	
	def solve(list: List[String]):Int = {
	  val width = list(0).toInt
	  val height = list(1).toInt
	  val words = list.drop(2)
	  
	  for(size <- Range(1, 1 + math.max(width, height))) {
	    
	    val cols = width/size
	    val rows = height/size
	    
	    if(longestWord(words) > cols || cols*rows < words.mkString(" ").length || isOverflow(cols,rows,words)) {
	      return size-1
	    }
	  }
	  return 0
	}
	
	def longestWord(words: List[String]) = {
	  var word = words.head
	  for (i <- 1 until words.length) {
	    if (words(i).length() > word.length()) {
	      word = words(i)
	    }
	  }
	  word.length()
	}
	
	
	def isOverflow(cols: Int, rows: Int, words:List[String]):Boolean = {
	  var line = 1
	  var sb = new StringBuilder(words.head);
	  
	  for (word <- words.tail) {
	    if (sb.length < cols) {
	      
	      if (sb.length > 0) sb.append(" ")
	      sb.append(word)
	      
	      if (sb.length >= cols) {
	        
	        if (sb.length == cols) sb = new StringBuilder()
	        else sb = new StringBuilder(word)
	        
	        line += 1
	        
	      }
	      
	    } else {
	      
	      line += 1
	      
	    }
	  }
	  
	  if (line > rows) true
	  else false
	}
}