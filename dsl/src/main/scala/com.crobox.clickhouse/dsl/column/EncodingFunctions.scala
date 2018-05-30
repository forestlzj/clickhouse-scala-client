package com.crobox.clickhouse.dsl.column

import com.crobox.clickhouse.dsl.TableColumn.AnyTableColumn
import com.crobox.clickhouse.dsl.{ExpressionColumn, TableColumn}

trait EncodingFunctions { self: Magnets =>
  abstract class EncodingFunction[O](col: AnyTableColumn) extends ExpressionColumn[O](col)

  case class Hex(col: HexCompatible)               extends EncodingFunction[String](col.column)
  case class Unhex[I](col: StringColMagnet)        extends EncodingFunction[I](col.column)
  case class UUIDStringToNum(col: StringColMagnet) extends EncodingFunction[Long](col.column)
  case class UUIDNumToString(col: StringColMagnet) extends EncodingFunction[Long](col.column)
  case class BitmaskToList(col: NumericCol)        extends EncodingFunction[String](col.column)  //TODO Add type
  case class BitmaskToArray(col: NumericCol)       extends EncodingFunction[Iterable[Long]](col.column)

  def hex(col: HexCompatible)                   = Hex(col)
  def unhex(col: StringColMagnet)           = Unhex(col)
  def uUIDStringToNum(col: StringColMagnet) = UUIDStringToNum(col)
  def uUIDNumToString(col: StringColMagnet) = UUIDNumToString(col)
  def bitmaskToList(col: NumericCol)            = BitmaskToList(col)
  def bitmaskToArray(col: NumericCol)           = BitmaskToArray(col)
  /*
hex
unhex(str)
UUIDStringToNum(str)
UUIDNumToString(str)
bitmaskToList(num)
bitmaskToArray(num)
 */
}