package org.countmap.mik;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JavaCountMapArrayMainTest {

    @InjectMocks
    private JavaCountMap javaCountMap;

    @Test
    @DisplayName("Возвращение пустой Map если список равен null")
    public void givenArrayInteger_ArrayIsNull_ThenReturnEmptyMap(){
        int[] listIntegerIsEmpty = null;
        Map<Integer,Integer> mapResNeedAssert = new HashMap<>();
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listIntegerIsEmpty));
    }

    @Test
    @DisplayName("Возвращение пустой Map если массив пустой")
    public void givenArrayInteger_ArrayIsEmpty_ThenReturnEmptyMap(){
        int[] listIntegerIsEmpty = {};
        Map<Integer,Integer> mapResNeedAssert = new HashMap<>();
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listIntegerIsEmpty));
    }


    @Test
    @DisplayName("Возвращение Map если массив заполнен числами")
    public void givenArrayAnyIntegers_ArrayIsNotEmpty_ThenReturnMap(){
        int[] listAnyIntegers = {1,1,3,2,5,4,2,4};
        Map<Integer,Integer> mapResNeedAssert = new HashMap<Integer,Integer>(){{
            put(1,2);
            put(3,1);
            put(2,2);
            put(5,1);
            put(4,2);
        }};
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listAnyIntegers));
    }

    @Test
    @DisplayName("Возвращает Map если массив заполнен отрицат. числа")
    public void giveArrayNegativeIntegers_ArrayIsNotEmpty_ThenReturnMap(){
        int[] listNegativeIntegers = {-1,-20,-2,-2,-3};
        Map<Integer,Integer> mapResNeedAssert = new HashMap<Integer, Integer>(){{
            put(-1,1);
            put(-20,1);
            put(-2,2);
            put(-3,1);
        }};
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listNegativeIntegers));
    }

    @Test
    @DisplayName("Возвращает Map если массив заполнен одинаковыми числами")
    public void givenArrayIdenticalIntegers_ArrayIsNotEmpty_ThenReturnMap(){
        int[] listIdenticalInteger = {1,1,1,1,1,1};
        Map<Integer,Integer> mapResNeedAssert = new HashMap<Integer,Integer>(){{
            put(1,6);
        }};
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listIdenticalInteger));
    }


}
