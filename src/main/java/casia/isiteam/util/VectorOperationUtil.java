package casia.isiteam.util;

import java.util.Arrays;

/**
 * ClassName: VectorOperationUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/13
 * Email: zhiyou_wang@foxmail.com
 */
public class VectorOperationUtil {
    /**
     * 向量叠加
     * @param datas
     * @return
     */
    public static Double[] superposition(Double[] ... datas){
        if( datas!=null ){
            int maxLength=0;
            for(Double[] data:datas){
                if( data!=null){
                    maxLength=data.length>maxLength?data.length:maxLength;
                }
            }
            Double[] result = new Double[maxLength];
            for(Double[] data:datas){
                if(data!=null){
                    for (int i=0;i<data.length;i++){
                        result[i]= result[i]==null ? (data[i]==null?0.0:data[i]) : (data[i]==null?result[i]:result[i]+data[i]);
                    }
                }
            }
            return result;
        }
        return new Double[]{};
    }
}
