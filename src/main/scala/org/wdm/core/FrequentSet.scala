package org.wdm.core

import java.io.Serializable

/**
 * Represents a collection of k-length frequent sequence
 * items.
 *
 * @param transactions The k-length frequent patterns
 * @param length The pattern length this represents
 */
class FrequentSet[T] private (val transactions:List[Transaction[T]],
    val length:Int) extends Serializable {

    def size() = transactions.size
    def unique() = transactions.map { _.unique }.flatten

    override def toString() = transactions.mkString("\n")
}

/**
 * Companion object for the frequent set class
 */
object FrequentSet {
    def apply[T](items:List[Transaction[T]]) = new FrequentSet[T](items,
        items.headOption.map { _.length }.getOrElse(0))
    def apply[T](items:Transaction[T]*) = new FrequentSet[T](items.toList,
        items.headOption.map { _.length }.getOrElse(0))
}
