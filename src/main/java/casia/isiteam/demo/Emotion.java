package casia.isiteam.demo;

import casia.isiteam.util.DataReadUtil;
import casia.isiteam.util.IKUtil;
import casia.isiteam.util.IndividualityUtil;
import casia.isiteam.util.VectorOperationUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Emotion
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/10
 * Email: zhiyou_wang@foxmail.com
 */
public class Emotion {
    public static void forecast(String dataPath){
        Map<String,Double[]> result = new HashMap<>();

        //加载词典向量
        Map<String, Double[]> lexicons = DataReadUtil.loadLexicon();

        //加载用户发帖内容
        List<String> userBlogs = DataReadUtil.readUserBlog(dataPath);

        //逐条处理
        userBlogs.forEach(blog->{
            //排除空值
            /*if(blog==null||blog.trim().length()==0){
                return;
            }*/

            //分词
            List<String> blogSegmenters = IKUtil.segmenter(blog);

            //提取词向量分布
            blogSegmenters.stream().filter(key->key.length()>0 && lexicons.containsKey(key)).forEach(s->{
                //叠加词向量
                result.put( "emotions", VectorOperationUtil.superposition( result.get("emotions"),lexicons.get(s)) );
            });

        });

        //打印输出情绪向量结果
        System.out.println("积极\t\t消极\t\t愤怒\t\t期待\t\t厌恶\t\t恐惧\t\t喜悦\t\t悲伤\t\t惊奇\t\t信任");
        for(Double d:result.get("emotions")){
            System.out.print((d==null||d==0?"--":d)+"\t");
        }

        //划分人物性格
        Map<String,Double> map = IndividualityUtil.individualityType(result.get("emotions"));
        System.out.println("\r\n");
        map.forEach((k,v)->{
            System.out.println(k+"："+v);
        });

    }
}
