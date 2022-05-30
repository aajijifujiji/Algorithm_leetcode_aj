package leetcode.editor.test;

import com.sun.media.sound.SoftTuning;

import javax.lang.model.element.VariableElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Array;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Random;

public class test1 {

    public static void main(String[] args) {
        Class cl1 = Random.class;

        try {
            Constructor ctr = cl1.getConstructor();
            Object o = ctr.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
