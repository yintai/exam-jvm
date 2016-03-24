package com.lee.exam.action.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {

    private static String APP_PATH ="";
    private static String CONFIG_PATH;
    public static ApplicationContext applicationContext;
    
    public static boolean isOpeningTime = false;

	public static void init() {

		init(true);
	}

	public static void init(Boolean initLotoConfig) {

		applicationContext = createApplicationContext();

	}
	
	public static void init(ApplicationContext appContext, String log4jProperties, Boolean initLotoConfig) {

		applicationContext = appContext;

	}
	
    private static ApplicationContext createApplicationContext() {    	
        try {
    		ApplicationContext appContext = new ClassPathXmlApplicationContext(
    				new String[] {"classpath:config/spring_mvc.xml"
    				});
        	return appContext;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
 
	
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static String getAPP_PATH() {
        return APP_PATH;
    }

    public static String getCONFIG_PATH() {
        return CONFIG_PATH;
    }
 
}
