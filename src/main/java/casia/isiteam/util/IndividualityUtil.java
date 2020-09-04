package casia.isiteam.util;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: IndividualityUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/13
 * Email: zhiyou_wang@foxmail.com
 */
public class IndividualityUtil {
    /**
     * 性格分类
     * @param emotions
     * @return
     */
    public static Map<String,Double> individualityType(Double[] emotions){
        Map<String,Double> map = new HashMap<>();
        map.put("极不偏激",( emotions[0]+emotions[3]+emotions[6]+emotions[8]+emotions[9] ) );
        map.put("不偏激",( emotions[0]+emotions[3]+emotions[6]+emotions[9] ) );
        map.put("中立",( emotions[0]+emotions[1]+emotions[3]+emotions[8] ) );
        map.put("偏激",( emotions[1]+emotions[2]+emotions[4]+emotions[5]+emotions[8] ) );
        map.put("极度偏激",( emotions[1]+emotions[2]+emotions[4]+emotions[5]+emotions[7] ) );

        return map;
    }
}
