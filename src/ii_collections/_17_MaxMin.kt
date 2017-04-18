package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
    return customers.maxBy {
        it.orders.size }
// Learned: size val for collections -
// same as count() for List. similar bytecode (inline)
//    todoCollectionTask()
    return customers.maxBy { it.orders.count() }
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
    return orderedProducts.maxBy { it.price }
//    todoCollectionTask()
//    return orders.flatMap { it.products } .maxBy { it .price}
}
