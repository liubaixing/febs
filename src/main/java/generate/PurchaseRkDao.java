package generate;

import generate.PurchaseRk;
import generate.PurchaseRkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseRkDao {
    long countByExample(PurchaseRkExample example);

    int deleteByExample(PurchaseRkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseRk record);

    int insertSelective(PurchaseRk record);

    List<PurchaseRk> selectByExample(PurchaseRkExample example);

    PurchaseRk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseRk record, @Param("example") PurchaseRkExample example);

    int updateByExample(@Param("record") PurchaseRk record, @Param("example") PurchaseRkExample example);

    int updateByPrimaryKeySelective(PurchaseRk record);

    int updateByPrimaryKey(PurchaseRk record);
}