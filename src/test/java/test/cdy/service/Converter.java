package test.cdy.service;

/**
 * Created by wentao_chang on 2016/8/9.
 *
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
