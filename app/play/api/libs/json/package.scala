package play.api.libs

package object json {

  implicit def kvToSeq(kv:(String,String)):JsValue = seqToJson(Seq(kv))
  implicit def seqToJson(seq:Seq[(String,String)]):JsValue = JsObject(seq.map { case(k,v) => (k,JsString(v))})

}