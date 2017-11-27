package br.com.my_jhipster.domain;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis
 */
public class DeductionsTest {

    public DeductionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testLetters1() {
        Deductions deduction = new Deductions();
        deduction.setPassword("abcdefghfd");
        List<Integer> result = deduction.letters_only();
        assertEquals((Integer) 7, result.get(0));
        assertEquals((Integer) 10, result.get(1));
        assertEquals((Integer) (-10), result.get(2));
    }

    @Test
    public void testLetters2() {
        Deductions deduction = new Deductions();
        deduction.setPassword("aoifgljsd");
        List<Integer> result = deduction.letters_only();
        assertEquals((Integer) 7, result.get(0));
        assertEquals((Integer) 9, result.get(1));
        assertEquals((Integer) (-9), result.get(2));
    }

    @Test
    public void testLetters3() {
        Deductions deduction = new Deductions();
        deduction.setPassword("1aoifgljsd");
        List<Integer> result = deduction.letters_only();
        assertEquals((Integer) 7, result.get(0));
        assertEquals((Integer) 0, result.get(1));
        assertEquals((Integer) 0, result.get(2));
    }

    @Test
    public void testConsecutiveUppercase1() {
        Deductions deduction = new Deductions();
        deduction.setPassword("KHijAsG3SDF");
        List<Integer> result = deduction.consecutive_uppercase_letter();
        assertEquals((Integer) 10, result.get(0));
        assertEquals((Integer) 3, result.get(1));
        assertEquals((Integer) (-6), result.get(2));
    }

    @Test
    public void testConsecutiveUppercase2() {
        Deductions deduction = new Deductions();
        deduction.setPassword("TESTE3aAsd");
        List<Integer> result = deduction.consecutive_uppercase_letter();
        assertEquals((Integer) 10, result.get(0));
        assertEquals((Integer) 4, result.get(1));
        assertEquals((Integer) (-8), result.get(2));
    }

    @Test
    public void testConsecutiveUppercase3() {
        Deductions deduction = new Deductions();
        deduction.setPassword("aAaAaA");
        List<Integer> result = deduction.consecutive_uppercase_letter();
        assertEquals((Integer) 10, result.get(0));
        assertEquals((Integer) 0, result.get(1));
        assertEquals((Integer) (0), result.get(2));
    }

    @Test
    public void testConsecutiveLowercase1() {
        Deductions deduction = new Deductions();
        deduction.setPassword("lower1case");
        List<Integer> result = deduction.consecutive_lower_letter();
        assertEquals((Integer) 11, result.get(0));
        assertEquals((Integer) 7, result.get(1));
        assertEquals((Integer) (-14), result.get(2));
    }

    @Test
    public void testConsecutiveLowercase2() {
        Deductions deduction = new Deductions();
        deduction.setPassword("LoWerCase");
        List<Integer> result = deduction.consecutive_lower_letter();
        assertEquals((Integer) 11, result.get(0));
        assertEquals((Integer) 3, result.get(1));
        assertEquals((Integer) (-6), result.get(2));
    }

    @Test
    public void testConsecutiveLowercase3() {
        Deductions deduction = new Deductions();
        deduction.setPassword("w4953fgtju8289");
        List<Integer> result = deduction.consecutive_lower_letter();
        assertEquals((Integer) 11, result.get(0));
        assertEquals((Integer) 4, result.get(1));
        assertEquals((Integer) (-8), result.get(2));
    }

    @Test
    public void testSequentialLetters1() {
        Deductions deduction = new Deductions();
        deduction.setPassword("abcdeabcde");
        List<Integer> result = deduction.sequential_letter();
        assertEquals((Integer) 13, result.get(0));
        assertEquals((Integer) 3, result.get(1));
        assertEquals((Integer) (-9), result.get(2));
    }

  

    @Test
    public void testSequentialLetters2() {
        Deductions deduction = new Deductions();
        deduction.setPassword("abc1defabcdabcab");
        List<Integer> result = deduction.sequential_letter();
        assertEquals((Integer) 13, result.get(0));
        assertEquals((Integer) 3, result.get(1));
        assertEquals((Integer) (-9), result.get(2));
    }
    @Test
    public void testSequentialSymbol1() {
        Deductions deduction = new Deductions();
        deduction.setPassword(")!@#$%^&*(");
        List<Integer> result = deduction.sequential_symbol();
        assertEquals((Integer) 14, result.get(0));
        assertEquals((Integer) 8, result.get(1));
        assertEquals((Integer) (-24), result.get(2));
    }
    @Test
    public void testSequentialSymbol2() {
        Deductions deduction = new Deductions();
        deduction.setPassword("%^&*()!@#$");
        List<Integer> result = deduction.sequential_symbol();
        assertEquals((Integer) 14, result.get(0));
        assertEquals((Integer) 6, result.get(1));
        assertEquals((Integer) (-18), result.get(2));
    }
    @Test
    public void testSequentialSymbol3() {
        Deductions deduction = new Deductions();
        deduction.setPassword("test!@#tes@#$%");
        List<Integer> result = deduction.sequential_symbol();
        assertEquals((Integer) 14, result.get(0));
        assertEquals((Integer) 3, result.get(1));
        assertEquals((Integer) (-9), result.get(2));
    }
}
