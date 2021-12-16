package Weed15_Test;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Calendar;

public class GreetingAttributeTagHandler extends TagSupport {
    // 标签有一个属性：name
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int doStartTag() throws JspTagException {
        Calendar calendar = Calendar.getInstance();
        int hr = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        String showtime = "，现在时间是 ："+hr+":"+min+":"+sec;
        try {
            if (hr < 12) {
                pageContext.getOut().write("Good monrning," + getName()+showtime);
            } else if (hr < 16) {
                pageContext.getOut().write("Good afternoon," + getName()+showtime);
            } else if (hr < 19) {
                pageContext.getOut().write("Good evening," + getName()+showtime);
            } else {
                pageContext.getOut().write("Good night," + getName()+showtime);
            }
        } catch (IOException e) {
            throw new JspTagException(
                    "Fatal error:greeeting tag could not write to the output stream.");
        }
        return EVAL_BODY_INCLUDE;
    }
    @Override
    public int doEndTag() throws JspTagException {
        return EVAL_PAGE;
    }

}
