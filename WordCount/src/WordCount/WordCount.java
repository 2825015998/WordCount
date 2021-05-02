package WordCount;

import java.io.BufferedReader;
import java.io.*;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        String s=input.nextLine();
        String[] arr=s.split(" ");
        String str=arr[0];     //控制参数
        String filename=arr[1];//文本文件名称

        File dir=new File("src/TESTONE");//dir为执行程序所在目录
        File[]files=dir.listFiles();
        File file = null;     //文本所在地址

        for(File filed :files)  //根据文本名称检索文件并返回地址
        {
            if(filed.isFile() && filename.equals(filed.getName())){
                file=filed.getAbsoluteFile();
                break;
            }
        }

        try
        {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);

            char ch;
            char fh='A';
            int c = 0;//字符数
            int w = 0; //单词数

            while((ch = (char) bf.read()) != (char)-1)//按字符读取文本内容
            {
                c++;//累计字符数，每个回车占2个字符
                if(!(ch>='a'&&ch<='z')&&!(ch>='A'&&ch<='Z')&&((fh>='a'&&fh<='z')||(fh>='A'&&fh<='Z')))
                //!(ch>='a'&&ch<='z')&&!(ch>='A'&&ch<='Z')&&((fh>='a'&&fh<='z')||(fh>='A'&&fh<='Z'))

                {

                    w++;//累计单词数
                }
                fh=ch;
            }

            if(str.equals("-c"))
                System.out.println("字符数："+c);
            else  if(str.equals("-w"))
                System.out.println("单词数："+w);

            bf.close();
            fr.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


