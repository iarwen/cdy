package test.cdy.service;

/**
 * Created by wentao_chang on 2016/8/9.
 *
 */
public class ConverterTest {

    static Converter<String,Integer> convert= Integer::parseInt;

    public static void main(String []args){
        System.out.println(convert.convert("1")*100);
    }

}
