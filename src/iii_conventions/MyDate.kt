package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}

// Learn: using "when" can be used with predicate in each line /
// or as when (predicate(it))  and value in each line { value-> etc ..... }
//
//data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int):Comparable<MyDate> {
//    override fun compareTo(other: MyDate): Int {
//        val y = this.year.compareTo(other.year)
//        if (y!=0) return y
//        val m = this.month.compareTo(other.month)
//        if (m!=0) return m
//        return this.dayOfMonth.compareTo(other.dayOfMonth)
//    }
//}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

class DateRange(
        override val start: MyDate,
        override val endInclusive: MyDate
) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)
    override fun contains(value: MyDate): Boolean = start <= value && value <= endInclusive
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.addTimeIntervals(TimeInterval.DAY, 1)
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.endInclusive
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) = addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)

//operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(start=this, endInclusive = other)
//operator fun TimeInterval.times(i : Int) = Pair(this, i)
//operator fun MyDate.plus(interval: TimeInterval): MyDate = this.addTimeIntervals(interval, 1)
//operator fun MyDate.plus(interval: Pair<TimeInterval,Int>): MyDate = this.addTimeIntervals(interval.first, interval.second)
//
//class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>,  Iterable<MyDate> {
//    override fun iterator(): Iterator<MyDate> {
//        return  object : Iterator<MyDate> {
//            var cur = start
//            override fun hasNext(): Boolean = (cur<=endInclusive)
//
//            override fun next(): MyDate {
//                val ret = cur
//                cur=cur.nextDay()
//                return ret
//            }
//        }
//    }
//}


//
 // or  implement contains.
//class DateRange(val start: MyDate, val endInclusive: MyDate) {
//    operator fun contains(d: MyDate):Boolean {
//        return  (start<=d) && (d<=endInclusive)
//    }
//
//    operator fun  iterator(): Iterator<MyDate> {}
//}
