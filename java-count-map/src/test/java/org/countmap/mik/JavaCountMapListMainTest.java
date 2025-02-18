package org.countmap.mik;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JavaCountMapListMainTest {

    @InjectMocks
    private JavaCountMap javaCountMap;

    @Test
    @DisplayName("Возвращение пустой Map если список равен null")
    public void givenListInteger_ListIsNull_ThenReturnEmptyMap(){
        List<Integer> listIntegerIsEmpty = null;
        Map<Integer,Integer> mapResNeedAssert = new HashMap<>();
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listIntegerIsEmpty));
    }

    @Test
    @DisplayName("Возвращение пустой Map если список пустой")
    public void givenListInteger_ListIsEmpty_ThenReturnEmptyMap(){
        List<Integer> listIntegerIsEmpty = Collections.emptyList();
        Map<Integer,Integer> mapResNeedAssert = new HashMap<>();
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listIntegerIsEmpty));
    }


    @Test
    @DisplayName("Возвращение Map если список заполнен числами")
    public void givenListAnyIntegers_ListIsNotEmpty_ThenReturnMap(){
        List<Integer> listAnyIntegers = Arrays.asList(1,1,3,2,5,4,2,4);
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
    @DisplayName("Возвращает Map если список заполнен отрицат. числа")
    public void giveListNegativeIntegers_ListIsNotEmpty_ThenReturnMap(){
        List<Integer> listNegativeIntegers = Arrays.asList(-1,-20,-2,-2,-3);
        Map<Integer,Integer> mapResNeedAssert = new HashMap<Integer, Integer>(){{
            put(-1,1);
            put(-20,1);
            put(-2,2);
            put(-3,1);
        }};
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listNegativeIntegers));
    }

    @Test
    @DisplayName("Возвращает Map если список заполнен одинаковыми числами")
    public void givenListIdenticalIntegers_ListIsNotEmpty_ThenReturnMap(){
        List<Integer> listIdenticalInteger = Arrays.asList(1,1,1,1,1,1);
        Map<Integer,Integer> mapResNeedAssert = new HashMap<Integer,Integer>(){{
            put(1,6);
        }};
        assertEquals(mapResNeedAssert,javaCountMap.countMap(listIdenticalInteger));
    }


}
