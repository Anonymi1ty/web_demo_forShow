package test;

import utils.JdbcUtils;

public class JdbcUtilsTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(JdbcUtils.getConnect());
        }
    }
}
