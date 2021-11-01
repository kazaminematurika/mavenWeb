package Weed9_Test_Listener;

import Weed9_Test_class.Dog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;

/**
 * @author Kazamine_Setueka
 */
public class ServletContextListener implements javax.servlet.ServletContextListener, ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("在web中添加上下文属性" + event.getName() + ":" + event.getValue());

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("在web中删除上下文属性" + event.getName() + ":" + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //创建上下文属性(初始化)
        ServletContext servletContext = sce.getServletContext();
//        初始化上下文属性的数值在web.xml中的<context-param/->/name>
        String string = servletContext.getInitParameter("breed");
        Dog dog = new Dog(string);
//        将上下文属性绑定给了一个对象,由这个对象封装了上下文属性
        servletContext.setAttribute("dogName", dog);
    }
}
