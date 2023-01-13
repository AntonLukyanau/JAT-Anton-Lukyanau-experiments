package org.example.reflection.copying;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FullCopyCloner {

    private final Stack<Object> newValues = new Stack<>();

    public Object deepCopy(Object source) {
        if (newValues.contains(source)) {
            return source;
        }
        if (source.getClass().isPrimitive()) {
            newValues.push(source);
            return source;
        }
        if (source.getClass().getModule() != FullCopyCloner.class.getModule()) {
            if (source instanceof Collection<?> collection) {
                StructureCloner structureCloner = new StructureCloner();
                Collection newCollection = (Collection) structureCloner.createEmptyInstanceByClass(collection.getClass());
                collection.forEach(elem -> newCollection.add(deepCopy(elem)));
                newValues.push(newCollection);
                return newCollection;
            }
            newValues.push(source);
            return source;
        }
        if (source.getClass().isArray()) {
            Class<?> arrayComponentType = source.getClass().getComponentType();
            int length = Array.getLength(source);
            Object arrayCopy = Array.newInstance(arrayComponentType, length);
            newValues.push(arrayCopy);
            if (arrayComponentType.isPrimitive() || arrayComponentType == String.class) {
                System.arraycopy(source, 0, arrayCopy, 0, length);
            } else {
                for (int i = 0; i < length; i++) {
                    Object oldElement = Array.get(source, i);
                    Object newElement = deepCopy(oldElement);
                    newValues.push(newElement);
                    Array.set(arrayCopy, i, newElement);
                }
            }
            return arrayCopy;
        }
        try {
            Class<?> sourceClass = source.getClass();
            Object newObj = createEmpty(sourceClass);
            newValues.push(newObj);
            Field[] declaredFields = sourceClass.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
                Object sourceValue = declaredField.get(source);
                Object newValue = deepCopy(sourceValue);
                System.out.println("Set in field " + declaredField.getName() + " value " + newValue);
                declaredField.set(newObj, newValue);
            }
            return newObj;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object createEmpty(Class<?> aClass) {
        System.out.println("Create new instance with type " + aClass.getName());
        try {
            Constructor<?> constructor = getConstructorFrom(aClass);
            Class<?>[] constructorParameterTypes = constructor.getParameterTypes();
            Object[] parameters = Arrays.stream(constructorParameterTypes)
                    .map(this::getDefaultValue)
                    .toArray();
            return constructor.newInstance(parameters);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    private Constructor<?> getConstructorFrom(Class<?> aClass) {
        Constructor<?>[] constructors = aClass.getConstructors();
        if (constructors.length == 0) {
            constructors = aClass.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
            }
        }
        Optional<Constructor<?>> constructorOptional = Arrays.stream(constructors)
                .filter(constructor -> constructor.getParameterTypes().length == 0)
                .findAny();
        if (constructorOptional.isPresent()) {
            return constructorOptional.get();
        }
        return Arrays.stream(constructors)
                .min(Comparator.comparingInt(constructor -> constructor.getParameterTypes().length))
                .orElseThrow(RuntimeException::new);
    }

    private Object getDefaultValue(Class<?> type) {
        if (type == byte.class) {
            return (byte) 0;
        } else if (type == short.class) {
            return (short) 0;
        } else if (type == int.class) {
            return 0;
        } else if (type == long.class) {
            return 0L;
        } else if (type == float.class) {
            return 0f;
        } else if (type == double.class) {
            return 0d;
        } else if (type == boolean.class) {
            return false;
        } else if (type == char.class) {
            return (char) 0;
        } else if (type == Byte.class) {
            return Byte.valueOf((byte) 0);
        } else if (type == Short.class) {
            return Short.valueOf((short) 0);
        } else if (type == Integer.class) {
            return Integer.valueOf(0);
        } else if (type == Long.class) {
            return Long.valueOf(0);
        } else if (type == Float.class) {
            return Float.valueOf(0);
        } else if (type == Double.class) {
            return Double.valueOf(0);
        } else if (type == Boolean.class) {
            return Boolean.FALSE;
        } else if (type == Character.class) {
            return Character.valueOf((char) 0);
        }
        return null;
    }

}
