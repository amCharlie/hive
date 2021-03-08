package org.apache.hadoop.hive.ql.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * @Author: Charlie Wu
 * @Date: 2021/3/8 23:01
 * @Description: 自定义Hive UDF函数
 */
@Description(name = "HelloUDF",
        value = "_FUNC_(input_str) - returns Hello : input_str ",
        extended =  "Example:\n "
                + "  > SELECT _FUNC_('moyuan') FROM src LIMIT 1;\n"
                + "  'Hello : moyuan'\n")
public class HelloUDF extends UDF {
    public Text evaluate(Text input){
        return new Text("Hello: "+input);
    }

    // 测试代码
    public static void main(String[] args) {
        HelloUDF udf = new HelloUDF();
        System.out.println(udf.evaluate(new Text("Charlie")));
    }
}