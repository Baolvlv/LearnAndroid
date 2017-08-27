package com.example.bwx.testxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class MainActivity extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        try {
//            //打开assets文件夹中的文件为InputStream
//           InputStream is =  getAssets().open("language.xml");
//            //创建DocumentBuilderFactory
//            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
//            //由builderFactory创建DocumentBuilder
//            DocumentBuilder builder = builderFactory.newDocumentBuilder();
//            //将InputStream通过builder转化为document
//            Document document = builder.parse(is);
//            //获取文件中的根元素
//            Element element = document.getDocumentElement();
//            //获取所有标签名为"lan"的子元素
//            NodeList nodeList =  element.getElementsByTagName("lan");
//            for(int i=0;i<nodeList.getLength();i++){
//                //将所有获取到的"lan"标签的nodelist转换为element
//                Element lan = (Element) nodeList.item(i);
//                //获取lan的id 属性
//                tv.append(lan.getAttribute("id")+"\n");
//                // 获取lan标签下第0个name 标签的文本
//                tv.append(lan.getElementsByTagName("name").item(0).getTextContent()+"\n");
//                //获取lan标签下第0个ide标签的文本内容
//                tv.append(lan.getElementsByTagName("ide").item(0).getTextContent()+"\n");

        //}
            //创建factory和builder
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            //创建Documnet
            Document newxml = builder.newDocument();
            //创建标签添加属性
            Element language = newxml.createElement("Language");
            language.setAttribute("cat","it");

            Element lan1 = newxml.createElement("lan");
            lan1.setAttribute("id","1");
            Element name1 = newxml.createElement("name");
            //创建标签的文本内容
            name1.setTextContent("java");
            Element ide1 = newxml.createElement("ide");
            ide1.setTextContent("Eclipse");
            //添加子标签
            lan1.appendChild(name1);
            lan1.appendChild(ide1);
            language.appendChild(lan1);

            Element lan2 = newxml.createElement("lan");
            lan2.setAttribute("id","2");
            Element name2 = newxml.createElement("name");
            name2.setTextContent("Swift");
            Element ide2 = newxml.createElement("ide");
            ide2.setTextContent("Xcode");
            lan2.appendChild(name2);
            lan2.appendChild(ide2);
            language.appendChild(lan2);

            Element lan3 = newxml.createElement("lan");
            lan3.setAttribute("id","3");
            Element name3 = newxml.createElement("name");
            name3.setTextContent("C#");
            Element ide3 = newxml.createElement("ide");
            ide3.setTextContent("visual studio");
            lan3.appendChild(name3);
            lan3.appendChild(ide3);
            language.appendChild(lan3);

            //为Document添加根标签
            newxml.appendChild(language);

            //创建factory和transformer
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            //设置输出属性
            transformer.setOutputProperty("encoding","utf-8");
            //创建StringWriter用于输出
            StringWriter sw = new StringWriter();
            //transformer将Document转化为结果
            transformer.transform(new DOMSource(newxml),new StreamResult(sw));
            tv.setText(sw.toString());







        }  catch (ParserConfigurationException e) {
            e.printStackTrace();
        }  catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
