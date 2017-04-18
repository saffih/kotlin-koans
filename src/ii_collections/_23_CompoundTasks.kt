package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
    // Learned: use "contains" rather then filter and count.
//    return customers.filter { it.orders.flatMap { it.products } .filter { it==product} .count() >0 }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
//    return orders.filter { it.isDelivered } .flatMap { it.products } .maxBy {it.price}
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    // Learn: nested gets complicated.
    return customers.flatMap { it.orders }.flatMap { it.products }.count { it == product }
//    return customers.flatMap { it.orders.flatMap { it.products.filter {it==product} } }.count()
}
