package com.crobox.clickhouse.dsl.language

import com.crobox.clickhouse.dsl._
import com.dongxiguo.fastring.Fastring.Implicits._


trait EncodingFunctionTokenizer {
  self: ClickhouseTokenizerModule =>

  def tokenizeEncodingFunction(col: EncodingFunction[_]): String = {""}

}
