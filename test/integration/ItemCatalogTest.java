package integration;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemCatalogTest {

    @Test
    public void testItemExists() {
        String tomat = "Tomat";
        boolean expectedResult = true;
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean actualResult = itemCatalog.itemExists(tomat);
        assertEquals("The expected item didn't exist in database.", expectedResult, actualResult);
    }

    public void testItemNotExists() {
        String tomat = "Banan";
        boolean expectedResult = false;
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean actualResult = itemCatalog.itemExists(tomat);
        assertEquals("The expected item does exist in database.", expectedResult, actualResult);
    }

    public void testItemExistsWithNullString() {
        String tomat = null;
        boolean expectedResult = false;
        ItemCatalog itemCatalog = new ItemCatalog();
        boolean actualResult = itemCatalog.itemExists(tomat);
        assertEquals("The expected item that is null does exist in database.", expectedResult, actualResult);
    }
}