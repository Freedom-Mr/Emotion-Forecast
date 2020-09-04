package casia.isiteam.demo;

import casia.isiteam.util.DataReadUtil;
import casia.isiteam.util.IKUtil;
import casia.isiteam.util.IndividualityUtil;
import casia.isiteam.util.VectorOperationUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: Test
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/10
 * Email: zhiyou_wang@foxmail.com
 */
public class Test {


    public static void main(String[] args) {
        System.out.println("---------------------- user_1 ----------------------");
        Emotion.forecast("data/user_data_1");
        System.out.println("---------------------- user_2 ----------------------");
        Emotion.forecast("data/user_data_2");
        System.out.println("---------------------- user_3 ----------------------");
        Emotion.forecast("data/user_data_3");
    }

}
