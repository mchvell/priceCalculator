fun applyMarkup(product: Int, priceDiscount: Double, markupEnabled: Boolean): Int{
    if (!markupEnabled) return product

    val priceWithMarkup = product * (1 + (priceDiscount / 100))
    val result = priceWithMarkup.toInt()

    if (result < 0) return 0
    return result
}

fun calculateTotal(product: Int, logistics: Int): Int = product + logistics

fun applyFinalPrice (product: Int, logistics: Int, logisticsInPrice: Boolean): String{
    if(!logisticsInPrice) return "Цена товара $product, доставка $logistics"

    return "Итоговая цена товара ${calculateTotal(product, logistics)}"
}


fun main() {
    print("Цена товара: ")
    val product = readLine()!!.toInt()

    print("Логистика товара: ")
    val logistics = readLine()!!.toInt()

    print("Признак логистики в цене: ")
    val logisticsInPriceEnabled = readLine()!!.toBoolean()

    print("Наценка %: ")
    val priceDiscount = readLine()!!.toDouble()

    print("Применять наценку? (true/false): ")
    val markupEnabled = readLine()!!.toBoolean()

    val productWithMarkup = applyMarkup(product, priceDiscount, markupEnabled)
    val output = applyFinalPrice(productWithMarkup, logistics, logisticsInPriceEnabled)

    println(output)
}