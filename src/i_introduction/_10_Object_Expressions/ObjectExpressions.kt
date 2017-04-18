package i_introduction._10_Object_Expressions

import util.TODO
import util.doc10
import java.util.*

fun todoTask10(): Nothing = TODO(
    """
        Task 10.
        Read about object expressions that play the same role in Kotlin as anonymous classes do in Java.

        Add an object expression that provides a comparator to sort a list in a descending order using java.util.Collections class.
        In Kotlin you use Kotlin library extensions instead of java.util.Collections,
        but this example is still a good demonstration of mixing Kotlin and Java code.
    """,
    documentation = doc10()
)

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object : Comparator<Int> {
        override fun compare(x: Int, y: Int) = y - x
    })

// Learned: Comparator is not strict 1,0,-1 but any positive negative would do.
//    Collections.sort(arrayList,
//            object:Comparator<Int> {
//                override fun compare(a:Int, b:Int): Int { //=  if (a==b) 0 else (if (a<b) 1 else -1)
//                    if (a==b) return 0
//                    return if (a>b) -1 else 1
//                }
//
//            }
//    )
    return arrayList
}