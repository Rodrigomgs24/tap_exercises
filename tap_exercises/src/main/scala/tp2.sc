def f (s: String): String =
  "Hello" + s


def g(s: String): Int =
  s.map(c => c.toInt).sum


def f2(s: String): String =
  s.drop(6)


val comp: String => Int =
  g compose f2 compose f


comp("A")
assert(comp("A") == 65)



// colecoes

val s = (1 to 6).toSet

val s2 = (3 to 9).toSet

s.headOption
s2.headOption


s ++ s2

s.diff(s2)

s + 100


s - 5

// reduz um elemento da colecao
s.reduceOption(_ + _)


val s3: Set[Int] = Set()

// 1 -> List(1)
// 2 -> List(1,2)
// 3 -> List(1,2,3)

def f3(n: Int): List[Int] =
  (1 to n).toList

f3(3)

s.map(f3)

s.foldLeft[List[Int]](List())(
  (ac, el) => ac ++ f3(el)
)

val l2: List[List[Int]] =
  List (
    List(1,2,3,4), // 10
    List(1,2,3,1), // 7
    List(4,5,6) // 120
)

l2.foldLeft[(List[Int], Boolean)]((List(), true)) { case ((li, b), el) =>
  if (b) then
    val s = el.sum
    if (s % 2 == 0) (s:: li, true) else (s :: li, false)
  else
    val s = el.product
    if (s % 2 == 0) (s:: li, true) else (s :: li, false)
}