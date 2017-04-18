package iii_conventions

import util.TODO


class Invokable(private var invocations: Int = 0) {
    operator fun invoke(): Invokable {
        invocations++
        return this
    }

    fun getNumberOfInvocations() = invocations
}

// Learned: better use private constructor var.
//class Invokable {
//    var cnt = 0
//
//    fun getNumberOfInvocations():Int = cnt
//    operator fun invoke(): Invokable {
//        this.cnt++
//        return this
//    }
//}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
