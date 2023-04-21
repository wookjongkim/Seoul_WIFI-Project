import com.example.seoul_wifiproject.util.TotalCnt;
import org.junit.jupiter.api.Test;

public class TotalCntTest {
    @Test
    public void testGetDataTotalCount(){
        int totalCnt = TotalCnt.getDataTotalCount();
        System.out.println(totalCnt);
    }
}
