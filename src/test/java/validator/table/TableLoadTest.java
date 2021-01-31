package validator.table;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class TableLoadTest {
    private String document = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";
    private Integer count = 225;
    private TableLoad tableLoad = new TableLoad();
    private String tablename = "tabpd5";
    TableLoadTest() throws IOException {
    }

    @Test
    void getHashMapSize() {
        assertEquals(count, tableLoad.getHashMapSize());
    }

    @Test
    void getLink()  {
        assertEquals(document, tableLoad.getLink());
    }


    @Test
    void getTableName() {
        assertEquals(tablename, tableLoad.getTableName());
    }
}