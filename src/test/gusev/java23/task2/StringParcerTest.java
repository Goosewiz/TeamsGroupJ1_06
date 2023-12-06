package gusev.java23.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParcerTest {

    @Test
    void getNetString() {
        String input = "";
        String answer = StringParcer.getNewString(input);
        assertEquals("", answer, "1");
        input = "Да; и; но ((4))";
        answer = StringParcer.getNewString(input);
        assertEquals("", answer, "2");
        input = "Добрый день!";
        answer = StringParcer.getNewString(input);
        assertEquals("ДЕНЬ ДОБРЫЙ", answer, "3");
        input = "сине-зеленый";
        answer = StringParcer.getNewString(input);
        assertEquals("ЗЕЛЕНЫЙ СИНЕ", answer, "4");
        input = "Чашка кофе с молоком без сахара.";
        answer = StringParcer.getNewString(input);
        assertEquals("БЕЗ КОФЕ МОЛОКОМ САХАРА ЧАШКА", answer, "5");
        input = "Эх раз, да еще раз, да еще много-много раз!";
        answer = StringParcer.getNewString(input);
        assertEquals("ЕЩЕ МНОГО РАЗ", answer, "6");
        input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
        answer = StringParcer.getNewString(input);
        assertEquals("ADIPISCING ALIQUA ALIQUIP AMET ANIM AUTE CILLUM COMMODO CONSECTETUR CONSEQUAT CULPA CUPIDATAT DESERUNT DOLOR DOLORE DUIS EIUSMOD ELIT ENIM ESSE EST EXCEPTEUR EXERCITATION FUGIAT INCIDIDUNT IPSUM IRURE LABORE LABORIS LABORUM LOREM MAGNA MINIM MOLLIT NISI NON NOSTRUD NULLA OCCAECAT OFFICIA PARIATUR PROIDENT QUI QUIS REPREHENDERIT SED SINT SIT SUNT TEMPOR ULLAMCO VELIT VENIAM VOLUPTATE", answer, "7");
    }
}