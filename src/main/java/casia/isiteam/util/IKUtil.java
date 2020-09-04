package casia.isiteam.util;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: IKAnalysisUtil
 * Description: unknown
 * <p>
 * Created by casia.wzy on 2020/7/10
 * Email: zhiyou_wang@foxmail.com
 */
public class IKUtil {

    public static List<String> segmenter(String text){
        List<String> list = new ArrayList<>();
        IKAnalyzer analyzer = new IKAnalyzer(true); //true 单词粒度分词，false 多词粒度分词
        StringReader stringReader = new StringReader(text);
        TokenStream ts = analyzer.tokenStream("", stringReader);
        try {
            ts.reset();
            if (ts == null)
                return null;
            CharTermAttribute attribute = ts.getAttribute(CharTermAttribute.class);
            while (ts.incrementToken()) {
                String word = new String(attribute.buffer(), 0, attribute.length());
                /*if(word.length() < 2)
                    continue;*/
                list.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ts.close();
                stringReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String text = "我购买了道具和服装，/欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;

        //IK
        segmenter(text).forEach(s-> System.out.print(s+"\t"));
        System.out.println();
    }
}
