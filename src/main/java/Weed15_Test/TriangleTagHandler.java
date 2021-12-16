package Weed15_Test;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.StringTokenizer;

public class TriangleTagHandler extends TagSupport {
    // 标签有一个属性：name
    private String sides;
    public String getSides() {
        return sides;
    }
    public void setSides(String sides) {
        this.sides = sides;
    }
    @Override
    public int doStartTag() throws JspTagException {
        int i=0;
        String s=null;
        double result=0;
        double a[]=new double[3];
        String answer=null;
        s=this.getSides();
        if(s!=null)
        { StringTokenizer fenxi=new StringTokenizer(s,",");
//根据"，"分拆字符串
            while(fenxi.hasMoreTokens())
            {//逐个显示分拆后的字符串
                String temp=fenxi.nextToken();
                try{ a[i]=Double.valueOf(temp).doubleValue();
                    i++;
                }
                catch(NumberFormatException e)
                {answer = "<BR>"+"请输入数字字符";
                }
            }
            if(a[0]+a[1]>a[2]&&a[0]+a[2]>a[1]&&a[1]+a[2]>a[0])
            { double p=(a[0]+a[1]+a[2])/2;
                result=Math.sqrt(p*(p-a[0])*(p-a[1])*(p-a[2]));
                answer = "面积："+result;
            }
            else
            {
                answer = "<BR>"+"您输入的三边不能构成一个三角形";
            }
        }
        String showMsg = "<P> 您输入的三边是： <BR>"+a[0]+" <BR>"+a[1]+" <BR>"+a[2]+" <BR>"+answer;
        try {
            pageContext.getOut().write(showMsg);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doEndTag() throws JspTagException {
        return EVAL_PAGE;
    }

}
