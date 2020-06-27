package generate;

import generate.PurchaseRkmx;
import generate.PurchaseRkmxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PurchaseRkmxDao {
    long countByExample(PurchaseRkmxExample example);

    int deleteByExample(PurchaseRkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseRkmx record);

    int insertSelective(PurchaseRkmx record);

    List<PurchaseRkmx> selectByExample(PurchaseRkmxExample example);

    PurchaseRkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseRkmx record, @Param("example") PurchaseRkmxExample example);

    int updateByExample(@Param("record") PurchaseRkmx record, @Param("example") PurchaseRkmxExample example);

    int updateByPrimaryKeySelective(PurchaseRkmx record);

    int updateByPrimaryKey(PurchaseRkmx record);
}