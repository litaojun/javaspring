package com.didispace.test.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ClassUtils { 
    public static List<Class> getAllImplClassesByInterface(Class c) { 

        List<Class> returnClassList = new ArrayList<Class>();// ���ؽ�� 
        if (c.isInterface()) { 
            String packageName = c.getPackage().getName();// ��õ�ǰ���� 
            try { 
                List<Class> allClass = getClassesByPackageName(packageName);// ��õ�ǰ�����Լ����µ������� 
                for (int i = 0; i < allClass.size(); i++) { 
                    if (c.isAssignableFrom(allClass.get(i))) {
                        if (!c.equals(allClass.get(i))) {// ����Ӳ���ȥ 
                            returnClassList.add(allClass.get(i)); 
                        } 
                    } 
                } 
            } catch (ClassNotFoundException e) { 
                // TODO Auto-generated catch block 
                e.printStackTrace(); 
            } catch (IOException e) { 
                // TODO: handle exception 
                e.printStackTrace(); 
            } 
        } 
        return returnClassList; 
 
    } 
 
    // ��һ�����в��ҳ�������,��jar���в��ܲ��� 
    private static ArrayList<Class> getClassesByPackageName(String packageName) throws IOException, ClassNotFoundException { 
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader(); 
        String path = packageName.replace('.', '/'); 
        Enumeration<URL> resources = classLoader.getResources(path); 
        List<File> dirs = new ArrayList<File>(); 
        while (resources.hasMoreElements()) { 
            URL resource = resources.nextElement(); 
            dirs.add(new File(resource.getFile())); 
        } 
        ArrayList<Class> classes = new ArrayList<Class>(); 
        for (File directory : dirs) { 
            classes.addAll(findClasses(directory, packageName)); 
        } 
        return classes; 
    } 
 
    private static List<Class> findClasses(File directory, String packageName) 
            throws ClassNotFoundException { 
        List<Class> classes = new ArrayList<Class>(); 
        if (!directory.exists()) { 
            return classes; 
        } 
        File[] files = directory.listFiles(); 
        for (File file : files) { 
            if (file.isDirectory()) { 
                assert !file.getName().contains("."); 
                classes.addAll(findClasses(file, packageName + '.' + file.getName())); 
            } else if (file.getName().endsWith(".class")) { 
                classes.add(Class.forName(packageName + "." + file.getName().substring(0,file.getName().length() - 6))); 
            } 
        } 
        return classes; 
    }
    
    
    
    public static ArrayList<Class> filterClassByKey(String key, String packageName) throws ClassNotFoundException, IOException
    {
    	ArrayList<Class>  clslist = getClassesByPackageName(packageName);
    	ArrayList<Class> rmls = new ArrayList<Class>();
    	if(key == null && key.equals(""))
    		return clslist;
    	// System.out.println("clslist.size="+clslist.size());
    	for(Class cls:clslist)
    	{
    		String clsname = cls.getName();
    		if(!clsname.contains(key))
    		{
    			//System.out.println(clsname);
    			rmls.add(cls);
    		}
    	}
    	clslist.removeAll(rmls);
    	return clslist;
    }
    
//    public static void main(String[] args) throws ClassNotFoundException, IOException
//    {
//    	 ArrayList<Class>  x = ClassUtils.filterClassByKey("HelloController","com");
//    	 System.out.println("xxx="+x.size());
//    	 for(Class s : x)
//    		 System.out.println(s.getName());
//    	 ArrayList<Method> als = AnnotationFilterClass.filterMethodListByAnnotation( x, TestCase.class);
//    	 for(Method md:als)
//    	 {
//    		 System.out.println(md.getName());
//    	 }
//    	 //WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
//
//    }
}

